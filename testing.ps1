$RTMPSERVERIP = "10.7.50.188"
$STREAMKEY = $env:COMPUTERNAME -replace "[^0-9]" , ''
# $streamProcess = cmd.exe /c "ffmpeg -f gdigrab -framerate 30 -i desktop -vcodec libx264 -preset ultrafast -f flv rtmp://$RTMPSERVERIP/live/$STREAMKEY"


if(Test-Path -Path "$PSScriptRoot/var.ini"){
    $iniContent = Get-Content -Path "$PSScriptRoot/var.ini"
    foreach ($line in $iniContent)
    {
        $line = $line.Trim()
        if ($line.Split('=')[0] -match "ServerIP"){
            $RTMPSERVERIP = $line.Split('=')[1]
            Write-Output "Updated Server IP to $RTMPSERVERIP."
            UpdateLog -message "Updated Server IP to $RTMPSERVERIP."
        }
    }
}
function StartTest {
    param (
        [Byte]$NewInstance
    )
    if($NewInstance -eq 1){
        Stream -NewInstance $NewInstance
    }
    else{
        UpdateLog -message "Live stream interrupted. Restarting live stream..."
        Stream -NewInstance $NewInstance
    }   
}
function UpdateLog {
    param (
        [string]$message
    )
    $date = Get-Date
    Add-Content -Path "$PSScriptRoot\StreamLog.log" -Value "$date: $message" -PassThru
}

function Stream {
    param (
        [Byte]$NewInstance
    )
    #Check if currently running, stop if it is,
    If ($FFMPEG_PID){
        if(Get-Process -Name "ffmpeg" -ErrorAction SilentlyContinue){
            UpdateLog -message "Stopping current instance of FFMPEG Recording"
            Stop-Process -Name "ffmpeg" -Force
        }
    }

    Start-Sleep -Seconds 3
    UpdateLog -message "Starting streaming on rtmp://$RTMPSERVERIP/live/$STREAMKEY ..."
    #Run VLC and obtain PID # to track it during testing
    $FFMPEG_EXE = (Get-ChildItem -Path "C:\Users\TACCUSER\AppData\Local\Microsoft\WinGet\Packages\" -Filter "ffmpeg.exe" -Recurse).FullName
    if( -not $FFMPEG_EXE){
        UpdateLog -message "ERROR: FFMPEG executable not found. Please install FFMPEG."
        ExitTest -code 0
    }

    $FFMPEG_PID = (Start-Process -FilePath $FFMPEG_EXE -ArgumentList "-f gdigrab -framerate 30 -i desktop -vcodec libx264 -preset ultrafast -f flv rtmp://$RTMPSERVERIP/live/$STREAMKEY" -WindowStyle Minimized).Id
    Start-Sleep -Seconds 15
    if (-Not (Get-Process -Name "ffmpeg" -ErrorAction SilentlyContinue)){
        UpdateLog -message "ERROR: Timed out launching stream."
        ExitTest -code 0
    }
    UpdateLog -message "Stream started!"
    #For new tests set a .bat file in startup apps to run with with NewInstance = 0 to recover from reboots, save start time
    if($NewInstance){
        Set-Content -Path "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup\StreamTest.bat" -Value "if exist "$PSScriptRoot\LiveStream.ps1" (powershell -command "& {. $PSScriptRoot\LiveStream.ps1; StartTest -NewInstance 0}") else ( del "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup\StreamTest.bat" )"
        $startTime = Get-Date
        Set-Content -Path "$PSScriptRoot\start_time.txt" -Value "$startTime"
    }
    #If this is not a new instance, set start time as the time from the start_time file
    else{
        $startTimeString = Get-Content -Path "$PSScriptRoot\start_time.txt"
        $startTime = [DateTime]$startTimeString
        Remove-Variable startTimeString
        UpdateLog -message "Streaming started!"
    }
    #Run the test for 12 hours, check if vlc is running and log every five minutes.
    while((New-TimeSpan -Start $startTime -End (Get-Date)).TotalHours -lt 12){
        if(-Not (Get-Process -Name "ffmpeg" -ErrorAction SilentlyContinue)){
                UpdateLog -message "ERROR: Stream not running!"
                ExitTest -code 0
        }
        $mins = [int](New-TimeSpan -Start $startTime -End (Get-Date)).TotalMinutes
        UpdateLog -message "Streaming $mins of 720 minutes"
        Start-Sleep -Seconds 300
    }
    ExitTest -code 1

}

function ExitTest {
    param (
        [byte]$code
    )
    if($code -eq 1){
        UpdateLog -message "Test Passed!"
    }
    else{
        UpdateLog -message "Test Failed."
    }
    UpdateLog -message "Deleting files and exiting live streaming test."
    #Close FFMPEG and delete start_time file and startup app
    try{
        Remove-Item -Path "$PSScriptRoot\start_time.txt" -Force -ErrorAction SilentlyContinue
        if(Get-Process -Name "ffmpeg" -ErrorAction SilentlyContinue){
            UpdateLog -message "Stopping current instance of FFMPEG Recording"
            Stop-Process -Name "ffmpeg" -Force
        }
        Start-Sleep -Seconds 3
        if(Test-Path -Path "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup\StreamTest.bat"){
            Remove-Item -Path "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup\StreamTest.bat" -Force
        }
    }
    catch{
        UpdateLog -message "Error during file cleanup or closing FFMPEG."
    }
    Exit
}

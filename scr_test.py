if os.name == 'nt':  # Windows
            player = r"C:\Program Files\VideoLAN\VLC\vlc.exe"
            if os.path.exists(player):
                subprocess.Popen([player, video_pathh])
            else:
                os.startfile(video_path)  # Default player
        else:  # Unix/Linux/Mac
            subprocess.Popen(['xdg-open', video_pathh])
    except Exception as e:
        logging.error(f'unable to play video: {e}')

def main():
    resultlog = r'.\Logs\ResultLogs.txt'
    #video_path = 'chimei_demo_4k_h264.mp4'
    live_kernel_path = r'C:\Windows\LiveKernelReports\WATCHDOG'
    live_kernel_folder = r'C:\Windows\LiveKernelReports'

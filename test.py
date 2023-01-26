import ctypes
import time

srapi = ctypes.windll.ScreenReaderAPI
srapi.sapiEnable(1)
srapi.sayStringA("It works!", 1)
time.sleep(1) # wait 1 second

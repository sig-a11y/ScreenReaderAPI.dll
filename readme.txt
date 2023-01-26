Screen reader API DLL

1. Description
The screen reader API DLL goal is to unify access to major screen readers individual APIs.
Its features are :
* Universal sayString and stopSpeech function that automatically connect to the currently active screen reader respectively to speak a string of text and to immediately stop speaking
* Optionnaly fallback to speech via SAPI5 if no screen reader is active
* Screen reader specific functions are still available directly and independently from the automatic detection system, allthough you are strongly advised to rely only on automatic functions (so that your users don't have to stick on a particular screen reader)
* SAPI5 features: adjust voice, speech rate and volume, as well as redirecting audio to an user-defined function (this last function is Only for C/C++ users).

Screen readers currently supported are: jaws for windows, non visual desktop access, window eye, system access and dolphin supernova/HAL.
Don't hesitate to let me know of other APIs of other screen readers that could be included in the DLL.

2. Using the Screen reader API DLL

2.1. From C/C++
The C/C++ distribution includes an header file ScreenReaderAPI.h and an import library libScreenReaderAPI.a that can be used by MinGW compiler. You can use the import library in MSVC simply by renaming it to ScreenReaderAPI.lib.
The header file contains function prototypes and their documentation.

2.2. From Java
Import the provided class quentinc.accessibility.ScreenReaderAPI. The source code of this class is documented. You can use it out of the box.
You can look at Test.java as an example .

2.3. Using the COM interface
Before you can use the COM interface to the screen reader API DLL, you must first register it using regsvr32.exe by issuing the command: regsvr32 ScreenReaderAPI.dll. The type library ScreenReaderAPI.tlb must be in the same directory when doing the registration and you must also distribute it with your application.
Then, use the ProgID "ScreenReaderAPI.Interface" to create an object. An HTML application, test.hta, is provided with an example call in JScript.
Note: The DLL registration mainly consists of creating the required registry entries in HKEY_LOCAL_MACHINE\Software\Classes\ScreenReaderAPI.Interface. Once the DLL is registered, you aren't supposed to move or rename it. Place it in a consist folder before registering.

2.4. From a language with an FFI library
Most languages provide an FFI library to access native C/C++ DLLs. You can use them to access the API with your favorite language.
* Lua: example in test.lua that run with luajit 2.0.0.8 (not standard lua 5.1.4) with the included FFI library
* Python: short example in test.py
* ruby ? need ruby example
* VB6 and other basic family languages ? Need examples
* C# and VB.net ? Need C# example.

3. Known issues
3.1. Keyboard hook
Keyboard hook could be used to bypass jaws keyboard hook that could be problematic for games. The most known problem of that sort is arrow keys not working or with a delay.
The hook installed by your application must be explicitely uninstalled at exit. You should also uninstall it when the user switches to another application (Alt+Tab), and reinstall it when he comes back to it.
Other applications wont work correctly with jaws when the custom keyboard hook is active and average users wont understand what's going on if it remain active outside of your application.
Note that the hook may not work as expected. Use this feature as your own risk.
3.2. Jaws sleep mode
When jaws is running but in sleep mode, it is still detected by ScreenReaderAPI, allthough nothing can be spoken through it.  Its successful detection prevent another screen reader or SAPI5 from being used.
IN that case, the only solution is to use "force SAPI5" mode. 
Sleep mode can't be detected properly by ScreenReaderAPI, and is highly discouraged by freedom scientific.
3.3. SAPI5 specific functions
For an unknown reason, it is impossible to retriev number of voices available, get voice names, or get or set current SAPI5 voice on certain computers.
That has already been noticed at least once on windows 7 64 bits. Any other information about that problem is welcome.
3.4. Registering the COM server in an inno setup script
For an unknown reason, inno setup scripts fail to register ScreenReaderAPI when using the regserver flag in the files section (it returns an error #5)
A work around is to explicitly tell the script to run regsvr32.exe at the end of the installation, in the run section.
This problem concern both 32 and 64 bit versions of windows.

4. Copyright and license
Copyright © 2011-2012, Quentin Cosendey http://quentinc.net/
You can use the screen reader APi DLL for free in your own software  as long as it is also distributed for free. If you wish to use it in a commercial product, please contact me for arrangements.

5. Changelog
R11: added functions to braille messages and informations on supported screen readers
R9: Added installKeyboardHook and uninstallKeyboardHook. Use at your own risks !
R8: added some default values in COM/automation interface to make the API even easier to use. Auto-initialization of SAPI5 when using SapiSayString for the first time.
R7: NVDA, dolphin and SA DLLs are now loaded from the same folder where ScreenReaderAPI.dll is, instead of relying on windows path to find them
R6: fixed: stopSpeech function was incorrectly exported as __cdecl instead of __stdcall in C/C++ interface
R3: fixed: double initialisation of SAPI5 in certain circunstances
R2: Added SAPI direct support in COM/automation interface



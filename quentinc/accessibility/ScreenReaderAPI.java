package quentinc.accessibility;
/** Screen reader API class */
public class ScreenReaderAPI {
/** Constants to use with get/setCurrentScreenReader */
public static final int
NoScreenReader=0, Jaws=1, NVDA=2, WindowEye=3, SystemAccess=4, SAPI=15;
static { System.loadLibrary("ScreenReaderAPI"); }
private ScreenReaderAPI () {}
/** Say a string of text */
public static native boolean sayString (String str, boolean interrupt) ;
/** Display a text in the braille display */
public static native boolean brailleMessage (String str) ;
/** Immediately stop speaking */
public static native boolean stopSpeech () ;
/** Enable sapi5 as fallback if no other screen reader is found */
public static native boolean sapiIsEnabled () ;
public static native void sapiEnable (boolean on) ;
/** Get or force the current screen reader */
public static native int getCurrentScreenReader () ;
public static native boolean setCurrentScreenReader (int sr) ;
public static native String getScreenReaderName (int id) ;
public static native int getScreenReaderId (String name) ;
public static native String getCurrentScreenReaderName () ;
public static native boolean setCurrentScreenReaderName (String name) ;
// Specific SAPI functions
public static native boolean sapiSayString (String str, boolean interrupt) ;
public static native boolean sapiSaySSML (String ssml, boolean interrupt) ;
public static native int sapiGetRate () ;
public static native int sapiGetVolume () ;
public static native void sapiSetRate (int rate) ;
public static native void sapiSetVolume (int volume) ;
public static native int sapiGetVoice () ;
public static native void sapiSetVoice (int voiceIndex) ;
public static native String sapiGetVoiceName (int voiceIndex) ;
public static native int sapiGetNumVoices () ;
public static native boolean sapiIsSpeaking () ;
public static native boolean sapiWait (int timeout) ;
public static native boolean sapiIsPaused () ;
public static native void sapiSetPaused (boolean pause) ;
public static native boolean sapiLoad () ;
public static native void sapiUnload () ;
public static native void sapiStopSpeech () ;
public static native void installKeyboardHook () ;
public static native void uninstallKeyboardHook () ;
}

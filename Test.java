import static quentinc.accessibility.ScreenReaderAPI.*;

public class Test {
public static void main (String[] args) {
sapiLoad();
sapiSayString(sapiGetVoiceName(sapiGetVoice()), true);
sapiWait(-1);
}}

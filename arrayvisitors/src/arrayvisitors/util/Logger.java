package arrayvisitors.util;

public class Logger {
    /**
     * MyLogger class for the purpose of debugging
     */
    public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR, COMMONINT, MISSINGINT, POPULATE, RESULTS, NONE
    };

    private static DebugLevel debugLevel;

    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 6: debugLevel = DebugLevel.POPULATE; break;
            case 5: debugLevel = DebugLevel.RESULTS; break;
            case 4: debugLevel = DebugLevel.MISSINGINT; break;
            case 3: debugLevel = DebugLevel.COMMONINT; break;
            case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
            case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
            default: debugLevel = DebugLevel.NONE; break;
        }
    }

    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    /**
     * To check the debug level set value
     * @return debugLevel value
     */
    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }
}

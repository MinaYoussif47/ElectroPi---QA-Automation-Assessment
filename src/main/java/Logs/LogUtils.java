package Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {


    private static Logger Logger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void info(String message) {
        Logger().info(message);
    }

    public static void error(String message) {
        Logger().error(message);
    }

    public static void debug(String message) {
        Logger().debug(message);
    }

    public static void fatal(String message) {
        Logger().fatal(message);
    }

    public static void debug(String message, Throwable t) {
        Logger().debug(message, t);
    }
}

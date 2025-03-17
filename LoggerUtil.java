import java.util.logging.Logger;

/**
 * Utility class for obtaining a logger instance for a given class.
 */
class LoggerUtil {
    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }
}
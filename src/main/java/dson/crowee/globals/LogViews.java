package dson.crowee.globals;

import dson.crowee.sources.graphicSource.GraphicCoreManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogViews {
    private static final Logger graphicLogger = LoggerFactory.getLogger(GraphicCoreManager.class);
    private static Logger playerCharacterGraphicsControllerLogger;


    public static void dropGraphicsCoreWarning(String image){
        graphicLogger.error("Error al opening file {}", image);
    }
}

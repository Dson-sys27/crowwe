package dson.crowee.globals;

import dson.crowee.sources.graphicSource.GraphicCoreManager;
import dson.crowee.sources.graphicSource.DrawerClasses.UIGraphicsDrawer;
import dson.crowee.sources.sourceTools.MapRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogViews {
    private static final Logger graphicLogger = LoggerFactory.getLogger(GraphicCoreManager.class);
    private static final Logger playerCharacterGraphicsControllerLogger = LoggerFactory.getLogger(UIGraphicsDrawer.class);
    private static final Logger mapRendererLogger = LoggerFactory.getLogger(MapRenderer.class);

    //Ordered by handled exceptions
    private static final Logger UnpredictableExceptionError = LoggerFactory.getLogger("UNPRED_logger");
    private static final Logger IOExceptionLogger = LoggerFactory.getLogger("IOEX_logger");


    public static void dropIOExceptionError(String resource, Class<?> caller){
        IOExceptionLogger.error("Failed at opening resource {} from {}", resource, caller.getCanonicalName());
    }

    public static void dropUnexpectedExceptionError(Class<?> caller){
        UnpredictableExceptionError.error("Unpredictable error from {}", caller.getCanonicalName());
    }

}

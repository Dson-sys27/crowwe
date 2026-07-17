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


    public static void dropMapRendererError(String image){
        mapRendererLogger.error("Error at opening map file {}", image);
    }

    public static void dropGraphicsCoreWarning(String image){
        graphicLogger.error("Error at opening file {}", image);
    }
}

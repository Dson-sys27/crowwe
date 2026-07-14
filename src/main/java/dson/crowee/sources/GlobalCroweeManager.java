package dson.crowee.sources;

import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.colliderSystem.CollisionManager;
import dson.crowee.sources.entityControllers.PlayerEventManager;
import dson.crowee.sources.graphicSource.GraphicCoreManager;
import dson.crowee.sources.graphicSource.DrawerClasses.PlayerCharacterGraphicsDrawer;
import dson.crowee.sources.graphicSource.DrawerClasses.PropsGraphicsDrawer;
import dson.crowee.sources.graphicSource.DrawerClasses.UIGraphicsDrawer;
import dson.crowee.sources.graphicSource.DrawerClasses.WorldMapGraphicsDrawer;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

public class GlobalCroweeManager {

    public static void startDaShit(){

        KeyboardListener.initializeKeyboardListener();
        DataStorageManager.loadObjectMapper();

        PlayerCharacter theMan = new PlayerCharacter(FormalCode.PLAYER_1);

        CollisionManager.setTriggerSystemOnWork();

        PlayerEventManager.setPlayerKeyEventManagerOnWork(theMan);

        PlayerCharacterGraphicsDrawer.setPlayerCharacterGraphicsControllerOnWork(theMan);
        PropsGraphicsDrawer.setPropsGraphicsManagerOnWork();
        WorldMapGraphicsDrawer.setWorldMapGraphicsOnWork();
        UIGraphicsDrawer.setUIGraphicsManagerOnWork();

        GraphicCoreManager.setGraphicCoreManagerOnWork();
    }

}

package dson.crowee.sources;

import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.colliderSystem.CollisionManager;
import dson.crowee.sources.entityControllers.MobsEventManager;
import dson.crowee.sources.entityControllers.PlayerEventManager;
import dson.crowee.sources.graphicSource.DrawerClasses.*;
import dson.crowee.sources.graphicSource.GraphicCoreManager;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

public class GlobalCroweeManager {

    public static void startDaShit(){

        KeyboardListener.initializeKeyboardListener();
        DataStorageManager.loadObjectMapper();

        PlayerCharacter theMan = new PlayerCharacter(FormalCode.PLAYER);

        CollisionManager.setTriggerSystemOnWork();

        PlayerEventManager.setPlayerKeyEventManagerOnWork(theMan);
        MobsEventManager.setMobsEventManagerOnWork(theMan);

        PlayerCharacterGraphicsDrawer.setPlayerCharacterGraphicsControllerOnWork(theMan);
        MobsGraphicsDrawer.setMobsGraphicsDrawerOnWork();
        PropsGraphicsDrawer.setPropsGraphicsManagerOnWork();
        WorldMapGraphicsDrawer.setWorldMapGraphicsOnWork();
        UIGraphicsDrawer.setUIGraphicsManagerOnWork();

        GraphicCoreManager.setGraphicCoreManagerOnWork();
    }

}

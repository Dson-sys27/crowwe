package dson.crowee.sources;

import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.colliderSystem.CollisionManager;
import dson.crowee.sources.entityControllers.PlayerEventManager;
import dson.crowee.sources.graphicSource.GraphicCoreManager;
import dson.crowee.sources.graphicSource.singleGraphicManagers.PlayerCharacterGraphicsController;
import dson.crowee.sources.graphicSource.singleGraphicManagers.PropsGraphicsController;
import dson.crowee.sources.graphicSource.singleGraphicManagers.UIGraphicsManager;
import dson.crowee.sources.graphicSource.singleGraphicManagers.WorldMapGraphicsManager;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

public class GlobalCroweeManager {

    public static void startDaShit(){

        KeyboardListener.initializeKeyboardListener();
        DataStorageManager.loadObjectMapper();

        PlayerCharacter theMan = new PlayerCharacter(FormalCode.PLAYER_1);

        CollisionManager.setTriggerSystemOnWork();

        PlayerEventManager.setPlayerKeyEventManagerOnWork(theMan);

        PlayerCharacterGraphicsController.setPlayerCharacterGraphicsControllerOnWork(theMan);
        PropsGraphicsController.setPropsGraphicsManagerOnWork();
        WorldMapGraphicsManager.setWorldMapGraphicsOnWork();
        UIGraphicsManager.setUIGraphicsManagerOnWork();

        GraphicCoreManager.setGraphicCoreManagerOnWork();
    }

}

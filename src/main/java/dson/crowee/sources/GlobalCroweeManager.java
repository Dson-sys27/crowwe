package dson.crowee.sources;

import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.entityControllers.PlayerKeyEventManager;
import dson.crowee.sources.graphicSource.GraphicCoreManager;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

public class GlobalCroweeManager {

    public static void startDaShit(){
        KeyboardListener.initializeKeyboardListener();
        DataStorageManager.loadObjectMapper();
        GraphicCoreManager.setGraphicCoreManagerOnWork();

        PlayerCharacter theMan = new PlayerCharacter();

        PlayerKeyEventManager.setPlayerKeyEventManagerOnWork(theMan);

    }

}

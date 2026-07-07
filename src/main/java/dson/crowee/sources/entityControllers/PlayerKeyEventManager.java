package dson.crowee.sources.entityControllers;

import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

import java.awt.event.KeyEvent;

public class PlayerKeyEventManager {
    private static KeyboardListener keyboardListener;
    private static PlayerCharacter playerCharacter;

    public static void setPlayerKeyEventManagerOnWork(PlayerCharacter player){
        keyboardListener = KeyboardListener.getKeyboardListener();
        playerCharacter = player;
    }

    public static void updatePlayerAction(){

        float curentX = playerCharacter.getX();
        float currentY = playerCharacter.getY();

        if(KeyboardListener.getKey(KeyEvent.VK_W)){
            playerCharacter.setY(currentY - Util.PLAYER_SPEED);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_A)){
            playerCharacter.setX(curentX - Util.PLAYER_SPEED);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_S)){
            playerCharacter.setY(currentY + Util.PLAYER_SPEED);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_D)){
            playerCharacter.setX(curentX + Util.PLAYER_STEP_LENGTH);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_E)){
            System.out.println("E");
        }
    }

    public static float getX(){
        return playerCharacter.getX();
    }

    public static float getY(){
        return playerCharacter.getY();
    }
}

package dson.crowee.sources.entityControllers;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

import java.awt.event.KeyEvent;

public class PlayerEventManager {
    private static KeyboardListener keyboardListener;
    private static PlayerCharacter playerCharacter;

    public static void setPlayerKeyEventManagerOnWork(PlayerCharacter player){
        keyboardListener = KeyboardListener.getKeyboardListener();
        playerCharacter = player;
    }

    public static void updatePlayerAction(){

        int currentX = playerCharacter.getX();
        int currentY = playerCharacter.getY();

        if(KeyboardListener.getKey(KeyEvent.VK_W)){
            playerCharacter.setY(currentY - Utilities.PLAYER_SPEED);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_A)){
            playerCharacter.setX(currentX - Utilities.PLAYER_SPEED);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_S)){
            playerCharacter.setY(currentY + Utilities.PLAYER_SPEED);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_D)){
            playerCharacter.setX(currentX + Utilities.PLAYER_SPEED);
        }
        if(KeyboardListener.getKey(KeyEvent.VK_E)){
            System.out.println("E");
        }

        playerCharacter.getTrigger().udatePosition();

        if((currentX % 32 != playerCharacter.getX()) || (currentY % 32 != playerCharacter.getY())){
            playerCharacter.getTrigger().sendSignal();
        }
    }

    public static int getX(){
        return playerCharacter.getX();
    }

    public static int getY(){
        return playerCharacter.getY();
    }
}

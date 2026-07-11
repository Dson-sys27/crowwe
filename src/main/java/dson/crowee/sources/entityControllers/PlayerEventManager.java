package dson.crowee.sources.entityControllers;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.colliderSystem.CollisionManager;
import dson.crowee.sources.colliderSystem.Signal;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Queue;

public class PlayerEventManager {
    private static PlayerCharacter playerCharacter;
    private static ArrayDeque<Signal> signalMail;


    public static void setPlayerKeyEventManagerOnWork(PlayerCharacter player){
        playerCharacter = player;
        signalMail = CollisionManager.getSignalMail();
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

        if((currentX % Utilities.SPATIAL_GRID_CELL_SIZE != playerCharacter.getX())
                || (currentY % Utilities.SPATIAL_GRID_CELL_SIZE != playerCharacter.getY())){
            Signal signal = new Signal(playerCharacter, currentX, currentY);
            signalMail.add(signal);
        }
    }

    public static int getX(){
        return playerCharacter.getX();
    }

    public static int getY(){
        return playerCharacter.getY();
    }
}

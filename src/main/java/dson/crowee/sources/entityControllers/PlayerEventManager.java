package dson.crowee.sources.entityControllers;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.obj.objects.Prop;
import dson.crowee.sources.colliderSystem.CollisionManager;
import dson.crowee.sources.colliderSystem.Signal;
import dson.crowee.sources.graphicSource.DrawerClasses.UIGraphicsDrawer;
import dson.crowee.sources.keyboardHandler.KeyboardListener;

import java.awt.event.KeyEvent;
import java.util.ArrayDeque;

public class PlayerEventManager {
    private static PlayerCharacter playerCharacter;
    private static ArrayDeque<Signal> signalMail;
    private static ArrayDeque<Event> eventMail;
    private static long next;


    public static void setPlayerKeyEventManagerOnWork(PlayerCharacter player){
        playerCharacter = player;
        signalMail = CollisionManager.getSignalMail();
        eventMail = new ArrayDeque<>();
        next = 0;

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
        if(KeyboardListener.getKey(KeyEvent.VK_F)){
            System.out.println("E");
        }

        playerCharacter.getTrigger().udatePosition();

        //send position signal
        Signal signal = new Signal(playerCharacter, currentX, currentY);
        signalMail.add(signal);

        //receive and process events
        while(!eventMail.isEmpty()){
            Event currentEvent = eventMail.poll();
            Entity eventEmitter = currentEvent.getEventEmitter();

            long tiempoActual = System.currentTimeMillis();

            if(tiempoActual >= next){
                if(eventEmitter.getClass() == Prop.class){
                    int currentHealth = playerCharacter.getHeathScore();
                    playerCharacter.setHeathScore(currentHealth - 10);
                    UIGraphicsDrawer.setHealthValue(1 + (100 / 17) - (currentHealth / 17));
                    if(currentHealth <= 0)
                        UIGraphicsDrawer.setHealthValue(6);

                    playerCharacter.setX(currentX);
                    playerCharacter.setY(currentY);
                }
            }

            next = tiempoActual + 1;
        }

    }

    public static int getX(){
        return playerCharacter.getX();
    }

    public static int getY(){
        return playerCharacter.getY();
    }

    public static void sendEvent(Event event){
        eventMail.add(event);
    }
}

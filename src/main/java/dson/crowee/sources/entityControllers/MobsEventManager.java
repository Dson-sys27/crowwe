package dson.crowee.sources.entityControllers;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.Mob;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.obj.objects.mobs.H27;
import dson.crowee.sources.colliderSystem.Signal;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MobsEventManager {
    private static ArrayDeque<Signal> signalMail;
    private static ArrayDeque<Event> eventMail;
    private static PlayerCharacter playerCharacter;
    private static ArrayList<Entity> onStageMobs;

    public static void setMobsEventManagerOnWork(PlayerCharacter player){
        signalMail = new ArrayDeque<>();
        eventMail = new ArrayDeque<>();
        onStageMobs = new ArrayList<>();
        playerCharacter = player;

        H27 mobito = new H27(FormalCode.PLAYER, 0, 0);
        onStageMobs.add(mobito);
    }

    public static void updateMobs(){
        for(Entity currentMob : onStageMobs){
            if(currentMob.getX() > playerCharacter.getX())
                currentMob.setX(currentMob.getX() - Utilities.MOB_SPEED);
            if(currentMob.getX() < playerCharacter.getX())
                currentMob.setX(currentMob.getX() + Utilities.MOB_SPEED);
            if(currentMob.getY() > playerCharacter.getY())
                currentMob.setY(currentMob.getY() - Utilities.MOB_SPEED);
            if(currentMob.getY() < playerCharacter.getY())
                currentMob.setY(currentMob.getY() + Utilities.MOB_SPEED);
        }
    }

    public static ArrayDeque<Signal> getSignalMail() {
        return signalMail;
    }

    public static void setSignalMail(ArrayDeque<Signal> signalMail) {
        MobsEventManager.signalMail = signalMail;
    }

    public static PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public static void setPlayerCharacter(PlayerCharacter playerCharacter) {
        MobsEventManager.playerCharacter = playerCharacter;
    }

    public static ArrayDeque<Event> getEventMail() {
        return eventMail;
    }

    public static void setEventMail(ArrayDeque<Event> eventMail) {
        MobsEventManager.eventMail = eventMail;
    }

    public static ArrayList<Entity> getOnStageMobs() {
        return onStageMobs;
    }

    public static void setOnStageMobs(ArrayList<Entity> onStageMobs) {
        MobsEventManager.onStageMobs = onStageMobs;
    }
}

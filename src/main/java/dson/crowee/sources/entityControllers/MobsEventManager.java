package dson.crowee.sources.entityControllers;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.buiders.EntityFactory;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.Mob;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.obj.objects.mobs.H27;
import dson.crowee.sources.colliderSystem.CollisionManager;
import dson.crowee.sources.colliderSystem.Signal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class MobsEventManager {
    private static ArrayDeque<Signal> signalMail;
    private static ArrayDeque<Event> eventMail;
    private static PlayerCharacter playerCharacter;
    private static CopyOnWriteArrayList<Entity> onStageMobs;
    private static long nextTime;

    public static void setMobsEventManagerOnWork(PlayerCharacter player){
        signalMail = new ArrayDeque<>();
        eventMail = new ArrayDeque<>();
        onStageMobs = new CopyOnWriteArrayList<>();
        playerCharacter = player;
        nextTime = 0;
    }

    public static void updateMobs(){
        EntityFactory entityFactory = EntityFactory.getInstance();
        Random rand = new Random();
        long currentTime = System.currentTimeMillis();

        if(currentTime >= nextTime){
            Entity currentMob = entityFactory.build(FormalCode.BALDARK);
            currentMob.setX(playerCharacter.getX() + rand.nextInt(1000 + 1 - (-1000)) - 1000);
            currentMob.setY(playerCharacter.getY() + rand.nextInt(1000 + 1 - (-1000)) - 1000);

            onStageMobs.add(currentMob);

            //TODO: join collisionManager and this class
            CollisionManager.setEntityOnSpatialGrid(currentMob);


            nextTime += 50000000000L;
        }

        for(Entity currentMob : onStageMobs){

            int oldX = currentMob.getX();
            int oldY = currentMob.getY();

            if(currentMob.getX() > playerCharacter.getX())
                currentMob.setX(currentMob.getX() - Utilities.MOB_SPEED);
            if(currentMob.getX() < playerCharacter.getX())
                currentMob.setX(currentMob.getX() + Utilities.MOB_SPEED);
            if(currentMob.getY() > playerCharacter.getY())
                currentMob.setY(currentMob.getY() - Utilities.MOB_SPEED);
            if(currentMob.getY() < playerCharacter.getY())
                currentMob.setY(currentMob.getY() + Utilities.MOB_SPEED);


            CollisionManager.getSignalMail().add(new Signal(currentMob, oldX, oldY));
            if(outOfRangeMob(currentMob))
                onStageMobs.remove(currentMob);
        }

    }

    private static boolean outOfRangeMob(Entity entity){
        return entity.getX() > (playerCharacter.getX() + Utilities.SCREEN_WIDTH)
                || entity.getX() <  - Utilities.SCREEN_WIDTH
                || entity.getY() > (playerCharacter.getY() + Utilities.SCREEN_HEIGHT)
                || entity.getY() < - Utilities.SCREEN_HEIGHT;
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

    public static CopyOnWriteArrayList<Entity> getOnStageMobs() {
        return onStageMobs;
    }

    public static void setOnStageMobs(CopyOnWriteArrayList<Entity> onStageMobs) {
        MobsEventManager.onStageMobs = onStageMobs;
    }
}

package dson.crowee.sources.graphicSource.DrawerClasses;

import dson.crowee.obj.objects.Entity;
import dson.crowee.sources.entityControllers.MobsEventManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class MobsGraphicsDrawer {
    private static CopyOnWriteArrayList<Entity> onStageMobs;

    public static void setMobsGraphicsDrawerOnWork(){
        onStageMobs = MobsEventManager.getOnStageMobs();
    }

    public static void drawMobs(Graphics2D graphics){
        for(Entity currentMob : onStageMobs){
            graphics.drawImage(currentMob
                    .getSpriteModel()
                    .getSpriteModelImages()
                    .getFirst(),
                    currentMob.getX(),
                    currentMob.getY(),
                    64,
                    64,
                    null);
        }
    }
}

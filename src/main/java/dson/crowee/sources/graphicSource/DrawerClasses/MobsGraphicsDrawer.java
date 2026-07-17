package dson.crowee.sources.graphicSource.DrawerClasses;

import dson.crowee.obj.objects.Entity;
import dson.crowee.sources.entityControllers.MobsEventManager;

import java.awt.*;
import java.util.ArrayList;

public class MobsGraphicsDrawer {
    private static ArrayList<Entity> onStageMobs;

    public static void setMobsGraphicsDrawerOnWork(){
        onStageMobs = MobsEventManager.getOnStageMobs();
    }

    public static void drawMobs(Graphics2D graphics){
        for(Entity currentMob : onStageMobs){
            graphics.drawImage(currentMob.getSpriteImages().getFirst(), currentMob.getX(), currentMob.getY(), null);
        }
    }
}

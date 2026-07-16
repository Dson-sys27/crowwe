package dson.crowee.sources.graphicSource.DrawerClasses;

import dson.crowee.globals.Utilities;
import dson.crowee.sources.graphicSource.UI.SpriteSheet;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class UIGraphicsDrawer {

    private static ArrayList<Image> UIImages;
    private static int healthValue;

    public static void setUIGraphicsManagerOnWork(){
        UIImages = new ArrayList<>();
        healthValue = 1;
        SpriteSheet UISprites = null;
        try{
            URL sourcePath = UIGraphicsDrawer.class.getResource(Utilities.UI_SPRITESHEET);
            UISprites = new SpriteSheet(sourcePath, 16);
        }catch(Exception e){
            System.out.println("gg");
        }
        for(int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                UIImages.add(UISprites.getSpriteSheetImages()[i][j]);
    }

    public static void drawUIObjects(Graphics2D graphics){
        graphics.drawImage(UIImages.get(healthValue), 600, 380, 32, 32, null);
    }

    public static void setHealthValue(int value){
        healthValue = value;
    }

    public static int getHealthValue(){
        return healthValue;
    }
}

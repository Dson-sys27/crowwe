package dson.crowee.sources.graphicSource.singleGraphicManagers;

import dson.crowee.sources.graphicSource.UI.SpriteSheet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UIGraphicsManager {

    private static ArrayList<Image> UIImages;
    private static int healthValue;

    public static void setUIGraphicsManagerOnWork(){
        UIImages = new ArrayList<>();
        healthValue = 1;
        SpriteSheet UISprites = null;
        try{
            UISprites = new SpriteSheet("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\UI\\UI_spritesheet.png", 16);
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

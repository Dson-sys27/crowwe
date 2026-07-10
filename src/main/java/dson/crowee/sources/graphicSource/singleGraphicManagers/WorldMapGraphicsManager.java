package dson.crowee.sources.graphicSource.singleGraphicManagers;

import dson.crowee.globals.LogViews;
import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.sourceTools.MapRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WorldMapGraphicsManager {

    private static int[][] worldMap;
    private static ArrayList<Image> worldMapImages;
    private final static int SPRITE_SCALE = Utilities.SPRITE_SIZE * Utilities.SCALE_SIZE;

    public static void setWorldMapGraphicsOnWork(){
        try{
            worldMap = MapRenderer.renderMap("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\map\\mapSource");
        }catch(Exception e){

        }
        worldMapImages = new ArrayList<>();
        Image image = null;
        Image im2 = null;
        try{
            image = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\euclideus_floor.png"));
            im2 = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\euclideus_grass.png"));
        }catch(IOException e){
            LogViews.dropGraphicsCoreWarning("");
        }
        worldMapImages.add(image);
        worldMapImages.add(im2);
    }

    public static void drawWorldMap(Graphics2D graphics){
        PlayerCharacter player = PlayerCharacterGraphicsController.getPlayerCharacter();

        int camX = player.getX() - (Utilities.SCREEN_WIDTH / 2) + (Utilities.SPRITE_SIZE / 2);
        int camY = player.getY() - (Utilities.SCREEN_HEIGHT / 2) + (Utilities.SPRITE_SIZE / 2);

        int initialScreenPositionX = camX / Utilities.SPRITE_SIZE;
        int initialScreenPositionY = camY / Utilities.SPRITE_SIZE;

        int finalScreenPositionX = initialScreenPositionX +
                (Utilities.SCREEN_WIDTH / Utilities.SPRITE_SIZE);

        int finalScreenPositionY = initialScreenPositionY +
                (Utilities.SCREEN_HEIGHT / Utilities.SPRITE_SIZE);

        for(int j = initialScreenPositionY; j < finalScreenPositionY ; j ++)
            for(int i = initialScreenPositionX; i < finalScreenPositionX; i ++)
                if(i >= 0 && j >= 0)
                    graphics.drawImage(worldMapImages.get(worldMap[i][j]),
                            i * Utilities.SPRITE_SIZE,
                            j * Utilities.SPRITE_SIZE,
                            SPRITE_SCALE,
                            SPRITE_SCALE,
                            null);
    }
}

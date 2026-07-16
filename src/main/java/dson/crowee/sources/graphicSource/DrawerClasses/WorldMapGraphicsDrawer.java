package dson.crowee.sources.graphicSource.DrawerClasses;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.graphicSource.UI.SpriteSheet;
import dson.crowee.sources.sourceTools.MapRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WorldMapGraphicsDrawer {

    private static int[][] worldMap;
    private static ArrayList<Image> worldMapImages;
    private static int worldHeigth;
    private static int worldWidth;
    private final static int SPRITE_SCALE = Utilities.SPRITE_SIZE * Utilities.SCALE_SIZE;

    public static void setWorldMapGraphicsOnWork(){
        worldMapImages = new ArrayList<>();
        SpriteSheet spriteSheet = null;
        try{
            worldMap = Utilities.WORLD_MAP;
            URL spriteSheetURL = WorldMapGraphicsDrawer.class.getResource(Utilities.SPRITESHEET_1_R_PATH);
             spriteSheet = new SpriteSheet(spriteSheetURL, 32);
        }catch(Exception e){
            e.printStackTrace();
        }

        worldHeigth = worldMap.length;
        worldWidth = worldMap[0].length;

        Image[][] sprites = spriteSheet.getSpriteSheetImages();
        for(int i = 0; i < 10; i++)
            for(int j = 0; j< 10; j++)
                worldMapImages.add(sprites[i][j]);

    }

    public static void drawWorldMap(Graphics2D graphics){
        PlayerCharacter player = PlayerCharacterGraphicsDrawer.getPlayerCharacter();

        int camX = player.getX() - (Utilities.SCREEN_WIDTH / 2) + (Utilities.SPRITE_SIZE / 2);
        int camY = player.getY() - (Utilities.SCREEN_HEIGHT / 2) + (Utilities.SPRITE_SIZE / 2);

        int initialScreenPositionX = camX / Utilities.SPRITE_SIZE - Utilities.CAMERA_DISPLAY_OFFSET_X;
        int initialScreenPositionY = camY / Utilities.SPRITE_SIZE - Utilities.CAMERA_DISPLAY_OFFSET_Y;

        int finalScreenPositionX = initialScreenPositionX +
                Utilities.CAMERA_DISPLAY_OFFSET_X * (Utilities.SCREEN_WIDTH / Utilities.SPRITE_SIZE);

        int finalScreenPositionY = initialScreenPositionY +
                Utilities.CAMERA_DISPLAY_OFFSET_Y * (Utilities.SCREEN_HEIGHT / Utilities.SPRITE_SIZE);

        if(initialScreenPositionX <= 0)
            initialScreenPositionX = 0;
        if(initialScreenPositionY <= 0)
            initialScreenPositionY = 0;
        if(finalScreenPositionY >= worldHeigth)
            finalScreenPositionY = worldHeigth;
        if(finalScreenPositionX >= worldWidth)
            finalScreenPositionX = worldWidth;

        for(int j = initialScreenPositionY; j < finalScreenPositionY ; j ++)
            for(int i = initialScreenPositionX; i < finalScreenPositionX; i ++)
                    graphics.drawImage(worldMapImages.get(worldMap[j][i]),
                            i * Utilities.SPRITE_SIZE,
                            j * Utilities.SPRITE_SIZE,
                            SPRITE_SCALE,
                            SPRITE_SCALE,
                            null);
    }
}

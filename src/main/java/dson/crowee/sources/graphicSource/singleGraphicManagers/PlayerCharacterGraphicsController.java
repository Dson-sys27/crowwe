package dson.crowee.sources.graphicSource.singleGraphicManagers;

import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.colliderSystem.Trigger;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerCharacterGraphicsController {
    private static PlayerCharacter playerCharacter;


    public static void setPlayerCharacterGraphicsControllerOnWork(PlayerCharacter player){
        playerCharacter = player;
        Image image = null;
        List<Image> spriteImages = playerCharacter.getSpriteImages();
        if(spriteImages == null)
            spriteImages = new ArrayList<Image>();
        try {
            image = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\player\\davdrak.png"));
        }catch (IOException e){

        }
        playerCharacter.getSpriteImages().addFirst(image);

        playerCharacter.setX(320);
        playerCharacter.setY(240);
    }

    public static synchronized void drawObject(Graphics2D graphics) {
        List<Image> images = playerCharacter.getSpriteImages();
        Trigger trigger = playerCharacter.getTrigger();
        graphics.drawImage(images.get(0), playerCharacter.getX(), playerCharacter.getY(), 64, 64, null);
        trigger.render(graphics);
    }

    public static PlayerCharacter getPlayerCharacter(){
        return playerCharacter;
    }
}

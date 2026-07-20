package dson.crowee.sources.graphicSource.DrawerClasses;

import dson.crowee.obj.buiders.EntityFactory;
import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerCharacterGraphicsDrawer {
    private static PlayerCharacter playerCharacter;


    public static void setPlayerCharacterGraphicsControllerOnWork(PlayerCharacter player){
        playerCharacter = player;
    }

    public static void drawObject(Graphics2D graphics) {
        SpriteModel spriteModel = playerCharacter.getSpriteModel();

        graphics.drawImage(
                spriteModel.getSpriteModelImages().getFirst(),
                playerCharacter.getX(),
                playerCharacter.getY(),
                64,
                64,
                null);
    }

    public static PlayerCharacter getPlayerCharacter(){
        return playerCharacter;
    }
}

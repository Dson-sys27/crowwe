package dson.crowee.sources.graphicSource.UI;

import dson.crowee.globals.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class SpriteModel {

    private final int spriteSize;
    private final int initX, initY, endX, endY;
    private SpriteSheet spriteSheet;
    private ArrayList<BufferedImage> spriteModelImages;

    public SpriteModel(int initX, int initY, int endX, int endY, SpriteSheet spriteSheet){
        this.spriteSize = Utilities.SPRITE_MODEL_SIZE_1;
        setSpriteModelImages(new ArrayList<>());
        this.initX = initX;
        this.initY = initY;

        this.endX = endX;
        this.endY = endY;

        BufferedImage[][] spriteSheetImages = spriteSheet.getSpriteSheetImages();

        for(int y = this.initY; y < this.endY; y++){
            for(int x = this.initX; x <= this.endX; x++)
                spriteModelImages.add(spriteSheetImages[y][x]);
        }
    }

    public ArrayList<BufferedImage> getSpriteModelImages() {
        return spriteModelImages;
    }

    public void setSpriteModelImages(ArrayList<BufferedImage> spriteModelImages) {
        this.spriteModelImages = spriteModelImages;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }
}

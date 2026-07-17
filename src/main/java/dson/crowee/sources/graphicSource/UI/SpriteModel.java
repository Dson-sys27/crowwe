package dson.crowee.sources.graphicSource.UI;

import dson.crowee.globals.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteModel {

    private final int spriteSize;
    private int initX, initY, endX, endY;
    private SpriteSheet spriteSheet;
    private ArrayList<BufferedImage> spriteModelImages;

    public SpriteModel(int x, int y, SpriteSheet spriteSheet){
        this.spriteSize = Utilities.SPRITE_MODEL_SIZE_1;

        this.initX = x * spriteSize;
        this.initY = y * spriteSize;

    }

}

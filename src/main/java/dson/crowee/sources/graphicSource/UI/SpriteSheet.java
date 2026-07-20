package dson.crowee.sources.graphicSource.UI;

import dson.crowee.globals.LogViews;
import dson.crowee.globals.Utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SpriteSheet {
    private Integer width, length;
    private BufferedImage[][] spriteSheetImages;
    private int spriteSize;

    public SpriteSheet (final URL sourcePath, final int spriteSize) throws IOException{
        width = spriteSize * 10;
        length = spriteSize * 10;
        this.spriteSize = spriteSize;
        spriteSheetImages = new BufferedImage[length / spriteSize][width / spriteSize];
        BufferedImage spriteImage;
        spriteImage = ImageIO.read(sourcePath);

        try{
            for(int i = 0; i < length / spriteSize; i++)
                for(int j = 0; j < width / spriteSize; j++){
                    BufferedImage currentSprite = new BufferedImage(spriteSize
                            , spriteSize
                            , BufferedImage.TYPE_INT_ARGB);
                    for(int k = 0; k < spriteSize * spriteSize; k++){
                        int rgb = spriteImage.getRGB((k % spriteSize) + (j * spriteSize)
                                , (k / spriteSize) + (i * spriteSize));
                        currentSprite.setRGB((k % spriteSize)
                                , (k / spriteSize), rgb);
                    }
                    spriteSheetImages[i][j] = currentSprite;
                }
        } catch (Exception e) {
            LogViews.dropUnexpectedExceptionError(SpriteSheet.class);
        }
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public BufferedImage[][] getSpriteSheetImages() {
        return spriteSheetImages;
    }
}

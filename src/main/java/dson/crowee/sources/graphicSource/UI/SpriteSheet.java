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
    private Integer width, height;
    private final BufferedImage[][] spriteSheetImages;
    private final int spriteHeight, spriteWidth;

    public SpriteSheet (final URL sourcePath,
                        final int spriteHeight,
                        final int spriteWidth,
                        final int height,
                        final int width
    ) throws IOException{
        this.width = width;
        this.height = height;
        this.spriteHeight = spriteHeight;
        this.spriteWidth = spriteWidth;
        spriteSheetImages = new BufferedImage[spriteHeight][spriteWidth];
        BufferedImage spriteImage;
        spriteImage = ImageIO.read(sourcePath);

        try{
            for(int i = 0; i < this.height / spriteHeight; i++)
                for(int j = 0; j < this.width / spriteWidth; j++){
                    BufferedImage currentSprite = new BufferedImage(
                            spriteWidth
                            , spriteHeight
                            , BufferedImage.TYPE_INT_ARGB);
                    for(int k = 0; k < this.spriteHeight * this.spriteWidth; k++){
                        int rgb = spriteImage.getRGB((k % spriteWidth) + (j * spriteWidth)
                                , (k / spriteHeight) + (i * spriteHeight));
                        currentSprite.setRGB((k % spriteWidth)
                                , (k / spriteHeight), rgb);
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

    public Integer getHeight() {
        return height;
    }

    public void setLength(Integer height) {
        this.height = height;
    }

    public BufferedImage[][] getSpriteSheetImages() {
        return spriteSheetImages;
    }
}

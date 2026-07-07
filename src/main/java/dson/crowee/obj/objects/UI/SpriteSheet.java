package dson.crowee.obj.objects.UI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private Integer width, length;
    private int[] pixelMap;

    public SpriteSheet (final String sourcePath) throws IOException{
        width = Util.SPRITESHEET_STANDARD_WIDTH;
        length = Util.SPRITESHEET_STANDARD_LENGTH;
        pixelMap = new int[Util.SPRITESHEET_STANDARD_WIDTH * Util.SPRITESHEET_STANDARD_LENGTH];
        BufferedImage spriteImage;
        spriteImage = ImageIO.read(SpriteSheet.class.getResource(sourcePath));
        spriteImage.getRGB(
                0,
                0,
                Util.SPRITESHEET_STANDARD_WIDTH,
                Util.SPRITESHEET_STANDARD_LENGTH,
                pixelMap,
                0,
                Util.SPRITESHEET_STANDARD_WIDTH);

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

    public int[] getPixelMap() {
        return pixelMap;
    }

    public void setPixelMap(int[] pixelMap) {
        this.pixelMap = pixelMap;
    }
}

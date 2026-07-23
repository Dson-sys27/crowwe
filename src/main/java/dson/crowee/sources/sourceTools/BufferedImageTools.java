package dson.crowee.sources.sourceTools;

import java.awt.image.BufferedImage;

public class BufferedImageTools{
    public static BufferedImage upSideDownRotation(BufferedImage originalImage) {
        if(originalImage == null)
            return null;

        int origWidth = originalImage.getWidth();
        int origHeight = originalImage.getHeight();

        BufferedImage modifiedImage = new BufferedImage(
                origWidth,
                origHeight,
                BufferedImage.TYPE_INT_ARGB
        );

        for(int i = origHeight - 1; i >= 0; i--)
            for(int j = origWidth - 1; j >= 0; j--){
                int rgb = originalImage.getRGB(j, i),
                        newX = origWidth - j - 1,
                        newY = origHeight - i - 1;
                modifiedImage.setRGB(newX, newY, rgb);
            }

        return modifiedImage;
    }

    public static BufferedImage rotateLeft(BufferedImage originalImage) {
        if(originalImage == null)
            return null;

        int origWidth = originalImage.getWidth();
        int origHeight = originalImage.getHeight();

        BufferedImage modifiedImage = new BufferedImage(
                origWidth,
                origHeight,
                BufferedImage.TYPE_INT_ARGB
        );

        for(int i = origHeight - 1; i >= 0; i--)
            for(int j = origWidth - 1; j >= 0; j--){
                int rgb = originalImage.getRGB(j, i),
                        newX = origWidth - j - 1,
                        newY = origHeight - i - 1;
                modifiedImage.setRGB(newX, newY, rgb);
            }

        return originalImage;
    }

    public static BufferedImage rotateRight(BufferedImage originalImage) {
        return null;
    }
}

package dson.crowee.obj.objects.UI;

public class SpriteModel {

    private final int spriteSize;
    private int x,y;
    private int[] pixelMap;
    private SpriteSheet spriteSheet;

    public SpriteModel(int x, int y, SpriteSheet spriteSheet){
        this.spriteSize = Util.SPRITE_MODEL_SIZE_1;

        this.x = x * spriteSize;
        this.y = y * spriteSize;

        int[] pixelMapFromSpriteSheet = spriteSheet.getPixelMap();
        this.spriteSheet = spriteSheet;
        for(int j = 0; j < spriteSize; j++)
            for(int i = 0; i < spriteSize; i++){
                pixelMap[i + j * spriteSize] =
                        pixelMapFromSpriteSheet[(i * this.x) *
                                (j* this.y) *
                                spriteSheet.getWidth()];
            }

    }

}

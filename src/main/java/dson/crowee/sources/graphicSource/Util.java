package dson.crowee.sources.graphicSource;

public class Util {

    //deltaTime
    static final int NS_PER_SEC = 1000000000;
    static final byte FPS = 60;
    static final double NS_PER_FRAME = NS_PER_SEC / (double)FPS;

    static final int SCREEN_WIDTH = 640;
    static final int SCREEN_HEIGHT = 480;

    static final int SPRITE_SIZE = 32;

    static int SCALE_SIZE = 2;
}

package dson.crowee.globals;

import dson.crowee.sources.sourceTools.MapRenderer;

public class Utilities {


    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;

    public static final int SPRITESHEET_STANDARD_WIDTH = 320;
    public static final int SPRITESHEET_STANDARD_LENGTH = 320;

    public static final int SPRITE_MODEL_SIZE_1 = 32;

    public static final int PLAYER_SPEED = 2;

    public static final int NS_PER_SEC = 1000000000;
    public static final byte FPS = 120;
    public static final double NS_PER_FRAME = NS_PER_SEC / (double)FPS;

    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 480;

    public static final int SPRITE_SIZE = 32;

    public static int SCALE_SIZE = 2;


    public static final int LARGEST_KEY_CODE = 10000;

    public static final int[][] worldMap = MapRenderer.renderMap("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\map\\mapSource");

    public static final int SPATIAL_GRID_CELL_SIZE = 128;

    public static int WAIT_TIME = 10;

}

package dson.crowee.globals;

import dson.crowee.sources.sourceTools.MapRenderer;

public class Utilities {

    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;
    public static final int SPRITE_MODEL_SIZE_1 = 32;
    public static final int PLAYER_SPEED = 2;
    public static final int NS_PER_SEC = 1000000000;
    public static final byte FPS = 120;
    public static final double NS_PER_FRAME = NS_PER_SEC / (double)FPS;
    public static final int WAIT_TIME = 100;

    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 480;
    public static final int SPRITE_SIZE = 32;
    public static int SCALE_SIZE = 2;

    public static final int LARGEST_KEY_CODE = 10000;
    public static final int[][] WORLD_MAP = MapRenderer.renderMap("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\map\\mapSource");
    public static final String SPRITESHEET_1_R_PATH = "/sprites/bg/spritesheet_1.png";
    public static final String UI_SPRITESHEET = "/sprites/bg/UI/UI_spritesheet.png";
    public static final int SPATIAL_GRID_CELL_SIZE = 128;
    public static final int MAP_DRAWER_OFFSET = 4;
    public static final int CAMERA_DISPLAY_OFFSET_X = SCREEN_WIDTH / SPRITE_SIZE;
    public static final int CAMERA_DISPLAY_OFFSET_Y = SCREEN_HEIGHT / SPRITE_SIZE;


}

package dson.crowee.sources.graphicSource;

import dson.crowee.obj.objects.UI.Screen;

public class ScreenManager {
    private static  int[][] screenGrid; // on pixels
    private int[] mapGrid; // on pixels
    private int[] spriteGrid; // on spriteUnits

    public static void setScreenManagerOnWork(){
        screenGrid = new int[Util.SCREEN_HEIGHT][Util.SCREEN_WIDTH];
    }

}
package dson.crowee.sources.graphicSource.UI;

import dson.crowee.globals.Utilities;

@Deprecated
public class Screen {
    private int width, length;
    private int[] pixelmap;

    public Screen(){
        this.length = Utilities.WINDOW_HEIGHT;
        this.width = Utilities.WINDOW_WIDTH;

        pixelmap = new int[this.length * this.width];
    }

    public void clean(){
        for(int i = 0; i < length; i++)
            pixelmap[i] = 0;
    }

    public void show(final int compensationX, final int compensationY){
        for(int j = 0; j < length; j++){
            int positionY = compensationY + j;
            if(positionY > 0 || positionY >= length)
                continue;

            for(int i = 0; i < width; i++){
                int positionX = compensationX + i;
                if(positionX > 0 || positionX >=width)
                    continue;

                //TODO
            }
        }
    }
}

package dson.crowee.sources.graphicSource.singleGraphicManagers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UIGraphicsManager {

    private static ArrayList<Image> UIImages;

    public static void setUIGraphicsManagerOnWork(){
        UIImages = new ArrayList<>();
        Image heart = null;
        try{
            heart = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\UI\\img.png"));
        }catch(Exception e){

        }
        UIImages.addFirst(heart);
    }

    public static void drawUIObjects(Graphics2D graphics){
        graphics.drawImage(UIImages.getFirst(), 600, 380, 32, 32, null);
    }
}

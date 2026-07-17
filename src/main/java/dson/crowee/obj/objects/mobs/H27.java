package dson.crowee.obj.objects.mobs;

import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.Mob;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class H27 extends Mob {
    public H27(FormalCode formalCode, int x, int y){
        super(formalCode, x, y);
        Image im = null;
        try{
            im = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\baldark.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSpriteImage(im, 0);
    }
}

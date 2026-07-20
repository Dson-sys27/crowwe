package dson.crowee.sources.graphicSource.DrawerClasses;

import dson.crowee.obj.buiders.EntityFactory;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.Prop;
import dson.crowee.sources.colliderSystem.CollisionManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class PropsGraphicsDrawer {
    private static TreeMap<Integer, Entity> props;

    public static void setPropsGraphicsManagerOnWork(){
        if(props == null){
            props = new TreeMap<Integer, Entity>();
        }
        /*
        Entity farola = props.get(0);
        if(farola == null)
            farola = EntityFactory.;
        props.put(0, farola);
        CollisionManager.setEntityOnSpatialGrid(farola);
        ArrayList<Image> spritesImages = props.get(0).getSpriteImages();
        Image farolaImage = null;
        try{
            farolaImage = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\farola.png"));
        }catch (IOException e){
            System.out.println("caca");
        }
        spritesImages.add(farolaImage);
        */
         
    }

    public static void drawObjects(Graphics2D graphics){
        Entity farola = props.get(0);
        Image image = farola.getSpriteImages().getFirst();
        graphics.drawImage(image, farola.getX(), farola.getY(), 128, 128, null);
    }

    public static void setProps(Integer key, Entity value){
        props.put(key, value);
    }

}

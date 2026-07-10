package dson.crowee.sources.colliderSystem;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.Entity;

import java.util.List;

public class CollisionManager {
    private static List<Signal> signalMail;
    private List<Entity>[][] quadTreeGrid;
    private static int width, heigth;

    public static void setTriggerSystemOnWork(){
        heigth = Utilities.worldMap.length;
        width = Utilities.worldMap[0].length;
    }

    public static void receiveSignal(){
        while(!signalMail.isEmpty()){
            Signal signal = signalMail.getFirst();
            
        }
    }

    public static List<Signal> getSignalMail(){
        return signalMail;
    }
}

package dson.crowee.sources.colliderSystem;

import dson.crowee.obj.objects.Entity;

import java.awt.*;
import java.util.List;

public class Trigger <T extends Entity>{
    private final T entityOnTrigger;
    private int triggerX, triggerY, heigth, width;

    public Trigger(T entityOnTrigger){
        this.entityOnTrigger = entityOnTrigger;
        triggerX = entityOnTrigger.getX();
        triggerY = entityOnTrigger.getY();
    }

    public void render(Graphics graphics){
        graphics.setColor(new Color(Color.RED.getRGB()));
        graphics.drawRect(triggerX, triggerY, 20, 32);
    }

    public void udatePosition(){
        triggerX = entityOnTrigger.getX();
        triggerY = entityOnTrigger.getY();
    }

    public boolean onCollision(int x, int y){
        return (x >= triggerX && x <= (width + triggerX))
                && (y >= triggerY && y <= (heigth + triggerY));
    }

    public void sendSignal(){
        List<Signal> signalMail = CollisionManager.getSignalMail();
        //signalMail.add(new Signal(entityOnTrigger, entityOnTrigger.getX(), entityOnTrigger.getY(), ));
    }
}

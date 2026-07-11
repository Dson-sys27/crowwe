package dson.crowee.sources.colliderSystem;

import dson.crowee.obj.objects.Entity;

import java.awt.*;

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public T getEntityOnTrigger() {
        return entityOnTrigger;
    }

    public int getTriggerX() {
        return triggerX;
    }

    public void setTriggerX(int triggerX) {
        this.triggerX = triggerX;
    }

    public int getTriggerY() {
        return triggerY;
    }

    public void setTriggerY(int triggerY) {
        this.triggerY = triggerY;
    }
}

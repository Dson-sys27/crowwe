package dson.crowee.sources.colliderSystem;

import dson.crowee.obj.objects.Entity;

import java.awt.*;

public class Trigger <T extends Entity>{
    private final T entityOnTrigger;
    private int triggerX, triggerY, height, width;

    public Trigger(T entityOnTrigger, int height, int width){
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

    public boolean onCollision(Trigger<?> other) {
        // Nota: Te recomiendo cambiar tu variable 'heigth' por 'height' (la forma correcta en inglés)
        return (this.triggerX < other.triggerX + other.width) &&
                (this.triggerX + this.width > other.triggerX) &&
                (this.triggerY < other.triggerY + other.height) &&
                (this.triggerY + this.height > other.triggerY);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return height;
    }

    public void setHeigth(int height) {
        this.height = height;
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

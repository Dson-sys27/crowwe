package dson.crowee.sources.colliderSystem;

import dson.crowee.obj.objects.Entity;

public class Signal {
    Entity entity;
    int x, y, previousX, previousY;

    public Signal(Entity entity, int previousX, int previousY){
        this.entity = entity;
        this.x = entity.getX();
        this.y = entity.getY();
        this.previousX = previousX;
        this.previousY = previousY;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPreviousX() {
        return previousX;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }
}

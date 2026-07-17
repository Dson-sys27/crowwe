package dson.crowee.obj.objects;

import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;
import dson.crowee.sources.graphicSource.UI.SpriteSheet;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {
    private FormalCode formalCode;
    private Integer internalCode;
    private String formmalName;
    @Deprecated
    private ArrayList<Image> spriteImages;
    private SpriteModel spriteModel;
    private int x, y;
    private Trigger<Entity> trigger;
    @Deprecated
    private Boolean onScreen;

    public Entity(){
        this.spriteImages = new ArrayList<Image>();

    }

    public Entity(FormalCode formalCode, int x, int y){
        this();
        this.formalCode = formalCode;
        setX(x);
        setY(y);
    }

    public FormalCode getFormalCode() {
        return formalCode;
    }

    public void setFormalCode(FormalCode formalCode) {
        this.formalCode = formalCode;
    }

    public Integer getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(Integer internalCode) {
        this.internalCode = internalCode;
    }

    public String getFormmalName() {
        return formmalName;
    }

    public void setFormmalName(String formmalName) {
        this.formmalName = formmalName;
    }

    public ArrayList<Image> getSpriteImages() {
        return spriteImages;
    }

    public void setSpriteImage(Image spriteImage, int pos) {
        this.spriteImages.add(pos, spriteImage);
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

    public Trigger<Entity> getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger<Entity> trigger) {
        this.trigger = trigger;
    }

    public void setSpriteImages(ArrayList<Image> spriteImages) {
        this.spriteImages = spriteImages;
    }

    public Boolean getOnScreen() {
        return onScreen;
    }

    public void setOnScreen(Boolean onScreen) {
        this.onScreen = onScreen;
    }
}

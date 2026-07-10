package dson.crowee.obj.objects;

import dson.crowee.sources.colliderSystem.Trigger;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {
    private FormalCode formalCode;
    private Integer internalCode;
    private String formmalName;
    private ArrayList<Image> spriteImages;
    private int x, y;
    private Trigger trigger;
    private Boolean onScreen;

    public Entity(FormalCode formalCode){
        this.formalCode = formalCode;
        this.spriteImages = new ArrayList<Image>();
    }

    public Entity(FormalCode formalCode, int x, int y){
        this(formalCode);
        this.x = x;
        this.y = y;
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

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
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

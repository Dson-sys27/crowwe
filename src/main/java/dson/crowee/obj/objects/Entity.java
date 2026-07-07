package dson.crowee.obj.objects;

import java.awt.*;

public abstract class Entity {
    private String formalCode;
    private Integer internalCode;
    private String formmalName;
    private Image spriteImage;
    private Float x, y;

    public String getFormalCode() {
        return formalCode;
    }

    public void setFormalCode(String formalCode) {
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

    public Image getSpriteImage() {
        return spriteImage;
    }

    public void setSpriteImage(Image spriteImage) {
        this.spriteImage = spriteImage;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}

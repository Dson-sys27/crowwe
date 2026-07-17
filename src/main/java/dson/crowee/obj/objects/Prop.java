package dson.crowee.obj.objects;

import dson.crowee.globals.Utilities;
import dson.crowee.sources.colliderSystem.Trigger;

import java.util.ArrayList;

public class Prop extends Entity {

    public Prop(FormalCode formalCode, int x, int y){
        super(formalCode, x, y);

        this.setSpriteImages(new ArrayList<>());
        super.setTrigger(new Trigger<>(this, 32, 32));

        super.getTrigger().setTriggerX(super.getX());
        super.getTrigger().setTriggerY(super.getY());
        super.getTrigger().setHeigth(Utilities.SPRITE_SIZE);
        super.getTrigger().setWidth(Utilities.SPRITE_SIZE);


    }

}
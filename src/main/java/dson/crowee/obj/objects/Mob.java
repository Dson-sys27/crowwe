package dson.crowee.obj.objects;

import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;

import java.awt.*;

public abstract class Mob extends Entity{
    Trigger<Entity> onSightTrigger;

    public Mob(){

    }


    public Mob(FormalCode formalCode, Integer internalCode, int x, int y, SpriteModel spriteModel, Trigger<Entity> trigger){
        super(formalCode, internalCode, x, y, spriteModel, trigger);
    }

}

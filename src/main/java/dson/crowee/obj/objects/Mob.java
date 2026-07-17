package dson.crowee.obj.objects;

import dson.crowee.sources.colliderSystem.Trigger;

import java.awt.*;

public abstract class Mob extends Entity{
    Trigger onSightTrigger;

    public Mob(FormalCode formalCode, int x, int y){
        super(formalCode, x, y);
    }
}

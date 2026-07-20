package dson.crowee.obj.objects;

import dson.crowee.globals.Utilities;
import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;

import java.util.ArrayList;

public class Prop extends Entity {

    public Prop(FormalCode formalCode, Integer internalCode, int x, int y, SpriteModel spriteModel, Trigger<Entity> trigger){
        super(formalCode, internalCode, x, y, spriteModel, trigger);
    }

}
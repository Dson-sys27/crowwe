package dson.crowee.obj.objects.mobs;

import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.FormalCode;
import dson.crowee.obj.objects.Mob;
import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;

public class Baldark extends Mob {

    public Baldark(FormalCode formalCode, Integer internalCode, int x, int y, SpriteModel spriteModel, Trigger<Entity> trigger){
        super(formalCode, internalCode, x, y, spriteModel, trigger);
    }
}

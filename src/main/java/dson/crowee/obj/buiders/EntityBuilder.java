package dson.crowee.obj.buiders;

import dson.crowee.localStorage.entityMetadata.EntityRecord;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.FormalCode;
import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;

public interface EntityBuilder {
    abstract FormalCode setFormalCode(FormalCode code);
    abstract Integer setInternalCode();
    abstract Trigger<Entity> setTrigger(EntityRecord record);
    abstract SpriteModel setSpriteModel(EntityRecord record);

    abstract int setX();
    abstract int setY();
    abstract Entity build(FormalCode entityCode) throws NoSuchMethodException;
}

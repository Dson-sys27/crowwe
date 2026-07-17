package dson.crowee.obj.buiders;

import dson.crowee.obj.objects.Entity;

public interface EntityBuilder {
    abstract void setFormalCode();
    abstract void setInternalCode();
    abstract void setTrigger();
    abstract void setSpriteModel();

    abstract void setX();
    abstract void setY();
    abstract Entity build(Entity entity);
}

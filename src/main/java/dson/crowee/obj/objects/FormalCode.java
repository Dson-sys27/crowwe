package dson.crowee.obj.objects;

import dson.crowee.obj.objects.mobs.Baldark;

public enum FormalCode {
    //playerArea
    PLAYER(PlayerCharacter.class),
    //mobArea
    BALDARK(Baldark.class),
    H27(Mob.class),
    //propsArea
    ONE_LIGHT_STREETLIGHT(Prop.class),
    TWO_LIGHT_STREETLIGHT(Prop.class);
    //tilesArea


    private final Class<? extends Entity> entityClass;

    FormalCode(Class<? extends Entity> entityClass){
        this.entityClass = entityClass;
    }

    public Class<? extends Entity> getValueOfFormalCode(FormalCode formalCode){
        return this.entityClass;
    }
}

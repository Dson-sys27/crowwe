package dson.crowee.obj.buiders;

import dson.crowee.obj.objects.Mob;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.obj.objects.Prop;

public enum ClassCode {
    PLAYER_CHARACTER(PlayerCharacter.class),
    MOB(Mob.class),
    PROP(Prop.class);

    ClassCode(Object object) {

    }
}

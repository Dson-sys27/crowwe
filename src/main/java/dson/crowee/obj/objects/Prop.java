package dson.crowee.obj.objects;

import java.util.ArrayList;

public class Prop extends Entity {

    public Prop(FormalCode formalCode, int x, int y){
        super(formalCode, x, y);

        this.setSpriteImages(new ArrayList<>());
    }

}
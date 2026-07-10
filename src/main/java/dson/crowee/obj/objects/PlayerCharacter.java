package dson.crowee.obj.objects;

import dson.crowee.sources.colliderSystem.Trigger;

public class PlayerCharacter extends Entity{

      private int heathScore;

      public PlayerCharacter(FormalCode formalCode){
            super(formalCode);
            super.setX(0);
            super.setY(0);
            super.setTrigger(new Trigger<>(this));
            this.heathScore = 100;
      }

}

package dson.crowee.obj.objects;

import dson.crowee.sources.colliderSystem.Trigger;

public class PlayerCharacter extends Entity{

      public int heathScore;

      public PlayerCharacter(FormalCode formalCode){
            super(formalCode);
            super.setX(0);
            super.setY(0);
            super.setTrigger(new Trigger<>(this));
            this.heathScore = 100;
      }

      public void setHeathScore(int heathScore){
            this.heathScore = heathScore;
      }

      public int getHeathScore(){
            return heathScore;
      }

}

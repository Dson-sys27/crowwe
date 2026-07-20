package dson.crowee.obj.objects;

import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;

public class PlayerCharacter extends Entity{

      public int heathScore;

      public PlayerCharacter(){

      }

      public PlayerCharacter(FormalCode formalCode, Integer internalCode, int x, int y, SpriteModel spriteModel, Trigger<Entity> trigger){
            super(formalCode, internalCode, x, y, spriteModel, trigger);
      }

      public void setHeathScore(int heathScore){
            this.heathScore = heathScore;
      }

      public int getHeathScore(){
            return heathScore;
      }

}

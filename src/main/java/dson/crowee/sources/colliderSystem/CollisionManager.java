package dson.crowee.sources.colliderSystem;

import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.entityControllers.Event;
import dson.crowee.sources.entityControllers.EventCode;
import dson.crowee.sources.entityControllers.PlayerEventManager;

import java.util.*;

public class CollisionManager {
    private static ArrayDeque<Signal> signalMail;
    private static ArrayList<Entity>[][] spatialGrid;
    private static int width, heigth;

    public static void setTriggerSystemOnWork(){
        signalMail = new ArrayDeque<>();

        heigth = Utilities.WORLD_MAP.length * Utilities.SPRITE_SIZE / Utilities.SPATIAL_GRID_CELL_SIZE;
        width = Utilities.WORLD_MAP.length * Utilities.SPRITE_SIZE  / Utilities.SPATIAL_GRID_CELL_SIZE;

        spatialGrid = new ArrayList[heigth][width];

        for(int i = 0; i < heigth; i++)
            for(int j = 0; j < width; j++)
                spatialGrid[i][j] = new ArrayList<>();
    }

    private static void updateEntitiesOnSpatialGrid(Entity playerOnMotion, int row, int col, int oldRow, int oldCol){
        List<Entity> entitiesOnCell = spatialGrid[row][col];
        Trigger<Entity> playerTrigger = playerOnMotion.getTrigger();

        for(Entity entity : entitiesOnCell){
            if(entity == playerOnMotion)
                continue;

            if(col != oldCol || row != oldRow)
                spatialGrid[row][col].remove(playerOnMotion);

            if(playerTrigger.onCollision(entity.getTrigger())){
                //TODO : handle trigger events
                Event event = new Event(entity, EventCode.DAMAGE_EVENT);
                PlayerEventManager.sendEvent(event);
            }
        }
    }

    public static void processSignals(){
        while(!signalMail.isEmpty()){
            Signal currentSignal = signalMail.poll();
            Entity playerOnMotion = currentSignal.getEntity();

            int oldCol = Math.max(0, Math.min(width - 1, currentSignal.getPreviousX() / Utilities.SPATIAL_GRID_CELL_SIZE));
            int oldRow = Math.max(0, Math.min(heigth - 1, currentSignal.getPreviousY() / Utilities.SPATIAL_GRID_CELL_SIZE));

            int newCol = Math.max(0, Math.min(width - 1, currentSignal.getX() / Utilities.SPATIAL_GRID_CELL_SIZE));
            int newRow = Math.max(0, Math.min(heigth - 1, currentSignal.getY() / Utilities.SPATIAL_GRID_CELL_SIZE));

            updateEntitiesOnSpatialGrid(playerOnMotion, newRow, newCol, oldRow, oldCol);

        }
    }

    public static ArrayDeque<Signal> getSignalMail(){
        return signalMail;
    }

    public static List<Entity>[][] getSpatialGrid(){
        return spatialGrid;
    }

    public static void setEntityOnSpatialGrid(Entity entity){
        int entityX = entity.getX();
        int entityY = entity.getY();

        int col = entityX / Utilities.SPATIAL_GRID_CELL_SIZE;
        int row = entityY / Utilities.SPATIAL_GRID_CELL_SIZE;

        spatialGrid[row][col].add(entity);
    }

    public static void removeEntityFromSpatianCell(Entity entity){

    }
}

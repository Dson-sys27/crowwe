package dson.crowee.obj.buiders;

import dson.crowee.globals.LogViews;
import dson.crowee.globals.Utilities;
import dson.crowee.localStorage.entityMetadata.EntityMetadataContainer;
import dson.crowee.localStorage.entityMetadata.EntityRecord;
import dson.crowee.obj.objects.Entity;
import dson.crowee.obj.objects.FormalCode;
import dson.crowee.sources.colliderSystem.Trigger;
import dson.crowee.sources.graphicSource.UI.SpriteModel;
import dson.crowee.sources.graphicSource.UI.SpriteSheet;

import java.net.URL;

public class EntityFactory implements EntityBuilder{

    private static EntityFactory entityFactory;

    private EntityFactory(){

    }

    public static EntityFactory getInstance(){
        if(entityFactory == null)
            entityFactory = new EntityFactory();
        return  entityFactory;
    }

    @Override
    public FormalCode setFormalCode(FormalCode code) {
        return code;
    }

    @Override
    public Integer setInternalCode() {
        //TODO: internalId assignation logic
        return 0;
    }

    @Override
    public Trigger<Entity> setTrigger(EntityRecord record) {
        return new Trigger<>(record.x(), record.y(), record.triggerHeight(), record.triggerWidth());
    }

    @Override
    public SpriteModel setSpriteModel(EntityRecord record) {
        SpriteSheet spriteSheet = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource(record.spriteSheetRelativePath());
        try{
            spriteSheet = new SpriteSheet(
                    url,
                    record.spriteHeight(),
                    record.spriteWidth(),
                    record.spriteHeight() * 10,
                    record.spriteWidth() * 10
            );
        } catch (Exception e) {
            LogViews.dropIOExceptionError(record.spriteSheetRelativePath(), EntityFactory.class);
        }
        return new SpriteModel(
                record.spriteInitX(),
                record.spriteInitY(),
                record.spriteEndX(),
                record.spriteEndY(),
                spriteSheet);
    }

    @Override
    public int setX() {
        return 10;
    }

    @Override
    public int setY() {
        return 0;
    }

    @Override
    public Entity build(FormalCode entityCode) {
        EntityRecord entityMetadata = EntityMetadataContainer.getEntityMetadata(entityCode);
        Class<? extends Entity> entityClass = entityCode.getValueOfFormalCode(entityCode);
        Entity builtEntity = null;
        try{
            Trigger<Entity> builtTrigger = setTrigger(entityMetadata);
            builtEntity = entityClass.getDeclaredConstructor(
                    FormalCode.class,
                    Integer.class,
                    int.class,
                    int.class,
                    SpriteModel.class,
                    Trigger.class)
                    .newInstance(
                        setFormalCode(entityCode)
                        ,setInternalCode()
                        ,setX()
                        ,setY()
                        ,setSpriteModel(entityMetadata)
                        ,builtTrigger

            );    //formalCode, internalCode, x, y, spriteModel, trigger
            builtTrigger.setEntityOnTrigger(builtEntity);
        }catch (Exception e){
            e.printStackTrace();
            LogViews.dropUnexpectedExceptionError(EntityFactory.class);
        }
        return  builtEntity;
    }
}

package dson.crowee.sources;

import dson.crowee.obj.objects.Item;
import dson.crowee.obj.objects.Mob;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;

public class DataStorageManager <T extends Item>{

    private static ObjectMapper objectMapper;

    public static void loadObjectMapper(){
        if(objectMapper == null){
            objectMapper = JsonMapper.builder()
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .build();
        }
    }

    public static void storageObjectAsJSONFile(Object object){
        String objectType = "";
        if(object.getClass().equals(Item.class))
            try{
                objectMapper.writeValue(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\java\\dson\\crowee\\localStorage\\itemInstances\\items.json"), object);

            }catch (Exception e){
                e.printStackTrace();
            }
    }

    private static void storageAction(){

    }
}

package dson.crowee.localStorage.entityMetadata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dson.crowee.obj.objects.FormalCode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

import java.util.EnumMap;
import java.util.Map;

public class EntityMetadataContainer {
    private static EnumMap<FormalCode, EntityRecord> mDataContainer;

    private static ObjectMapper objectMapper;

    public static void setEntityMetadataClassOnWork(){
        loadObjectMapper();

        try (FileReader reader = new FileReader("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\mData\\entities_metadata.json")){
            Gson gson = new Gson();
            Type tokenType = new TypeToken<Map<FormalCode, EntityRecord>>(){}.getType();
            Map<FormalCode, EntityRecord> data = gson.fromJson(reader, tokenType);
            mDataContainer = new EnumMap<>(data);
        }
        catch (IOException e){

        }
    }

    public static EntityRecord getEntityMetadata(FormalCode code){
        return mDataContainer.get(code);
    }

    private static void loadObjectMapper(){
        if(objectMapper == null){
            objectMapper = JsonMapper.builder()
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .build();
        }
    }
}

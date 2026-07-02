package dson.crowee;

import dson.crowee.obj.objects.Item;
import dson.crowee.obj.objects.UI.Canva;
import dson.crowee.sources.DataStorageManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main() {

        // initial config be4 starting...
        Canva canva = new Canva();
        DataStorageManager.loadObjectMapper();



        Item item = new Item();

        item.setCarrierCode("1234");
        item.setFormalCode("2344");
        item.setInternalCode(Integer.valueOf(123));
        item.setOnCarryBy("3efe");

        DataStorageManager.storageObjectAsJSONFile(item);
    }
}

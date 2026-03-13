package com.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSonReader {

    
    /** 
     * @param filePath
     * @return List<Item>
     */
    public static List<Item> loadItemsInOrder(String filePath) {
        List<Item> items = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray itemsArray = (JSONArray) jsonObject.get("items");

            for (Object obj : itemsArray) {
                JSONObject itemJson = (JSONObject) obj;

                String name = (String) itemJson.get("name");
                int price = getIntValue(itemJson, "price");
                int effectValue = getIntValue(itemJson, "effect");
                String sprite = (String) itemJson.getOrDefault("sprite", "default.png");
                String description = (String) itemJson.getOrDefault("description", "No description available.");
                int negativeEffectValue = getIntValue(itemJson, "negativeEffectValue");
                int storeAmount = getIntValue(itemJson, "storeAmount");
                int inventoryAmount = getIntValue(itemJson, "inventoryAmount");

                // Fix enum parsing safely
                Item.ItemType type = parseEnum(Item.ItemType.class, (String) itemJson.get("type"), Item.ItemType.FOOD);
                Item.ElementType elementType = parseEnum(Item.ElementType.class, (String) itemJson.get("elementType"), Item.ElementType.FIRE);

                // Create and add item to the list
                Item item = new Item(name, effectValue, price, sprite, description, type, storeAmount, inventoryAmount, elementType, negativeEffectValue);
                items.add(item);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return items;
    }

    // Helper method to safely parse integers
    private static int getIntValue(JSONObject json, String key) {
        Object value = json.get(key);
        return (value instanceof Number) ? ((Number) value).intValue() : 0;
    }

    // Generic method to safely parse enums with a default value
    private static <T extends Enum<T>> T parseEnum(Class<T> enumClass, String value, T defaultValue) {
        try {
            return value != null ? Enum.valueOf(enumClass, value.toUpperCase()) : defaultValue;
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid enum value: " + value + ", defaulting to " + defaultValue);
            return defaultValue;
        }
    }
}

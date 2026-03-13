package com.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save_Inventory{

    public static void save(String filePath, String nameToUpdate, int newInventoryAmount, int moneyAmount) {
        System.out.println("File path: " + filePath);

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject data = (JSONObject) jsonParser.parse(new FileReader(filePath));

            // Safely update money
            if (data.get("money") != null) {
                long money = (long) data.get("money");
                data.put("money", moneyAmount);
            } else {
                data.put("money", moneyAmount); // Add it if it doesn't exist
            }

            JSONArray inventory = (JSONArray) data.get("items");

            boolean itemFound = false;

            for (Object item : inventory) {
                JSONObject itemObj = (JSONObject) item;
                String name = (String) itemObj.get("name");

                if (name != null && name.equals(nameToUpdate)) {
                    itemFound = true;

                    if (itemObj.get("inventoryAmount") != null) {
                        itemObj.put("inventoryAmount", newInventoryAmount);
                    } else {
                        itemObj.put("inventoryAmount", newInventoryAmount); // Add the key if missing
                    }
                    break;
                }
            }

            if (!itemFound) {
                System.out.println("Item not found: " + nameToUpdate);
            }

            // Write back to the file
            try (FileWriter file = new FileWriter(filePath)) {
                file.write(data.toJSONString());
                file.flush();
            }

            System.out.println("Inventory and money updated successfully!");

        } catch (IOException e) {
            System.err.println("Error reading or writing the file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}

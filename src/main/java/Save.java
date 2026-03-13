package com.example;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Save {

    public static void saveGame(Pet chosePet, int index) {
        Path path = Paths.get("src/main/java/com/example/save.json");
        String absPath = path.toAbsolutePath().toString();

        List<Pet> pets = Load.loadGame(absPath);

        JSONArray json = new JSONArray();
        for (int i = 0; i < 3; i++) {
            JSONObject petJson = new JSONObject();
            Pet pet = pets.get(i);
            if(i != index){
                json.add(saveHelper(petJson, pet));
            }
            else{
                petJson.put("name", chosePet.getName());
                petJson.put("level", chosePet.getLevel());
                petJson.put("health", chosePet.getHealth());
                petJson.put("happiness", chosePet.getHappiness());
                petJson.put("sleep", chosePet.getSleep());
                petJson.put("hunger", chosePet.getFullness());

                if(chosePet.getType() == Pet.ElementType.EARTH){
                    petJson.put("element",0);
                }
                else if(chosePet.getType() == Pet.ElementType.FIRE){
                    petJson.put("element", 1);
                }
                else if(chosePet.getType() == Pet.ElementType.WATER){
                    petJson.put("element", 2);
                }
                petJson.put("score", chosePet.getScore());
                petJson.put("exp",chosePet.getEXP());
                petJson.put("asleep", chosePet.checkAsleep());

                json.add(petJson);
            }
        }

        try (FileWriter file = new FileWriter(absPath)) {
            file.write(json.toJSONString());
            System.out.println("Game saved successfully.");
            file.close();
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public static void reset(int index) {
        Path path = Paths.get("src/main/java/com/example/save.json");
        String absPath = path.toAbsolutePath().toString();

        List<Pet> pets = Load.loadGame(absPath);

        JSONArray json = new JSONArray();
        for (int i = 0; i < 3; i++) {
            JSONObject petJson = new JSONObject();
            Pet pet = pets.get(i);
            if(i != index){
                json.add(saveHelper(petJson, pet));
            } else {
                petJson.put("name", "");
                petJson.put("level", -1);
                petJson.put("health", -1);
                petJson.put("happiness", -1);
                petJson.put("sleep", -1);
                petJson.put("hunger", -1);
                petJson.put("element", -1);
                petJson.put("score", -1);
                petJson.put("exp",-1);
                petJson.put("asleep",false);

                json.add(petJson);
            }
        }

        try (FileWriter file = new FileWriter(absPath)) {
            file.write(json.toJSONString());
            System.out.println("Game saved successfully.");
            file.close();
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    private static JSONObject saveHelper(JSONObject petJson, Pet pet) {
        if (pet != null) {
            petJson.put("name", pet.getName());
            petJson.put("level", pet.getLevel());
            petJson.put("health", pet.getHealth());
            petJson.put("happiness", pet.getHappiness());
            petJson.put("sleep", pet.getSleep());
            petJson.put("hunger", pet.getFullness());

            if(pet.getType() == Pet.ElementType.EARTH){
                petJson.put("element",0);
            }
            else if(pet.getType() == Pet.ElementType.FIRE){
                petJson.put("element", 1);
            }
            else if(pet.getType() == Pet.ElementType.WATER){
                petJson.put("element", 2);
            }
            petJson.put("score", pet.getScore());
            petJson.put("exp",pet.getEXP());
            petJson.put("asleep", pet.checkAsleep());
        } else {
            petJson.put("name", "");
            petJson.put("level", -1);
            petJson.put("health", -1);
            petJson.put("happiness", -1);
            petJson.put("sleep", -1);
            petJson.put("hunger", -1);
            petJson.put("element", -1);
            petJson.put("score", -1);
            petJson.put("exp",-1);
            petJson.put("asleep", false);
        }

        return petJson;
    }
}
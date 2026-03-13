package com.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.Pet.State;

public class Load {

    public static List<Pet> loadGame(String filepath) {
        List<Pet> pets = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filepath)) {
            Object obj = jsonParser.parse(reader);
            JSONArray petList = (JSONArray) obj;

            for (Object petObj : petList) {
                JSONObject petJson = (JSONObject) petObj;
                String name = (String) petJson.get("name");
                int level = ((Long) petJson.get("level")).intValue();
                int health = ((Long) petJson.get("health")).intValue();
                int happiness = ((Long) petJson.get("happiness")).intValue();
                int sleep = ((Long) petJson.get("sleep")).intValue();
                int hunger = ((Long) petJson.get("hunger")).intValue();
                int element =  ((Long) petJson.get("element")).intValue();
                int score =  ((Long) petJson.get("score")).intValue();
                int exp =  ((Long) petJson.get("exp")).intValue();
                ArrayList<State> state = new ArrayList<>();
                state.add(State.NORMAL);
                if ((boolean) petJson.get("asleep")) state.add(State.ASLEEP);
                if (health == 0) state.add(State.DEAD);
                if (happiness == 0) state.add(State.ANGRY);
                if (hunger == 0) state.add(State.HUNGRY);

                Pet pet = null;

                if(element == 0){
                    pet = new Blonk(name, health, sleep, hunger, happiness, state, score, exp, level);
                }
                else if(element == 1){
                    pet = new Bouba(name, health, sleep, hunger, happiness, state, score, exp, level);
                }
                else if (element == 2){
                    pet = new Blorbo(name, health, sleep, hunger, happiness, state, score, exp, level);
                }

                pets.add(pet);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error loading game: " + e.getMessage());
        }

        return pets;
    }
}
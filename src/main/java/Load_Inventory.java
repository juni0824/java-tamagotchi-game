package com.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class Load_Inventory{

    public static long loadMoney(String filePath) {
        long money = 0;
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject data = (JSONObject) jsonParser.parse(new FileReader(filePath));

            money = (long) data.get("money");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return money;
    }

}

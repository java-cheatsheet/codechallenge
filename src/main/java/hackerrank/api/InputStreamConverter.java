package hackerrank.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class InputStreamConverter {

    public static String toString(InputStream is)
            throws InventoryNotFoundException {

        StringBuilder sb = new StringBuilder();
        String jsonString = null;
        String line;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(is))) {

            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

            JSONObject json = new JSONObject(sb.toString());
            JSONArray dataArray = (JSONArray) json.get("data");

            if ( dataArray.isEmpty() ) {
                throw new InventoryNotFoundException("Inventory Not Found!");
            }

            jsonString = dataArray.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}

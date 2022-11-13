package hackerrank.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Convert Input Stream to String
 */
@SuppressWarnings("PMD.LawOfDemeter")
public final class InputStreamConverterUtil {

    /**
     * To prevent initialization
     */
    private InputStreamConverterUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param inputStream InputStream
     * @return String JSON inventory string
     * @throws InventoryNotFoundException Inventory Not Found
     */
    public static String toString(final InputStream inputStream)
            throws InventoryNotFoundException, IOException {

        final StringBuilder stringBuilder = new StringBuilder();
        String line;

        final BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
        do {
            line = reader.readLine();
            stringBuilder.append(line).append('\n');
        } while (line != null);

        final JSONObject json = new JSONObject(
                stringBuilder.toString());
        final  JSONArray dataArray = (JSONArray) json.get("data");

        if ( dataArray.isEmpty() ) {
            throw new InventoryNotFoundException(
                    "Inventory Not Found!");
        }

        return dataArray.toString();
    }
}

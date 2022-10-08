package hackerrank.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarcodeReader   {

    private final static String TAG = BarcodeReader.class.getSimpleName();
    private final static Logger logger =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final static String inventoryURI = "https://jsonmock.hackerrank.com/api/inventory";

    public Inventory read(int barcode) {
        Inventory inventory = null;
        String barcodeURI = inventoryURI + "?barcode=";

        try {
            String inventoryJSONString = InputStreamConverter.toString(
                    HttpRequests.get(barcodeURI+barcode));

            inventory =  getInventories(inventoryJSONString)[0];

        } catch (InventoryNotFoundException e) {
            if (logger.isLoggable(Level.INFO)) {
                logger.log(Level.INFO, TAG + " InventoryNotFoundException: " + e.getMessage());
            }
        } catch (MalformedURLException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, TAG + " MalformedURLException: " + e.getMessage());
            }
        } catch (IOException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.severe(TAG + " IOException: " + e.getMessage());
            }
        } catch (Exception e) {
            if (logger.isLoggable(Level.INFO)) {
                logger.info(TAG + " Exception: " + e.getMessage());
            }
        }

        return inventory;
    }

    private Inventory[] getInventories(String jsonInventories)
            throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        return objectMapper
                .readValue(jsonInventories,
                        Inventory[].class);
    }

}


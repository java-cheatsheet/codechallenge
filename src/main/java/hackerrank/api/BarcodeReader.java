package hackerrank.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarcodeReader   {

    private final static String TAG = HttpHandler.class.getSimpleName();
    private final static Logger logger =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final static String barcodeURI = "https://jsonmock.hackerrank.com/api/inventory?barcode=";

    public Inventory read(int barcode)
            throws BarcodeNotFoundException {
        Inventory[] inventories = null;

        try {
            String inventoryJSONString = InputStreamConverter.toString(
                    HttpRequests.get(barcodeURI+barcode))
                    .toString();

            inventories =  getInventories(inventoryJSONString);

        } catch (MalformedURLException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, TAG + " MalformedURLException: " + e.getMessage());
            }
        } catch (IOException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.severe(TAG + " IOException: " + e.getMessage());
            }
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.severe(TAG + " Exception: " + e.getMessage());
            }
        }

        if ( inventories.length == 0 ) {
            throw new BarcodeNotFoundException("Barcode Not Found!");
        }

        return inventories[0];
    }

    private Inventory[] getInventories(String inventories)
            throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        return objectMapper
                .readValue(inventories,
                        Inventory[].class);
    }

}


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

    private static final String TAG = HttpHandler.class.getSimpleName();
    private final static Logger logger =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final String barcodeURI = "https://jsonmock.hackerrank.com/api/inventory?barcode=";
    private Inventory inventory;

    public Inventory read(int barcode)
            throws BarcodeNotFoundException {
        Inventory[] inventories = null;

        try {
            String inventoryJSONString = InputStreamConverter.toString(
                    HttpRequests.get(barcodeURI+barcode))
                    .toString();

            inventories =  getInventories(inventoryJSONString);

        } catch (MalformedURLException e) {
            logger.log(Level.WARNING, TAG + " MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            logger.log(Level.WARNING, TAG + " IOException: " + e.getMessage());
        } catch (Exception e) {
            logger.log(Level.WARNING, TAG + " Exception: " + e.getMessage());
        }

        if ( inventories.length == 0 )
            throw new BarcodeNotFoundException("Barcode Not Found!");

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


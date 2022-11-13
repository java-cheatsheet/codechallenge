package hackerrank.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Get inventories from barcode
 *
 */
public class BarcodeReader   {
    /**
     * Class name
     */
    private final static String TAG = "BarcodeReader";

    /**
     * Log messages
     */
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Inventory URI
     */
    private final static String INVENTORY_URI = "https://jsonmock.hackerrank.com/api/inventory";

    /**
     * Barcode
     */
    private final int barcode;

    /**
     *
     * @return int barcode
     */
    public int getBarcode() {
        return barcode;
    }

    /**
     *
     */
    public BarcodeReader(final int barcode) {
        this.barcode = barcode;
    }

    /**
     * Read inventory from barcode.
     *
     * @return Inventory
     */
    public Inventory read() {
        Inventory inventory = new Inventory();
        final String barcodeURI = INVENTORY_URI + "?barcode=";

        try {
            final String inventoryJSON = InputStreamConverterUtil.toString(
                    HttpRequestsUtil.get(barcodeURI + barcode));

            inventory =  inventory.getInventories(inventoryJSON)[0];

        } catch (InventoryNotFoundException e) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.log(Level.INFO, TAG + " InventoryNotFoundException: " + e.getMessage());
            }
        } catch (MalformedURLException e) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, TAG + " MalformedURLException: " + e.getMessage());
            }
        } catch (IOException e) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.severe(TAG + " IOException: " + e.getMessage());
            }
        }

        return inventory;
    }



}


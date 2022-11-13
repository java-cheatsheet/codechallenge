package hackerrank.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Inventory Entity
 */
@SuppressWarnings("PMD.DataClass")
public class Inventory {

    /**
     * String Item code
     */
    public String item;

    /**
     * Item price
     */
    private int price;

    /**
     * Availability of item
     */
    private int available;

    /**
     * Discount amount, if available
     */
    private int discount;

    /**
     * Category of item
     */
    private String category;

    /**
     * Barcode number
     */
    private int barcode;

    /**
     * Constructor
     */
    public Inventory() {
        item = "";
        price = 0;
        available = 0;
        discount = 0;
        category = "";
        barcode = 0;
    }



    public String getItem() {
        return item;
    }

    public void setItem(final String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(final int available) {
        this.available = available;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(final int discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(final int barcode) {
        this.barcode = barcode;
    }

    /**
     * Get inventories object from JSON.
     *
     * @param jsonInventories final String
     * @return Inventory[]
     * @throws JsonProcessingException
     */
    public Inventory[] getInventories(final String jsonInventories)
            throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        return objectMapper
                .readValue(jsonInventories,
                        Inventory[].class);
    }
}

package hackerrank.api;

import com.sun.net.httpserver.HttpHandler;

import java.util.logging.Logger;

public class Inventory {
    private final static Logger logger =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final String TAG = HttpHandler.class.getSimpleName();

    private final String URL = "https://jsonmock.hackerrank.com/api/inventory?barcode=";

    String item;
    int price;
    int available;
    int discount;
    String category;
    int barcode;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
}

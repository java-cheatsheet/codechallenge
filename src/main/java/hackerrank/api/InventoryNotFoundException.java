package hackerrank.api;

public class InventoryNotFoundException extends NullPointerException {
    public InventoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

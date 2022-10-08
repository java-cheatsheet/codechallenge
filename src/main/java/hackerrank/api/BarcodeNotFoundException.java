package hackerrank.api;

public class BarcodeNotFoundException extends NullPointerException {
    public BarcodeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

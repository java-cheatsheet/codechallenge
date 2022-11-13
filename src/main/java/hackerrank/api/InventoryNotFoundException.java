package hackerrank.api;

/**
 * Inventory Not Found Exception
 */
public class InventoryNotFoundException extends NullPointerException {
    public static final long serialVersionUID = 42L;

    /**
     * Constructor method
     *
     * @param errorMessage String
     */
    public InventoryNotFoundException(final String errorMessage) {
        super(errorMessage);
    }
}

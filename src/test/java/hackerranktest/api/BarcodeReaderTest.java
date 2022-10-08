package hackerranktest.api;

import hackerrank.api.BarcodeNotFoundException;
import hackerrank.api.BarcodeReader;
import hackerrank.api.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BarcodeReaderTest {

    @Test
    void givenBarCodeListData() {

        int barcode = 74001755;
        BarcodeReader obj = new BarcodeReader();
        Inventory actualArr = obj.read(barcode);

        Assertions.assertEquals(74001755, actualArr.getBarcode());
    }

    @Test
    void barcodeEmptyException() {
        Exception exception = Assertions.assertThrows(
                BarcodeNotFoundException.class, () -> {
                    BarcodeReader br = new BarcodeReader();
                    br.read(0);
                });

        String expectedMessage = "Barcode Not Found!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}

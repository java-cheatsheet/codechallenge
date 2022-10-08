package hackerranktest.api;

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
    void givenBarcodeNotListed() {

        int barcode = 0;
        BarcodeReader obj = new BarcodeReader();
        Inventory actualArr = obj.read(barcode);

        Assertions.assertNull(actualArr);
    }
}

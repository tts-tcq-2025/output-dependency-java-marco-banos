package tests;

import modules.Misaligned;
import modules.IColorCodePrinter;

public class FakePrinter implements IColorCodePrinter{
ArrayList<String> rows=new ArrayList<String>();
 public void print(String colorCodeMapItem){
    rows.add(colorCodeMapItem);
 }
}

public class MisalignedTests {
    public static void run() {
        FakePrinter _subtitueForPrint=new FakePrinter();
        int result = Misaligned.printColorMap(_subtitueForPrint);
        assert result == 25 : "Expected 25, got " + result;
        
        assert row.equals(" 0 | White | Blue")
                : "Expected '0 | White | Blue' but got " + row;

        System.out.println("Misaligned tests completed.");
    }
}

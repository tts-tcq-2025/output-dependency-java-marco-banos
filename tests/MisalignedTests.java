package tests;

import modules.Misaligned;

public class MisalignedTests {
    public static void run() {
        int result = Misaligned.printColorMap();
        assert result == 25 : "Expected 25, got " + result;

        // 🆕 Stronger test: check correct mapping format
        String row = Misaligned.formatColorPair(0, "White", "Blue");
        assert row.equals(" 0 | White | Blue")
                : "Expected '0 | White | Blue' but got " + row;

        System.out.println("Misaligned tests completed.");
    }
}

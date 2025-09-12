package tests;

import modules.Tshirts;

public class TshirtTests {
    public static void run() {
        assert Tshirts.size(37).equals("S");
        assert Tshirts.size(40).equals("M");
        assert Tshirts.size(43).equals("L");

        // 🆕 This will FAIL → bug at boundary 38
        assert Tshirts.size(38).equals("S") : "Expected 38 to be Small, but got " + Tshirts.size(38);

        System.out.println("Tshirt tests completed.");
    }
}

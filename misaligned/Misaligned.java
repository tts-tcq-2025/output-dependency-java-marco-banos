public class Misaligned {
    static int printColorMap() {
        String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
        String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.println(formatColorPair(i * 5 + j, majorColors[i], minorColors[i]));
            }
        }
        return i * j;
    }

    // 🆕 New helper method
    static String formatColorPair(int index, String major, String minor) {
        return String.format("%2d | %s | %s", index, major, minor);
    }

    public static void main(String[] args) {
        int result = printColorMap();
        assert(result == 25);

        // 🆕 New test → this will FAIL because minorColors index is wrong
        String row = formatColorPair(0, "White", "Blue");
        assert(row.equals(" 0 | White | Blue")) : "Expected 'White | Blue' but got " + row;

        System.out.println("All is well (maybe!)");
    }
}


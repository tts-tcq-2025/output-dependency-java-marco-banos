package modules;

public class Misaligned {
    public static int printColorMap() {
        String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
        String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
              String formatedColorCodeMapItem=formatColorPair(i * 5 + j, majorColors[i], minorColors[i]));
            }
        }
        return i * j;
    }

    // 🆕 New helper method
    public static String formatColorPair(int index, String major, String minor) {
        return String.format("%2d | %s | %s", index, major, minor);
    }
}


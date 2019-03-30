package Float;

import java.text.DecimalFormat;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-08-21 10:39
 */

public class MyFloat {
    public static void main(String[] args) {
        float maxGoodRatio = 0.034450f;
        String formatFloat = new DecimalFormat("0.0000").format(maxGoodRatio);
        System.out.println(formatFloat);
    }
}

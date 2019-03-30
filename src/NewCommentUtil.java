import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-11-09 18:46
 * 以前用正态分布的评价不准，现在用一定量的数据统计分析出区间来进行评价
 */

public class NewCommentUtil {

    private static final Double[][] doubles =
            /**
             * 10 9 8 7 6 5 4 3 2 1
             */
            {
                    {0.0, 16.6624, 21.233, 24.8881, 28.5134, 33.0763, 37.557, 41.6437, 46.154, 52.8367},//roughness
                    {0.0, 1.44034, 1.63097, 1.78855, 1.95986, 2.18721, 2.42688, 2.68233, 2.97954, 3.38746},//pore
                    {0.0, 0.0139957, 0.0223655, 0.0270502, 0.031981, 0.0384858, 0.0462607, 0.0542742, 0.0639535, 0.0770008},//splash
                    {0.0, 0.00228296, 0.00478455, 0.00726879, 0.00944007, 0.0117163, 0.0141017, 0.0165363, 0.0191924, 0.0228155},//wrinkle
                    {0.0, 0.000281391, 0.000900107, 0.00307219, 0.0145048, 0.112185, 0.524604, 0.907833, 0.99648, 0.999994},//porphyrin
                    {0.0, 0.0161591, 0.030088, 0.0412543, 0.0505616, 0.0610781, 0.0728305, 0.085589, 0.100955, 0.124581},//macula
                    {0.0, 0.0965323, 0.11812, 0.138994, 0.155322, 0.16165, 0.168082, 0.182505, 0.195925, 0.209175},//melanin
                    /**
                     * 1 3 5 7 9 10 8 6 4 2
                    */
                    {0.0, 0.000215576, 0.000457281, 0.00109127, 0.00243021, 0.00330597, 0.00448833, 0.0082204, 0.0145089, 0.022253},//oil
                    {0.0, 0.077786, 0.0995614, 0.111903, 0.129375, 0.138912, 0.148444, 0.164197, 0.17393, 0.187517},//hemoglobin
                    /**
                     * 1 2 3 4 5 6 7 8 9 10
                    */
                    {0.0, 174.721, 182.96, 189.998, 195.301, 200.263, 204.725, 208.544, 212.21, 216.654}};//whitening

    //map
    private static Map<String, Map<Integer, Double[]>> map = new LinkedHashMap<>();
    //init
    private static String[] descArr = {"roughness", "pore", "splash", "wrinkle", "porphyrin", "macula", "melanin"};

    static {
        /**
         * 10 9 8 7 6 5 4 3 2 1
         */
        for (int i = 0; i < descArr.length; i++) {
            Map<Integer, Double[]> tempDescMap = new LinkedHashMap<>();
            for (int j = 0; j < 9; j++) {
                tempDescMap.put(10 - j, new Double[]{doubles[i][j], doubles[i][j + 1]});
            }
            tempDescMap.put(1, new Double[]{doubles[i][9], Double.MAX_VALUE});
            map.put(descArr[i], tempDescMap);
        }
        /**
         * 1 3 5 7 9 10 8 6 4 2
         */
        //oil
        Map<Integer, Double[]> tempMidMap = new LinkedHashMap<>();
        int[] tempInt = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
        for (int i = 0; i < 9; i++) {
            tempMidMap.put(tempInt[i], new Double[]{doubles[7][i], doubles[7][i + 1]});
        }
        tempMidMap.put(2, new Double[]{doubles[7][9], Double.MAX_VALUE});
        map.put("oil", tempMidMap);
        //hemoglobin
        Map<Integer, Double[]> tempMidMap1 = new LinkedHashMap<>();
        for (int i = 0; i < 9; i++) {
            tempMidMap1.put(tempInt[i], new Double[]{doubles[8][i], doubles[8][i + 1]});
        }
        tempMidMap1.put(2, new Double[]{doubles[8][9], Double.MAX_VALUE});
        map.put("hemoglobin", tempMidMap1);
        /**
         * 1 2 3 4 5 6 7 8 9 10
         */
        //whitening
        Map<Integer, Double[]> tempAscMap = new LinkedHashMap<>();
        for (int i = 0; i < 9; i++) {
            tempAscMap.put(i + 1, new Double[]{doubles[9][i], doubles[9][i + 1]});
        }
        tempAscMap.put(10, new Double[]{doubles[9][9], Double.MAX_VALUE});
        map.put("whitening", tempAscMap);
    }

    public static void main(String[] a){

    }

}

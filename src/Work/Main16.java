package Work;

import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main16 {

    private static String line;
    private static int n, m;
    private static List<Integer[]> mapList = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();
        String[] tempSting = line.split(" ");
        n = Integer.parseInt(tempSting[0]);
        m = Integer.parseInt(tempSting[1]);

        int tempN = n;
        while (tempN-->0){
            line = scan.nextLine();
            String[] tempSting1 = line.split(" ");
            Integer[] tempInt = new Integer[Integer.parseInt(tempSting1[1]) -
                    Integer.parseInt(tempSting1[0]) + 1];
            for(int i=0; i<tempInt.length; i++){
                tempInt[i] = Integer.parseInt(tempSting1[0]) + i;
            }
            mapList.add(tempInt);
        }

        List<List<Integer>> result = combineAlg(mapList);
        System.out.println(result.size());
    }

    private static List<List<Integer>> combineAlg(List<Integer[]> nArray) {
        List<List<Integer>> values = new LinkedList<List<Integer>>();
        int[] x = new int[nArray.size()];
        for (int i = 0; i < x.length; i++) {
            x[i] = 0;
        }

        int flag = 0;
        do {
            /**一种组合形式**/
            List<Integer> objs = new LinkedList<Integer>();
            for (int looper = 0; looper < nArray.size(); looper++) {
                objs.add(nArray.get(looper)[x[looper]]);
            }
            flag = NextPermutation(x, nArray);
            if(isEqualM(objs)){
                values.add(objs);
            }
        } while (flag != 1);
        /**所有组合形式**/
        return values;
    }

    private static int NextPermutation(int[] x, List<Integer[]> nArray) {
        int carry = 0;
        for (int looper = nArray.size() - 1; looper >= 0; looper--) {
            if (x[looper] + 1 == nArray.get(looper).length) {
                carry = 1;
                x[looper] = 0;
            } else {
                x[looper] = x[looper] + 1;
                carry = 0;
                return 0;
            }
        }

        if (carry == 1)
            return 1;
        else
            return 0;
    }

    private static boolean isEqualM(List<Integer> numList){
        int sum = 0;
        for(Integer i : numList){
            sum += i;
        }
        return sum == m;
    }

}

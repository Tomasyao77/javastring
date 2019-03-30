package Work;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main12 {

    private static String line;
    private static int n;
    private static List<BigInteger> bigIntegers = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();
        n = Integer.parseInt(line);
        int tempN = n;
        while (tempN-->0){
            line = scan.nextLine();
            bigIntegers.add(new BigInteger(line));
        }

        xy();
    }

    private static void xy(){
        Map<int[], String> map = new HashMap<>();
        for(int i=0; i<n; i++){
            //按y优先 y最小
            //x奇数 y偶数
            if(bigIntegers.get(i).intValue() % 2 != 0){
                System.out.println("No");
                continue;
            }
            //int tempJ = bigIntegers.get(i).intValue() / 2;
            int tempJ = bigIntegers.get(i).toString().length();

            tempJ *= 256;

            for(int j=2; j<=tempJ; j=j+2){
                if(true){//如果找到了
                    System.out.println(j+" "+j);
                }
            }
            System.out.println("No");
        }

    }
}

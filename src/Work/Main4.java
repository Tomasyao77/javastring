package Work;

import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main4 {

    public static void main(String[] args) {
        //输入
        String tempLine;
        String[] tempLineArr = new String[2];
        int l = 0;
        int r = 0;
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            tempLine = scan.nextLine();
            tempLineArr = tempLine.split(" ");
        }
        l = Integer.parseInt(tempLineArr[0]);
        r = Integer.parseInt(tempLineArr[1]);

        int result = 0;
        for(int i=l; i<=r; i++){
            int tempSum = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=1;j<=i;j++){
                sb.append(""+j);
            }
            String s = sb.toString().trim();
            for(int j=0; j<s.length(); j++){
                tempSum += (int) sb.charAt(j);
            }
            if(tempSum % 3 == 0){
                result++;
            }
        }
        System.out.println(result);

    }
}

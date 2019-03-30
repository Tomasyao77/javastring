package Work;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n%(2*m)!=0||m<1||n<2||n>Math.pow(10,9))System.out.println("error");
        int t = n/m;
        int sum = 0;
        for (int i = 1;i<=t;i++){
            if (i%2!=0) {
                sum -= sum(m,1+m*(i-1));
            }else{
                sum += sum(m,1+m*(i-1));
            }
        }
        System.out.println(sum);
    }
    public static int sum(int n,int num){
        return (n*num + n*(n-1)/2);
    }
}

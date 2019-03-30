package Work;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] chocolate = new int[n];
        for(int i=0; i<n; i++){
            chocolate[i] = in.nextInt();
        }
        System.out.print(caseNum(chocolate));
    }

    public static int caseNum(int[] chocolate){
        int i=0, j=chocolate.length-1;

        while(chocolate[i] == 0){
            i++;
        }
        while(chocolate[j] == 0){
            j--;
        }

        if(i == j) return 1;

        int result = 1;
        for(;i<j;i++){
            int num = 1;
            while(chocolate[i] == 0){
                i++;
                num++;
            }
            if(num >1){
                result *= (num);
            }
        }

        return result;
    }
}

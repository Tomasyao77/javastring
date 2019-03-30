package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 给你一根长度为n的绳子，请把绳子剪成m段（m , n ）都是正整数，（n>1&m>1）
 每段绳子的长度为k[0],k[1],k[2],...,k[m]。请问k[0]k[1]k[2]...k[m]的最大值。
 例如绳子是长度为8，我们把它剪成的长度分别为2,3,3的三段，此时得到的最大的乘积是18。
 */

public class A014_CuttingScope {

    public static void main(String[] args){
        A014_CuttingScope ins = new A014_CuttingScope();
        System.out.println(ins.maxMultiDynamic(50));
        System.out.println(ins.maxMultiGreedy(50));
    }

    /**
     * 动态规划
     */
    private int maxMultiDynamic(int n) {
        if(n <= 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] ints = new int[n+1];//下标0~n
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 3;//注意这里是n>3时把绳子剪成小段的最大值
        int max;
        for(int i=4; i<=n; i++){//自底向上
            max = 0;
            for(int j=1; j<=i/2; j++){
                if(ints[j] * ints[i-j] > max){
                    max = ints[j] * ints[i-j];
                }
            }
            ints[i] = max;
        }

        return ints[n];
    }

    /**
     * 贪婪算法 我这个要比别人的通俗易懂
     */
    private int maxMultiGreedy(int n) {
        if(n <= 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        //n >= 5尽可能剪成长度为3的小段
        int multi = 1;
        while (n >= 5){
            n -= 3;
            multi *= 3;
        }
        //还剩下的情况
        if(n == 4){//7 - 3
            multi *= 4;
        }else if(n == 3){//6 - 3
            multi *= 3;
        }else if(n == 2){//5 - 3
            multi *= 2;
        }

        return multi;
    }

}

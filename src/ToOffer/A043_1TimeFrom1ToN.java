package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 15:24
 */

public class A043_1TimeFrom1ToN {
    public static void main(String[] args) {
        A043_1TimeFrom1ToN ins = new A043_1TimeFrom1ToN();
        System.out.println(ins.times(10));
        System.out.println(ins.numberOf1Between1AndN(10));
    }

    /**
     * 1到n整数中1出现的次数
     */
    private int times(int n){
        if(n < 1){
            return 0;
        }

        int count = 0;
        for(int i = 1; i <= n; i++){
            count += core(i);//暴力循环，每个数字各有几个1
        }
        return count;
    }

    private int core(int num){
        int times = 0;
        while(num != 0){
            if(num%10 == 1){
                times++;
            }
            num = num / 10;
        }
        return times;
    }

    /**
     * 1到n整数中1出现的次数（使用数学规律,难）
     * 注意，这方法有问题！！！
     */
    private int numberOf1Between1AndN(int n){
        if(n<=0)
            return 0;

        String strN = String.valueOf(n);
        return numberOf1(strN);
    }

    private int numberOf1(String strN){
        if(strN.length() == 1){
            return 1;
        }
        if(new Integer(strN) <= 0){
            return 0;
        }

        int times = 0;

        Integer m = new Integer(strN);
        Integer n = new Integer(strN.substring(1))+1;

        //计算最高位1的个数
        if(new Integer(strN.substring(0, 1)) > 1){
            times += Math.pow(10, strN.length()-1);
        }else{
            times += new Integer(strN.substring(1))+1;
        }

        //计算其他位1的个数
        times += new Integer(strN.substring(0,1)) * (strN.length()-1) * Math.pow(10, strN.length()-2);

        return times + numberOf1(strN.substring(1));
    }

}

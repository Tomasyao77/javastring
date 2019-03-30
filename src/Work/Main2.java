package Work;

import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main2 {
    private static String s;
    private static String m;
    public static void main(String[] args){
        //init
        s = "a";
        m = s;
        //输入
        int inputNum = 0;
        Scanner scan = new Scanner(System.in);
        if(scan.hasNext()){
            inputNum = Integer.parseInt(scan.nextLine());
        }
        //操作
        int minOp = 0;
        if(inputNum == 1){
            System.out.println("0");
        }else if(inputNum == 2){
            System.out.println("1");
        }else if(inputNum % 2 != 0){//奇数
            opOne();
            minOp++;
            while (s.length() < inputNum){
                opTwo();
                minOp++;
            }
            System.out.println(minOp);
        }else {//偶数
            if(isPowerOfTwo(inputNum)){//2的整数幂
                for(int i=0; i<powerOfTwo(inputNum); i++){
                    opOne();
                }
                minOp = powerOfTwo(inputNum);
                System.out.println(minOp);
            }else {
                //先计算到最接近
                int tempNum = 1;
                while (((int)(Math.pow((double)2, (double)tempNum) + Math.pow((double)2, (double)(tempNum-1))) < inputNum)){
                    tempNum++;
                }
                if((int)(Math.pow((double)2, (double)tempNum) + Math.pow((double)2, (double)(tempNum-1)))
                        == inputNum){
                    System.out.println(tempNum+1);
                }else {
                    tempNum = tempNum==1 ? 1 :tempNum-1;
                    if((Math.pow((double)2, (double)tempNum)*2) > inputNum){
                        tempNum--;
                    }
                    System.out.println(tempNum);
                    //操作1次数
                    for(int i=0; i<tempNum; i++){
                        opOne();
                        minOp++;
                    }
                    //操作2次数
                    while (s.length() < inputNum){
                        opTwo();
                        minOp++;
                    }
                    System.out.println(minOp);
                }
            }
        }
    }
    public static void opOne(){
        m = s;
        s = s + s;
    }
    public static void opTwo(){
        s = s + m;
    }
    //是否是2的整数幂
    public static boolean isPowerOfTwo(int n) {
        String str = Integer.toBinaryString(n);
        if(n < 1)
            return false;
        else if(str.lastIndexOf("1") == 0)
            return true;
        else
            return false;
    }
    //2的几次幂
    public static int powerOfTwo(int n){
        int p = 1;
        while (n > 2){
            n = n / 2;
            p++;
        }
        return p;
    }

}

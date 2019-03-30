package Work;

import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main7 {

    private static int input = 0;
    private static double result = 0;

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        input = Integer.parseInt(scan.nextLine());
        //step1
        result = input * 0.8;
        //step2
        result = step();

        System.out.println(Math.round(result));
    }

    private static double step(){
        double ynsrde = (input - input*0.2 - 3500) < 0 ? 0 :
                (input - input*0.2 - 3500);
        double jsed = 0;
        if(ynsrde<=1500){
            jsed = ynsrde * 0.03;
        }else if(ynsrde>1500 && ynsrde<=4500){
            jsed = ynsrde * 0.1 - 105;
        }else if(ynsrde>4500 && ynsrde<=9000){
            jsed = ynsrde * 0.2 - 555;
        }else if(ynsrde>9000 && ynsrde<=35000){
            jsed = ynsrde * 0.25 - 1005;
        }else if(ynsrde>35000 && ynsrde<=55000){
            jsed = ynsrde * 0.3 - 2755;
        }else if(ynsrde>55000 && ynsrde<=80000){
            jsed = ynsrde * 0.35 - 5505;
        }else if(ynsrde>80000){
            jsed = ynsrde * 0.45 - 13505;
        }
        return result - jsed;
    }

}

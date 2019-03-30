package Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main3 {

    public static void main(String[] args) {
        //闹钟数量与值
        int lineAfter = 0;
        int tempNum = 0;
        List<int[]> stringList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            lineAfter = Integer.parseInt(scan.nextLine());
            tempNum++;
        }
        while (scan.hasNext()) {//字符串
            String str = scan.nextLine();
            tempNum++;
            String[] temp=  str.split(" ");
            int[] tempIntArr = new int[2];
            tempIntArr[0] = Integer.parseInt(temp[0]);
            tempIntArr[1] = Integer.parseInt(temp[1]);
            stringList.add(tempIntArr);
            if (tempNum > lineAfter) {
                break;
            }
        }
        //闹钟排序(从小到大)
        for(int i=0; i<stringList.size()-1; i++){
            for(int j=i; j<stringList.size(); j++){
                if(stringList.get(i)[0] > stringList.get(j)[0]){
                    int[] tempIntA = stringList.get(j);
                    stringList.set(j, stringList.get(i));
                    stringList.set(i, tempIntA);
                }else if(stringList.get(i)[0] == stringList.get(j)[0]
                        && stringList.get(i)[1] > stringList.get(j)[1]){
                    int[] tempIntA = stringList.get(j);
                    stringList.set(j, stringList.get(i));
                    stringList.set(i, tempIntA);
                }
            }
        }
        //到校需要的时间(分钟)
        int needTimeSch = Integer.parseInt(scan.nextLine());
        //上课时间
        int[] classBegin = new int[2];
        String tempclassBegin = scan.nextLine();
        String[] tempListclassBegin =  tempclassBegin.split(" ");
        classBegin[0] = Integer.parseInt(tempListclassBegin[0]);
        classBegin[1] = Integer.parseInt(tempListclassBegin[1]);

        //sout
        /*for(int[] s : stringList){
            System.out.println("闹钟: "+s[0] +" "+s[1]);
        }
        System.out.println("到校需要的时间: "+needTimeSch);
        System.out.println("上课时间: "+classBegin[0]+" "+classBegin[1]);*/

        //计算最晚时间(不考虑闹钟)
        int[] theLatestNoClock = calTheLatestNoClock(needTimeSch, classBegin);
        //System.out.println("计算最晚时间(不考虑闹钟): "+theLatestNoClock[0]+" "+theLatestNoClock[1]);
        //计算起床时间(与闹钟对比)
        for(int i=stringList.size()-1; i>=0; i--){
            int[] tempClock = new int[2];
            tempClock[0] = stringList.get(i)[0];
            tempClock[1] = stringList.get(i)[1];

            if(needTimeSch == 0){
                System.out.println(tempClock[0]+" "+tempClock[1]);
                break;
            }

            if(theLatestNoClock[0] > tempClock[0]){
                System.out.println(tempClock[0]+" "+tempClock[1]);
                break;
            }

            if(theLatestNoClock[0] == tempClock[0]
                    && theLatestNoClock[1] >= tempClock[1] ){
                System.out.println(tempClock[0]+" "+tempClock[1]);
                break;
            }
        }

    }

    private static int[] calTheLatestNoClock(int needTimeSch, int[] classBegin){
        //init
        int[] theLatestNoClock = new int[2];
        theLatestNoClock[0] = classBegin[0];
        theLatestNoClock[1] = classBegin[1];

        while (needTimeSch > 0){//回溯
            if(needTimeSch >= 60){
                needTimeSch -= 60;
                theLatestNoClock[0]--;
            }else if(needTimeSch > theLatestNoClock[1] && theLatestNoClock[1] > 0){
                needTimeSch -= theLatestNoClock[1];
                theLatestNoClock[1] = 0;
            }else if(theLatestNoClock[1] == 0 && needTimeSch > 0 && needTimeSch < 60){
                theLatestNoClock[0]--;
                theLatestNoClock[1] = 60 - needTimeSch;
                needTimeSch = 0;
            }else if(needTimeSch <= theLatestNoClock[1] && theLatestNoClock[1] > 0){
                theLatestNoClock[1] -= needTimeSch;
                needTimeSch = 0;
            }
        }

        return theLatestNoClock;
    }

}

package Work;

import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main1 {
    public static void main(String[] args){
        //输入(第一行代表后面还有几行(int),后面每一行都是字符串)
        int lineAfter = 0;
        int tempNum=0;
        List<String> stringList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        if(scan.hasNext()){
            lineAfter = Integer.parseInt(scan.nextLine());
            tempNum++;
            //System.out.println(lineAfter);
        }
        while (scan.hasNext()){//字符串
            String str = scan.nextLine();
            tempNum++;
            stringList.add(str);
            if(tempNum > lineAfter){
                break;
            }
        }
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator() {
            public int compare(Object o1, Object o2) {
                //如果有空值，直接返回0
                if (o1 == null || o2 == null)
                    return 0;

                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        });
        for(String s : stringList){
            String[] tempS = s.split(" ");
            int tempGrade = 0;
            double temp = Integer.parseInt(tempS[2])/(Integer.parseInt(tempS[1])*1.0);
            if(0<temp&&temp<=0.3){
                tempGrade =5;
            }else if(0.3<temp&&temp<=0.6){
                tempGrade =4;
            }else if(0.6<temp&&temp<=1.0){
                tempGrade =3;
            }
            treeMap.put(tempS[0],String.valueOf(tempGrade));
        }
        while (treeMap.size() != 0) {
            //treemap自动按照key进行递增排序
            System.out.println(treeMap.firstEntry().getKey() + " " + treeMap.firstEntry().getValue());
            treeMap.remove(treeMap.firstKey());
        }
    }

}

package Work;

import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main17 {

    private static String line;
    private static List<String> inputList = new ArrayList<>();
    private static List<String> restList = new ArrayList<>();
    private static List<Map<String, List<String>>> sectionResultList = new ArrayList<>();
    //private static List<Map<String, List<String>>> sortList = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            line = scan.nextLine();
            if(line == null || line.isEmpty()){
                flag = false;
                continue;
            }
            flag = true;
            inputList.add(line);
        }
        //去掉注释 step1 单行注释
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).length() > 1 &&
                    (inputList.get(i).startsWith(";") || inputList.get(i).endsWith(";"))) {
                inputList.remove(i);
            }
        }
        //去掉注释 step2 多行注释
        List<Integer> delList = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).length() == 1 &&
                    inputList.get(i).startsWith(";")){
                delList.add(i);//放索引，最后肯定是偶数
            }
        }
        Map<Integer, Integer[]> delMap = new HashMap<>();
        for(Integer i : delList){
            if(delMap.size() == 0){
                delMap.put(1, new Integer[]{i});
            }else if(delMap.get(delMap.size()).length == 1){
                Integer[] tempInt = new Integer[]{delMap.get(delMap.size())[0], i};
                delMap.put(delMap.size(), tempInt);
            }else if(delMap.get(delMap.size()).length == 2){
                delMap.put(delMap.size() + 1, new Integer[]{i});
            }
        }
        //开始删除多余的多行注释
        if(delMap.size() == 0){
            restList = inputList;
        }else {
            for(Integer i : delMap.keySet()){
                for(int j = 0; j < inputList.size(); j++){
                    if(j < delMap.get(i)[0] && j > delMap.get(i)[1]){//不在范围内
                        restList.add(inputList.get(j));
                    }
                }
            }
        }
        /*for(String s : restList){
            System.out.println("rest: "+s);
        }*/
        //按照section放入list
        List<Integer> sectionList = new ArrayList<>();
        for (int i = 0; i < restList.size(); i++) {
            String s = restList.get(i).trim();
            if (s.startsWith("[") && s.endsWith("]")){
                sectionList.add(i);
            }
        }
        //private static List<Map<String, List<String>>> sectionResultList = new ArrayList<>();
        for(int i=0; i<sectionList.size(); i++){//开始分区
            List<String> list = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();

            for(int j=0; j<restList.size(); j++){
                if(i == sectionList.size()-1){
                    if(j>sectionList.get(i)){
                        list.add(restList.get(j));
                    }
                }else {
                    if(j>sectionList.get(i) && j<sectionList.get(i+1)){
                        list.add(restList.get(j));
                    }
                }
            }

            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            String tempSec = restList.get(sectionList.get(i));
            tempSec = tempSec.substring(1, tempSec.length()-1).trim();
            map.put(tempSec, list);
            sectionResultList.add(map);
        }

        sectionResultList.sort(new Comparator<Map<String, List<String>>>() {
            @Override
            public int compare(Map<String, List<String>> o1, Map<String, List<String>> o2) {
                String s1="", s2="";
                for(String s : o1.keySet()){
                    s1 = s;
                }
                for(String s : o2.keySet()){
                    s2 = s;
                }
                return s1.compareTo(s2);
            }
        });

        //private static List<Map<String, List<String>>> sectionResultList = new ArrayList<>();
        for(Map<String, List<String>> m : sectionResultList){
            for(String s : m.keySet()){
                for(String s1 : m.get(s)){
                    String tempLine;
                    tempLine = "{"+s+"}";

                    String[] strings = s1.split("=");
                    for(String s2 : strings){
                        tempLine += "{";
                        tempLine += s2.trim();
                        tempLine += "}";
                    }
                    System.out.println(tempLine);
                }
            }
        }

    }

}

package Work;

import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main15 {

    private static String line;
    private static Map<String, Integer> map = new HashMap<>();
    private static List<Map<String, Integer>> mapList = new ArrayList<>();
    private static List<String> result = new ArrayList<>();
    private static String resultString = "";

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();

        putIntoMapList();
        sort();
        ascPrint();
    }

    private static void putIntoMapList(){
        String[] tempStings = line.split("");
        for(String s : tempStings){
            if(map.get(s) == null){//不存在put
                map.put(s, 1);
            }else {
                map.put(s, map.get(s)+1);//已有了+1
            }
        }
        //放进list
        for(String s : map.keySet()){
            Map<String, Integer> tempMap = new HashMap<>();
            tempMap.put(s, map.get(s));
            mapList.add(tempMap);
        }
        /*for(Map<String, Integer> m : mapList){
            for(String s : m.keySet()){
                System.out.println(s+"-"+m.get(s));
            }
        }
        System.out.println(mapList.size());*/
    }

    private static void sort(){
        //先list排序 升序
        mapList.sort(new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                int o1Int = 0, o2Int = 0;
                for(String s : o1.keySet()){
                    o1Int = o1.get(s);
                }
                for(String s : o2.keySet()){
                    o2Int = o2.get(s);
                }
                return o1Int < o2Int ? -1 : 1;
            }
        });
        while (mapList.size() > 0){
            String tempString = "";
            for(int i=0; i<mapList.size(); i++){
                int tempInt = 0;
                String temp = "";
                for(String s : mapList.get(i).keySet()){
                    tempInt = mapList.get(i).get(s);
                    temp = s;
                }
                if(tempInt == 0){
                    mapList.remove(i);
                    break;
                }

                if(tempInt > 0){//还有就添加
                    tempString += temp;
                    for(String s : mapList.get(i).keySet()){
                        mapList.get(i).put(s, mapList.get(i).get(s)-1);//-1
                    }
                }
            }
            if(tempString.length() > 0){
                result.add(tempString);
            }
        }
    }

    private static void ascPrint(){
        for(int i=0; i<result.size(); i++){//asc
            String[] tempS = new String[result.get(i).length()];
            for(int j=0; j<result.get(i).length(); j++){
                tempS[j] = result.get(i).substring(j, j+1);
            }
            Arrays.sort(tempS);
            for(int j=0; j<tempS.length; j++){
                resultString += tempS[j];
            }
        }
        System.out.println(resultString);
    }

}

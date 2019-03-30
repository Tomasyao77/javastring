package Work;

import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main11 {

    private static String line;
    private static int n, m;
    private static List<String[]> arrayList = new ArrayList<>();
    private static String[][] strings;
    private static int minNum = 0;

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();
        String[] tempString = line.split(" ");
        n = Integer.parseInt(tempString[0]);
        m = Integer.parseInt(tempString[1]);
        strings = new String[n][m];
        int tempN = n;
        while (tempN-->0){
            line = scan.nextLine();
            tempString = line.split("");
            arrayList.add(tempString);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                strings[i][j] = arrayList.get(i)[j];
            }
        }
        paint();
        System.out.println(minNum);
    }

    private static void paint(){
        Map<int[], String> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                String temp = strings[i][j];
                if(temp.equals("Y") || temp.equals("B")){
                    if(map.get(new int[]{i, j}) == null){
                        for(int z=i; z<n && z<m; z++){
                            map.put(new int[]{i+z, j+z}, temp);
                            minNum++;
                        }
                    }
                }else if(temp.equals("G")){
                    if(map.get(new int[]{i, j}) == null){
                        for(int z=i; z<n && z<m; z++){
                            map.put(new int[]{i+z, j+z}, temp);
                            minNum++;
                        }
                    }
                }

            }
        }
    }
}

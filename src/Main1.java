import java.util.*;

public class Main1 {
    private static List<Integer> result1 = new ArrayList<>();
    private static int result2 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split(" ");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);
        //loop(n, m);
        yoseph(n, m);

        for(int i=0; i<result1.size(); i++){
            System.out.print(result1.get(i) + " ");
        }
        System.out.println();
        //System.out.println(result2);
    }

    public static void loop(int n, int m) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //从第0个开始
        int k = 0;
        while (list.size() > 1) {
            k = k + m;
            //第m人index  
            k = k % list.size() - 1;
            //是否到尾部
            if (k < 0) {//k==-1//到达链表的最后一个元素
                result1.add(list.get(list.size()-1));
                list.remove(list.size() - 1);
                k = 0;//又重头开始//从第0个开始
            } else {
                result1.add(list.get(k));
                list.remove(k);//k之后就自动变成下一个元素了
            }
        }
        if(list.size() == 1) result2 = list.get(0);
    }

    private static void yoseph(int n, int m){
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = i+1;//init
        int[] visited = new int[n];
        int cur = 0;//报数到第几人
        int index = 0;//报数到第几人的下标
        int rest = n;//还剩多少人
        while(rest > 0){
            cur += 1 - visited[index];//1 - 0 == 1表示报数 1-1==0表示跳过
            if(cur == m){
                result1.add(arr[index]);
                visited[index] = 1;
                rest--;
                cur = 0;
            }
            index = (index+1) % n;//下一位
        }
    }
}
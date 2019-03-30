package Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main14 {

    private static String line;
    private static int n;
    private static List<Integer> integers = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();
        n = Integer.parseInt(line);

        int tempN = n;
        while (tempN-->0){
            line = scan.nextLine();
            integers.add(Integer.parseInt(line));
        }

        System.out.println(jump(integers));
    }

    private static int jump(List<Integer> integers){
        int cur = 0, far = 0, step = 0;
        far = integers.get(0);
        while (cur < n){
            //能跳到最后了，直接返回
            if (far >= n - 1) {
                return step + 1;
            }
            //初始化next_step
            int next_step = cur;
            //把此时能跳到的最远位置用temp记录下来
            int temp = far;
            //寻找最大值
            while (cur <= temp){
                if (integers.get(cur) + cur > far) {
                    next_step = cur;
                    far = integers.get(cur) + cur;
                }
                cur += 1;
            }

            //跳了一步
            step += 1;
            //从下一个位置起跳
            cur = next_step;
        }
        return 0;
    }

}

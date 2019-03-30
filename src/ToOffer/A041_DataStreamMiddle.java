package ToOffer;

import java.util.*;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 14:51
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 这个很难理解
 */

public class A041_DataStreamMiddle {
    public static void main(String[] args) {
        A041_DataStreamMiddle ins = new A041_DataStreamMiddle();
        System.out.println(ins.func());
    }

    private String func() {
        return "hello";
    }

    /**
     * 数据流中的中位数 使用列表实现
     */
    public class Median1 {

        public List<Integer> list = new ArrayList<>();

        public void add(int num) {
            list.add(num);
        }

        public double getMedian() {
            double median = 0;
            if (list.size() == 0) {
                return median;
            }
            Integer[] arr = list.toArray(new Integer[list.size()]);
            Arrays.sort(arr);
            if (arr.length % 2 == 0) { // 数量是偶数
                median = (arr[arr.length/2-1]+arr[arr.length/2]) / 2.0;
            } else { // 数量是奇数
                median = arr[arr.length / 2];
            }
            return median;
        }
    }

    /**
     * 数据流中的中位数 使用两个堆实现
     */
    public class Median2 {

        public int count = 0;
        public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11,
                new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

        public void insert(int num) {
            if (count % 2 == 0) {       // 第偶数个数
                maxHeap.offer(num);
                int temp = maxHeap.poll();
                minHeap.offer(temp);
            } else {                    // 第奇数个数
                minHeap.offer(num);
                int temp = minHeap.poll();
                maxHeap.offer(temp);
            }
            count++;
        }

        public double getMedian() {
            if (count % 2 == 0) { // 总数量为偶数
                return (maxHeap.poll() + minHeap.poll()) / 2.0;
            } else { // 总数量为奇数
                return minHeap.poll();
            }
        }

    }

}

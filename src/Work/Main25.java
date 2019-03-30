package Work;

public class Main25 {

    public static void main(String[] args) {
        Main25 ins = new Main25();
        System.out.println(ins.NumberOf1(357));//357 -> 5
    }

    private int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;//按位与//去掉最右边的1
        }
        return count;
    }

}

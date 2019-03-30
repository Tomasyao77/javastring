package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-10-18 15:40
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数，求任意第n位对应的数字。
 * 寻找数学规律(数学规律题真头疼)
 * 跳过不同位数的数字，在相应位数中寻找
 * •以序列中第1001位为例：
 * •序列前10位为0-9，跳过，再从后面找991位；
 * •后面180位为10-99，跳过，再从后面找881位；
 * •后面2700位为100-999，因为811<2700，所以811位是某个三位数中的一位；
 * •由于811=270*3+1，这就是说811位是从100开始的第270个数字即370的中间一位，即7。(注意，这里都是从第0位开始计数的)
 */

public class A044_DigitAtIndex {
    public static void main(String[] args) {
        A044_DigitAtIndex ins = new A044_DigitAtIndex();
        System.out.println(ins.digitAtIndex(1001));
    }

    private int digitAtIndex(int index) {
        if (index < 0)
            return -1;
        if (index <= 9)
            return index;

        int curIndex = 10;
        int boundNum = 10;
        int digit = 2;
        while (index > curIndex + lengthSum(digit)) {
            curIndex += lengthSum(digit);
            boundNum += lengthSum(digit) / digit;
            digit++;
        }
        int addNum = (index - curIndex) / digit;
        int tempIndex = (index - curIndex) % digit;
        boundNum = boundNum + addNum;
        int result = boundNum;
        for (int i = 1; i < digit - tempIndex; i++) {
            result = result / 10;
        }
        result = result % 10;
        return result;
    }

    // n位数的长度
    private int lengthSum(int digit) {
        if (digit == 1)
            return 10;
        int temp = 9;
        for (int i = 1; i < digit; i++) {
            temp = temp * 10;
        }
        return digit * temp;
    }

}

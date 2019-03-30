package encode;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-07-24 10:15
 */

public class DESTest {
    public static void main(String[] args) {
        try {
            DESTest.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void test() throws Exception {
        String inputStr = "DESwomen中文嫦娥抗水公司武汉光谷DESwomen中文嫦娥抗水公司武汉光谷DESwomen中文嫦娥抗水公司武汉光谷DESwomen中文嫦娥抗水公司武汉光谷DESwomen中文嫦娥抗水公司武汉光谷DESwomen中文嫦娥抗水公司武汉光谷DESwomen中文嫦娥抗水公司武汉光谷DESwomen中文嫦娥抗水公司武汉光谷";
        String key = DESCoder.initKey("cejsyjsbgs");
        System.err.println("原文:\t" + inputStr);

        System.err.println("密钥:\t" + key);

        byte[] inputData = inputStr.getBytes();
        inputData = DESCoder.encrypt(inputData, key);

        System.err.println("加密后:\t" + DESCoder.encryptBASE64(inputData));

        byte[] outputData = DESCoder.decrypt(inputData, key);
        String outputStr = new String(outputData);

        System.err.println("解密后:\t" + outputStr);
    }
}

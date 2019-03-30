package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * java和c++的实现考虑方式还是不同的
 */

public class A005_SpaceTo20 {

    public static void main(String[] args){
        A005_SpaceTo20 ins = new A005_SpaceTo20();
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(ins.replaceSpace(stringBuffer));
    }

    /**
     * StringBuffer是线程安全的
     */
    private String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        StringBuilder sb = new StringBuilder();//额外空间

        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    //还可以用类似c++的指针法，我就不写了，没时间

}

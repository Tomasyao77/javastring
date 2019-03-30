package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串”aaa”与模式”a.a”和”ab*ac*a”匹配，但是与”aa.a”和”ab*a”均不匹配
 */

public class A019_RegularMatch {

    public static void main(String[] args) {
        A019_RegularMatch ins = new A019_RegularMatch();
        String str = "aaa";
        String pattern = "aab*a";

        boolean result = ins.match(str.toCharArray(), pattern.toCharArray());
        System.out.println(result);
    }

    /**
     * @param str     字符串
     * @param pattern 模式
     * @return
     */
    private boolean match(char[] str, char[] pattern) {
        //参数校验
        if (str == null || pattern == null || str.length == 0 || pattern.length == 0) {
            return false;
        }
        //递归匹配
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int pIndex) {
        //涉及到递归，一般都要在函数开始处加判断，看是否终止
        //字符串和模式都已操作完，返回true
        if (strIndex >= str.length && pIndex >= pattern.length)
            return true;
        //字符串没有操作完，模式操作完，返回false
        if (strIndex < str.length && pIndex >= pattern.length)
            return false;
        //字符串操作完，模式没有操作完
        if (strIndex >= str.length && pIndex < pattern.length) {
            if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
                return matchCore(str, strIndex, pattern, pIndex + 2);//精妙
            } else {
                return false;
            }
        }
        /**
         * 字符串没有操作完并且模式没有操作完
         * 核心，太难了
         */
        //如果模式的下一个字符为*
        if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
            //字符串和模式的当前字符能够匹配
            if (str[strIndex] == pattern[pIndex]) {
                return matchCore(str, strIndex, pattern, pIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, pIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, pIndex);
            } else {
                return matchCore(str, strIndex, pattern, pIndex + 2);
            }
        } else {
            if (str[strIndex] == pattern[pIndex] || pattern[pIndex] == '.') {
                return matchCore(str, strIndex + 1, pattern, pIndex + 1);
            } else {
                return false;
            }
        }
    }

}

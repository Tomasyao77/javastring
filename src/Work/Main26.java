package Work;

/**
 * 不用length等系统属性将字符数组中的连续空格保留到1个
 */
public class Main26 {

    public static void main(String[] args) {
        Main26 ins = new Main26();
        /*char[] chars = {' ', ' ', ' ', 'a', ' ', ' ', ' ', 'b',
                ' ', ' ', 'c', ' ', ' ', ' ',
                ' ', ' ', 'f', ' ', ' ', ' ',
                ' ', ' ', 'e', ' ', ' ', ' ',
                ' ', ' ', 'a', ' ', ' ', 'b',
                ' ', ' ', 'c', ' ', ' ', ' '};
        System.out.println(String.valueOf(ins.slimSpace(chars)).trim());*/
        System.out.println(f(12));
    }

    public static int f(int n){
        if(n<=3){
            return 1;
        }else {
            return f(n-2)+f(n-6)+1;
        }
    }

    /*private char[] slimSpace(char[] chars) {
        int index = 0;
        for(char c : chars){
            index++;
        }
        index--;//指向最后一位
        int len = index;
        boolean flag = false;
        int count = 0;
        while (index >= 0){
            if(chars[index] == ' '){
                count++;
                flag = true;
            }else {
                flag = false;
            }

            if((!flag) && (count > 1)){
                //去空格
                for(int i=index+2; i<len-count+1; i++){//不越界
                    chars[i] = chars[i+count-1];
                }
                count = 0;
            }

            index--;
        }
        return chars;
    }*/

}

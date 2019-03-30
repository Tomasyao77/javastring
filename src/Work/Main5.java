package Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main5 {
    private static String result = "";
    private static List<String> strings = new ArrayList<>();
    private static List<String> resultStrings = new ArrayList<>();
    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        int n= Integer.parseInt(scan.nextLine());

        char[] cs = new char[2*n];
        printParenthesis(0, n, 0, 0, cs);


        for(int i=strings.size()-1; i>=0; i--){
            resultStrings.add(strings.get(i));
        }
        for(String s : resultStrings){
            result += (s + ",");
        }

        System.out.println(result.substring(0, result.length()-1));

    }

    private static void printParenthesis(int pos , int n , int open ,int close ,char[] buffer){
        if(close == n){
            strings.add(new String(buffer));
            return;
        }
        if(open > close){
            buffer[pos]=')';
            printParenthesis(pos+1, n, open, close+1, buffer);

        }
        if(open < n){
            buffer[pos] = '(';
            printParenthesis(pos+1, n, open+1, close, buffer);
        }

    }
}

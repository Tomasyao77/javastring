package Work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zouy on 17-9-20.
 */
public class Main8 {
    enum Type{
        Unspecified, Loopback, LinkLocal, SiteLocal, GlobalUnicast, Multicast, Error
    }
    private static String input;
    private static List<String> inputList;
    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        //input = "FE81:0001:0000:0000:FF01:0203:0405:0607";
        inputList = Arrays.asList(input.split(":"));

        decideType();
    }
    private static void decideType(){
        if(input.length() != (32 + 7)){
            System.out.println(Type.Error.toString());
        }else if(ifUnspecified()){
            System.out.println(Type.Unspecified.toString());
        }else if(ifLoopback()){
            System.out.println(Type.Loopback.toString());
        }else if(ifLinkLocal()){
            System.out.println(Type.LinkLocal.toString());
        }else if(ifSiteLocal()){
            System.out.println(Type.SiteLocal.toString());
        }else if(ifMulticast()){
            System.out.println(Type.Multicast.toString());
        }else {
            System.out.println(Type.GlobalUnicast.toString());
        }
    }
    private static boolean ifUnspecified(){
        StringBuilder sb = new StringBuilder();
        StringBuilder sbZero = new StringBuilder();
        for(String s : inputList){
            sb.append(s);
            sbZero.append("0000");
        }
        return sb.toString().equals(sbZero.toString());
    }
    private static boolean ifLoopback() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbZero = new StringBuilder();
        for(String s : inputList){
            sb.append(s);
            sbZero.append("0000");
        }
        String temp = sbZero.toString();
        temp = temp.substring(0, temp.length()-1) + "1";
        return sb.toString().equals(temp);
    }
    private static boolean ifLinkLocal() {
        StringBuilder sb = new StringBuilder();
        for(String s : inputList){
            sb.append(s);
            break;
        }
        int temp = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(sb.toString(), 16)).substring(0, 10));
        return (temp & 1111111010) == 1111111010;
    }
    private static boolean ifSiteLocal() {
        StringBuilder sb = new StringBuilder();
        for(String s : inputList){
            sb.append(s);
            break;
        }
        int temp = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(sb.toString(), 16)).substring(0, 10));
        return (temp & 1111111011) == 1111111011;
    }
    private static boolean ifMulticast() {
        StringBuilder sb = new StringBuilder();
        for(String s : inputList){
            sb.append(s);
            break;
        }
        int temp = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(sb.toString(), 16)).substring(0, 8));
        return (temp & 11111111) == 11111111;
    }

}

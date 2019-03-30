import java.util.*;
public class Main {
    private static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = Integer.parseInt(line);

        while(n>0){
            line = in.nextLine();
            line = in.nextLine();
            String[] scoresStr = line.split(" ");
            Integer[] scores = new Integer[scoresStr.length];
            for(int i=0; i<scoresStr.length; i++){
                scores[i] = Integer.parseInt(scoresStr[i]);
            }
            calMinReward(scores);
            n--;
        }

        for(Integer i: numList){
            System.out.println(i);
        }

    }


    private static void calMinReward(Integer[] scores){
        int[] rewards = new int[scores.length];
        for(int i=0; i<scores.length; i++){
            rewards[i] = 1;
        }

        boolean flag = true;
        do{
            //从左到右
            for(int i=1; i<scores.length; i++){
                if(scores[i]>scores[i-1]){
                    rewards[i] = rewards[i-1] + 1;
                }
            }
            //最后一个元素和第一个元素比较
            if(rewards.length>2){
                if(scores[scores.length-1] > scores[0]){
                    rewards[rewards.length-1] = rewards[0] + 1;
                    flag = false;
                }else {
                    flag = true;
                }
            }else {
                flag = true;
            }
            //从右到左
            for(int i=scores.length-2; i>=0; i--){
                if(scores[i]>scores[i+1]){
                    rewards[i] = rewards[i+1] + 1;
                }
            }
            //第一个元素和最后一个元素比较
            if(rewards.length>2){
                if(scores[0] > scores[scores.length-1]){
                    rewards[0] = rewards[rewards.length-1] + 1;
                    flag = false;
                }else {
                    flag = true;
                }
            }else {
                flag = true;
            }
        }while (!flag);

        int num = 0;
        for(int i=0; i<rewards.length; i++){
            num += rewards[i];
        }

        numList.add(num);
    }
}
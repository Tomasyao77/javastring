package string;

/**
 * Created by zouy on 19-6-4.
 */
public class KMP {
    public static int count = 0;
    public static void main(String[] args){
        System.out.println(KMP("abcaba", "aba"));
        //System.out.println(count);
    }
    //getNext[]
    public static int[] getNext(String target){
        int[] next = new int[target.length()];
        next[0] = -1; //相等最长前缀最长后缀的前缀的长度减一
        int k = -1;//相等最长前缀最长后缀的前缀的最后一个字符的索引//k+1代表缀长

        for(int i = 1; i < target.length(); i++){
            while(k > -1 && target.charAt(k + 1) != target.charAt(i)){
                //能运行到这里，就说明不是我们最希望的状况，而这个循环就是当状况不好时，退而求其次，“缩短”能偷得懒。
                //k > -1有两个作用，1是是防止访问越界2是k如果<=-1表示不存在最长前/后缀，就没有必要找了
                k = next[k];
            }
            //跳出循环有两种情况，一种是找到了一个缩短后能用的，一个就是k等于-1了
            if (target.charAt(k + 1) == target.charAt(i)) k++;
            next[i] = k;
        }

        return next;
    }
    public static int KMP(String source, String target){
        int next[] = getNext(target);
        int k = next[0];
        for(int i = 0; i < source.length(); i++){
            while(k > -1 && target.charAt(k + 1) != source.charAt(i)){
                k = next[k];
            }
            if(target.charAt(k + 1) == source.charAt(i))  k++;//成功匹配一个节点
            if(k == target.length()-1){//k等于已经匹配的长度-1，表示找到了
                return i - target.length() + 1;
            }

        }
        return -1;
    }
}

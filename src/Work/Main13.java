package Work;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by zouy on 17-9-20.
 */
public class Main13 {

    private static String line;
    private static int k, x, y;

    private static int[][] chessboard =  new int[9][9];
    private static long result = 0;

    private static int dx[] = {1, 2, 2, 1};
    private static int dy[] = {2, 1, -1, -2};

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();
        k = Integer.parseInt(line);

        line = scan.nextLine();
        String[] temp = line.split(" ");
        x = Integer.parseInt(temp[0]);
        y = Integer.parseInt(temp[1]);

        horse_count(0, 0, x, y);
        System.out.println(result % 1000000007);
    }

    private static void horse_count(int srcx, int srcy, int destx, int desty) {
        if(srcx>=0 && srcx<9 && srcy>=0 && srcy<9) {
            if(chessboard[srcx][srcy]==0){
                if(srcx == destx && srcy == desty) {
                    int c = 0;
                    for(int i=0; i<9; i++){
                        for(int j=0; j<9; j++){
                            if(chessboard[i][j] == 1){
                                c++;
                            }
                        }
                    }
                    if(c == k){
                        result++;
                    }
                    return;
                }
                //标记为已经走过
                chessboard[srcx][srcy] = 1;
                int i;
                for(i=0; i<4; ++i) {
                    horse_count(srcx+dx[i], srcy+dy[i], destx, desty);
                }
                //当走完四个方向后，回溯到之前走过的一步，标记为未走过。
                chessboard[srcx][srcy] = 0;
            }
        }
    }
}

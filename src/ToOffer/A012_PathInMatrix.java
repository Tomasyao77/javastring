package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:27
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串”bcced”的路径，但是矩阵中不包含”abcb”路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class A012_PathInMatrix {

    public static void main(String[] args){
        A012_PathInMatrix ins = new A012_PathInMatrix();
        System.out.println(System.currentTimeMillis());
        System.out.println(ins.hasPath("abceabcesfcssfcsadeeadeesfcssfcssfcssfcs".toCharArray(), 5, 8,
                //"ABCCEE".toCharArray()));
                "sfdasffsssescedffc".toCharArray()));
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 分析：
     这是一个可以用回朔法解决的典型题。
     1、首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的第i个位置。
     如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
     2、重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。

     由于回朔法的递归特性，路径可以被看成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
     由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子
     a b c e a b c e
     s f c s s f c s
     a d e e a d e e
     s f c s s f c s
     s f c s s f c s

     str: a b c c e e
     */
    /**
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 待搜索的字符串
     * @return true 存在路径, false 不存在路径
     */
    private boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        //参数校验
        if(matrix == null || matrix.length == 0 || matrix.length != rows * cols || str == null || str.length == 0){
            return false;
        }
        //初始化访问标记矩阵
        boolean[] visited = new boolean[rows * cols];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        //以每个点为起始点进行搜索
        //咋一看暴力遍历，其实某个点不满足只需要最多4步就可以剔除出局，所以时间复杂度不会很高
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(hasPathCore(matrix, rows, cols, str, 0, i, j, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 待搜索的字符串
     * @param row 当前处理的行数
     * @param col 当前处理的列数
     * @param visited 访问标记数组
     * @return true 存在路径， false 不存在路径
     */
    public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int index, int row, int col, boolean[] visited){
        //index是局部变量，且是值传递
        if(index >= str.length){
            return true;
        }
        boolean hasPath = false;//初始化,接下来如果该点符合要求就递归走下一步
        // 推断位置是否合法 &&是短路运算，后面不用担心越界
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[index] && !visited[row * cols + col]){
            //如果未被访问，且匹配字符串，标记当前位置为已访问，分上下左右四个位置递归求解
            visited[row * cols + col] = true;
            // 按左上右下进行探索
            hasPath =  hasPathCore(matrix, rows, cols, str, index+1, row, col - 1, visited)||
                    hasPathCore(matrix, rows, cols, str, index+1, row - 1, col, visited)||
                    hasPathCore(matrix, rows, cols, str, index+1, row, col + 1, visited)||
                    hasPathCore(matrix, rows, cols, str, index+1, row + 1, col, visited);
            // 回溯
            if(!hasPath){
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

}

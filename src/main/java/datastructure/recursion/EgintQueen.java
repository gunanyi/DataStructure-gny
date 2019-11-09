package main.java.datastructure.recursion;

/**
 * 使用递归来解决8皇后问题
 */
public class EgintQueen {
    static int result = 0;
    static int max = 8;
    static int[] map = new int[8];  //棋盘 0~7表示7个行 每个中的值表示放在所在行的列
    public static void main(String[] args) {
        // 分析 递归需要的参数 row 当前行
        doEgintQueen(0);
        System.out.printf("共%d中解法\n",result);
    }

    /**
     * 思路
     * 1. 第一行放在第一列
     * 2. 第二行放在第二列，判断是否符合规则，找到一个合适的位置
     * 3. 依次放第三行依次到最后，找到一个合适的位置
     * 4. 找到路径后回溯，即第一行放第二次，找出所有解
     * @param row 当前行
     */
    private static void doEgintQueen(int row) {
        if(row == max){
            result++;
            print();
            return;
        }
        for(int i=0;i<max;i++){
            map[row] = i;
            if(isRule(row)){        // 找到正确的位置
                doEgintQueen(row+1);
            }
        }
    }

    /**
     * 判断当前行放的位置是否符合规则
     * @param row 当前行家
     * @return true 符合 false 不符合
     */
    private static boolean isRule( int row) {
        boolean result = true;
        int diff = 0;
        for(int i=0;i<row;i++){
            diff = Math.abs(map[i] - map[row]);
            if(0 == diff || Math.abs(row-i) == Math.abs(map[row] - map[i])){
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 打印正确的路线
     */
    private static void print(){
        for(int i=0;i<max;i++){
            System.out.printf(map[i]+"\t");
        }
        System.out.printf("\n 一种解法");
    }
}

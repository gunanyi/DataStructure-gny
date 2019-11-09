package main.java.datastructure.recursion;

/**
 * 使用递归来解决迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        // 使用数组模拟一个迷宫
        int[][] map = new int[8][7];
        // 使用 1 表示墙  上下全部设为1
        initMap(8,7,map);
        map[3][1] = 1;
        map[3][2] = 1;
        // 使用递归回溯来找到一条出去的路径

        boolean result = setway(map,1,1,6,5);
        if(result){
            for(int i=0;i<8;i++){
                for(int j=0;j<7;j++){
                    System.out.printf(map[i][j]+"\t");
                }
                System.out.printf("\n");
            }
        }else {
            System.out.println("走不通!");
        }

    }

    /**
     *使用递归回溯来找路  节点为0时，该节点未走过  1 时表示墙  2 表示为通路 3 该位置走过但无法到达终点
     * @param map  地图
     * @param startX 开始x坐标
     * @param startY 开始y坐标
     * @param endX      结束x坐标
     * @param endY      结束y坐标
     *  走的规则（自己定义） 先下，再右，再上，再左 如果走不通则回溯
     */
    private static boolean setway(int[][] map, int startX, int startY, int endX, int endY) {
        if(map[endX][endY] == 2){ // 通路找到
            return true;
        }else{                      // 没有走到终点
            if(map[startX][startY] == 0){   // 当前节点
                // 走路策略 下 -》 右 -》 上 -》 左
                map[startX][startY] = 2;
                if(setway(map,(startX+1),startY,endX,endY)){
                    return true;
                }else if(setway(map,startX,startY+1,endX,endY)){
                    return true;
                }else if(setway(map,startX-1,startY,endX,endY)){
                    return true;
                }else if(setway(map,startX,startY-1,endX,endY)){
                    return true;
                }else{ // 走不通
                    map[startX][startY] = 3;
                    return false;
                }
            }else { // map[startX][startY] = 1 || 2 || 3
                return false;
            }
        }
    }

    /**
     * 初始化迷宫，四周都为1
     * @param row
     * @param col
     * @param map
     */
    private static void initMap(int row, int col, int[][] map) {
        int [] temp = map[0];
        int [] temp1 = map[row-1];
        for(int i=0;i<col;i++){
            temp[i] = 1;
            temp1[i] = 1;
        }
        for(int i=1;i<row-1;i++){
            map[i][0] = 1;
            map[i][col-1] = 1;
        }
    }

}

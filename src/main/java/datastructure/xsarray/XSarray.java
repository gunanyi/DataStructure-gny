package main.java.datastructure.xsarray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 二维数组转稀疏数组
 */
public class XSarray {
    private static final String FILEPATH = "D:/test/newarrays.txt";

    public static void main(String[] args) throws IOException {
        // 稀疏数组
        int [][] oldArray = new int[11][11];
        oldArray[1][2] = 1;
        oldArray[2][3] = 2;
        int row = oldArray.length;
        int len = oldArray[0].length;
        int dataNum = 0;
        for(int i = 0; i< oldArray.length; i++){
            for(int j = 0; j<oldArray[0].length; j++){
                if(oldArray[i][j] != 0){
                    dataNum++;
                }
            }
        }
        // 构建新数组
        int[][] newArray = new int[dataNum+1][3];
        newArray[0][0] = row;
        newArray[0][1] = len;
        newArray[0][2] = dataNum;
        conversion(oldArray,newArray);
        // 存文件
        saveArray4Txt(newArray);
        // 从文件恢复
        conversionReader();
        // 将稀疏数组恢复为二维数组
        conversionArray(newArray);
    }

    // 把稀疏数组存入文件
    public static void saveArray4Txt(int[][] newArray) throws IOException {
         FileWriter fileWriter = new FileWriter(FILEPATH,true);
        try{
            for(int[] array:newArray){
                fileWriter.write((array[0]+"-"+array[1]+"-"+array[2])+"\r\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileWriter.flush();
            fileWriter.close();
        }
    }


    // 从文件转为 标准数组
    private static void conversionReader() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader( new FileReader(FILEPATH));
       try {
           String[] newstr = bufferedReader.readLine().split("-");
           int[][] newarr = new int[Integer.parseInt(newstr[0])][Integer.parseInt(newstr[1])];
           String strtemp=null;
           while((strtemp = bufferedReader.readLine())!=null){
               newstr = strtemp.split("-");
               newarr[Integer.parseInt(newstr[0])][Integer.parseInt(newstr[1])] = Integer.parseInt(newstr[2]);
           }
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           try {
               bufferedReader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    // 稀疏数组转二维数组
    private static void conversionArray(int[][] newArray) {
        int[][] oldArray = new int[newArray[0][0]][newArray[0][1]];
        boolean temp = false;
        for(int[] arr:newArray){
            if(temp){
                oldArray[arr[0]][arr[1]] = arr[2];
            }else{
                temp = true;
            }

        }
        for(int i=0;i<oldArray.length;i++){
            for(int j=0; j<oldArray[0].length;j++){
                System.out.print(oldArray[i][j]+"  ");
            }
            System.out.println("");
        }
    }

    // 二维数组转稀疏数组
    private static void conversion(int[][] oldArray,int[][] newArray){
        int tempi = 1;
        for(int i=0;i<oldArray.length;i++){
            for(int j=0;j<oldArray[0].length;j++){
                if(oldArray[i][j] != 0){
                    newArray[tempi][0] = i;
                    newArray[tempi][1] = j;
                    newArray[tempi][2] = oldArray[i][j];
                    tempi++;
                }
            }
        }
    }
}

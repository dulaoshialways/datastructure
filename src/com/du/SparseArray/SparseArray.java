package com.du.SparseArray;

/**
 * @author: djg
 * @date: 2019/6/30 00:22
 * @des: 稀疏数组
 * 1 创建二维数组
 * 2 使用稀疏数组保存二维数组中的有效值
 * 3 将稀疏数组还原为二维数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //1 创建二维数组
        int[][] twoDimensionalArray1 = new int[11][11];
        twoDimensionalArray1[1][3] = 1;
        twoDimensionalArray1[2][4] = 2;
        twoDimensionalArray1[3][5] = 1;
        //二维数组中有效数据的个数
        int sum = 0;
        for (int[] array : twoDimensionalArray1) {
            for (int i = 0; i < 11; i++) {
                if (array[i] != 0) {
                    sum++;
                }
                System.out.printf("%d\t", array[i]);
            }
            System.out.println();
        }

        //2 将二位数组转化为稀疏数组
        //2.1 稀疏数组的第一行存储二维数组的总行 总列 有效数据的总数
        //2.2 稀疏数组的第二行开始存储二位数组中的有效值所在的行 列 值（这里的有效值即为不为0的数据）
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int size = 0;
        for (int i = 0; i < twoDimensionalArray1.length; i++) {
            for (int j = 0; j < twoDimensionalArray1.length; j++) {
                if (twoDimensionalArray1[i][j] != 0) {
                    size++;
                    sparseArray[size][0] = i;
                    sparseArray[size][1] = j;
                    sparseArray[size][2] = twoDimensionalArray1[i][j];
                }
            }
        }

        System.out.println("--------------------------");

        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
            System.out.println();
        }


        //3 将稀疏数组恢复为二维数组
        int[][] twoDimensionalArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            twoDimensionalArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("----------------------------");
        for (int[] array : twoDimensionalArray2) {
            for (int i : array) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

    }
}

package writtenTest;

import java.util.*;

public class XiaoMiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNum = Integer.parseInt(scanner.nextLine());

        while (countNum-- > 0) {
            int[][] arr = new int[3][3];
            for (int i = 0; i < 3; i++) {
                String[] split = scanner.nextLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(split[j]);
                }
            }
            int result = countSolutions(arr);
            System.out.println(result);
        }
        scanner.close();
    }

    public static int countSolutions(int[][] arr) {
        List<Integer> zeroIndexList = new ArrayList<>();

        // 找到所有空位的位置
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    zeroIndexList.add(i * 3 + j); // 计算空位的索引
                }
            }
        }

        return solve(arr, zeroIndexList, 0); // 从第一个空位开始递归
    }

    private static int solve(int[][] arr, List<Integer> zeroIndexList, int index) {
        if (index == zeroIndexList.size()) {
            return 1; // 找到一个解决方案
        }

        int totalSolutions = 0;
        int pos = zeroIndexList.get(index); // 当前空位索引
        int row = pos / 3; // 行
        int col = pos % 3; // 列

        for (int num = 1; num <= 9; num++) {
            if (canInsert(arr, row, col, num)) {
                arr[row][col] = num; // 尝试填入数字
                totalSolutions += solve(arr, zeroIndexList, index + 1); // 递归
                arr[row][col] = 0; // 回溯
            }
        }

        return totalSolutions; // 返回有效方案的数量
    }

    public static boolean canInsert(int[][] arr, int row, int col, int targetNum) {
        // 检查上下左右是否与目标数字相邻
        if (col - 1 >= 0 && Math.abs(arr[row][col - 1] - targetNum) == 1) {
            return false; // 左侧相邻
        }
        if (row - 1 >= 0 && Math.abs(arr[row - 1][col] - targetNum) == 1) {
            return false; // 上侧相邻
        }
        if (col + 1 < 3 && Math.abs(arr[row][col + 1] - targetNum) == 1) {
            return false; // 右侧相邻
        }
        if (row + 1 < 3 && Math.abs(arr[row + 1][col] - targetNum) == 1) {
            return false; // 下侧相邻
        }

        return true; // 可以插入
    }
}
//示例1
//第一行给定一个整数n，表示数组大小，
// 第二行给定n个整数，每个整数用空格隔开，表示数组中的n个数字，请你返回数组中的元素之和。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 10000;
        long sum = 0;
        int[] w = new int[N];

        int n = scanner.nextInt(); //read size of array
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sum += w[i];
        }

        System.out.println(sum); // output sum

    }
}

//示例2
//给定一个n*m的矩形，矩形中的元素不是1就是0，
// 每个1可以和上下左右四个方向的1构成一整个连通块，求这个矩形中含有的连通块数量
//其实就是LeetCode原题，改成了ACM模式：LeetCode 200. 岛屿数量
//输入描述
//第一行输入两个整数n,m用空格隔开，接下来n行，每行输入m个整数，用,隔开

import java.util.Scanner

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(",|\\s+"); // \\s表示空白字符 \\n换行 \\d数字 +一个或多个
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][] grid = new int[n][m];
        //获取grid
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = scanner.nextInt();
            }
        }
        //numIslands计数
        System.out.println(numIslands(grid));
    }
    public static int numIslands(int [][] grid){
        if(grid==null || grid.length==0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        int numIslands = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    numIslands += 1;
                    dfs(grid, i, j); // 通过深度搜索，把联通的都变成0
                }
            }
        }
        return numIslands;
    }

    public static void dfs(int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;// 当前的标记为0
        //联通的也标记为0，防止numIslands重复计算已联通的1
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }


}

//示例3
//给定一行数字，每个数字用空格隔开
//请你将这些数字排序后并输出排序后的结果
import java.util.Scanner

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] numberStr = input.split("//s+");
        int[] numbers = new int[numberStr.length];
        for(int i=0; i<numberStr.length; i++){
            numbers[i] = Integer.parseInt(numberStr[i]);
        }
        //排序
        Arrays.sort(numbers);
        //输出
        for(int i=0; i<numberStr.length; i++){
            System.out.println(numbers[i] + ' ');
        }
        scanner.close();
    }
}





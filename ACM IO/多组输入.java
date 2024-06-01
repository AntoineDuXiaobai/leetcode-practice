//多组输入
// 其实就是题目的输入样例包含多组输入，每一组输入有对应的规则，然后最后需要返回每一组输入的输出结果

//示例1
//第一行给定一个整数T，表示输入样例的组数，
// 接下来T*2行，第一行给定一个整数n，表示数组大小，第二行给定n个整数，每个整数用空格隔开，表示数组中的n个数字，
// 请你返回每一组的数组中的元素之和。

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T= scanner.nextInt();
        ArrayList<Integer> sums = new ArrayList<>();

        for(int i=0; i<T; i++){
            int n = scanner.nextInt();
            int sum = 0;
            for(int j=0; j<n; j++) {
                int num = scanner.nextInt();
                sum += num;
            }
            sums.add(sum);
        }
        //直接每次循环里打印也行，不是必须存到数组里
        for(int sum:sums){
            System.out.println(sums[i] + "/n");
        }
    }
}

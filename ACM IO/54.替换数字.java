//多组输入
// 其实就是题目的输入样例包含多组输入，每一组输入有对应的规则，然后最后需要返回每一组输入的输出结果

//示例1
//第一行给定一个整数T，表示输入样例的组数，
// 接下来T*2行，第一行给定一个整数n，表示数组大小，第二行给定n个整数，每个整数用空格隔开，表示数组中的n个数字，
// 请你返回每一组的数组中的元素之和。

import java.util.Scanner;

public class Main{
    
    public static String Replace(String s){
        StringBuilder res = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                res.append("number");
            }else{
                res.append(ch);
            }
        }
        return res.toString();
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(Replace(input));
        
    }


}
//59.螺旋矩阵II


//1. 循环  处理边界条件    一个原则：左闭右开
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] nums = new int[n][n];
        int startX = 0, startY = 0;   //每一圈起始点
        int count = 1;   //填写的数字
        int offset = 1; // 偏移量
        int loop = 1;   // 当前圈数
        int i , j ;

        while(loop<=n/2){
            //顶部  左闭右开
            for(j=startY;j<n-offset;j++){   // 举例子 n=4 只处理0 1 2
                nums[startX][j] = count++; 
            }
            //右列 左闭右开
            for(i=startX;i<n-offset;i++){
                nums[i][j] = count++; 
            }
            //底部 左闭右开
            for(;j>startY;j--){
                nums[i][j] = count++; 
            }
            //左列 左闭右开
            for(;i>startX;i--){
                nums[i][j] = count++; 
            }
            startX++;
            startY++;
            offset++;
            loop++;

        }

        if(n%2==1){  // 如果是奇数，最后中间给n^2
            nums[startX][startY] = n*n;
        }

        return nums;
    }
}

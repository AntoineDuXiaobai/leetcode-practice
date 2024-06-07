//54.螺旋矩阵


//1. 循环  处理边界条件    一个原则：左闭右开
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();   // List接口类型  ArrayList具体实现类型

        if(matrix==null||matrix.length==0) return res;

        int m = matrix.length;
        int n = matrix[0].length;
        int left=0, right=n-1, top=0, bottom=m-1;  //设置好边界条件

        while(left<=right && top<=bottom){
            for(int j=left; j<=right; j++){
                res.add(matrix[top][j]);
            }
            top++;
            for(int i=top; i<=bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            //重点： top和right边界条件更新了，如果不符合应该直接break！！！！！！
            if(left > right || top > bottom)   break;

            for(int j=right; j>=left; j--){
                res.add(matrix[bottom][j]);
            }
            bottom--;
            for(int i=bottom; i>=top; i--){
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;

    }
};

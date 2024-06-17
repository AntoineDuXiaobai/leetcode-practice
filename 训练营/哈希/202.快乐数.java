//202.快乐数

//1. 哈希集  HashSet  O(n)
class Solution {
    private int getNext(int n){
        int d;
        int sum = 0;
        //计算每个数字的平方和
        while(n > 0){
            d = n%10;
            sum += d*d;
            n = n/10;    
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        //如果出现重复，说明已经循环了，永远不会变成1
        while(n!=1 && !record.contains(n)){
            record.add(n);
            n = getNext(n);
        }

        return n==1;
    }
}
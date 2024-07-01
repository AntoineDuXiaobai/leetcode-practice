//239.滑动窗口最大值

//1. 单调队列    deque 存索引，res存每次窗口内的头部节点对应值    O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;
        for(int i=0;i<n;i++){
            //1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek()<=i-k){
                deque.poll();
            }
            // 2.单调队列，每次放进去的数字要比末尾的都大，不然就把前面的弹出
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //窗口形成了，之后每i递增一次，相当于窗口滑动一次，每次返回头部的值
            if(i>=k-1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
//2.双指针，超时    O(n*k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = left+k-1;
        while(right<=nums.length-1){
            int max = nums[left];
            for(int i=left+1; i<=right; i++){
                max = Math.max(max,nums[i]);
            }
            res.add(max);
            //每次更新窗口边界
            left++;
            right = left+k-1;
        }
        //List<Integer> 转换成 int[]
        return res.stream().mapToInt(i->i).toArray();
    }
}


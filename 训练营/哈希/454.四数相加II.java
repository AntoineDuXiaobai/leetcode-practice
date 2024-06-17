//454.四数相加II

//1. 哈希表分别存前两个的和  & 后两个的和  HashMap  O(n^2)

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){      
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //统计前两个数组中的元素之和，并同时统计出现的次数，放入map
        for(int i:nums1){
            for(int j:nums2){
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        } 
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，  更新总次数
        for(int i:nums3){
            for(int j:nums4){
                count += map.getOrDefault(0-i-j,0);
            }
        } 
    }
}
//349.两个数组的交集

//1. 哈希集  HashSet  O(n)

import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> numSet = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        for(int i:nums1){
            numSet.add(i); // 直接加入，自动去重
        }
        for(int i:nums2){
            if(numSet.contains(i)){ 
                common.add(i);
            }
        }
        //方法一   set转换成int[]    .stream().mapToInt(x->x).toArray()
        int[] result = common.stream().mapToInt(x->x).toArray();
        return result;
        //方法二 另外申请一个数组  存放common的元素
        int[] arr = new int[common.size()];
        int j=0;
        for(int i:common){
            arr[j++] = i;
        }
        return arr;
        
    }
}

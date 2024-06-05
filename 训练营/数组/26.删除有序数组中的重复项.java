//27.移除元素

//1. 快慢双指针  初始值fast比slow大1，不一样就数组位置先加一，再赋值
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int slow = 0;
        for(int fast = 1; fast<nums.length; fast++){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;   //举一个简单的例子验证就行

    }
}


//2.HashSet(element), 统计是否出现过
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        
        Set<Integer> seen = new HashSet<>();
        int slow = 0, fast = 0;

        for(;fast<nums.length;fast++){
            if(!seen.contains(nums[fast])){
                seen.add(nums[fast]);
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;


    }
}


//3. HashMap(key,value), 存放键值对，可统计出现次数
class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Boolean> seen = new HashMap<>();
        int slow = 0, fast = 0;

        for(;fast<nums.length;fast++){
            if(!seen.containsKey(nums[fast])){
                seen.put(nums[fast],true);
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;


    }
}
//如果需要统计次数
Map<Integer, Integer> occurrences = new HashMap<>();

for (int num : nums) {
    // 如果哈希映射中已存在该数字，则计数加一；否则，初始化为1
    if (occurrences.containsKey(num)) {
        occurrences.put(num, occurrences.get(num) + 1);
    } else {
        occurrences.put(num, 1);
    }
}
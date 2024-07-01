//347.前k个高频元素

//1. 最小堆 heap   O(nlog(k))
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        //哈希表遍历  key,value   元素，频率
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //构建最小堆   比较器根据元素频率比较元素  lambda表达式 比较器
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        //遍历map.keySet()  存入元素 
        for(int num:map.keySet()){
            //加入元素，自动按照次数排序
            heap.add(num);
            if(heap.size()>k){
                heap.poll();//移除最小堆的顶部，保证一直是k个值
        }

        }
        int[] topK = new int[k];
        for(int i=k-1;i>=0;i--){
            topK[i] = heap.poll();
        }
        
        return topK;
    }
}
//2.排序   
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 创建一个列表，包含map中的所有条目
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // 根据频率对条目进行排序
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // 取出前k个元素的键
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }

        return res;
    }
}   

//3.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //Map.Entry 遍历 map.entrySet()
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
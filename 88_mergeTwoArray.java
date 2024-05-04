//88.合并两个有序数组

//1. 直接合并后排序
// 复杂度分析

// 时间复杂度:O((m+n)log(m+n))
// 排序序列长度为 m+n, 套用快速排序的时间复杂度即可，平均情况为 O((m+n)log(m+n))

// 空间复杂度:O(log(m+n))
// 排序序列长度为 m+n, 套用快速排序的空间复杂度即可,平均情况为O(log(m+n))

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i<n; i++){
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}

//2. 新建另一个数组   双指针  比较  每次放最小的进新数组   时间复杂度 空间复杂度降低为O(m+n)   

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}

//3. 逆向双指针  时间复杂度：O(m+n)。 指针移动单调递减，最多移动 m+n次，因此时间复杂度为 O(m+n)
// 直接对数组 nums1原地修改，不需要额外空间空间复杂度 O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1, p2=n-1;
        int tail = m+n-1;
         // 从后向前生成结果数组，类似合并两个有序链表的逻辑
        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[tail] = nums1[p1];
                tail--;
                p1--;
            }else{
                nums1[tail] = nums2[p2];
                tail--;
                p2--;
            }
        }
        //因为我们本身就是在往 nums1 中放元素，所以只需考虑 nums2 是否剩元素即可
        while(p2>=0){
            nums1[tail] = nums2[p2];
                tail--;
                p2--;
        }
    }
}
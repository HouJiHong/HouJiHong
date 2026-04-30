package com.HJh.test.ZuoYeTest.merge;

public class test {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] afterMerge = new int[m + n];
        //合并 nums2 , nums1 ，使合并后的数组按 递增顺序 排列
        int i = 0; // nums1的指针
        int j = 0; // nums2的指针
        int k = 0; // afterMerge的指针

        // 比较两个数组的元素，将较小的放入合并数组
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                afterMerge[k++] = nums1[i++];
            } else {
                afterMerge[k++] = nums2[j++];
            }
        }

        // 将nums1中剩余的元素复制到合并数组
        while (i < m) {
            afterMerge[k++] = nums1[i++];
        }

        // 将nums2中剩余的元素复制到合并数组
        while (j < n) {
            afterMerge[k++] = nums2[j++];
        }
        return afterMerge;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        int []m = merge(nums1, nums1.length, nums2, nums2.length);
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i]);
        }
        System.out.println();
    }
}

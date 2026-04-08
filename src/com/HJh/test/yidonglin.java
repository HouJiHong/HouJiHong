package com.HJh.test;

public class yidonglin {

        public void moveZeroes(int[] nums) {
            int nonZeroIndex = 0;  // 指向下一个非零元素应该放的位置

            // 第一遍：把所有非零元素移到前面
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[nonZeroIndex] = nums[i];
                    nonZeroIndex++;
                }
            }

            // 第二遍：把剩下的位置填0
            for (int i = nonZeroIndex; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

}

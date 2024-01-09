package com.leetcode.demo.leetcode;

import java.util.*;

/**
 * 三数之和
 * https://leetcode.cn/problems/3sum/description/
 */
public class LeetCode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 以下是根据官方题解
        // 将数组先排序，然后按 a、b、c 三层分别遍历
        int n = nums.length;
        Arrays.sort(nums);
        // 遍历 a
        for (int first = 0; first < n; ++first) {
            // 因为数组是递增的，如果前三个元素和已经大于0，后面就没必要继续尝试了
            if (first + 2 < n && (nums[first] + nums[first + 1] + nums[first + 2]) > 0) {
                break;
            }
            // 相似的原因，如果第一个元素加上最大的两个元素都还是小于 0 ，那么第二层和第三层也就没必要尝试了，但第一层还是可以继续尝试后面的元素
            if (first < n - 2 && (nums[first] + nums[n - 2] + nums[n - 1]) < 0) {
                continue;
            }
            // 排除调相邻的相等元素
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = - nums[first];
            // 遍历 b
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 遍历 c
                // (a 确定的情况下，b 是递增遍历的，如果 c 也是正向递增遍历的话，那么 a+b+c 就是从一个很小的值
                // 不断递增遍历，直到和等于 0，然后之后的 c 就没遍历的必要了，这种方法耗时且不好控制，更好的方法
                // 是 c 按反向递减的方式进行遍历)
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    // 精选解答中一种更精简的写法
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序还是要做的
        int n = nums.length;
        Arrays.sort(nums);
        // 基本思路和上面的官方类似，但是做法更精简
        // 最外面一个大的for循环，里面就是一个 while 遍历双指针，中间有一些去重的措施
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // 去重
            int l = i + 1;  // 左指针
            int r = n - 1;  // 右指针
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 下面2步比较关键，都是为了去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -1, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println();
    }
}

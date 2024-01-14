package com.leetcode.demo.leetcode;

import java.util.HashMap;

/**
 * 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/description/
 */
public class LeetCode76 {

    /**
     * 以下滑动窗口解法来自 labuladong：
     *
     * 思路是用一个窗口 window 来记录遍历到的字符，下标 left 和 right 分别代表窗口的起始和结束
     * （这里要注意 [left, right) 这个区间是左闭右开的，主要是为了好处理边界值）
     * right 指针从左往右不断扫描，符合要求的字符就放进 window 中，然后记录最新的子串长度 len；
     * 当 window 中包含了所要求的全部字符后，比较最新的 len 和 之前记录的最小 len，二者选小的记
     * 录为最小；
     * 然后 left 左指针右移，开始寻找下一个有效子串，找到后再和之前的 minLen 比较长短；
     *
     * 重复以上逻辑，直到遍历一遍原字符串，即得到最终的结果。
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        // 需要被包含的字符集（key是字符，value是字符出现的次数）
        HashMap<Character, Integer> need = new HashMap<>(t.length());
        // 滑动窗口，记录遍历过程中匹配到的字符
        HashMap<Character, Integer> window = new HashMap<>(t.length());
        int valid = 0;  // 记录滑动窗口中符合要求的字符的个数（窗口收缩时要用到）
        int left = 0, right = 0;  //  左右指针，也是窗口的起始和结束下标
        int len = Integer.MAX_VALUE;  // 记录最短子串的长度
        String res = "";  // 待返回的最短子串

        // 先初始化 need 字符集
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 开始遍历，并向右移动窗口
        while (right < s.length()) {
            // 不断向右遍历 s 字符串，把符合要求的字符放入 window，直到有效字符数 valid 等于 need 大小
            Character c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 这里要注意：window 中包含的字符的数量和 need 需要的字符数量相等，valid 才能加 1
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 上面是窗口扩张的过程
            // 当寻找到有效的子串后，就需要进行窗口收缩了，当然收缩前需要更新一下相关的数据，比如 len 和 valid
            while (valid == need.size()) {
                // 因为这里区间是左闭右开的设定，所以这里 right-left 就是子串的长度
                if (right - left < len) {
                    len = right - left;
                    res = s.substring(left, right);
                }
                Character c1 = s.charAt(left);
                left++;
                if (window.containsKey(c1)) {
                    // 先更新 valid 值
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "A";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println();
    }
}

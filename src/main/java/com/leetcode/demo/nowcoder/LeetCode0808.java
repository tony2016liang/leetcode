package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * 面试题 08.08 有重复字符串的排列组合
 * https://leetcode.cn/problems/permutation-ii-lcci/
 */
public class LeetCode0808 {

    List<String> permutations = new ArrayList<String>();
    StringBuffer temp = new StringBuffer();  // 临时字符串用于存储当前排列
    char[] arr;
    int n;  // 字符串长度
    boolean[] visited;  // 标记数组，记录某字符是否已加入当前排列（为了去重）

    // todo 这个解法理解的还不透，先不纠结，后面有时间再回头看看
    public String[] permutation(String s) {
        arr = s.toCharArray();
        Arrays.sort(arr);
        this.n = s.length();
        this.visited = new boolean[n];
        backtrack(0);
        return permutations.toArray(new String[permutations.size()]);
    }

    public void backtrack(int index) {
        if (index == n) {
            permutations.add(temp.toString());
        } else {
            // 每次将字符加入当前排列前，需要遍历字符数组，只有尚未加入当前排列的字符才能加入
            for (int i = 0; i < n; i++) {
                // 这步主要为了去重，即当已排序数组中 arr[i] == arr[i-1] 时，
                // 需要确保 arr[i-1] 在 arr[i] 之前加入当前排列
                if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) {
                    continue;
                }
                // 将 arr[i] 加入当前排列，并将该字符的状态更新为已加入
                temp.append(arr[i]);
                visited[i] = true;
                /**
                 * 针对这个 for 循环和这个 backtrack 回溯的理解：
                 * 每次 i 取值，都会从 0 到 n-1 回溯 n 次，每次回溯又会进行 n 次的 for 循环，直到 index == n 结束回溯或递归，
                 * 事实上是形成了一个双重循环的结构。
                 * 然后通过 visited 数组和一些规则，限制了已加入当前排列的元素无法再次加入，也就不会再次进行回溯。
                 *
                 * 再简单一些理解的话（不知是否准确）：
                 * 当 i=0 时，通过
                 */
                backtrack(index + 1);
                // 回溯结束后，将当前排列的末尾字符（arr[i], 此时 i = index = n)
                // 并将该字符的状态更新为为加入当前排列
                // 为啥有这一步，还不太明白？
                temp.deleteCharAt(index);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0808 lc08 = new LeetCode0808();
        String[] abs = lc08.permutation("abc");
        System.out.println();
    }

}



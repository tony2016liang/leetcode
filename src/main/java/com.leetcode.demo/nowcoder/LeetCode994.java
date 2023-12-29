package com.leetcode.demo.nowcoder;

import java.util.*;

/**
 * https://leetcode.cn/problems/rotting-oranges/
 * 腐烂的橘子
 */
public class LeetCode994 {

    // 这两个变量用来获取某个方格的上、左、下、右四个方向的邻居方格
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        // 总行数、总列数
        int R = grid.length, C = grid[0].length;
        // queue 用来存放腐烂的且未遍历处理过的橘子，先进先出（尾进头出）
        Queue<Integer> queue = new ArrayDeque<Integer>();
        // depth 用来记录橘子腐烂的速度，即某个方格的深度，初始阶段的腐烂橘子节点视为第 0 层，即深度为 0
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        // 遍历所有方格，对于其中腐烂的橘子，将其方格代码存入 queue 双端队列，将方格代码作为key、0作为value存入 depth
        // 这里是把所有的方格按从左到右、从上到下的顺序从 0 开始进行编码，code 的值代表的就是对应编码的方格
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;  // 记录最大深度
        // 遍历 queue，此时 queue 中存的是腐烂的橘子
        while (!queue.isEmpty()) {
            int code = queue.remove();  // 弹出首个橘子
            int r = code / C, c = code % C;  // 计算该橘子所在的行和列
            // 遍历橘子上下左右四个方向
            for (int k = 0; k < 4; ++k) {
                // k从0到3，得到的 (nr, nc) 坐标分别位于原橘子的上、左、下、右
                int nr = r + dr[k];
                int nc = c + dc[k];
                // 前面四个条件判断是否溢出；最后一个条件判断是否新鲜
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    // 如果遍历到的这个橘子是新鲜的，则变为腐烂，同时将该橘子所在的方格代码存入 queue，
                    // 以及将该代码对应的 depth 深度都设置为原橘子所在深度加 1
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);  // 同时将 ans 值更新为最新的最大深度
                }
            }
        }
        // 最后判断剩下的橘子中是否还有新鲜的，如果有，说明有橘子永远不会腐烂，返回 -1
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

}

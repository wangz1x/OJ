package com.wzx.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/6/27 上午10:39
 */
public class Leetcode909 {

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,14,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        // 如何把 1,2,3...映射到board中
        // 横坐标：
        //   board.length-1 - (x-1)/board[0].length
        //   偶数就从左到右, 奇数就从右到左
        // 纵坐标：
        //   (x-1)%board[0].length
        //   从上边的判断，如果是从左到右: (x-1)%board[0].length
        //               如果是从右到左: (board[0].length-1) - (x-1)%board[0].length

        int step = 0;
        int end = board.length * board[0].length;

        visited.add(1);
        queue.offer(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size > 0) {
                int cur = queue.poll();
                for (int i = 1; i < 7; i++) {
                    if (!visited.contains(cur+i)) {
                        visited.add(cur+i);
                        // can jump
                        int jump = numToCoordinate(board, cur+i);
                        // end
                        if (cur+i == end || jump == end) {
                            return step;
                        }
                        if (jump != -1) {
                            queue.offer(jump);
//                            visited.add(jump);
                        } else {
                            queue.offer(cur+i);
                        }
                    }
                }
                size--;
            }
        }
        return -1;
    }

    public static int numToCoordinate(int[][] board, int num) {
                int len = (num-1)/board[0].length;
                int x = board.length-1 - len;
                int y = (num-1)%board[0].length;
                if ((len&1) == 1) {
                    y = (board[0].length-1) - y;
                }
                return board[x][y];
    }
}

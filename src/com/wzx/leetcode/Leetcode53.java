package com.wzx.leetcode;

public class Leetcode53 {
    public static void main(String[] args) {
        Leetcode53 l = new Leetcode53();

        int[] arr = {-1};
        System.out.println(l.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, nums.length - 1).mSum;
    }

    public SegNode dfs(int[] nums, int left, int right) {

        if (left == right) return new SegNode(nums[left], nums[left], nums[left], nums[left]);

        // max(left, right, mid)
        int mid = (left+right) >> 1;
        SegNode node = new SegNode();
        SegNode l = dfs(nums, left, mid);
        SegNode r = dfs(nums, mid+1, right);
        node.allSum = l.allSum + r.allSum;
        node.lSum = Math.max(l.lSum, l.allSum+r.lSum);
        node.rSum = Math.max(l.rSum+r.allSum, r.rSum);
        node.mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum+r.lSum);

        return node;
    }

    static class SegNode {
        int lSum;
        int rSum;
        int mSum;
        int allSum;

        public SegNode() {
        }

        public SegNode(int lSum, int rSum, int mSum, int allSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.allSum = allSum;
        }
    }
}

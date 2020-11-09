package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-23,-14,3,-17,27,-26,-9,-1,11,24,26,12,-15,-5,-15,2,24,7,-26,20,28,-7,23,-9,16,29,-9,-27,20,-29,8,3,23,14,-6,19,10,18,4,29,1,-20,13,24,-16,-8,-25,13,-18,-30,21,21,-10,3,5,-11,2,7,-17,-28,-15,-12,3,16,18,3,22,-3,19,10,0,-29,0,-10,-20,-29,16,-10,17,5,-26,17,0,-7,-6,22,7,25,-4,-14,-19,11,22,8,-11,-16,29,-15,21,1,5,5,18,17,29,11,10,8,3,16,-25,10,18,8,-9,-15,-10,-18,26,-26,1,-11,-13,-1,-13,22,-13,-21,5,-28,-27,-7,8,-16,19,19,-12,-19,-10,7,0,15,-20,28,-20,-23,-26,-12,6,-7,-14,29,7,-27,-17,11,17,7,12,-11,18,-4,28,0,12,27,6,17,25,22,-10,9,-29,-9,28,-9,9,13,-11,7,28,-7,-26,11,4,8,20,27,-5,-26,22,-18,-8,2,28,27,-22,-19,16,-14,-20,5,9,-23,-15,-24,-4,-5,9,29,-16,-4,26,-18,-18,-26,21,-4,9,8,21,-3,25,-30,-25,17,19,-20,-11,23,-23,8,4,-10,14,19,-27,-3,-4,12,-5,12,-16,-30,-21,-6,-25,15,2,27,-4,-19,4,10,22,8,-10,21,-25,7,-3,-3,-5,25,15,-7,-9,-28,3,-22,7,10,28,-26,23,6,19,-29,-7,22,-25,-1,4,23,-29,5,-28,-6,26,18,-10,23,-17,-14,25,23,3,7,27,-20,-29,17,18,20,16,7,-6,22,-13,25,27,3,19,-5,17,5,-30,-9,20,-10,27,4,19,-20,17,23,-27,-24,16,-10,-10,2,18,0,4,0,27,15,17,-2,-14,14,2,18,-1,-5,-14,-8,1,-4,14,-10,9,3,9,11,22,8,7,26,-12,-8,-13,18,27,-29,-30,16,-23,-26,-4,21,-12,-4,1,-22,-5,28,9,2,5,8,-15,-28,-13,16,14,15,-1,28,20,-9,-3,-20,28,-12,3,24,-5,29,-3,5,8,27,-30,-25,-23,9,-5,-12,1,-10,29,6,25,25,19,-11,-27,-16,22,20,-28,-8,16,6,12,17,-12,-7,24,-21,-28,-13,27,-3,-29,24,-19,-26,10,-15,14,29,-23,3,-13,-22,-1,24,18,-13,18,-17,6,13,25,-22,23,-7,16,2,-4,22,-22,20,6,10,15,-13,-18,-8,-7,-11,16,-19,-26,6,-9,-23,0,-4,-11,15,11,19,23,-2,4,-19,13,10,6,-20,0,26,-13,-16,9,18,-10,24,24,28,-4,2,19,-26,2,12,24,19,5,25,1,5,29,-30,-14,-6,-8,1,18,15,-13,-9,-29,11,3,-13,25,14,5,-6,-18,-29,3,15,-1,-13,12,21,-1,-29,4,-13,8,20,25,-24,19,15,-14,-4,-22,21,-11,27,14,-15,-3,13,-24,22,3,-14,-16,19,-10,25,28,-20,1,8,23,-17,3,3,-11,-23,2,2,-20,-28,-30,-27,-11,-14,-26,-5,-23,-24,-10,19,4,-24,24,0,-17,29,-12,2,-26,-10,-1,10,1,10,-17,-5,20,-1,12,-28,-22,4,12,16,-13,18,-30,-20,15,-1,2,27,-29,23,0,-13,-21,-15,19,-16,21,12,-24,-13,16,15,-9,1,9,-18,-16,-14,-4,-23,-20,5,4,3,-25,2,20,-16,12,-29,-17,0,8,-12,-29,-9,-8,-11,-11,-10,-9,14,21,12,-23,24,8,-21,5,3,-20,9,1,28,-3,16,-29,16,29,5,22,-6,-10,-11,27,-10,-17,22,-26,15,-9,13,29,9,3,-21,-29,-12,-19,29,-29,16,-6,29,4,22,20,-22,-11,-21,18,12,22,-16,-6,-7,-3,22,-12,-12,-28,29,-19,1,16,-15,3,14,22,13,20,-7,-13,-12,15,1,-19,-15,-30,3,-22,26,-6,-1,17,-27,-3,17,15,-8,-30,24,1,-24,-8,20,-17,9,24,7,-10,3,29,22,27,-4,2,-19,20,-21,-5,-25,-8,-1,-30,-17,-25,14,25,16,-24,20,24,13,-14,-2,28,9,-18,11,-1,-1,-29,-5,-27,12,-27,24,-4,-19,8,-25,-12,5,13,-1,-7,12,-5,-3,-23,-29,-12,29,3,5,11,28,-30,-3,10,15,8,-6,4,20,-14,-16,-19,-20,-7,-19,-1,1,-1,-19,-23,17,12,-2,-25,20,24,-19,-20,0,2,-26,-20,-9,0,14,-14,-5,14,-12,7,-7,-15,13,-11,-25,-16,-15,3,-3,-7,7,26,-25,-6,-27,25,6,12,26,6,-4,2,17,-8,-30,19,11,-22,-7,9,29,6,-4,6,-25,-29,-26,21,13,-16,-28,27,-27,18,26,16,9,-10,-9,8,-13,16,-18,-10,6,20,-19,20,1,22,9,-6,-20,-19,17,25,-9,14,-8,1,-16,-12,24,27,-8,0,21,5,13,-7,27,24,7,-6,-18,11,-23,24,-28,-23,-25,-5,-11,25,-5,18,-10,-13,9,3,-2,-4,-20,-11,23,22,-2,4,17,6,7,16,23,-9,-1,-14,-1,-20,-14,20,-13,12,-18,4,11,-15,4,-1,-28,22,-28,-3,-24,-15,3,13,4,-11,-30,15,-22,-10,-26,29,17,-1,-10,-30,18,10,-15,-8,27,11,13,10,19,11,25,5,-24,11,28,8,25,12,22,14,-21,6,9,0,-4,-10,-27,-11,15,-13,24,21,19,16,18,-1,6,16,16,23,14,2,16,-24,21,7,29,-20,22,7,14,12,8,-25,-14,19,-30,22,-15,-12,12,-17,6,16,-14,27,0,26,-30,-7,4,-11,24,-10,-6,-24,-25,20,-4,21,27,-9,-23,-3,27,18,13,29,5,-7,-30,21,12,-21,-9,-3,2,-29,17,25,-6,24,8,-17,17,-19,-4,-4,-30,8,29,-4,23,23,4,3,17,-15,15,5,16,3,1,18,19,-21,28,-14,15,15,15,-20,14,-9,21,-10,20,28,-4,-30,-2,21,7,-8,27,28,-21,7,-12,-29,0,23,8,13,24,-11,29,7,-16,15,11,7,-28,10,22,-12,-2,0,-26,-6,7,-16,-1,-15,-2,18,19,5,13,-15,22,19,18,23,-19,7,-4,-17,3,27,-21,2,-20,13,18,-16,19,6,3,-13,3,-11,-7,-13,14,14,19,4,-18,-20,-16,25,10,-5,-9,-14,-22,-12,28,-29,15,-25,-14,-19,-6,-30,-22,10,-5,4,-19,-13,-6,5,-3,-2,13,18,13,4,21,-7,3,6,-12,26,-25,-17,-20,-24,-22,-25,-17,-1,-15,-21,7,-4,-24,24,-8,12,27,18,24,19,21,14,-22,16,4,6,4,-7,-15,21,16,19,-19,-26,-1,5,-23,9,26,23,26,-28,29,7,-28,-18,-3,17,-30,18,12,-6,-8,4,28,23,25,-8,2,27,-20,22,15,-16,1,27,-26,-12,-8,6,28,-16,-17,-23,-8,-10,22,-21,14,27,29,-2,-5,-1,-11,6,7,21,-13,-16,-8,0,-26,25,23,-16,-8,15,-30,16,25,10,-27,-12,-4,-19,-18,10,2,20,-9,13,25,-6,21,-30,22,24,-20,-3,-1,-19,26,0,-20,-11,-10,15,-7,-7,-21,-30,14,-19,-14,4,-12,-16,20,-10,-28,-7,-8,-27,24,-29,6,-6,9,0,1,18,0,15,23,-30,-5,8,-13,25,17,-11,24,-19,-16,22,-23,-24,19,3,29,7,-21,10,-26,-6,-15,28,9,23,27,0,4,-10,3,-9,4,6,-27,12,-30,18,23,8,-26,-18,16,-10,4,-4,-30,-15,-17,-4,-19,18,-17,28,9,-15,23,18,-24,-23,-24,24,26,-8,29,13,-13,-14,-5,6,3,-11,5,-20,0,-11,-10,1,28,2,11,14,-16,-9,17,-29,10,-5,-5,15,20,-25,13,-4,12,26,25,-9,-7,-15,23,29,-14,28,16,17,-7,-13,-5,9,29,-2,13,28,2,-13,7,11,-20,-27,14,21,-13,-10,19,-14,-22,-18,-7,-17,6,7,-28,3,23,-27,-4,1,-5,-29,7,-22,10,22,24,23,-23,-30,29,-24,18,-29,-28,29,-27,-15,10,25,-17,-25,-15,2,-16,-6,-28,8,-29,5,5,-15,21,11,-6,-10,18,-3,-15,-1,-10,-6,19,-26,-20,-15,12,-22,14,21,14,-13,4,13,12,-9,-26,23,-22,-20,29,7,14,20,21,25,21,22,-22,-5,19,-29,29,-19,-30,-3,-17,20,7,-3,29,-22,12,15,27,28,-25,-1,11,22,-18,-9,25,19,4,-25,14,2,-2,-17,5,0,8,-29,-26,25,12,9,14,-25,21,5,0,-20,7,5,23,17,5,29,-11,-22,-20,-15,-24,18,6,2,-13,9,-29,-17,28,13,-2,24,-19,8,-1,-2,-15,26,10,-25,-22,-6,23,25,9,6,11,-14,14,-15,-4,-18,9,7,-10,20,-2,28,3,-8,-10,-3,-27,14,18,22,-14,9,-27,-19,17,6,-30,-14,16,-17,-12,-22,13,-19,-29,29,-1,-26,-11,22,-11,-10,25,29,18,-20,19,-7,14,4,-23,29,1,-20,-10,-3,-14,27,13,14,-2,8,-7,14,3,-13,-20,11,-25,-15,-5,3,2,7,9,-19,17,5,-16,-25,5,7,25,-25,24,0,14,29,-5,-23,-25,19,9,-18,23,-8,0,-1,-23,-30,14,24,19,-17,-29,27,-26,0,2,-22,-12,-15,26,6,4,-23,27,21,-28,-26,-2,-11,4,-16,10,10,2,-13,-11,-14,26,-20,-25,5,6,-19,1,-8,16,1,-1,-14,8,26,24,-22,4,-17,-13,-20,25,10,-13,27,-8,-1,7,8,19,-25,13,-12,19,7,-14,-7,-13,-19,23,-21,-13,-2,10,27,-17,-17,-21,-10,-18,-7,10,11,23,-17,-20,22,-17,-10,26,-24,21,5,1,0,24,-12,19,-11,-9,-20,-29,27,-29,-23,5,24,-7,-10,-23,23,-25,-10,6,-13,17,24,27,-10,9,6,-26,-2,-3,-16,-15,18,9,-5,-9,-25,9,9,14,1,16,-25,-29,-27,-21,13,12,-4,1,-13,-6,9,0,22,-24,-4,6,11,-5,23,-10,-12,16,-21,17,-4,-16,-16,26,-28,3,-28,-18,-21,24,-11,16,-28,-7,-2,-11,24,26,3,-25,-21,-7,28,-26,-16,-10,5,-16,9,-16,19,14,-30,-8,29,16,-7,20,-6,-8,11,13,-10,-15,-11,-29,20,-29,9,11,6,-25,-2,28,13,-28,27,-27,1,-4,-28,10,17,10,10,-26,4,-10,-15,-6,23,4,17,20,-17,-27,6,19,-25,10,-14,27,-9,-13,0,-19,-20,-14,-14,6,-8,-11,16,-27,26,14,28,2,11,9,-21,16,12,-4,18,-21,-4,16,6,5,-14,24,18,28,-20,19,22,-6,12,-22,14,-21,12,28,29,15,-23,11,8,4,4,11,-25,23,20,17,18,13,17,-29,18,-16,2,24,-22,24,-1,8,29,4,10,-27,-2,-22,27,-12,-28,-8,23,-25,13,4,-11,20,-18,19,-28,-28,-24,10,-14,-3,16,-27,3,25,2,29,-21,-3,-16,-10,21,-5,16,26,-29,-3,0,-2,-1,11,25,-5,-8,-21,26,-28,8,3,18,14,-9,27,-26,-20,-12,21,-18,26,-1,-9,12,22,-18,12,-6,20,13,-24,-11,-1,-2,-1,-14,3,-9,-24,29,-27,3,7,-30,-23,12,-12,-24,-16,21,-10,17,-12,-11,25,24,-11,-12,12,25,-22,-2,12,27,-20,11,-26,-3,6,5,8,-29,2,25,-20,13,28,-23,-20,-28,14,-25,2,-20,1,3,15,24,-17,-20,15,5,13,9,14,3,16,27,14,9,-1,13,14,-14,21,3,14,6,-27,14,-4,20,-26,14,-5,-1,19,15,-26,4,-29,21,-7,-7,-10,-11,-15,20,-20,25,-14,-8,14,29,3,8,-28,29,16,-17,-10,-1,-13,27,3,29,-6,26,-28,-8,5,-8,10,-20,18,3,12,24,-11,18,-13,22,-3,-12,-17,28,18,-27,-21,2,20,-2,18,-12,-30,-2,10,-23,11,13,-18,18,21,-3,-1,-4,29,13,27,-16,-17,-26,-13,-10,25,-22,15,-14,-29,-9,12,-29,12,28,21,29,16,-9,-21,-27,-22,-13,4,-12,-3,-2,-13,6,4,-12,-17,7,-5,22,18,-16,-12,-26,-16,15,15,0,-27,19,26,-3,-9,-26,18,20,1,26,-21,-19,26,20,-30,-12,-18,-10,-11,24,-19,16,-17,-19,12,16,27,27,-12,14,-23,-1,26,15,-16,-7,-7,-8,2,-20,21,-5,-27,23,25,-19,-22,25,-8,3,-2,-16,-29,-9,-19,8,-1,23,-13,14,-18,25,-15,8,-23,-18,0,-1,25,-15,-13,0,-29,-3,-26,17,-29,27,-28,-17,20,9,-19,25,-9,-17,17,-19,-23,17,2,-29,-14,-21,-4,8,-12,5,-28,-4,9,14,2,-1,22,-17,-8,-10,-14,14,21,14,-13,21,-13,19,-21,-18,22,-1,-18,-3,-11,6,-24,12,14,2,-1,-9,-15,-4,-4,-5,13,-3,-29,-30,-7,4,16,6,-24,-8,-4,27,-20,14,17,7,-28,22,3,-13,27,-25,29,28,1,10,12,1,-13,7,10,-19,24,10,-10,5,-9,-11,19,19,-6,3,16,-22,-4,26,20,-2,-16,-18,8,20,6,-23,-29,7,-8,12,-3,-5,10,-28,-17,-14,-26,27,-10,-23,-5,-18,-14,25,25,-10,-25,-25,23,22,13,-5,21,-16,13,24,-15,-2,0,21,28,5,-18,8,-27,-19,-16,4,15,27,-20,18,22,18,-2,-8,20,1,-28,-3,-8,28,22,10,-5,3,-23,22,12,0,15,26,19,-16,20,-28,-26,-20,19,-19,-24,-14,11,3,-14,15,9,8,8,5,17,21,9,-6,29,27,27,15,-19,-5,-2,-9,-12,2,1,-15,-1,20,20,-14,-22,-21,24,16,5,-20,12,-17,5,13,-4,21,3,10,-7,-16,-16,-2,-3,29,-23,-22,17,-19,3,9,28,25,-5,-20,18,-10,-5,28,8,26,-29,26,7,7,8,-21,13,13,-27,-15,-29,-8,-19,-5,-29,8,8,-20,-25,12,0,27,-13,7,23,11,22,-2,12,10,-5,-5,16,-19,-19,-14,-4,2,-11,2,-3,-23,25,-24,19,14,8,4,15,0,-23,-2,27,-19,27,27,-12,-19,-18,-8,-27,-9,17,16,2,28,-19,-30,8,11,23,26,-9,-21,5,-27,3,19,-3,-18,-19,-9,-29,-16,13,-23,-14,29,-6,-9,19,9,24,21,-9,-29,-18,12,-25,-11,-28,8,1,-28,-7,-14,-12,19,-29,18,12,12,-25,29,29,25,-15,0,-16,18,12,-15,13,13,22,22,-28,26,-5,-4,-14,4,21,6,-17,9,-27,-17,14,-14,-4,3,16,-24,-27,21,27,-20,23,-10,-20,5,19,-6,-15,-1,28,-20,-4,16,-29,20,-13,11,13,17,-23,2,-4,-10,7,-15,15,-14,-10,-14,-6,-25,-3,8,15,-24,22,18,2,-25,-12,20,17,18,-24,-10,19,-26,-25,6,26,18,-20,-4,21,10,-1,13,-25,-21,-15,16,-12,-12,-5,10,21,-16,-9,-22,-26,-9,-19,9,-12,27,16,-14,-2,-25,16,-16,-17,11,-8,-5,29,27,-6,22,-4,27,-30,-12,12,20,-15,22,1,7,10,-17,-5,-21,3,19,-24,-11,-9,18,2,-26,-21,23,8,6,23,-27,19,-26,8,8,-2,20,0,-7,-15,-14,-30,3,20,2,19,-28,-11,26,18,25,14,3,-11,22,-12,-28,-20,-7,-3,17,-29,24,17,11,8,-5,-15,19,11,24,-3,-14,-20,-9,1,11,-17,18,-25,9,29,-18,-5,25,-2,-24,-29,0,11,-14,26,-15,20,-5,-19,-7,-8,-22,-26,-23,20,28,-3,9,13,-4,20,-4,25,7,-11,19,-26,-23,16,15,15,6,0,-24,-20,20,-12,-1,25,18,11,-3,-22,-14,-1,4,-30,-7,-12,-29,-2,-1,-15,3,14,6,-19,21,7,-9,-9,17,28,-29,-13,-16,-1,25,-23,-15,-10,-30,1,26,4,15,-22,-19,22,-13,23,15,27,7,-4,2,29,19,25,7,2,0,18,-22,-16,-28,-17,-27,11,-6,-13,-11,-24,-26,-7,13,12,-19,-18,-23,-5,6,22,-14,-15,-26,-11,-17,11,14,18,4,29,-5,-16,-28,23,-5,-3,11,-26,-13,-3,6,-10,-2,-5,17,15,19,-17,6,-11,15,-12,-29,18,26,9,8,18,8,23,-12,13,-3,21,14,-3,22,13,25,14,12,27,-17,-27,10,-28,3,29,18,29,18,1,-3,-22,-25,26,-28,2,8,-7,0,-27,20,-26,11,-18,-4,-16,5,14,15,5,-16,17,-10,-16,27,-24,-14,-6,-2,1,-5,-21,21,24,-7,-21,4,-10,-2,13,15,16,-4,8,3,13,2,-11,14,-11,22,-27,29,19,9,-17,20,-21,-5,-26,23,1,15,25,5,13,2,12,14,-24,-8,-7,-5,-29,-25,-29,13,12,-15,18,-1,10,-26,-9,9,2,-22,11,1,24,-23,-11,-19,23,-24,-7,-29,-30,2,-11,5,20,17,-22,22,19,-22,-14,-25,-19,-21,-2,-17,-24,-22,15,-12,-7,0,20,-25,-8,13,26,-17,-18,8,-9,-29,-5,23,-15,-10,22,12,-2,-25,-4,-12,-1,-25,-22,1,-18,19,-8,-29,-11,0,8,-21,-20,-8,-30,-26,11,22,-22,-10,2,-17,15,20,-2,5,-5,15,24,-9,-27,17,25,6,10,11,29,-27,-6,28,-15,-5,11,2,-19,15,28,9,2,-22,23,-3,-14,-27,-1,3,14,-6,-19,-7,21,12,-29,27,-9,-24,22,-3,-9,-25,-7,26,19,-2,-6,-13,11,17,-5,26,-7,-5,-7,-17,-20,-12,-1,12,2,-7,22,22,4,21,-6,-1,-26,-12,4,-1,-11,-12,-14,-24,27,25,-15,13,25,16,10,4,18,-11,9,15,27,20,14,4,-6,-7,-11,18,-22,-25,1,28,11,28,-18,-26,-22,-15,-7,-5,16,-8,-4,28,-1,11,19,-17,-30,-1,-19,-8,-9,-26,9,-5,-29,-29,-2,-7,10,11,17,12,0,26,-26,20,-1,-11,-11,-2,-4,-9,-24,20,21,26,-25,5,-30,-6,-29,-20,21,-15,4,4,-17,7,1,15,8,-2,14,-13,-26,23,-2,2,11,16,-21,18,13,-11,0,5,-19,-27,9,7,0,-14,22,-2,4,13,14,-20,-18,5,7,3,-15,4,-5,-10,-11,15,-7,-27,-25,26,-21,-6,17,-5,-16,-29,-16,-27,22,11,5,2,-18,-14,25,-13,28,-14,-22,-24,22,19,-16,23,-11,0,29,5,19,23,2,0,-8,-29,-26,-27,24,-22,28,-15,-30,13,16,4,-9,8,11,-14,25,-30,14,17,-28,3,-10,-23,16,14,10,-30,13,1,24,-11,19,-20,9,-18,-24,-26,-16,-6,-3,-20,7,22,-22,24,-29,-2,18,-18,6,20,24,13,6,17,-5,16,-29,27,13,20,-6,1,-13,10,14,12,1,3,-7,2,6,-19,9,13,-11,-6,-24,15,3,-1,-27,-11,-2,22,24,19,15,9,-18,1,29,6,-13,12,-23,-19,-3,-19,-11,29,-2,-25,-27,23,5,29,-2,18,6,-6,0,-24,28,-8,-6,14,-3,0,8,-11,-26,-1,-24,5,-21,7,29,4,18,22,6,-20,20,4,-24,-1,-7,13,-12,24,-6,-18,28,14,0,-24,0,21,-12,-2,5,-11,18,-21,-18,-25,-5,1,-29,8,-11,-21,19,-16,1,6,-7,-16,27,-6,3,-20,-25,-21,-12,-20,19,-2,-4,-17,-14,12,-17,9,19,7,27,-22,-25,15,26,-4,-27,19,-16,-26,16,-12,5,11,-11,13,11,-14,-23,-3,-21,12,26,14,11,12,-30,-17,-7,-16,14,5,7,-20,-7,7,-13,16,12,23,13,4,-9,-22,-5,-28,-27,-17,-23,-18,29,-19,-1,-22,29,-24,0,-27,20,5,-8,3,-11,-19,-30,3,-4,-29,17,-27,4,-12,-10,-5,-22,-24,28,-7,12,3,7,0,-17,6,-11,-17,-28,-5,-1,4,13,-19,28,1,-7,-3,-15,-26,-23,-30,17,-25,15,11,28,-25,21,-5,-8,-15,18,8,-25,8,-22,-4,24,-2,27,28,8,-6,16,23,25,10,2,-13,3,-28,-30,25,-17,5,-17,15,1,-27,29,10,22,6,27,21,4,3,-6,-16,-14,-28,-6,-16,-17,-4,-6,3,22,-20,4,0,-16,19,-21,6,23,16,9,14,19,-17,-22,29,-13,-8,-29,-1,-22,-5,-9,-23,16,-7,4,-4,16,8,10,18,-20,8,22,-8,0,6,-30,-5,0,27,-23,-2,-3,14,2,8,-5,4,29,22,25,5,14,-29,-3,28,-13,27,-4,19,-19,-29,26,-15,-6,-5,-29,-3,22,8,22,15,11,-7,15,-29,-17,-4,-3,-10,27,1,-7,-11,-29,-22,-14,-10,-3,-21,-30,26,21,-21,-3,25,-17,12,17,12,-16,-5,19,-24,19,-1,14,20,25,20,10,17,-5,-23,-10,0,0,-9,7,-18,24,-19,18,15,1,12,13,0,-12,-3,11,-22,14,-30,5,17,9,-26,-24,3,3,4,21,-2,-25,-13,-27,20,-12,5,-17,-24,22,21,-28,-28,-6,-16,-27,7,14,-8,-12,13,28,-20,17,-10,21,-28,-25,-10,21,-23,-20,-4,1,28,-11,-22,-16,-12,23,6,4,-5,24,27,-17,-1,-1,-11,-26,13,-25,-12,0,6,6,16,-9,10,13,-25,-16,-22,5,-24,14,-1,26,27,-2,-23,-9,1,-26,-29,-14,6,-15,7,8,-13,-10,18,-2,-25,-15,14,-7,-6,-10,-20,12,-4,-5,27,28,13,-21,15,-16,1,10,-21,-25,24,28,4,27,-21,-14,-10,-9,-7,-29,13,12,-14,-12,-18,6,-3,28,-22,-13,-29,3,24,26,-28,2,-9,-9,6,-17,-30,26,-4,-26,15,1,-20,9,-1,2,22,21,-9,10,9,23,-26,8,25,11,-25,7,-13,15,26,-25,-4,-28,-12,-21,-28,-23,-6,-24,28,-16,20,-2,-16,27,26,-10,6,-4,0,-10,-16,18,4,-8,-7,20,-11,6,-17,16,28,3,6,-3,-18,17,1,21,-28,15,29,14,14,-3,-6,27,-24,-14,3,-20,28,-22,-17,8,-14,-26,-26,-24,22,17,17,20,14,-27,-19,-4,20,-28,-4,22,-1,-15,-10,16,3,-2,-20,-18,28,23,-14,-7,-17,-3,2,-15,-13,1,19,5,-2,-19,-12,-18,29,18,-6,11,16,-21,0,16,11,-30,29,-11,-7,21,29,-9,10,1,9,10,-16,-21,25,-10,0,-2,28,24,-25,-23,-4,-25,-8,-23,0,9,16,-12,-25,28,5,-8,10,19,-3,-5,21,-22,-26,-25,24,-19,-28,28,-19,-30,3,-19,-1,13,19,25,-16,-27,-25,28,28,-15,21,3,19,-7,8,-20,-2,12,-21,6,-17,-28,-3,-10,-2,0,-25,-20,24,-19,14,29,-27,3,-28,-3,10,-4,22,12,18,21,-26,6,26,20,-12,-11,-23,29,-2,-12,-23,-28,18,26,-20,-3,-24,15,-29,-12,-8,19,1,-8,-12,-11,-15,-5,-22,16,-3,27,-27,6,11,20,-15,-27,2,-10,28,-20,6,-10,-18,2,13,22,-7,26,6,-6,-2,-25,0,-25,3,-30,-19,-6,26,18,29,-16,24,-4,-14,-11,-28,-11,9,-9,27,18,14,-29,23,3,-30,-8,4,16,14,8,7,20,9,-5,-13,-13,6,-10,-26,-21,24,-16,16,-29,-14,28,12,-15,-29,-4,-16,-6,-27,19,15,5,-2,15,-10,4,13,29,19,7,-18,-22,10,27,-4,-2,-29,22,3,7,-3,-29,1,-27,17,20,28,25,-2,-27,-29,-7,25,19,26,-13,-13,-28,-4,22,-14,27,-25,-26,21,-12,15,26,19,8,-4,5,-9,-24,6,-26,19,-9,-13,-18,-13,17,0,-7,2,-26,22,-12,6,-4,-8,13,-15,-26,1,4,-4,-19,27,11,17,25,-1,2,-7,-18,-19,21,-25,26,-19,-21,9,-24,20,15,16,21,-23,-10,0,-18,15,13,27,25,-29,24,10,-13,-8,12,-2,29,-29,18,-8,-30,22,-10,-16,-20,-3,3,5,5,3,0,-15,10,7,25,9,19,10,20,-28,15,10,22,13,12,18,18,-28,-25,5,16,-28,6,-15,0,22,26,8,20,19,-8,-3,12,-11,-5,-11,16,17,-8,-26,-30,-24,-22,-26,-10,11,2,-19,8,5,24,-8,14,1,-4,-14,-21,-10,11,13,8,14,-19,2,26,-30,-28,-21,29,-8,12,-23,-29,24,15,2,20,5,27,-15,-21,-12,-13,-11,15,-21,27,-23,-12,7,0,1,-3,-12,-12,22,26,6,-2,-8,-10,-23,7,-19,24,19,6,10,20,-5,-3,-26,26,-6,-7,15,22,-11,-17,-6,-2,-11,-23,-9,17,-13,-19,-22,-8,24,13,-16,-4,6,-3,1,21,-10,22,-12,-26,-20,-25,1,21,1,-30,-1,-20,28,8,1,-10,-7,-6,24,-19,12,-27,-20,-7,13,-11,-16,-4,25,26,24,-4,27,-20,25,-7,-6,-3,-20,-23,16,1,13,17,16,-18,-2,-25,1,18,23,13,-10,7,29,29,11,-3,-12,8,2,7,-24,7,-12,15,-29,7,19,-20,-28,-15,-29,-13,-12,29,28,-10,-23,-11,7,-30,5,-15,-21,23,17,-5,0,-22,-17,13,-25,-10,-25,-30,0,0,-14,14,-8,-10,9,-27,-17,20,12,-8,-26,22,7,9,-9,-7,14,-15,-15,-3,17,-25,16,-29,18,-1,-22,-19,-13,-12,16,-29,-11,4,4,-7,-28,-14,-5,7,26,22,-4,8,2,14,-9,20,25,-23,21,-7,-29,-30,-11,-23,-4,2,28,7,-25,-15,-10,-29,-11,-1,1,28,7,24,15,-11,-23,11,-13,19,-25,1,9,-13,-18,-16,3,-25,-20,19,17,4,-14,-15,-27,-12,-25,-10,16,2,21,-4,-3,15,19,5,-8,-6,23,11,-17,-5,22,-11,-4,-3,10,4,-13,28,1,-26,-9,-28,3,-6,-27,24,10,-6,6,5,-10,-21,17,-10,29,20,28,-19,29,-18,23,-23,-24,-10,-27,12,5,23,16,-29,-20,-20,-5,-12,20,-4,-5,-12,-6,6,6,-5,-9,-24,-15,-23,-9,18,17,-5,-23,27,29,3,-17,29,23,-27,10,-17,3,28,-9,-8,26,9,-27,2,17,-30,-30,-7,-10,-26,-27,-1,-8,-19,-21,1,-1,-16,3,-20,7,27,-24,-23,-18,-29,-22,-22,20,-13,20,7,3,-2,-11,18,9,-4,-18,-17,17,7,-8,23,-13,-24,-29,-12,0,-25,26,-21,-18,-8,-20,-13,-22,-4,0,-11,3,16,-7,-24,18,-24,0,18,-25,29,-26,25,4,25,7,2,-21,20,9,12,18,-3,3,-15,6,29,-3,10,-1,12,-27,28,-25,23,24,12,-8,-29,-9,-1,-27,-15,-6,10,13,25,-14,-5,-23,-8,3,28,-12,-27,17,-18,14,9,-19,26,22,13,-4,-25,22,-19,-17,5,28,18,25,-19,-11,12,2,27,-22,-21,26,13,8,-28,7,-23,-1,5,-11,-14,19,-15,-18,8,-22,-23,-14,-10,-14,-28,-12,10,26,22,15,-24,-4,-22,-6,11,11,10,-1,1,19,-4,-12,-18,1,-18,22,-11,25,-14,-18,-9,-24,1,-18,29,-17,-2,9,21,-30,-17,-27,-4,18,7,14,-1,14,-21,-8,-20,21,28,29,-16,12,23,17,11,-20,13,-17,8,-2,24,17,28,-9,2,-11,10,-15,-11,14,-27,15,-8,-26,-23,-11,10,-27,24,3,-11,12,5,0,-22,-15,-8,8,-24,19,10,26,-13,-10,27,25,24,20,13,10,11,11,27,26,24,-14,24,7,-2,-8,18,17,18,8,24,27,-12,-25,-4,-20,25,20,21,20,18,-26,-11,8,-8,-7,27,-3,-23,-25,-23,25,-9,22,13,-19,-28,26,14,18,6,-15,-6,23,21,23,-10,-7,-25,0,-18,-30,-20,13,-8,-27,-9,-18,23,14,-23,-29,-7,-26,25,-6,-18,5,28,1,-8,8,19,-22,5,-13,0,28,-8,-13,10,-22,-4,6,-14,9,26,-13,-17,-30,-14,-2,-3,2,-23,-30,18,10,-21,13,-19,13,8,-3,-23,21,-7,-9,-18,-18,-4,14,11,21,-20,11,27,-19,0,0,-14,-19,-21,24,21,21,-17,4,-5,19,-21,0,0,25,13,-10,-22,1,9,-4,-10,-22,-20,-11,8,-17,25,-15,9,15,14,22,-17,-25,-25,24,19,23,9,-10,10,27,-26,15,-8,22,-19,-30,-29,-10,-15,5,29,24,6,2,19,-9,-20,21,-22,12,4,-30,-22,-29,9,19,-7,-7,-16,-22,-19,-9,-11,25,-17,8,-25,-21,-11,-12,6,14,23,23,-13,27,23,25,28,22,14,3,-2,8,-13,-17,17,8,-13,-22,-20,-7,-5,-8,23,-18,7,-19,14,19,11,-29,23,20,-21,-9,23,-28,-8,-11,25,-24,-26,20,-28,-16,-9,22,-8,-5,-22,7,-27,-2,-24,-16,-24,-2,-24,0,23,-5,17,-21,-28,10,-25,-7,6,11,10,18,-4,-28,26,20,-10,17,-24,-8,25,20,2,27,-9,-29,-24,-12,5,18,-21,11,-29,-1,15,8,-10,-12,16,-7,-16,3,-7,10,0,17,-2,-21,8,13,28,1,-19,20,-1,3,10,26,11,9,-2,-27,-8,2,-24,11,-27,10,-8,22,-7,-6,-12,19,5,12,25,-17,-23,-4,-19,-6,6,-11,23,-2,12,23,18,-8,-18,29,21,11,-17,-18,19,14,16,-7,-1,9,16,5,28,-4,19,4,28,-2,12,-28,23,-12,-18,-15,3,26,-10,-18,14,9,-5,-14,-12,-4,3,-1,24,29,14,-11,-14,20,2,-27,19,-19,-30,-2,9,-13,3,22,-20,-19,8,-25,-2,-3,-15,-4,16,-7,-20,18,11,-27,1,28,19,16,-3,-14,22,11,-30,27,-20,-20,1,2,-26,9,17,-5,10,-21,-12,20,23,-14,8,10,2,27,-24,7,9,25,12,-11,-9,-21,20,-12,-10,22,-15,-22,-7,23,27,20,-15,28,-9,10,-17,-13,-6,-28,3,25,24,-4,-14,20,7,23,18,-19,-10,-21,-26,21,-29,-5,26,22,-1,-5,-8,-9,-19,-8,2,28,-8,16,-4,-19,-5,-13,9,-10,20,17,22,20,29,-20,19,-13,28,22,3,4,2,-12,27,26,-1,-10,-6,-16,20,18,-4,-30,-23,-19,-3,29,-10,25,17,10,-2,-22,-1,-29,-5,28,-21,13,21,25,-19,-2,-11,-11,4,7,-18,-18,-13,-26,-23,-13,27,13,-18,-8,-18,-26,23,3,16,16,-25,-2,-11,-3,8,-11,27,-6,11,5,-18,0,5,-1,5,-21,-16,19,27,-16,26,21,-20,1,-10,1,-21,-10,10,-25,29,-12,2,6,-16,9,-29,-10,26,-17,-21,-19,28,25,28,23,-17,0,-12,-10,26,16,-15,-27,26,11,-25,-15,20,-17,-9,26,29,19,29,9,-28,-24,-30,7,-8,22,-8,-14,-16,-21,-4,-29,-2,-15,-25,-29,-20,-20,-19,-21,-30,-30,-14,12,-16,-22,-22,1,7,-8,9,12,9,14,-16,-25,2,-11,-9,-13,6,8,-28,-24,20,-9,-3,17,-7,-4,10,3,-29,22,22,13,-3,-30,-24,2,12,15,-11,-30,14,-17,-11,-28,7,-4,-4,25,6,21,-4,27,-16,9,13,-16,20,-14,0,18,29,11,25,24,9,9,24,-13,-13,-28,-18,24,-11,-26,10,21,-4,9,19,-29,-24,-6,13,10,7,15,20,-15,15,12,8,-10,5,14,16,6,-26,1,-10,22,-4,0,4,29,20,0,-7,-10,8,18,-1,18,0,26,21,-5,3,13,-14,20,20,-29,-16,28,18,18,-22,3,-14,-25,18,21,12,22,23,26,13,1,16,-25,-29,22,12,-26,14,27,-22,12,4,27,-14,20,21,-21,6,-23,-11,-17,-28,-10,10,10,-16,14,10,-18,-14,-1,-14,-23,2,-16,10,-22,8,10,18,11,-14,-21,12,6,25,22,-4,12,21,-5,29,6,-26,16,14,16,-28,-21,-26,25,14,-30,20,0,3,1,12,16,1,-10,7,-25,-13,-18,-10,-7,2,-27,-2,21,-11,16,-30,2,19,-8,-14,-5,-21,22,1,-15,-26,10,-29,-23,-13,9,-30,-14,-16,-5,7,-30,24,-13,3,-15,7,-18,-5,-4,22,-10,-19,23,0,27,-26,-12,-21,-11,2,28,-1,13,-9,21,-22,-30,19,-16,28,-23,28,-6,-18,1,-23,-27,2,0,11,-5,5,7,1,-19,-15,-20,-10,-13,26,11,-2,14,-23,24,-12,4,-27,-8,-9,-8,-18,-9,-13,-27,7,-17,0,-23,11,20,-22,6,-28,1,19,25,-7,16,10,-16,-9,-17,-24,5,11,-14,-10,14,26,-19,-1,28,-6,5,-24,-8,0,-21,26,-19,-17,-11,0,15,21,-10,22,10,17,-10,29,22,-18,19,29,-17,14,-29,-15,6,-21,-2,26,-9,-13,16,-29,-1,-18,24,-22,29,22,8,0,-8,-1,-15,11,20,-27,7,29,10,7,-26,0,20,-30,12,-7,2,-21,-25,-15,-26,18,16,20,21,12,-15,-19,18,-24,-3,-20,11,-18,-3,-4,-12,-8,-17,24,-8,-9,15,-27,10,-30,-3,25,-20,-6,4,19,19,-2,4,-1,24,-2,8,5,19,-28,-29,26,-15,-6,-28,-28,17,11,-27,28,-24,28,20,-23,7,27,9,-1,-16,-4,13,-7,0,-23,-15,20,-6,24,-24,-10,-3,-21,-18,24,25,7,-27,24,-21,2,25,19,-30,20,-8,-13,10,-7,1,1,8,-14,-22,6,-16,29,-22,-1,16,10,-27,15,-2,4,3,-8,2,14,-9,-25,-26,12,-28,26,-3,26,-9,-1,-13,27,0,4,18,-10,20,18,12,-18,-20,12,9,-7,19,-20,-4,8,-6,11,23,-2,-20,22,-1,-30,-2,-3,18,6,-19,-10,-9,-2,-25,-8,-12,-2,17,-6,-21,10,26,10,7,28,-18,-14,19,-9,-14,-26,17,22,23,-25,21,-12,-22,4,-23,28,-6,-20,9,-26,6,-19,8,-27,22,13,25,15,17,-26,24,-2,14,24,21,1,23,-29,-28,-20,-20,29,-28,9,5,-13,2,29,-2,-24,1,-18,-13,-1,-22,19,4,19,22,5,-15,-19,-11,-3,7,6,-28,13,2,3,3,-5,-1,25,-8,2,2,6,-4,-25,5,10,19,11,-27,22,4,24,-3,5,3,25,-16,29,22,4,-3,29,15,23,27,5,24,-20,-9,2,-18,10,-3,13,24,-20,27,18,4,-19,-6,10,4,-4,26,10,27,19,-27,-17,-17,-12,-24,24,-6,17,21,19,17,5,-2,29,-7,-29,-16,-9,-22,-29,-12,29,7,11,-18,27,-13,-20,12,-17,-6,7,14,19,-17,-21,20,12,26,5,-15,28,-1,16,-5,13,17,2,20,-6,2,20,-4,-29,20,2,-14,-24,9,-5,-3,3,-12,4,-17,17,-29,15,17,8,2,12,-22,-1,-18,-17,-22,18,-1,26,0,8,28,-13,-1,3,-16,-15,-14,-13,-22,-16,7,11,-14,7,25,25,-5,-2,15,5,-10,9,21,-14,1,20,19,-19,10,9,25,3,7,12,-11,-3,18,-26,9,-14,9,-11,20,-6,27,-1,-16,-1,27,10,-10,-18,-25,5,-23,-29,-26,18,-14,-19,6,16,2,-23,12,3,-18,21,-2,6,19,-21,-5,-19,-26,-28,16,-11,11,-9,11,6,-10,11,-21,-4,-9,-24,27,-23,-21,-30,8,-10,-15,23,11,25,3,-24,-8,4,18,24,-8,5,-24,-14,7,-15,7,12,-26,-6,16,1,-11,-7,-21,-5,13,26,-9,5,-14,17,-30,21,24,5,-6,-6,5,22,-21,14,4,-29,25,-9,6,15,7,0,-23,15,-18,-9,-14,29,0,-27,15,-21,-16,18,10,6,10,-21,6,19,-12,14,12,9,28,25,-13,-19,-17,-24,-24,10,8,13,-12,27,-7,-3,27,-8,10,18,19,-10,-21,-17,-28,24,-12,1,-22,-21,6,-24,17,-23,21,-7,-8,-19,29,0,-30,-25,9,-12};
        long start1 = System.currentTimeMillis();
        System.out.println(s.countRangeSum(nums, 12, 18));
        System.out.println(System.currentTimeMillis()-start1);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];

        // preSum[i] means sum of former i numbers
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }


        Set<Long> allNumbers = new TreeSet<Long>();
        for (long x : preSum) {
            allNumbers.add(x);
            allNumbers.add(x - lower);
            allNumbers.add(x - upper);
        }

        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        SegNode root = build(0, values.size() - 1);
        int ret = 0;
        for (long x : preSum) {
            int left = values.get(x - upper), right = values.get(x - lower);
            ret += count(root, left, right);
            insert(root, values.get(x));
        }
        return ret;
    }

    public SegNode build(int left, int right) {
        SegNode node = new SegNode(left, right);
        if (left == right) {
            return node;
        }
        int mid = (left + right) / 2;
        node.lchild = build(left, mid);
        node.rchild = build(mid + 1, right);
        return node;
    }

    public int count(SegNode root, int left, int right) {
        if (left > root.hi || right < root.lo) {
            return 0;
        }
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }

    public void insert(SegNode root, int val) {
        root.add++;
        if (root.lo == root.hi) {
            return;
        }
        int mid = (root.lo + root.hi) / 2;
        if (val <= mid) {
            insert(root.lchild, val);
        } else {
            insert(root.rchild, val);
        }
    }
}

class SegNode {
    int lo, hi, add;
    SegNode lchild, rchild;

    public SegNode(int left, int right) {
        lo = left;
        hi = right;
        add = 0;
        lchild = null;
        rchild = null;
    }
}

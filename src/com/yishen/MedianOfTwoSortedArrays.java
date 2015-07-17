package com.yishen;

/**
 * Created by yishen on 15/7/11.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Error: not best solution
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findKth(new int[]{1, 2},
                new int[]{1, 2}, 2));
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}
                , new int[]{1, 2}));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2 == null || nums2.length == 0) {
                return 0;
            } else {
                return nums2.length % 2 == 0 ? ((nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0) : (nums2[nums2.length / 2]);
            }
        } else {
            if (nums2 == null || nums2.length == 0) {
                return nums1.length % 2 == 0 ? ((nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0) : (nums1[nums1.length / 2]);
            }
        }

        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, nums2, total / 2 + 1);
        }
    }

    public int findKth(int[] nums1, int[] nums2, int k) {
        int p1 = 0;
        int p2 = 0;
        System.out.println("p1: " + p1 + "p2: " + p2 + "k: " + k);
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                if (k == 1) {
                    return nums2[p2];
                }
                p2++;
            } else {
                if (k == 1) {
                    return nums1[p1];
                }
                p1++;
            }
            k--;
        }

        if (p1 < nums1.length) {
            return nums1[p1 + k - 1];
        }

        if (p2 < nums2.length) {
            return nums2[p2 + k - 1];
        }

        return 0;
    }
}

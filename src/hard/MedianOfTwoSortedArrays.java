package hard;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[] {2}));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int indexMergedArray = 0;

        int indexNums1 = 0;
        int indexNums2 = 0;
        while (indexNums1 < nums1.length || indexNums2 < nums2.length) {
            if (indexNums1 < nums1.length) {
                if (indexNums2 < nums2.length) {
                    if (nums1[indexNums1] <= nums2[indexNums2]) {
                        mergedArray[indexMergedArray] = nums1[indexNums1];
                        indexNums1++;
                    } else {
                        mergedArray[indexMergedArray] = nums2[indexNums2];
                        indexNums2++;
                    }
                } else {
                    mergedArray[indexMergedArray] = nums1[indexNums1];
                    indexNums1++;
                }
                indexMergedArray++;
            }
            if (indexNums2 < nums2.length) {
                if (indexNums1 < nums1.length) {
                    if (nums1[indexNums1] <= nums2[indexNums2]) {
                        mergedArray[indexMergedArray] = nums1[indexNums1];
                        indexNums1++;
                    } else {
                        mergedArray[indexMergedArray] = nums2[indexNums2];
                        indexNums2++;
                    }
                } else {
                    mergedArray[indexMergedArray] = nums2[indexNums2];
                    indexNums2++;
                }
                indexMergedArray++;
            }
        }

        if (mergedArray.length % 2 == 0) {
            return (double) (mergedArray[mergedArray.length / 2 - 1] + mergedArray[mergedArray.length / 2]) / 2;
        } else {
            return mergedArray[mergedArray.length / 2];
        }
    }
}

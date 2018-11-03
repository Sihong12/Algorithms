package utils;

import java.util.Arrays;

/**
 * 이진 탐색 비교
 *
 * lower bound : 주어진 target에 대한 index을 반환
 * upper bound : 주어진 target의 다음 index를 반환
 *                - 중복되는 값이 존재할 경우 가장 마지막 중복되는 값의 다음 index를 반환
 *                 ex) 1, 2, 3, 4, 5, 5, 5, 6, 7, 9
 *                     -> 5를 찾으면 마지막 5 다음 6의 index 7 반환
 */

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 3, 3, 5, 8};
        int[] arr = {1, 2, 3, 4, 5, 5, 5, 6, 7, 9};

        int target = 8;
        System.out.println("lower " + lowerBound(arr, 0, arr.length, target));
        System.out.println("upper " + upperBound(arr, 0, arr.length, target));
        System.out.println("binary " + Arrays.binarySearch(arr, 0, arr.length, target));
    }

    public static int lowerBound(int[] arr, int start, int end, int target) {
        while(start < end) {
            int mid = (start + end) / 2;

            int midVal = arr[mid];

            if(midVal < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static int upperBound(int[] arr, int start, int end, int target) {
        while(start < end) {
            int mid = (start + end) / 2;

            int midVal = arr[mid];

            if(midVal <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

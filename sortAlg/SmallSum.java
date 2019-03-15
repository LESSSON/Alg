package sortAlg;

import java.util.Objects;

public class SmallSum {
    public static void main(String[] args) {
        int[] arr = DuiShuQi.generateArrayRandom(10, 10);
        int[] otherarr = arr;
        // for(int i = 0;i<arr.length;i++){
        // System.out.print(arr[i] + " ");
        // }
        DuiShuQi.printArray(arr);
        System.out.println();

        int rightSum = rightMerge(otherarr);
        int nowSum = smallSum(arr);
        System.out.println(rightSum);
        System.out.println(nowSum);
    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort2(arr, 0, arr.length - 1);
    }

    private static int mergeSort2(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return mergeSort2(arr, L, mid) + mergeSort2(arr, mid + 1, R) + merge2(arr, L, mid, R);
    }

    private static int merge2(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }

    private static int rightMerge(int[] arr) {
        int res = 0;
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < j; i++) {
                res += arr[i] < arr[j] ? arr[i] : 0;
            }
        }
        return res;
    }
}
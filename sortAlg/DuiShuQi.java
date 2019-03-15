package sortAlg;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DuiShuQi {
    public static void main(String[] args) {

    }

    public static void duishuQi(Method f) {
        int testTime = 500;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateArrayRandom(size, value);
            int[] arr2 = copyArray(arr1);
            try{
                f.invoke(null, arr1);
            } catch (Exception e){
                e.printStackTrace();
            }

            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        if (succeed == false) {
            System.out.println("Oh No!");
            int[] arr = generateArrayRandom(size, value);
            System.out.println("Init:");
            printArray(arr);
            System.out.println("Now:");
            try{
                f.invoke(null, arr);
            } catch (Exception e){
                e.printStackTrace();
            }
            printArray(arr);
            System.out.println("Right:");
            Arrays.sort(arr);
            printArray(arr);
        } else {
            System.out.println("Nice!");
        }
    }

    public static int[] generateArrayRandom(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = (int) ((value + 1) * Math.random()) - (int) ((value) *
             Math.random());
//            arr[i] = (int) ((value) * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr1) {
        if (arr1 == null) {
            return null;
        }
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }


}

package sortAlg;


public class Solution {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int i = 0, j = array.length - 1;
        int mid = i;
        while (array[i] >= array[j]) {
            if(j - i == 1) {
                mid = j;
                break;
            }
            mid = (i + j) /2;

            if(array[i] == array[mid] && array[mid] == array[j]){

                return GetMin(array,i,j);
            }
            if (array[mid] >= array[i]) {
                i = mid;
            }else if (array[mid] <= array[j]) {
                j = mid;
            }
        }
        return array[mid];
    }

    public static int GetMin(int[] arr,int index1, int index2){
        int re = arr[index1];
        for(int i = index1 + 1; i <= index2; ++i){
            if(re > arr[i]){
                re = arr[i];
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        int rs = minNumberInRotateArray(arr);
        System.out.println(rs);
    }
}
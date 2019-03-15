package sortAlg;

public class ErFen {
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            int[] arr = DuiShuQi.generateArrayRandom(100, 100);
//            DuiShuQi.(arr);
            if (erFen(arr, 15) != -1) {
                System.out.println(erFen(arr, 15));
            }

        }

    }

    public static int erFen(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }

        int L = 0, R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return -1;
    }

}

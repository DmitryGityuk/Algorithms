package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 3, 5, 7, 11, 15, 18};
        System.out.println(binarySearch(arr, 5));
    }

    public static int binarySearch(int[] arr, int requiredElement) {
        int l = 0;
        int r = arr.length - 1;
        for (; l <= r; ) {
            int m = l + (r - l) / 2;
            int element = arr[m];
            if (requiredElement == element) {
                return m;
            }
            if (element < requiredElement) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
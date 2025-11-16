import java.util.Arrays;

public class QuickSort {

    // In-place quicksort
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        int[][] testCases = new int[][] {
            {3, 6, 8, 10, 1, 2, 1},
            {5, 2, 9, 1, 7, 6, 3},
            {},
            {1},
            {2, 1},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int[] copy = Arrays.copyOf(arr, arr.length);
            quickSort(arr);
            Arrays.sort(copy);
            System.out.println("Test " + (i+1) + ": " + Arrays.toString(copy) + " -> " + Arrays.toString(arr));
            if (!arraysEqual(arr, copy)) {
                throw new AssertionError("Test " + (i+1) + " failed!");
            }
        }

        System.out.println("\nAll tests passed!");
    }
}

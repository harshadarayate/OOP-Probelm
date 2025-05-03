import java.util.Arrays;

public class ArrayOperations {

    // 1. Find the largest and smallest elements in an array
    public static void findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("Smallest element: " + min);
        System.out.println("Largest element: " + max);
    }

    // 2. Reverse an array in place
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    // 3. Merge two arrays and return a single sorted array
    public static int[] mergeAndSortArrays(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];

        // Copy elements from both arrays
        System.arraycopy(a, 0, merged, 0, a.length);
        System.arraycopy(b, 0, merged, a.length, b.length);

        // Sort the merged array
        Arrays.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        // Sample arrays
        int[] arr = {23, 5, 12, 7, 34, 1, 9};
        int[] arr1 = {3, 8, 15};
        int[] arr2 = {4, 11, 2};

        System.out.println("Original array: " + Arrays.toString(arr));
        
        // 1. Find min and max
        findMinMax(arr);

        // 2. Reverse array
        reverseArray(arr);
        System.out.println("Reversed array: " + Arrays.toString(arr));

        // 3. Merge and sort arrays
        int[] mergedSorted = mergeAndSortArrays(arr1, arr2);
        System.out.println("Merged and sorted array: " + Arrays.toString(mergedSorted));
    }
}


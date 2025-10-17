// ==============================
// Task 3: Sorting & Searching
// ==============================

import java.util.Arrays;
import java.util.Random;

public class Task3 {

    // ---------- Sorting ----------
    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Merge Sort
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1, n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i=0;i<n1;i++) L[i]=arr[l+i];
        for (int j=0;j<n2;j++) R[j]=arr[m+1+j];

        int i=0,j=0,k=l;
        while (i<n1 && j<n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i<n1) arr[k++] = L[i++];
        while (j<n2) arr[k++] = R[j++];
    }

    // Quick Sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp=arr[i]; arr[i]=arr[j]; arr[j]=temp;
            }
        }
        int temp=arr[i+1]; arr[i+1]=arr[high]; arr[high]=temp;
        return i+1;
    }

    // ---------- Searching ----------
    // Linear Search
    static int linearSearch(int[] arr, int x) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==x) return i;
        }
        return -1;
    }

    // Binary Search (array must be sorted)
    static int binarySearch(int[] arr, int x) {
        int l=0, r=arr.length-1;
        while (l<=r) {
            int mid=(l+r)/2;
            if (arr[mid]==x) return mid;
            if (arr[mid]<x) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        // ---- Sorting small array ----
        System.out.println("Original Array: " + Arrays.toString(arr));

        int[] a1 = arr.clone();
        bubbleSort(a1);
        System.out.println("Bubble Sort: " + Arrays.toString(a1));

        int[] a2 = arr.clone();
        mergeSort(a2, 0, a2.length-1);
        System.out.println("Merge Sort: " + Arrays.toString(a2));

        int[] a3 = arr.clone();
        quickSort(a3, 0, a3.length-1);
        System.out.println("Quick Sort: " + Arrays.toString(a3));

        // ---- Searching ----
        int target = 22;
        System.out.println("\nLinear Search for " + target + ": index = " + linearSearch(a1, target));
        System.out.println("Binary Search for " + target + ": index = " + binarySearch(a1, target));

        // ---- Execution time test ----
        int n = 100000; // large dataset
        int[] bigArr = new int[n];
        Random rand = new Random();
        for (int i=0; i<n; i++) bigArr[i] = rand.nextInt(n);

        int[] b1 = bigArr.clone();
        long start = System.currentTimeMillis();
        bubbleSort(b1);
        long end = System.currentTimeMillis();
        System.out.println("\nBubble Sort (n=" + n + ") Time: " + (end-start) + " ms");

        int[] b2 = bigArr.clone();
        start = System.currentTimeMillis();
        mergeSort(b2, 0, b2.length-1);
        end = System.currentTimeMillis();
        System.out.println("Merge Sort (n=" + n + ") Time: " + (end-start) + " ms");

        int[] b3 = bigArr.clone();
        start = System.currentTimeMillis();
        quickSort(b3, 0, b3.length-1);
        end = System.currentTimeMillis();
        System.out.println("Quick Sort (n=" + n + ") Time: " + (end-start) + " ms");

        // ---- Complexity Notes ----
        System.out.println("\n--- Time Complexities ---");
        System.out.println("Bubble Sort: O(n^2)");
        System.out.println("Merge Sort: O(n log n)");
        System.out.println("Quick Sort: O(n log n) avg, O(n^2) worst");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
    }
}

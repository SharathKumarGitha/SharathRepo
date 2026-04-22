package com.practice;

public class MergeSortFromBoard {

    public static void main(String[] args) {
        int[] a = {5, 24, 8, 1, 3, 16, 10, 20};
        int n = a.length;

        mergeSort(a, 0, n - 1);

        System.out.println("Sorted Array:");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    // Recursive divide function
    public static void mergeSort(int[] a, int lb, int ub) {
        if (lb < ub) {
            int mid = (lb + ub) / 2;

            mergeSort(a, lb, mid);
            mergeSort(a, mid + 1, ub);

            merge(a, lb, mid, ub);
        }
    }

    // Merge function (same as board logic)
    public static void merge(int[] a, int lb, int mid, int ub) {

        int[] b = new int[a.length]; // temp array

        int i = lb;
        int j = mid + 1;
        int k = lb;

        // Merge two sorted halves
        while (i <= mid && j <= ub) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left half
        if (i > mid) {
            while (j <= ub) {
                b[k] = a[j];
                j++;
                k++;
            }
        } else {
            // Copy remaining elements of right half
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }

        // Copy back to original array
        for (k = lb; k <= ub; k++) {
            a[k] = b[k];
        }
    }
}

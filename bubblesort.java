/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program prints an unsorted array, sorts it, and then prints the sorted array.
*/
public class bubblesort {

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    array = swapTwoArrayElements(array, i);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    public static int[] swapTwoArrayElements(int[] arrayToSwap, int lowerIndex) {
        int temp;
        temp = arrayToSwap[lowerIndex];
        arrayToSwap[lowerIndex] = arrayToSwap[lowerIndex + 1];
        arrayToSwap[lowerIndex + 1] = temp;
        return arrayToSwap;
    }

    public static void main(String[] args) {
        int[] array={1,3,4,5,1,23,57,126,4,543,345,23,12,45,67,97};

        System.out.print("Unsorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        bubbleSort(array);

        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

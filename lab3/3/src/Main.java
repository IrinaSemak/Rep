public class Main {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr1 = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] arr2 = {34, 8, 50, 121, 7, 90, 21, 5};

        radixSort.addArray(arr1);
        radixSort.addArray(arr2);

        for (int[] arr : radixSort.getAllArrays()) {
            RadixSort.radixSort(arr);
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

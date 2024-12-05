import java.util.List;

public class RadixSort {
    private Repository<int[]> repository;

    public RadixSort() {
        repository = new Repository<>();
    }

    public void addArray(int[] arr) {
        repository.add(arr);
    }

    public void removeArray(int[] arr) {
        repository.remove(arr);
    }

    public void updateArray(int index, int[] arr) {
        repository.update(index, arr);
    }

    public List<int[]> getAllArrays() {
        return repository.getAll();
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr1 = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] arr2 = {34, 8, 50, 121, 7, 90, 21, 5};

        radixSort.addArray(arr1);
        radixSort.addArray(arr2);

        for (int[] arr : radixSort.getAllArrays()) {
            radixSort(arr);
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}


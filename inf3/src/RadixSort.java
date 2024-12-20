import java.util.List;

public class RadixSort {
    private Repository<int[]> repository;

    public RadixSort() {
        repository = new Repository<>();
    }

    public void addArray(int[] arr) {
        repository.add(arr);
    }

    public void removeArrayByIndex(int index) {
        List<int[]> arrays = repository.getAll();
        if (index >= 0 && index < arrays.size()) {
            repository.remove(arrays.get(index));
        }
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
}

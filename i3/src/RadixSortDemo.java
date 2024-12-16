import java.util.Scanner;

public class RadixSortDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Введите элементы:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        RadixSort.radixSort(arr);

        System.out.println("Отсортированный массив:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

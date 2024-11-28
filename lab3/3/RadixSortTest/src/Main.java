import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class RadixSortTest {

    @Test
    public void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        RadixSort.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRadixSortWithNegatives() {
        int[] arr = {-170, -45, -75, -90, -802, -24, -2, -66};
        int[] expected = {-802, -170, -90, -75, -66, -45, -24, -2};
        RadixSort.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRadixSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        RadixSort.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRadixSortWithSingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        RadixSort.radixSort(arr);
        assertArrayEquals(expected, arr);
    }
}
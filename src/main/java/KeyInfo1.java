import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class New {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 4, 9, 10};
        int[] arr2 = {2, 1, 3, 4};
        System.out.println(Arrays.toString(arrayDiff(arr1, arr2)));

        System.out.println("Arrays.toString(removeNumFromArray(arr1, arr2)) = " + Arrays.toString(removeNumFromArray(arr1, arr2)));


    }

    static int[] arrayDiff(int[] a, int[] b) {
        int offset = 0;

        for (int i = 0; i < a.length-1; i++) {
            if (!containsNum(b, a[i])) {
                System.arraycopy(a, 0, a, 0, i + 1);

            }else {
                System.arraycopy(a, i+1, a, i, a.length-i-1);
                a[a.length-1] = -1;
                i--;
                offset++;
            }
        }
        int arrLength = a.length-offset;
        int[] c = new int[arrLength];
        System.arraycopy(a, 0, c, 0, arrLength);
        return c;
    }

    static boolean containsNum(int[] numbers, int num) {
        for (int a : numbers) {
            if (num == a) {
                return true;
            }
        }
        return false;
    }

    static int[] removeNumFromArray(int[] a, int[] b){
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }
}

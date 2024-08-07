import java.util.ArrayList;
import java.util.List;

public class Q216CombinationSum {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<Integer> l1 = new ArrayList<>();
        List<List<Integer>> L1 = new ArrayList<>();
        f(0, arr, k, n, l1, L1);
        return L1;
    }

    public static void f(int i, int arr[], int k, int tar, List<Integer> l1, List<List<Integer>> L1) {
        if ((l1.size() == k) && (tar == 0)) {
            L1.add(new ArrayList<>(l1));
            return;
        }
        if (i >= arr.length)
            return;
        if (arr[i] > tar)
            return;
        if (l1.size() > k)
            return;

        l1.add(arr[i]);
        f(i + 1, arr, k, tar - arr[i], l1, L1);
        l1.remove(l1.size() - 1);
        f(i + 1, arr, k, tar, l1, L1);
    }

    public static void main(String[] args) {

        Q216CombinationSum obj = new Q216CombinationSum();

        @SuppressWarnings("unused")
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int k = 3;

        int n = 7;

        List<List<Integer>> L1 = obj.combinationSum3(k, n);

        for (int i = 0; i < L1.size(); i++) {
            for (int j = 0; j < L1.get(i).size(); j++) {
                System.out.print(L1.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}

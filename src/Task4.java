public class Task4 {
    static void main() {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        task(arr);
    }

    static void task(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) return;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(arr[j][i] + " ");
            }
            for (int j = i+1; j < n; j++) {
                System.out.print(arr[n-i-1][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

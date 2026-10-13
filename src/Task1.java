public class Task1 {
    static void main() {
        task(new int[] {1,2,3,4,5});
        task(new int[] {1,2,3,4});
    }

    static void task(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < arr.length / 2; i++) {
            System.out.print(arr[i] + " " + arr[len-i-1] + " ");
        }
        if (len % 2 == 1) {
            System.out.print(arr[len/2] + "\n");
        }
    }
}

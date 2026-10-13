public class Task2 {
    static void main() {
        task(new int[] {1,2,3,1,2,1,5});
        task(new int[] {2,1,1,2,3,4,1,2,1,2});
    }
    static void task(int[] arr) {
        int cnt = 0;

        boolean inPlace = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1] && !inPlace) {
                cnt++;
                inPlace = true;
            } else if (arr[i] <= arr[i-1]) {
                inPlace = false;
            }
        }
        System.out.println(cnt);
    }
}

import java.util.Arrays;

public class Task3 {
    static void main() {
        task(new int[] {1,2,2,1,3,4});
    }

    public static void task(int[] arr) {
        int curSum = 0;
        float[] b = new float[arr.length];

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            b[i] = curSum / (float) (i+1);
        }

        System.out.println(Arrays.toString(b));
    }
}

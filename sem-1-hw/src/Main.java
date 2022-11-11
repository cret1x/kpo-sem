import java.util.Arrays;

public class Main {

    private static int getRandomInt(int low, int up) {
        int val = (int) (Math.random() * up);
        return (val + low) % up;
    }

    private static int getMaxInt(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int getMinInt(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int getAvgInt(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum / arr.length;
    }


    public static void main(String[] args) {
        System.out.println("----- TASk 2 -----");
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomInt(1,100);
        }
        System.out.print("Array: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Max: " + getMaxInt(array));
        System.out.println("Min: " + getMinInt(array));
        System.out.println("Avg: " + getAvgInt(array));


        System.out.println("----- TASk 3 -----");
        int n = 100;
        int[] primes = new int[n + 1];
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 1)
                if (i * i <= n)
                    for (int j = i * i; j <= n; j += i)
                        primes[j] = 0;
        }
        System.out.print("Primes [2;100]: ");
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 1)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        boolean sorted = true;
        for (int j = 1; j < n; j++) {
            if (array[j] < array[j - 1]) {
                sorted = false;
            }
        }
        System.out.println(sorted);
    }
}
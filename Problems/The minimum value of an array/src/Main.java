import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] numbers = new int [n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int minimum = numbers[0];
        for (int j = 1; j < n; j++) {
            if (numbers[j] < minimum) {
                minimum = numbers[j];
            }
        }

        System.out.println(minimum);
    }
}
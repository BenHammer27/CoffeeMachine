import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = scanner.nextInt();
        int number = scanner.nextInt();

        while (number != 0) {
            if (number > max) {
                max = number;
            }
            number = scanner.nextInt();
        }

        System.out.println(max);
    }
}
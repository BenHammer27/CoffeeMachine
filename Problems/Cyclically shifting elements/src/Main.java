import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int memory = array[length - 1];
        for (int j = length - 1; j > 0; j--) {
            array[j] = array[j - 1];
        }
        array[0] = memory;

        for (int k = 0; k < length; k++) {
            System.out.print(array[k] + " " );
        }
    }
}
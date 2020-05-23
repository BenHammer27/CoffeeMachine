import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int companies = scanner.nextInt();
        int[] incomes = new int[companies];
        int[] taxes = new int[companies];

        for (int i = 0; i < companies; i++) {
            incomes[i] = scanner.nextInt();
        }
        for (int j = 0; j < companies; j++) {
            taxes[j] = scanner.nextInt();
        }

        int[] payedTaxes = new int[companies];
        for (int k = 0; k < companies; k++) {
            payedTaxes[k] = incomes[k] * taxes[k];
        }

        int max = 0;

        for (int l = 1; l < companies; l++) {
            if (payedTaxes[l] > payedTaxes[l - 1]) {
                max = l;
            }
        }
        System.out.println(max + 1);
    }
}
import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().printMenu();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double payUnRound = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(payUnRound, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double base, int exponent) {
        double scale = Math.pow(10, exponent);
        return Math.round(base * scale) / scale;
    }

    void printMenu() {
        int period;
        int action;
        int amount;
        double pay = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            pay = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            pay = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + pay);
    }
}
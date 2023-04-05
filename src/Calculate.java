import java.util.Scanner;

class DepositCalculator {
    public static void main(String[] args) {
       menu();
    }

    static void menu() {
        int amount;
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях: ");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах: ");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией: ");
        action = scanner.nextInt();

        double out;//Все переменные можно в начале метода объявить

        out = 0;//Сразу можно, чтобы не загромождать код написать: double out = 0;
        if (action == 1) {
            out = simplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = complexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    static double complexPercent(double a, double y, int d) {//в следующем методе, ниже, вроде те же переменные, можно так же назвать переменные и тут
        // информативнее будет
        double pay;

        pay = a * Math.pow((1 + y / 12), 12 * d);
        return rnd(pay, 2);
    }

    static double simplePercent(double amount, double yearRate, int depositPeriod) {
        return rnd(amount + amount * yearRate * depositPeriod, 2);
    }

    static double rnd(double value, int places) {// в практикуме просили переназвать метод, можно round назвать, тут округление происходит.
        double scaLe;
        
        scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }
}

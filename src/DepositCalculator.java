import java.util.Scanner;
public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double income = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return findIncome(income, 2);
    }

    double calculateSimplePercent(double amount,
                                  double yearRate,
                                  int depositPeriod) {
        return findIncome(amount + amount * yearRate * depositPeriod, 2);
    }

    double findIncome(double income, int places) {
        double scale = Math.pow(10, places);
        return Math.round(income * scale) / scale;
    }

    void displaysUserInterface() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, "
                + "2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

public static void main(String[] args) {
        new DepositCalculator().displaysUserInterface();
    }
}

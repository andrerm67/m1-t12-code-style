import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundDecimalPlace(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) { //в названии метода осталась русская "с"
        return roundDecimalPlace(amount + amount * yearRate * period, 2);
    }

    double roundDecimalPlace (double value, int places) {
        double scale = Math.pow(10, places); // в scaLe - осталась большая буква "L" в середине слова
        /*после переименования переменной, нужно изменить её и в вызовах
         + ещё заметила: знак умножения "*" тоже надо пробелами выделить */
        return Math.round(value * scale) / scale;
    }

    void resultDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double outputVariable = 0;

        if (action == 1){
            outputVariable = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outputVariable = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outputVariable);
    }

    public static void main(String[] args) {
        new DepositCalculator().resultDeposit();
    }
}
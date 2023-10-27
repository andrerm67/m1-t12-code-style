import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) { //лишний пробел перед закрывающей скобкой + 
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period); //лишняя пустая сторока после вычислений + 
        return roundDecimalPlace(pay, 2);
    }

    double сalculateSimplePercent(double amount, double yearRate, int period) {
        return roundDecimalPlace(amount + amount * yearRate * period, 2);
    }
    //название метода лучше более детализировать (например roundDecimalPlace - округление десятичных знаков),
    // с текущим названием метода может выйти путаница со стандартным математическим методом округления + 
    double roundDecimalPlace (double value, int places) {
        /*название переменных должно быть в формате lowerCamelCase -
        в ScaLe - намешаны прописные и строчные буквы, а должны быть все маленькие +*/ 
        double scaLe = Math.pow(10, places); // здесь тоже лишняя пустая строка после вычисления +
        return Math.round(value*ScaLe) / ScaLe;
    }

    void resultDeposit() {
        Scanner scanner = new Scanner(System.in); //тут пустая строка после объявления переменных добавлена правильно

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double outputVariable = 0;

        /*сalculateSimplePercent и сalculateComplexPercent - первая буква "с" - русская, лучше исправить на латиницу +*/
        if (action == 1){
            /*знак "=" должен быть выделен пробелами с двух сторон +*/
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

/* не знаю где написать, поэтому напишу здесь. Нужно удалить файл calculate_deposit.java из репозитория,
 тогда появится возможность запустить этот код */

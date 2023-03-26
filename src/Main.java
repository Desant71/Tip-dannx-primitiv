import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int earnings = 0;//перем доходы
        int spendings = 0;//перем расходы
        Scanner scanner = new Scanner(System.in);//созд сканер

        while (true) {//созд цикл
            System.out.println("Выберите операцию и введите её номер:\n" +//выводим
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения");
            int operation = scanner.nextInt();//перем ввода
            String input = scanner.nextLine();//перем ввода
            if ("end".equals(input)) {//если вводим енд
                break;//заканчиваем
            }

            switch (operation) {//цикл
                case 1://условие 1
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStr2 = scanner.nextLine();
                    int money2 = Integer.parseInt(moneyStr2);
                    earnings -= money2;
                    break;
                case 3:
                    System.out.println("Система налогообложения: ");
                    int one = taxEarningsMinusSpendings(earnings, spendings);
                    int two = taxEarnings2(earnings);
                    int bank = earnings - spendings;

                    if (one > two) {
                        System.out.println(bank);
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + two);
                        System.out.println("Налог на другой системе: " + one);
                        System.out.println("Экономия: " + (one - two));
                    } else if (two>one) {
                        System.out.println(bank);
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + one);
                        System.out.println("Налог на другой системе: " + two);
                        System.out.println("Экономия: " + (two - one));
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings2(int earnings) {
        int tax2 = earnings * 6 / 100;
        return tax2;
    }
}



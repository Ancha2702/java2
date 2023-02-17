import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lesson2_2 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Lesson2_2.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("Lesson2_2log.xml");

            logger.addHandler(fileHandler);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите число 1");
            Long number1 = scanner.nextLong();
            logger.info("Первое число:" + number1);

            System.out.println("Введите число 2");
            Long number2 = scanner.nextLong();
            logger.info("Второе число:" + number2);

            System.out.println("Введите операцию: 1- число1 + число2; 2- число1 - число2;3- число1 * число2;4- число1/число2;");
            String operation = scanner.next();

            Long result;
            switch (operation) {
                case "1":
                    result = number1 + number2;
                    break;
                case "2":
                    result = number1 - number2;
                    break;
                case "3":
                    result = number1 * number2;
                    break;
                case "4":
                    result = number1 / number2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверный ввод");
            }

            System.out.println("Результат: " + result);
            logger.info("Результат:" + result);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "возможно, это не число", e);
        }
    }
}
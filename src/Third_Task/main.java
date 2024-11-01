package Third_Task;

import java.security.SecureRandom;
import java.util.Scanner;

public class main {
    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{};:,.<>?";

    private static final int UPPER_PRIORITY = 24;
    private static final int LOWER_PRIORITY = 24;
    private static final int DIGIT_PRIORITY = 20;
    private static final int SPECIAL_PRIORITY = 32;

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите способ генерации пароля:");
        System.out.println("1 - Случайная длина (от 8 до 12 символов)");
        System.out.println("2 - Ввести длину пароля самостоятельно");

        int choice = scanner.nextInt();
        int passwordLength;

        if (choice == 1) {
            passwordLength = random.nextInt(5) + 8; // случайная длина от 8 до 12 символов
        } else {
            System.out.print("Введите желаемую длину пароля (не менее 8 символов): ");
            passwordLength = scanner.nextInt();
            if (passwordLength < 8 || passwordLength > 12 ) {
                System.out.println("Длина пароля не может быть меньше 8 символов или больше 12. Установлена длина 8.");
                passwordLength = 8;

            }
        }

        String password = generatePassword(passwordLength);
        System.out.println("Сгенерированный пароль: " + password);
    }

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);

        // Добавляем один символ каждого типа, чтобы обеспечить требования
        password.append(randomCharacter(UPPER_CASE_LETTERS));
        password.append(randomCharacter(LOWER_CASE_LETTERS));
        password.append(randomCharacter(DIGITS));
        password.append(randomCharacter(SPECIAL_CHARACTERS));

        // Добавляем оставшиеся символы
        for (int i = 4; i < length; i++) {
            password.append(randomCharacter());
        }

        // Перемешиваем символы в пароле для рандомного порядка
        return shuffleString(password.toString());
    }

    private static char randomCharacter() {
        int priorityRange = UPPER_PRIORITY + LOWER_PRIORITY + DIGIT_PRIORITY + SPECIAL_PRIORITY;
        int randomValue = random.nextInt(priorityRange);

        if (randomValue < UPPER_PRIORITY) {
            return UPPER_CASE_LETTERS.charAt(random.nextInt(UPPER_CASE_LETTERS.length()));
        } else if (randomValue < UPPER_PRIORITY + LOWER_PRIORITY) {
            return LOWER_CASE_LETTERS.charAt(random.nextInt(LOWER_CASE_LETTERS.length()));
        } else if (randomValue < UPPER_PRIORITY + LOWER_PRIORITY + DIGIT_PRIORITY) {
            return DIGITS.charAt(random.nextInt(DIGITS.length()));
        } else {
            return SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length()));
        }
    }

    private static char randomCharacter(String characters) {
        return characters.charAt(random.nextInt(characters.length()));
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int j = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}

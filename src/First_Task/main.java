package First_Task;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String[] words = {"яблоко", "банан", "вишня", "апельсин", "виноград",
                "киви", "манго", "ананас", "клубника", "голубика",
                "арбуз", "персик", "абрикос", "кокос", "папайя",
                "малина", "лимон", "лайм", "инжир", "слива",
                "груша", "гранат", "мандарин", "дыня", "драконий фрукт"}; // Список слов для игры
        HangmanGame game = new HangmanGame(words); // Создание экземпляра игры
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру 'Виселица'! Вам дано случайное слово из тематики 'Плоды и фрукты'");

        // Основной игровой цикл
        while (!game.isGameOver()) {
            game.displayCurrentState(); // Показываем текущее состояние слова
            System.out.print("Введите букву: ");
            char letter = scanner.nextLine().charAt(0);
            game.guessLetter(letter); // Проверяем введённую букву
        }

        scanner.close(); // Закрываем сканнер после завершения игры
    }
}

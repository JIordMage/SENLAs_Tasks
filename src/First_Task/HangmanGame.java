package First_Task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class HangmanGame {
    private final String wordToGuess; // Загаданное слово
    private int lives;          // Количество жизней
    private final char[] guessedWord; // Текущее состояние отгаданного слова
    private final HashSet<Character> usedLetters; // Набор использованных букв

    // Конструктор для инициализации игры
    public HangmanGame(String[] words) {
        Random random = new Random();
        this.wordToGuess = words[random.nextInt(words.length)]; // Случайный выбор слова
        int wordLength = wordToGuess.length(); // Для расчета доп жизней
        this.lives = 4; // Начальное количество жизней
        this.lives += (wordLength / 2) + (wordLength / 4); // Доп жизни от длины слова
        this.guessedWord = new char[wordToGuess.length()];
        this.usedLetters = new HashSet<>();

        // Заполняем массив guessedWord символами '_'
        Arrays.fill(guessedWord, '_');
    }

    // Метод для проверки угаданной буквы
    public void guessLetter(char letter) {
        boolean isCorrect = false;

        // Проверка, что введенная буква является русской и единственной
        if (!Character.toString(letter).matches("[а-яА-ЯЁё]")) {
            System.out.println("Ошибка: Пожалуйста, введите одну русскую букву.");
            return; // Завершаем выполнение метода, если буква неверная
        }

        // Проверка, не была ли буква уже использована ранее или это была не букваа
        if (usedLetters.contains(letter)) {
            System.out.println("Эта буква уже была использована!");
            return;
        }

        usedLetters.add(letter); // Добавляем букву в список использованных

        // Проверка, есть ли буква в слове
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedWord[i] = letter;
                isCorrect = true;
            }
        }

        if (!isCorrect) {
            lives--; // Уменьшаем количество жизней, если буква не угадана
            System.out.println("Неверно! Осталось жизней: " + lives);
        }

    }

    // Метод для отображения текущего состояния игры
    public void displayCurrentState() {
        System.out.print("\nСлово: ");
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println("\nЖизни: " + lives);
    }

    // Проверка, завершена ли игра
    public boolean isGameOver() {
        if (lives <= 0) {
            System.out.println("Игра окончена! Вы проиграли. Слово было: " + wordToGuess);
            return true;
        }

        // Проверяем, угадано ли слово полностью
        for (char c : guessedWord) {
            if (c == '_') {
                return false; // Если есть пропуски, игра продолжается
            }
        }

        System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
        return true;
    }
}

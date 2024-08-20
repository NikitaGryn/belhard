import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaTask4 {
    public static void main(String[] args) {
        String text = "Апельсин и яблоко растут на дереве. В доме есть телефон: +375 (29) 123-4567 и еще один 80 1234567, 80 123, +375 (29) 22. Лол";

        System.out.println("Слова, начинающиеся на гласные:");
        findWordsStartingWithVowel(text);

        System.out.println("\nНайденные белорусские номера телефонов:");
        extractBelarusPhoneNumbers(text);

        System.out.println("\nПредложения в порядке возрастания количества символов:");
        sortSentencesByCharacterCount(text);
    }

    public static void findWordsStartingWithVowel(String text) {
        Pattern pattern = Pattern.compile("\\b[АаЕеЁёИиОоУуЫыЭэЮюЯя][\\w]*\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void extractBelarusPhoneNumbers(String text) {
        Pattern pattern = Pattern.compile("\\+375\\s?\\(?\\d{2}\\)?\\s?\\d{3}-?\\d{4}|80\\s?\\d{7}", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void sortSentencesByCharacterCount(String text) {
        String[] sentences = text.split("[.!?]\\s*");

        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-Я\\s]", " ").replaceAll("\\s+", " ").trim();
        }

        Arrays.sort(sentences, Comparator.comparingInt(String::length));

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}

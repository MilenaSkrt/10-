import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException{
        String fileName = ("C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t3.txt");
        List<String> words = readWordsFromFile(fileName);
        List<String> wordsWithDigits = findWordsWithDigits(words);
        System.out.println("Слова, содержащие хотя бы одну цифру:");
        for (String word : wordsWithDigits) {
            System.out.println(word);
        }
    }

    public static List<String> readWordsFromFile(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] lineWords = line.split("\\s+");
            for (String word : lineWords) {
                words.add(word);
            }
        }
        return words;
    }

    public static List<String> findWordsWithDigits(List<String> words) {
        List<String> wordsWithDigits = new ArrayList<>();
        Pattern digitPattern = Pattern.compile("\\d");
        for (String word : words) {
            Matcher matcher = digitPattern.matcher(word);
            if (matcher.find()) {
                wordsWithDigits.add(word);
            }
        }
        return wordsWithDigits;
    }
}

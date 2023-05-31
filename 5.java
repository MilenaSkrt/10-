import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        String fil1 = "C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t5.txt";
        String file2 = "C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t5.1.txt";
        List<String> array1 = read(fil1);
        List<String> array2 = filter(array1);
        appendSentencesToFile(array2, file2);
    }
    public static List<String> read(String fileName) throws IOException {
        List<String> array = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] lineSentences = line.split("(?<=[.!?])\\s*");
            for (String sentence : lineSentences) {
                array.add(sentence);
            }
        }
        return array;
    }

    public static List<String> filter(List<String> sentences) {
        List<String> filteredSentences = new ArrayList<>();
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            for (String word : words) {
                if (isSymmetric(word)) {
                    filteredSentences.add(sentence);
                    break;
                }
            }
        }
        return filteredSentences;
    }

    public static boolean isSymmetric(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void appendSentencesToFile(List<String> sentences, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        for (String sentence : sentences) {
            writer.write(sentence);
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }
}

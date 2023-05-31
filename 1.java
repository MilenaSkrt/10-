import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\1022+report\\files\\t1.txt");
        FileWriter fwr = new FileWriter(file, true);
        BufferedReader br = new BufferedReader(new FileReader(file));
        fwr.write("\n");
        String str = br.readLine();
        char[] array = str.toCharArray();
        int cnt = 0;
        for (char c : array) {
            if (Character.isDigit(c)) {
                cnt++;
            }
        }
        fwr.write("Количество цифр: " + cnt + "\n");
        char s = 'a';
        int cnt1 = 0;
        for (char c : array) {
            if (c == s) {
                cnt1++;
            }
        }
        fwr.write("Символ " + s + " входит " + cnt1 + " раз."+ "\n");
        String num = "4";
        boolean flag = true;
        for (char digit : num.toCharArray()) {
            if (!str.contains(Character.toString(digit))) {
                flag = false;
                break;
            }
        }
        fwr.write("Все цифры из числа " + num + " присутствуют: " + flag+ "\n");
        boolean flag1 = false;
        Stack<Character> brackets = new Stack<>();
        for (char c : array) {
            if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
                if (!brackets.isEmpty() && Pair(brackets.peek(), c)) {
                    brackets.pop();
                } else {
                    brackets.push(c);
                }
            }
        }
        flag1 = brackets.isEmpty();
        fwr.write("Имеются закрытые пары разного сочетания: " + flag1+ "\n");
        String str1 = ".,;:!?";
        boolean flag2 = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (str1.contains(Character.toString(array[i])) && array[i] == array[i + 1]) {
                flag2 = true;
                break;
            }
        }
        fwr.write("Имеются соседствующие одинаковые символы, относящиеся к знакам препинания: " + flag2+ "\n");
        boolean flag3 = false;
        for (int i = 0; i < array.length - 3; i++) {
            if (Character.isDigit(array[i]) && Character.isDigit(array[i + 1]) && Character.isDigit(array[i + 2]) && Character.isDigit(array[i + 3])) {
                if (array[i] < array[i + 1] && array[i + 2] > array[i + 3]) {
                    flag3 = true;
                    break;
                }
            }
        }
        fwr.write("Существуют i и j, что si и si+1 возрастающая последовательность цифр, а sj и sj+1 убывающая последовательность цифр: " + flag3 + "\n");
        fwr.flush();
        fwr.close();
    }
    private static boolean Pair(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}

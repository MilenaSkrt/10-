import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t4.1.txt");
        File file2 = new File("C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t4.2.txt");
        FileWriter fwr = new FileWriter(file2, true);
        BufferedReader fread = new BufferedReader(new FileReader(file1));
        fwr.write("OUT\n");
        while (fread.ready()){
            String line = fread.readLine();
            String[] array = line.split("[_.,;:\\n\\t!?\\s]+");
            for (String str : array) {
                if (check(str)) {
                    fwr.write(str + "\n");
                }
            }
        }
        fwr.flush();
        fwr.close();
    }
    public static boolean check(String word) {
        int cnt = 0;
        int cnt1 = 0;
        String str = "AEIOUaeiou";
        String str1 = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
        for (char c : word.toCharArray()) {
            if (str.indexOf(c) != -1) {
                cnt++;
            } else if (str1.indexOf(c) != -1) {
                cnt1++;
            }
        }
        return cnt == cnt1;
    }
}

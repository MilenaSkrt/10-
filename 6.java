import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        File file = new File("C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t6.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        int cnt = 0;
        String str;
        while ((str = br.readLine()) != null) {
            String[] array = str.split(",");
            double weight = Double.parseDouble(array[2]);
            double price = Double.parseDouble(array[4]);
            if (weight >= 15 && weight <= 25 && price >= 10000 && price <= 50000) {
                cnt++;
            }
        }
        bw.write("\nКоличество товаров с массой от 15 до 25 кг и ценой от 10000 до 50000: " + cnt);
        br.close();
        bw.close();
    }
}

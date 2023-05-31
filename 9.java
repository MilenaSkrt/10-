import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t9.txt");
        FileWriter fwr = new FileWriter(file, true);
        BufferedReader fread = new BufferedReader(new FileReader(file));
        fwr.write("\n\nВЫВОД\n\n");
        int[] poorFamiliesByDistrict = new int[5];
        String [] array = new String[11];
        while (fread.ready()) {
            String str = fread.readLine();
            array = str.split(";");
            String district = array[1];
            String type = array[2];
            int income = Integer.parseInt(array[7]);
            int members = Integer.parseInt(array[3]);
            if (type.equalsIgnoreCase("неполная") && income / members < 10000) {
                switch (district) {
                    case "Центр":
                        poorFamiliesByDistrict[0]++;
                        break;
                    case "Север":
                        poorFamiliesByDistrict[1]++;
                        break;
                    case "Юг":
                        poorFamiliesByDistrict[2]++;
                        break;
                    case "Запад":
                        poorFamiliesByDistrict[3]++;
                        break;
                    case "Восток":
                        poorFamiliesByDistrict[4]++;
                        break;
                }
            }
        }
        fwr.write("Количество неполных семей по районам с доходом на одного члена семьи ниже, чем прожиточный минимум:" + "\n");
        fwr.write("Центр: " + poorFamiliesByDistrict[0]+ "\n");
        fwr.write("Север: " + poorFamiliesByDistrict[1]+ "\n");
        fwr.write("Юг: " + poorFamiliesByDistrict[2]+ "\n");
        fwr.write("Запад: " + poorFamiliesByDistrict[3]+ "\n");
        fwr.write("Восток: " + poorFamiliesByDistrict[4]+ "\n");
        int cnt= 0;
        String type = array[2];
        String hasComputer = array[8];
        if (type.equalsIgnoreCase("неполная") && Objects.equals(hasComputer, "да")) {
            cnt++;
        }
        fwr.write("Количество неполных семей, в которых есть хотя бы один компьютер: " + cnt+ "\n");
        fwr.flush();
        fwr.close();
    }
}

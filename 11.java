import java.io.*;
import java.text.DecimalFormat;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t11.txt");
        FileWriter fwr = new FileWriter(file, true);
        DecimalFormat dec = new DecimalFormat("#.#");
        fwr.write("Формула z = cos(x)+(sin(y))^2+3*x*y,\n" +
                "x: [-4;2]; x+=0.1, y: [-1;6]; y+=0.2\n\n" +
                "\t\t\t\t\t\t\tМатрица значений Z\n\nX/Y\t");
        for (double y = -1; y <= 6; y+=0.2){
            fwr.write(dec.format(y) + "\t");
        }
        fwr.write("\n");
        for (double x = -4; x <= 2; x+=0.1){
            fwr.write(dec.format(x) + "\t");
            for (double y = -1; y <= 6; y+=0.2){
                Double z = cos(x) + pow(sin(x), 2) + 3*x*y;
                fwr.write(dec.format(z) + "\t");
            }
            fwr.write("\n");
        }
        fwr.flush();
        fwr.close();
    }
}

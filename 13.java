import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        String file1Name = "C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t13.1.txt";
        String file2Name = "C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t13.2.txt";
        String file3Name = "C:\\Users\\ivanx\\OneDrive\\Рабочий стол\\t13.3.txt";
        List<int[][]> matrices1 = readFile(file1Name);
        List<int[][]> matrices2 = readFile(file2Name);
        List<int[][]> resultMatrices = multiplyMatrices(matrices1, matrices2);
        writeMatricesToFile(file3Name, resultMatrices);
        System.out.println("Содержимое файла " + file1Name + ":");
        printFileContent(file1Name);
        System.out.println("Содержимое файла " + file2Name + ":");
        printFileContent(file2Name);
        System.out.println("Содержимое файла " + file3Name + ":");
        printFileContent(file3Name);
    }
    private static List<int[][]> readFile(String fileName) throws IOException{
        List<int[][]> matrices = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        int i = 0;
        while (i < lines.size()) {
            String[] dimensions = lines.get(i).split(" ");
            int m = Integer.parseInt(dimensions[0]);
            int n = Integer.parseInt(dimensions[1]);
            int[][] matrix = new int[m][n];
            for (int j = 0; j < m; j++) {
                String[] row = lines.get(i + j + 1).split(" ");
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }
            matrices.add(matrix);
            i += m + 1;
        }
        return matrices;
    }

    private static void writeMatricesToFile(String fileName, List<int[][]> matrices)throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
        for (int[][] matrix : matrices) {
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(Integer.toString(row[i]));
                    if (i < row.length - 1) {
                        writer.write(" ");
                    }
                }
                writer.newLine();
            }
            writer.newLine();
        }
    }

    private static List<int[][]> multiplyMatrices(List<int[][]> matrices1, List<int[][]> matrices2) {
        List<int[][]> resultMatrices = new ArrayList<>();
        for (int i = 0; i < Math.min(matrices1.size(), matrices2.size()); i++) {
            if (i % 2 == 0) {
                int[][] matrix1 = matrices1.get(i);
                int[][] matrix2 = matrices2.get(i);
                int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];
                for (int j = 0; j < matrix1.length; j++) {
                    for (int k = 0; k < matrix2[0].length; k++) {
                        for (int l = 0; l < matrix2.length; l++) {
                            resultMatrix[j][k] += matrix1[j][l] * matrix2[l][k];
                        }
                    }
                }
                resultMatrices.add(resultMatrix);
            }
        }
        return resultMatrices;
    }

    private static void printFileContent(String fileName) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

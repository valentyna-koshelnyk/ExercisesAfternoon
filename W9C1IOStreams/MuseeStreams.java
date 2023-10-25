package W9C1IOStreams;

import java.io.*;

public class MuseeStreams {
public static void upperReplace() {

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("W9C1IOStreams/input.txt"));
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("W9C1IOStreams/output.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                line = line.replaceAll("JAVA", "Python");
                bufferedWriter.write(line.toUpperCase() + "\n");
            }
        } catch(IOException e) {
                System.out.println("");
        }
    }


    public static void main(String[] args) {
        upperReplace();
    }


}

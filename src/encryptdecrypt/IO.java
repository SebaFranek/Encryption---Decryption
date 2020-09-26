package encryptdecrypt;

import static encryptdecrypt.Main.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class IO {                         //   I N P U T   A N D   O U T P U T   M E T H O D S

    static void ReadFromFile(String inputPath) {
        File fromFile = new File(inputPath);
        String text = "";
        try (Scanner scanner = new Scanner(fromFile)) {
            while (scanner.hasNext()) {
                text += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + inputPath);
        }
        setData(text);
    }

    static void WriteToFile(String outputPath, String text) {
        File toFile = new File(outputPath);
        try (FileWriter writer = new FileWriter(toFile)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    static void TerminalMessage(String text) {
        System.out.println(text);
    }
}

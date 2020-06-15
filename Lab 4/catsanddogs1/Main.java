// Java Packages
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    // -----------------------------------------------------------------------------------------
    // Main Program
    static BufferedReader scroll = null;

    public static void main(String[] args) {
        try {
            scroll = new BufferedReader(new FileReader(args[0]));
            while (scroll.ready()) {
                String instruction = scroll.readLine();
                System.out.println(instruction);
            }

            scroll.close();
        }
        catch (FileNotFoundException e) {}
        catch (IOException e) {}
    }
}
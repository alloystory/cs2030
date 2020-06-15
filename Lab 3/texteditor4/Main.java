import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<TextFormatter> availableFormatters = new ArrayList<TextFormatter>();
        availableFormatters.add(new SnakeCaseFormatter());
        availableFormatters.add(new KebabCaseFormatter());
        availableFormatters.add(new PascalCaseFormatter());
        availableFormatters.add(new MixedFormatFormatter());
        TextEditor editor = new TextEditor(availableFormatters);

        while (scanner.hasNextLine()) {
            editor.addString(scanner.nextLine());
        }

        editor.printAll();
    }
}
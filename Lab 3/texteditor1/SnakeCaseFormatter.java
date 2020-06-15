import java.util.*;

public class SnakeCaseFormatter implements TextFormatter {
    private String _formattedString;

    public SnakeCaseFormatter(){};

    public SnakeCaseFormatter(String input) {
        StringBuilder formattedString = new StringBuilder();
        char[] inputCharArr = input.toCharArray();
        for (char currChar : inputCharArr) {
            if (Character.isSpaceChar(currChar)) {
                formattedString.append("_");
            } else {
                formattedString.append(Character.toLowerCase(currChar));
            }
        }
        this._formattedString = formattedString.toString();
    }

    public String format() {
        return _formattedString;
    }

    public TextFormatter addString(String inputStr) {
        return new SnakeCaseFormatter(inputStr);
    }
}
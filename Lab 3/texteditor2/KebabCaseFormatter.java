import java.util.*;

public class KebabCaseFormatter implements TextFormatter {
    private String _formattedString;

    public KebabCaseFormatter(){};

    public KebabCaseFormatter(String input) {
        StringBuilder formattedString = new StringBuilder();
        char[] inputCharArr = input.toCharArray();
        for (char currChar : inputCharArr) {
            if (Character.isSpaceChar(currChar)) {
                formattedString.append("-");
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
        return new KebabCaseFormatter(inputStr);
    }
}
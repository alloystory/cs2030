import java.util.*;

public class PascalCaseFormatter implements TextFormatter {
    private String _formattedString;

    public PascalCaseFormatter(){};

    public PascalCaseFormatter(String input) {
        StringBuilder formattedString = new StringBuilder();
        char[] inputCharArr = input.toCharArray();
        boolean isNewWord = true;
        for (char currChar : inputCharArr) {
            if (Character.isSpaceChar(currChar)) {
                isNewWord = true;
            } else {
                if (isNewWord) {
                    formattedString.append(Character.toUpperCase(currChar));
                    isNewWord = false;
                } else {
                    formattedString.append(Character.toLowerCase(currChar));
                }
            }
        }
        this._formattedString = formattedString.toString();
    }

    public String format() {
        return _formattedString;
    }

    public TextFormatter addString(String inputStr) {
        return new PascalCaseFormatter(inputStr);
    }
}
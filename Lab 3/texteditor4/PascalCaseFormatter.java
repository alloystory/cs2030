import java.util.*;

public class PascalCaseFormatter implements TextFormatter, Comparable<TextFormatter> {
    private String _formattedString;
    private Integer _asciiValue;

    public PascalCaseFormatter(){};

    public PascalCaseFormatter(String input) {
        this._asciiValue = 0;

        StringBuilder formattedString = new StringBuilder();
        char[] inputCharArr = input.toCharArray();
        boolean isNewWord = true;

        for (char currChar : inputCharArr) {
            if (Character.isSpaceChar(currChar)) {
                isNewWord = true;
            } else {
                char bufCharacter;

                if (isNewWord) {
                    bufCharacter = Character.toUpperCase(currChar);
                    formattedString.append(bufCharacter);
                    _asciiValue += (int) bufCharacter;
                    isNewWord = false;
                } else {
                    bufCharacter = Character.toLowerCase(currChar);
                    formattedString.append(bufCharacter);
                    _asciiValue += (int) bufCharacter;
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

    public int getASCIIValue() {
        return _asciiValue;
    }

    @Override
    public int compareTo(TextFormatter other) {
        return _asciiValue.compareTo(other.getASCIIValue());
    }
}
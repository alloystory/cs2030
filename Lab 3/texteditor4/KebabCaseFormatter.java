import java.util.*;

public class KebabCaseFormatter implements TextFormatter, Comparable<TextFormatter> {
    private String _formattedString;
    private Integer _asciiValue;

    public KebabCaseFormatter(){};

    public KebabCaseFormatter(String input) {
        this._asciiValue = 0;

        StringBuilder formattedString = new StringBuilder();
        char[] inputCharArr = input.toCharArray();
        char separator = '-';

        for (char currChar : inputCharArr) {
            if (Character.isSpaceChar(currChar)) {
                formattedString.append(separator);
                _asciiValue += (int) separator;
            } else {
                char bufCharacter = Character.toLowerCase(currChar);
                formattedString.append(bufCharacter);
                _asciiValue += (int) bufCharacter;
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

    public int getASCIIValue() {
        return _asciiValue;
    }

    @Override
    public int compareTo(TextFormatter other) {
        return _asciiValue.compareTo(other.getASCIIValue());
    }
}
import java.util.*;

public class MixedFormatFormatter implements TextFormatter, Comparable<TextFormatter> {
    private String _formattedString;
    private Integer _asciiValue;

    public MixedFormatFormatter(){};

    public MixedFormatFormatter(String input) {
        TextFormatter baseCase = new SnakeCaseFormatter("I Love CS2030");
        TextFormatter targetCase;
        int formatSelector = (int) input.charAt(0) % 3;

        switch (formatSelector) {
        case 0:
            targetCase = new SnakeCaseFormatter(input);
            break;
        case 1:
            targetCase = new KebabCaseFormatter(input);
            break;
        default:
            targetCase = new PascalCaseFormatter(input);
            break;
        }

        if (baseCase.getASCIIValue() > targetCase.getASCIIValue()) {
            this._formattedString = baseCase.format();
            this._asciiValue = baseCase.getASCIIValue();
        } else {
            this._formattedString = targetCase.format();
            this._asciiValue = targetCase.getASCIIValue();
        }
    }

    public String format() {
        return _formattedString;
    }

    public TextFormatter addString(String inputStr) {
        return new MixedFormatFormatter(inputStr);
    }

    public int getASCIIValue() {
        return _asciiValue;
    }

    @Override
    public int compareTo(TextFormatter other) {
        return _asciiValue.compareTo(other.getASCIIValue());
    }
}
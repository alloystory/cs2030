import java.util.*;

public class TextEditor {
    private List<TextFormatter> _availableFormatters;
    private List<TextFormatter> _formattedStrings;

    public TextEditor(List<TextFormatter> formatter) {
        this._availableFormatters = formatter;
        this._formattedStrings = new ArrayList<TextFormatter>();
    }

    public void addString(String inputStr) {
        for (TextFormatter formatter : _availableFormatters) {
            _formattedStrings.add(formatter.addString(inputStr));
        }
    }

    public void printAll() {
        for (TextFormatter formatter : _formattedStrings) {
            System.out.println(formatter.format());
        }
    }
}
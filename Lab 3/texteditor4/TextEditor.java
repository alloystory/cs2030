import java.util.*;

public class TextEditor {
    private List<TextFormatter> _availableFormatters;
    private PriorityQueue<TextFormatter> _formattedStrings;

    public TextEditor(List<TextFormatter> formatter) {
        this._availableFormatters = formatter;
        this._formattedStrings = new PriorityQueue<TextFormatter>();
    }

    public void addString(String inputStr) {
        for (TextFormatter formatter : _availableFormatters) {
            _formattedStrings.offer(formatter.addString(inputStr));
        }
    }

    public void printAll() {
        while (!_formattedStrings.isEmpty()) {
            TextFormatter formatter = _formattedStrings.poll();
            System.out.println(formatter.format());
        }
    }
}
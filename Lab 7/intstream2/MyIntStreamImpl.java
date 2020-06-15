import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;

public class MyIntStreamImpl implements MyIntStream {
    private ArrayList<Integer> _stream;

    public MyIntStreamImpl(int... values) {
        this._stream = new ArrayList<Integer>();
        for (int val : values) {
            _stream.add(val);
        }
    }

    public long count() {
        return _stream.size();
    }

    public int sum() {
        int output = 0;
        for (int val : _stream) {
            output += val;
        }
        return output;
    }

    public OptionalDouble average() {
        if (count() == 0) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(sum() / count());
    }

    public OptionalInt max() {
        if (count() == 0) {
            return OptionalInt.empty();
        }
        int output = _stream.get(0);
        for (int val : _stream) {
            if (val > output) output = val;
        }
        return OptionalInt.of(output);
    }

    public OptionalInt min() { 
        if (count() == 0) {
            return OptionalInt.empty();
        }
        int output = _stream.get(0);
        for (int val : _stream) {
            if (val < output) output = val;
        }
        return OptionalInt.of(output);
    }

    public void forEach(IntConsumer action) {
        for (int val : _stream) {
            action.accept(val);   
        };
    };

    @Override
    public String toString() {
        return _stream.toString();
    }
}

package cs2030.mystream;

import java.util.List;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.HashSet;
import java.util.Iterator;

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

    public MyIntStream limit(int maxSize) {
        List<Integer> buffer = _stream.subList(0, maxSize);
        int[] output = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++)
            output[i] = buffer.get(i);
        return new MyIntStreamImpl(output);
    };

    public MyIntStream distinct() {
        HashSet<Integer> buffer = new HashSet<Integer>(_stream);
        int[] output = new int[buffer.size()];
        Iterator<Integer> bufferIter = buffer.iterator();

        for (int i = 0; i < buffer.size(); i++)
            output[i] = bufferIter.next();
        return new MyIntStreamImpl(output);
    };

    public MyIntStream filter(IntPredicate predicate) {
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        for (int val : _stream) {
            if (predicate.test(val))
                buffer.add(val);
        }

        int[] output = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++)
            output[i] = buffer.get(i);
        return new MyIntStreamImpl(output);
    };

    public MyIntStream map(IntUnaryOperator mapper) {
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        for (int val : _stream) {
            buffer.add(mapper.applyAsInt(val));
        }

        int[] output = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++)
            output[i] = buffer.get(i);
        return new MyIntStreamImpl(output);
    };

    private int reduce(int identity, IntBinaryOperator op, ArrayList<Integer> targetStream) {
        int output = identity;
        for (int val : targetStream) {
            output = op.applyAsInt(output, val);
        }
        return output;
    };

    public int reduce(int identity, IntBinaryOperator op) {
        return reduce(identity, op, _stream);
    };

    public OptionalInt reduce(IntBinaryOperator op) {
        if (count() == 0) {
            return OptionalInt.empty();
        } else {
            ArrayList<Integer> tempStream = new ArrayList<Integer>(_stream);
            int identity = tempStream.remove(0);
            return OptionalInt.of(reduce(identity, op, tempStream));
        }
    };

    @Override
    public String toString() {
        return _stream.toString();
    }
}

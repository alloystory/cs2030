package cs2030.mystream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;

public interface MyIntStream {
    public static MyIntStream of(int... values) {   
        return new MyIntStreamImpl(values);   
    };

    public static MyIntStream range(int start, int end) {   
        if (start > end) {
            return new MyIntStreamImpl(new int[0]);
        } else {
            int size = end - start;
            int[] values = new int[size];
            for (int i = 0; i < size; i++) {
                values[i] = i + start;
            }
            return new MyIntStreamImpl(values);
        }
    };

    public static MyIntStream rangeClosed(int start, int end) {
        return range(start, end + 1);   
    };

    public long count();
    public int sum();
    public OptionalDouble average();
    public OptionalInt max();
    public OptionalInt min();
    public void forEach(IntConsumer action);

    public MyIntStream limit(int maxSize);
    public MyIntStream distinct();
    public MyIntStream filter(IntPredicate predicate);
    public MyIntStream map(IntUnaryOperator mapper);

    public int reduce(int identity, IntBinaryOperator op);
    public OptionalInt reduce(IntBinaryOperator op);
}

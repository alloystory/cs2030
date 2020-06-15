import java.util.ArrayList;

public class MyIntStreamImpl implements MyIntStream {
    private ArrayList<Integer> _stream;

    public MyIntStreamImpl(int... values) {
        this._stream = new ArrayList<Integer>();
        for (int val : values) {
            _stream.add(val);
        }
    }
    
    @Override
    public String toString() {
        return _stream.toString();
    }
}

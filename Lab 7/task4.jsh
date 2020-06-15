/open MyIntStream.java
/open MyIntStreamImpl.java
MyIntStream.rangeClosed(1,10).reduce(0, (x, y) -> x + y);
MyIntStream.rangeClosed(1,10).reduce(1, (x, y) -> x * 2);
MyIntStream.rangeClosed(1,10).reduce((x, y) -> x + y);
MyIntStream.rangeClosed(1,10).reduce((x, y) -> x * 2);
/exit
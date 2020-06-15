/open MyIntStream.java
/open MyIntStreamImpl.java
MyIntStream.rangeClosed(1,10).limit(5)
MyIntStream.rangeClosed(1,10).limit(0)
MyIntStream.rangeClosed(1,10).distinct()
MyIntStream.of(1,1,2,2,3,3,1).distinct()
MyIntStream.rangeClosed(1,10).filter(x -> x % 2 == 0)
MyIntStream.rangeClosed(1,10).filter(x -> true)
MyIntStream.rangeClosed(1,10).map(x -> x * 2)
/exit

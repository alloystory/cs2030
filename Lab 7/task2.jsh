/open MyIntStream.java
/open MyIntStreamImpl.java
MyIntStream.rangeClosed(1,10).count()
MyIntStream.rangeClosed(1,10).sum()
MyIntStream.rangeClosed(1,10).average()
MyIntStream.rangeClosed(1,1).average()
MyIntStream.rangeClosed(1,0).average()
MyIntStream.rangeClosed(1,10).max()
MyIntStream.rangeClosed(1,10).min()
MyIntStream.rangeClosed(1,0).max()
MyIntStream.rangeClosed(1,0).min()
MyIntStream.rangeClosed(1,5).forEach(System.out::println)
/exit

JFLAGS = -g
OUTFLAGS = -d
CLASSPATH = -cp
JC = javac
JVM = java
MAIN = Main.java
PATH_HASIL = ""
SOURCE = *.java

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(SOURCE) $(OUTFLAGS) $(PATH_HASIL)

run:
	$(JVM) $(CLASSPATH) $(PATH_HASIL) Main

clean:
	$(RM) *.class

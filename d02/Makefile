JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = ./ex00/Program.java ./ex01/Program.java ./ex02/Program.java 

all: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) ./ex00/*.class
	$(RM) ./ex01/*.class
	$(RM) ./ex02/*.class
re: clean
	$(MAKE) all

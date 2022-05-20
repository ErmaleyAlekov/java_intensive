JFLAGS = -g --release 8
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = ./ex00/Program.java ./ex00/Transaction.java ./ex00/User.java \
 ./ex01/Program.java ./ex01/User.java ./ex01/UserIdsGenerator.java \
  ./ex02/Program.java ./ex02/User.java ./ex02/UserIdsGenerator.java ./ex02/UsersArrayList.java ./ex02/UsersList.java \
  ./ex03/Program.java ./ex03/Transaction.java ./ex03/TransactionsLinkedList.java ./ex03/TransactionsList.java ./ex03/User.java ./ex03/UserIdsGenerator.java \
  ./ex04/Program.java ./ex04/Transaction.java ./ex04/TransactionsLinkedList.java ./ex04/TransactionsList.java ./ex04/TransactionsService.java ./ex04/User.java \
  ./ex04/UserIdsGenerator.java ./ex04/UsersArrayList.java ./ex04/UsersList.java \
  ./ex05/Program.java ./ex05/Transaction.java ./ex05/TransactionsLinkedList.java ./ex05/TransactionsList.java ./ex05/TransactionsService.java ./ex05/User.java \
  ./ex05/UserIdsGenerator.java ./ex05/UsersArrayList.java ./ex05/UsersList.java ./ex05/Menu.java 

all: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) ./ex00/*.class
	$(RM) ./ex01/*.class
	$(RM) ./ex02/*.class
	$(RM) ./ex03/*.class
	$(RM) ./ex04/*.class
	$(RM) ./ex05/*.class
re: clean
	$(MAKE) all

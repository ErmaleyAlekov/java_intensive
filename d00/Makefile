# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: uterese <uterese@student.21-school.ru>     +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2022/04/19 18:06:55 by uterese           #+#    #+#              #
#    Updated: 2022/04/19 18:06:55 by uterese          ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

JFLAGS = -g --release 8
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = ./ex00/Program.java ./ex01/Program.java ./ex02/Program.java ./ex03/Program.java ./ex04/Program.java

all: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) ./ex00/*.class
	$(RM) ./ex01/*.class
	$(RM) ./ex02/*.class
	$(RM) ./ex03/*.class
	$(RM) ./ex04/*.class
re: clean
	$(MAKE) all
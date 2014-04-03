JC = javac
JFLAGS = -g	
SOURCES = ${wildcard *.java */*.cc */*/*.cc}			
CLASSES = ${SOURCES:.java=.class}

default: 
	${JC} ${SOURCES}

clean: 
	rm ${CLASSES}


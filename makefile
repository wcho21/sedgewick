CLASSPATH:=./dist:./lib/algs4.jar
SRC_DIR:=./src
DIST_DIR:=./dist
DIST_ALGS_PATH=${DIST_DIR}/edu/princeton/cs/algs4
DATA_DIR:=./data
PACKAGE:=edu.princeton.cs.algs4

${DIST_ALGS_PATH}/%.class: ${SRC_DIR}/%.java
	javac -cp ${CLASSPATH} -d ${DIST_DIR} $<

.PHONY: build
build: $(patsubst ${SRC_DIR}/%.java,${DIST_ALGS_PATH}/%.class,$(wildcard ${SRC_DIR}/*.java))

.PHONY: testFixedCapacityStackOfStrings
testFixedCapacityStackOfStrings: ${DIST_ALGS_PATH}/FixedCapacityStackOfStrings.class
	java -cp ${CLASSPATH} ${PACKAGE}.FixedCapacityStackOfStrings < ${DATA_DIR}/tobe.txt

.PHONY: testFixedCapacityStack
testFixedCapacityStack: ${DIST_ALGS_PATH}/FixedCapacityStack.class
	java -cp ${CLASSPATH} ${PACKAGE}.FixedCapacityStack < ${DATA_DIR}/tobe.txt

.PHONY: testResizingArrayStack
testResizingArrayStack: ${DIST_ALGS_PATH}/ResizingArrayStack.class
	java -cp ${CLASSPATH} ${PACKAGE}.ResizingArrayStack < ${DATA_DIR}/tobe.txt

.PHONY: testStack
testStack: ${DIST_ALGS_PATH}/Stack.class
	java -cp ${CLASSPATH} ${PACKAGE}.Stack < ${DATA_DIR}/tobe.txt

.PHONY: testQueue
testQueue: ${DIST_ALGS_PATH}/Queue.class
	java -cp ${CLASSPATH} ${PACKAGE}.Queue < ${DATA_DIR}/tobe.txt

.PHONY: testBag
testBag: ${DIST_ALGS_PATH}/Bag.class
	java -cp ${CLASSPATH} ${PACKAGE}.Bag < ${DATA_DIR}/tobe.txt

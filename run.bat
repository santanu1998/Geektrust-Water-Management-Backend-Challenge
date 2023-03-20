@echo off

gradle clean build -x test --no-daemon
java -jar build\libs\geektrust.jar sample_input\input1.txt
java -jar build\libs\geektrust.jar sample_input\input2.txt
java -jar build\libs\geektrust.jar sample_input\input3.txt
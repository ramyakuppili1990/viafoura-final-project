The Project is developed using springboot
Clone the file into your local IDE or use the ready jar file to run it
The docker file has been included in it

go to the folder : /Documents/GitHub/Viafoura/AnagramChecker
run docker build : docker build -t anagram-viafoura-project.jar .
Find the image file: docker image ls
run the jar file : docker run -p 9090:8080 anagram-viafoura-project.jar

run the below examples:
http://localhost:9090/anagrams/apple
http://localhost:9090/anagrams/apple/elapp

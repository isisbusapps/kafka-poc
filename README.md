# kafka-poc
Kafka proof of concept project

Everything you need to run a basic Kafka program should be within the kafka-poc repo. 

All the scripts default to using the location cd ```C:\Programming\kafka-poc\kafka-training``` as their starting point. If you have cloned this repo to somewhere else please amend the scripts before you start or else nothing will run!

## Kafka from the command line

1.	In a new terminal, start Zookeeper by running the script ```\kafka-training\run-zookeeper.bat``` from the command line 
2.	In a new terminal, start a Kafka server by running the script ```\kafka-training\run-kafka.bat```
3.	In a new terminal, create a Kafka topic by running the script ```\kafka-training\lab1\create-topic.bat```
4.	Running the script ```\kafka-training\lab1\list-topics``` will give you a list of the topics that Kafka is currently managing
5.	In a new terminal, run the script ```\kafka-training\lab1\start-producer-console```. This will start a Kafka producer in a terminal window, which will send whatever you type in the terminal to the Kafka topic you just created. You should try and send at least 4 messages to the topic. 
6.	In order to see your messages, in a new terminal, run the script ```kafka-training\lab1\start-consumer-console.bat```. You should see the messages you previously sent in the new terminal, and should see any new messages you send straight away. (Note, the messages will not be in order as we have 13 partitions within this topic and our consumer is reading from all of them 

## Kafka failover via command line

1.	Make sure zookeeper is running, if not then run ```\kafka-training\run-zookeeper.bat``` in a new terminal
2.	In a new terminal, start 1st Kafka server by running the script ```\kafka-training\lab2\start-1st-server.bat```
3.	In a new terminal, start 2nd Kafka server by running the script ```\kafka-training\lab2\start-2nd-server.bat```
4.	In a new terminal, start 3rd Kafka server by running the script ```\kafka-training\lab2\start-3rd-server.bat```
5.	Create a replicated topic (replication factor 3) by running the script ```\kafka-training\lab2\create-replicated-topic.bat``` . This will create a topic that is replicated over the 3 servers we just made
6.	Running the script ```\kafka-training\lab2\describe-topics.bat``` will give you a list of the topics that Kafka is currently managing
7.	In a new terminal window, run the script ```start-producer-console-replicated.bat``` and type out some messages you want to send. 
8.	In a new terminal, run the script ```start-consumer-console-replicated.bat```. You should be able to see the messages you previously sent, and like before if you type new messages into the producer console, they should appear in the consumer console. 
9.	To demonstrate how Kafka deals with failover, if you kill one of the severs, you should still be able to send and receive messages. Running the ‘describe-topics’ script should show that Kafka is aware of a missing server and is compensating. If you bring the server back on line, ‘describe-topics’ should reflect this. You shouldn’t see a difference in how the producer and consumer work (unless you take down all the servers) 

## Maven project

Within the Maven project, the classes “KafkaProducerExample” and “KafkaConsumerExample” are simple classes that behave similarly to the command line, and show examples of synchronous and asynchronous communication. 

The UserExample project is a sends a simple user object, with a custom serializer. 

The stockprices project goes much more in depth into producer and consumer config, and uses a more complicated custom serializer. 

To run any of the producers/consumers within the maven project, the following scripts need to be running, each with its own terminal: 
1.	```\kafka-training\run-zookeeper.bat```
2.	```\kafka-training\lab2\start-1st-server.bat```
3.	```\kafka-training\lab2\start-2nd-server.bat```
4.	```\kafka-training\lab2\start-3rd-server.bat```
5.	```\kafka-training\create-example-topic.bat```

cd C:\Programming\kafka-poc\kafka-training

 kafka\bin\windows\kafka-topics.bat --create ^	
--replication-factor 3 ^	
--partitions 13 ^	
--topic my-example-topic ^	
--zookeeper localhost:2181	

 kafka\bin\windows\kafka-topics.bat --list ^	
--zookeeper localhost:2181 
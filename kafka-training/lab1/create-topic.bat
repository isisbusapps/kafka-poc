cd C:\Programming\kafka-poc\kafka-training

kafka\bin\windows\kafka-topics.bat --create ^
--zookeeper localhost:2181 ^
--replication-factor 1 --partitions 13 ^
--topic my-topic

cd C:\kafka-training

kafka\bin\windows\kafka-topics.bat --create ^
--zookeeper localhost:2181 ^
--replication-factor 3 ^
--partitions 13 ^
--topic my-failsafe-topic


cd C:\Programming\kafka-poc\kafka-training

kafka\bin\windows\kafka-console-consumer.bat ^
--bootstrap-server localhost:9094,localhost:9092 ^
--topic my-failsafe-topic ^
--consumer-property group.id=mygroup
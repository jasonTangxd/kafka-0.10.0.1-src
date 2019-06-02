
## 创建topic
kafka-topics.sh  --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

## 生产者
kafka-console-producer.sh --broker-list localhost:9092 --topic test


## 消费者
kafka-console-consumer.sh --zookeeper localhost:2181 --topic test

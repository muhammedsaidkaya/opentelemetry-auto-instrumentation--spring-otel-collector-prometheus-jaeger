
# Strimzi Kafka & Kafdrop

```
helm repo add strimzi https://strimzi.io/charts/
helm repo update
helm install kafka strimzi/strimzi-kafka-operator --version 0.27.1
kubeclt apply -f kafka-crd.yaml

helm upgrade --install kafkadrop kafdrop/chart/  --set kafka.brokerConnect="kafka-kafka-brokers:9092"
```


# Alternative Installation - Kafka & Kafka Client
```
kubectl apply -f kafka.yaml
kubectl run kafka-client --image bitnami/kafka:2.8.1
```

# Topics - Paritions
```
kubectl exec -it kafka-client bash 
kafka-topics.sh --create --topic spans --bootstrap-server kafka:9092
kafka-topics.sh --describe \
  --topic spans \
  --bootstrap-server kafka:9092
kafka-console-producer.sh \
  --topic spans \
  --bootstrap-server kafka:9092
kafka-console-consumer.sh \
  --topic spans \
  --from-beginning \
  --bootstrap-server kafka:9092
```
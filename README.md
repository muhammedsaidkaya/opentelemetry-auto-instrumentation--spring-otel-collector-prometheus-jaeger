
# OTEL-Collector - Prometheus - Jaeger Example

# USAGE
```
kind create cluster --config=kind.yaml
cd deployment
kubectl apply -f .
```

* Jaeger: http://localhost:30008
* Prometheus: http://localhost:30009
* Otel-Collector HTTP Receiver: http://localhost:30010
* Otel-Collector Prometheus Exporter: http://localhost:30011/metrics
* Kibana: http://localhost:30012
* Elasticsearch: http://localhost:30013


## Kafka Topics- Partitions
```
kubectl run kafka-client --rm -ti --image bitnami/kafka:3.1.0

kubectl exec -it kafka-client bash 

kafka-topics.sh --create --topic spans --bootstrap-server kafka-svc:9092
kafka-topics.sh --describe \
  --topic spans \
  --bootstrap-server kafka-svc:9092
kafka-console-producer.sh \
  --topic spans \
  --bootstrap-server kafka-svc:9092
kafka-console-consumer.sh \
  --topic spans \
  --from-beginning \
  --bootstrap-server kafka-svc:9092
```
# Print-Service Run - VM Options 
```
-javaagent:opentelemetry-javaagent.jar
-Dotel.exporter.otlp.protocol=http/protobuf
-Dotel.traces.exporter=otlp
-Dotel.exporter.otlp.traces.endpoint=http://localhost:30010/v1/traces
-Dotel.metrics.exporter=otlp
-Dotel.exporter.otlp.metrics.endpoint=http://localhost:30010/v1/metrics
-Dotel.logs.exporter=none
-Dotel.exporter.otlp.logs.endpoint=http://localhost:30010/v1/logs
-Dotel.service.name=print-service
```

# Test
```
# Run PrintServiceApplication
# Send POST request
curl -X POST --location "http://localhost:9091/api/v1.0/print" \
    -H "Content-Type: text/plain" \
    -d "muhammed"
```
# Resources

* [Otel Library Config](https://opentelemetry.io/docs/instrumentation/java/automatic/agent-config/)
* [Otel Collector Config](https://opentelemetry.io/docs/collector/configuration/)
* [Otel Collector Contrib Github](https://github.com/open-telemetry/opentelemetry-collector-contrib)
* [Otel Collector Contrib Dockerhub](https://hub.docker.com/r/otel/opentelemetry-collector-contrib/tags)
* [Otel Collector - Operator Helm Charts](https://github.com/open-telemetry/opentelemetry-helm-charts/tree/main/charts/opentelemetry-operator)
* [Elastic-Kibana Installation](https://medium.com/devopsturkiye/kubernetes-elk-kurulumu-80058c812cf6)
* [Otel Collector Kafka Exporter](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/0faff4502e26af10b570a8bd80d8d98a7d0283f5/exporter/kafkaexporter)
* [Otel Collector Elastic Exporter](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/0faff4502e26af10b570a8bd80d8d98a7d0283f5/exporter/elasticsearchexporter)
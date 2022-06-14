
# OTEL-Collector - Prometheus - Jaeger Example

# USAGE

## Kind 
```
kind create cluster --config=kind.yaml
```

## Elasticsearch & Kibana & Jaeger & Otel Collector & Prometheus
```

```

* [Jaeger](https://github.com/muhammedsaidkaya/blob/master/jaeger/jaeger.yaml): http://localhost:30008
* [Prometheus]((https://github.com/muhammedsaidkaya/blob/master/prometheus/prometheus.yaml)): http://localhost:30009
* [Otel-Collector](https://github.com/muhammedsaidkaya/blob/master/otel/otelcollector.yaml) 
  * HTTP Receiver: http://localhost:30010
  * Prometheus Exporter: http://localhost:30011/metrics
* [Kibana](https://github.com/muhammedsaidkaya/blob/master/elastic-kibana/kibana.yaml): http://localhost:30012
* [Elasticsearch](https://github.com/muhammedsaidkaya/blob/master/elastic-kibana/elastic.yaml): http://localhost:30013

# Print-Service Run - VM Options 
```
-javaagent:opentelemetry-javaagent.jar
-Dotel.exporter.otlp.protocol=http/protobuf
-Dotel.traces.exporter=otlp
-Dotel.exporter.otlp.traces.endpoint=http://localhost:30010/v1/traces
-Dotel.metrics.exporter=otlp
-Dotel.exporter.otlp.metrics.endpoint=http://localhost:30010/v1/metrics
-Dotel.logs.exporter=otlp
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
* [Kafka Installation](https://developer.lightbend.com/docs/cloudflow/current/install/how-to-install-and-use-strimzi.html)
* [Kafka Client - Kafdrop](https://ricardo-aires.github.io/helm-charts/charts/kafdrop/)
* [Kafka Client - Kafdrop Github](https://github.com/obsidiandynamics/kafdrop)

* [Otel Collector Kafka Exporter](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/0faff4502e26af10b570a8bd80d8d98a7d0283f5/exporter/kafkaexporter)
* [Otel Collector Elastic Exporter](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/0faff4502e26af10b570a8bd80d8d98a7d0283f5/exporter/elasticsearchexporter)
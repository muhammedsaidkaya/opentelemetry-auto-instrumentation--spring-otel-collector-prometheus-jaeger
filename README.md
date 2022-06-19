
# Opentelemetry Otel Collector Example

### Components
* Application: (Print-service) Creates telemetry data. (logs, spans, metrics)
  * Spring Boot 2.6.5
  * Java 18
* [OTel Agent](https://github.com/open-telemetry/opentelemetry-java/blob/main/sdk-extensions/autoconfigure/README.md): JVM Java Agent (Opentelemetry-Javaagent.jar): Filter all http requests and sends all telemetry data by creating OTLP exporter
* [OTel Collector](https://opentelemetry.io/docs/collector/configuration/): Kubernetes Daemonset: Collects all telemetry data and process(batch) them. By configuration,
  * Logging Exporter

## Installation (by Order)

* [Otel-Collector](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/otel/otelcollector.yaml)
* [App](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/app.yaml)

## Advanced - Otel Collector

* [Configuration](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/otel/all-config.yaml)

### [Exporters](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/main/exporter)

* [Jaeger](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/jaeger/jaeger.yaml)
* [Prometheus](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/prometheus/prometheus.yaml): http://localhost:30009
* [Elasticsearch](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/elastic-kibana/elastic.yaml): http://localhost:30013
  * [Kibana](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/elastic-kibana/kibana.yaml): http://localhost:30012
* [Kafka](https://github.com/muhammedsaidkaya/opentelemetry-auto-instrumentation-otel-collector--example/blob/master/deployments/kafka/README.md)


# Test Data
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
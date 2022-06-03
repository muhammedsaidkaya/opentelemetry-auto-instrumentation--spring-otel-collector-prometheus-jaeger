
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

* https://opentelemetry.io/docs/instrumentation/java/automatic/agent-config/
* https://opentelemetry.io/docs/collector/configuration/
* https://github.com/open-telemetry/opentelemetry-java/blob/main/sdk-extensions/autoconfigure/README.md#otlp-exporter-span-metric-and-log-exporters
* https://medium.com/devopsturkiye/kubernetes-elk-kurulumu-80058c812cf6
* https://www.elastic.co/guide/en/apm/guide/current/open-telemetry.html
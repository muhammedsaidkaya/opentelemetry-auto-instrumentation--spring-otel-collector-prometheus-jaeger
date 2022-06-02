
# OTEL-Collector - Prometheus - Jaeger Example

# USAGE
```
cd deployment
kubectl apply -f .
kubectl port-forward svc/prometheus-service 9090:9090
kubectl port-forward svc/jaeger-service 16686:16686
kubectl port-forward svc/otel-collector 4318:4318
```

# Print-Service Run - VM Options 
```
-javaagent:opentelemetry-javaagent.jar
-Dotel.exporter.otlp.protocol=http/protobuf
-Dotel.traces.exporter=otlp
-Dotel.exporter.otlp.traces.endpoint=http://localhost:4318/v1/traces
-Dotel.metrics.exporter=otlp
-Dotel.exporter.otlp.metrics.endpoint=http://localhost:4318/v1/metrics
-Dotel.logs.exporter=none
-Dotel.exporter.otlp.logs.endpoint=http://localhost:4318/v1/logs
-Dotel.service.name=print-service
```

* Prometheus-k8s: http://localhost:9090
* Jaeger: http://localhost:16686

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

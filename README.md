

# USAGE
```
cd deployment
kubectl apply -f .
# Run PrintServiceApplication
# Send POST request
curl -X POST --location "http://localhost:9091/api/v1.0/print" \
    -H "Content-Type: text/plain" \
    -d "muhammed"
```

* Prometheus: http://localhost:30009
* Jaeger: http://localhost:30008
* Otel Collector HTTP Receiver: http://localhost:30010
* Otel Collector Metric Exporter: http://localhost:30011

# Print-Service VM Options 
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

# Resources

* https://opentelemetry.io/docs/instrumentation/java/automatic/agent-config/
* https://opentelemetry.io/docs/collector/configuration/
* https://github.com/open-telemetry/opentelemetry-java/blob/main/sdk-extensions/autoconfigure/README.md#otlp-exporter-span-metric-and-log-exporters
package com.github.atomfrede.applicationinsightsdemo;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.connectionstring.ConnectionString;
import org.springframework.stereotype.Service;

@Service
public class ApplicationInsightsService {

    private String connectionString_A;
    private String connectionString_B;
    private TelemetryClient telemetryClient;

    public ApplicationInsightsService() {

        connectionString_A = System.getenv("CONNECTION_STRING_A");
        connectionString_B = System.getenv("CONNECTION_STRING_B");

        telemetryClient = new TelemetryClient();

        // the default connection, all auto instrumented things and
        // business module A related custom events go there
        ConnectionString.configure(connectionString_A);
    }

    public void trackEvent(BusinessUnit businessUnit, String eventName) {
        if (businessUnit == BusinessUnit.BU_A) {
            telemetryClient.getContext().setConnectionString(connectionString_A);
            telemetryClient.trackEvent(eventName);
        } else if (businessUnit == BusinessUnit.BU_B) {
            telemetryClient.getContext().setConnectionString(connectionString_B);
            telemetryClient.trackEvent(eventName);
        }

    }
}

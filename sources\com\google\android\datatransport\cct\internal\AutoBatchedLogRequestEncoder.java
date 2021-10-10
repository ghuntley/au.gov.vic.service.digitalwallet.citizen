package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 1;
    public static final Configurator CONFIG = new AutoBatchedLogRequestEncoder();

    private AutoBatchedLogRequestEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(BatchedLogRequest.class, BatchedLogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_BatchedLogRequest.class, BatchedLogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogRequest.class, LogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_LogRequest.class, LogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(ClientInfo.class, ClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_ClientInfo.class, ClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AndroidClientInfo.class, AndroidClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_AndroidClientInfo.class, AndroidClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogEvent.class, LogEventEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_LogEvent.class, LogEventEncoder.INSTANCE);
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, NetworkConnectionInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_NetworkConnectionInfo.class, NetworkConnectionInfoEncoder.INSTANCE);
    }

    private static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {
        static final BatchedLogRequestEncoder INSTANCE = new BatchedLogRequestEncoder();

        private BatchedLogRequestEncoder() {
        }

        public void encode(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("logRequest", batchedLogRequest.getLogRequests());
        }
    }

    private static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {
        static final LogRequestEncoder INSTANCE = new LogRequestEncoder();

        private LogRequestEncoder() {
        }

        public void encode(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("requestTimeMs", logRequest.getRequestTimeMs());
            objectEncoderContext.add("requestUptimeMs", logRequest.getRequestUptimeMs());
            objectEncoderContext.add("clientInfo", logRequest.getClientInfo());
            objectEncoderContext.add("logSource", logRequest.getLogSource());
            objectEncoderContext.add("logSourceName", logRequest.getLogSourceName());
            objectEncoderContext.add("logEvent", logRequest.getLogEvents());
            objectEncoderContext.add("qosTier", logRequest.getQosTier());
        }
    }

    private static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {
        static final ClientInfoEncoder INSTANCE = new ClientInfoEncoder();

        private ClientInfoEncoder() {
        }

        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("clientType", clientInfo.getClientType());
            objectEncoderContext.add("androidClientInfo", clientInfo.getAndroidClientInfo());
        }
    }

    private static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {
        static final AndroidClientInfoEncoder INSTANCE = new AndroidClientInfoEncoder();

        private AndroidClientInfoEncoder() {
        }

        public void encode(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("sdkVersion", androidClientInfo.getSdkVersion());
            objectEncoderContext.add("model", androidClientInfo.getModel());
            objectEncoderContext.add("hardware", androidClientInfo.getHardware());
            objectEncoderContext.add("device", androidClientInfo.getDevice());
            objectEncoderContext.add("product", androidClientInfo.getProduct());
            objectEncoderContext.add("osBuild", androidClientInfo.getOsBuild());
            objectEncoderContext.add("manufacturer", androidClientInfo.getManufacturer());
            objectEncoderContext.add("fingerprint", androidClientInfo.getFingerprint());
            objectEncoderContext.add("locale", androidClientInfo.getLocale());
            objectEncoderContext.add("country", androidClientInfo.getCountry());
            objectEncoderContext.add("mccMnc", androidClientInfo.getMccMnc());
            objectEncoderContext.add("applicationBuild", androidClientInfo.getApplicationBuild());
        }
    }

    private static final class LogEventEncoder implements ObjectEncoder<LogEvent> {
        static final LogEventEncoder INSTANCE = new LogEventEncoder();

        private LogEventEncoder() {
        }

        public void encode(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("eventTimeMs", logEvent.getEventTimeMs());
            objectEncoderContext.add("eventCode", logEvent.getEventCode());
            objectEncoderContext.add("eventUptimeMs", logEvent.getEventUptimeMs());
            objectEncoderContext.add("sourceExtension", logEvent.getSourceExtension());
            objectEncoderContext.add("sourceExtensionJsonProto3", logEvent.getSourceExtensionJsonProto3());
            objectEncoderContext.add("timezoneOffsetSeconds", logEvent.getTimezoneOffsetSeconds());
            objectEncoderContext.add("networkConnectionInfo", logEvent.getNetworkConnectionInfo());
        }
    }

    private static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {
        static final NetworkConnectionInfoEncoder INSTANCE = new NetworkConnectionInfoEncoder();

        private NetworkConnectionInfoEncoder() {
        }

        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add("networkType", networkConnectionInfo.getNetworkType());
            objectEncoderContext.add("mobileSubtype", networkConnectionInfo.getMobileSubtype());
        }
    }
}

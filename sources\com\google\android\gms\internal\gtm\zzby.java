package com.google.android.gms.internal.gtm;

import com.digitalwallet.utilities.DateFormattingHelper;
import net.openid.appauth.AuthState;

public final class zzby {
    public static zzbz<String> zzaaa = zzbz.zza("analytics.fallback_responses.k", "404,502", "404,502");
    public static zzbz<Integer> zzaab = zzbz.zza("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    private static zzbz<Long> zzaac = zzbz.zza("analytics.service_monitor_interval", (long) DateFormattingHelper.DAY_IN_MS, (long) DateFormattingHelper.DAY_IN_MS);
    public static zzbz<Integer> zzaad = zzbz.zza("analytics.http_connection.connect_timeout_millis", (int) AuthState.EXPIRY_TIME_TOLERANCE_MS, (int) AuthState.EXPIRY_TIME_TOLERANCE_MS);
    public static zzbz<Integer> zzaae = zzbz.zza("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static zzbz<Long> zzaaf = zzbz.zza("analytics.campaigns.time_limit", (long) DateFormattingHelper.DAY_IN_MS, (long) DateFormattingHelper.DAY_IN_MS);
    private static zzbz<String> zzaag = zzbz.zza("analytics.first_party_experiment_id", "", "");
    private static zzbz<Integer> zzaah = zzbz.zza("analytics.first_party_experiment_variant", 0, 0);
    public static zzbz<Boolean> zzaai = zzbz.zza("analytics.test.disable_receiver", false, false);
    public static zzbz<Long> zzaaj = zzbz.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
    public static zzbz<Long> zzaak = zzbz.zza("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
    private static zzbz<Long> zzaal = zzbz.zza("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
    private static zzbz<Long> zzaam = zzbz.zza("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
    public static zzbz<Long> zzaan = zzbz.zza("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
    public static zzbz<Long> zzaao = zzbz.zza("analytics.monitoring.sample_period_millis", (long) DateFormattingHelper.DAY_IN_MS, (long) DateFormattingHelper.DAY_IN_MS);
    public static zzbz<Long> zzaap = zzbz.zza("analytics.initialization_warning_threshold", 5000L, 5000L);
    public static zzbz<Boolean> zzaaq = zzbz.zza("analytics.gcm_task_service", false, false);
    private static zzbz<Boolean> zzyz = zzbz.zza("analytics.service_enabled", false, false);
    public static zzbz<Boolean> zzza = zzbz.zza("analytics.service_client_enabled", true, true);
    public static zzbz<String> zzzb = zzbz.zza("analytics.log_tag", "GAv4", "GAv4-SVC");
    private static zzbz<Long> zzzc = zzbz.zza("analytics.max_tokens", 60L, 60L);
    private static zzbz<Float> zzzd = zzbz.zza("analytics.tokens_per_sec", 0.5f, 0.5f);
    public static zzbz<Integer> zzze = zzbz.zza("analytics.max_stored_hits", 2000, 20000);
    private static zzbz<Integer> zzzf = zzbz.zza("analytics.max_stored_hits_per_app", 2000, 2000);
    public static zzbz<Integer> zzzg = zzbz.zza("analytics.max_stored_properties_per_app", 100, 100);
    public static zzbz<Long> zzzh = zzbz.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
    public static zzbz<Long> zzzi = zzbz.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    private static zzbz<Long> zzzj = zzbz.zza("analytics.min_local_dispatch_millis", 120000L, 120000L);
    private static zzbz<Long> zzzk = zzbz.zza("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
    public static zzbz<Long> zzzl = zzbz.zza("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
    public static zzbz<Long> zzzm = zzbz.zza("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
    public static zzbz<Integer> zzzn = zzbz.zza("analytics.max_hits_per_dispatch", 20, 20);
    public static zzbz<Integer> zzzo = zzbz.zza("analytics.max_hits_per_batch", 20, 20);
    public static zzbz<String> zzzp = zzbz.zza("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
    public static zzbz<String> zzzq = zzbz.zza("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
    public static zzbz<String> zzzr = zzbz.zza("analytics.simple_endpoint", "/collect", "/collect");
    public static zzbz<String> zzzs = zzbz.zza("analytics.batching_endpoint", "/batch", "/batch");
    public static zzbz<Integer> zzzt = zzbz.zza("analytics.max_get_length", 2036, 2036);
    public static zzbz<String> zzzu = zzbz.zza("analytics.batching_strategy.k", zzbg.BATCH_BY_COUNT.name(), zzbg.BATCH_BY_COUNT.name());
    public static zzbz<String> zzzv;
    private static zzbz<Integer> zzzw = zzbz.zza("analytics.max_hits_per_request.k", 20, 20);
    public static zzbz<Integer> zzzx = zzbz.zza("analytics.max_hit_length.k", 8192, 8192);
    public static zzbz<Integer> zzzy = zzbz.zza("analytics.max_post_length.k", 8192, 8192);
    public static zzbz<Integer> zzzz = zzbz.zza("analytics.max_batch_post_length", 8192, 8192);

    static {
        String name = zzbm.GZIP.name();
        zzzv = zzbz.zza("analytics.compression_strategy.k", name, name);
    }
}

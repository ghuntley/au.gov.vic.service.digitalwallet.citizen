package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.RemoteException;
import androidx.room.RoomMasterTable;
import com.bumptech.glide.load.Key;
import com.digitalwallet.app.model.P2PHeader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzff {
    private final String zzaec;
    private int zzaka;
    private final zzcm zzamx;
    private final zzcd zzanh;
    private final zznm zzaov;
    private final zzfl zzaow;
    private final zzok zzaox;
    private final zzok zzaoy;
    private final Set<String> zzaoz = new HashSet();
    private zzkz zzapa;
    private zzee zzapb;
    private final zzfj zzapc;
    private final Context zzrm;

    public zzff(Context context, String str, zznm zznm, zznu zznu, zzcm zzcm, zzcd zzcd) {
        zzfl zzfl = new zzfl();
        this.zzaow = zzfl;
        zzok zzok = new zzok(new HashMap(50));
        this.zzaox = zzok;
        zzok zzok2 = new zzok(new HashMap(10));
        this.zzaoy = zzok2;
        zzfg zzfg = new zzfg(this);
        this.zzapc = zzfg;
        Preconditions.checkNotNull(zznm, "Internal Error: Container resource cannot be null");
        Preconditions.checkNotNull(zznu, "Internal Error: Runtime resource cannot be null");
        Preconditions.checkNotEmpty(str, "Internal Error: ContainerId cannot be empty");
        Preconditions.checkNotNull(zzcm);
        Preconditions.checkNotNull(zzcd);
        this.zzrm = context;
        this.zzaec = str;
        this.zzaov = zznm;
        this.zzamx = zzcm;
        this.zzanh = zzcd;
        zzfl.zza("1", new zzof(new zzhy()));
        zzfl.zza("12", new zzof(new zzhz()));
        zzfl.zza("18", new zzof(new zzia()));
        zzfl.zza("19", new zzof(new zzib()));
        zzfl.zza("20", new zzof(new zzic()));
        zzfl.zza("21", new zzof(new zzid()));
        zzfl.zza("23", new zzof(new zzie()));
        zzfl.zza("24", new zzof(new zzif()));
        zzfl.zza("27", new zzof(new zzig()));
        zzfl.zza("28", new zzof(new zzih()));
        zzfl.zza("29", new zzof(new zzii()));
        zzfl.zza("30", new zzof(new zzij()));
        zzfl.zza("32", new zzof(new zzik()));
        zzfl.zza("33", new zzof(new zzik()));
        zzfl.zza("34", new zzof(new zzil()));
        zzfl.zza("35", new zzof(new zzil()));
        zzfl.zza("39", new zzof(new zzim()));
        zzfl.zza("40", new zzof(new zzin()));
        zzfl.zza("0", new zzof(new zzjk()));
        zzfl.zza("10", new zzof(new zzjl()));
        zzfl.zza("25", new zzof(new zzjm()));
        zzfl.zza("26", new zzof(new zzjn()));
        zzfl.zza("37", new zzof(new zzjo()));
        zzfl.zza("2", new zzof(new zzio()));
        zzfl.zza("3", new zzof(new zzip()));
        zzfl.zza("4", new zzof(new zziq()));
        zzfl.zza("5", new zzof(new zzir()));
        zzfl.zza("6", new zzof(new zzis()));
        zzfl.zza("7", new zzof(new zzit()));
        zzfl.zza("8", new zzof(new zziu()));
        zzfl.zza("9", new zzof(new zzir()));
        zzfl.zza("13", new zzof(new zziv()));
        zzfl.zza("47", new zzof(new zziw()));
        zzfl.zza("15", new zzof(new zzix()));
        zzfl.zza("48", new zzof(new zziy(this)));
        zziz zziz = new zziz();
        zzfl.zza("16", new zzof(zziz));
        zzfl.zza("17", new zzof(zziz));
        zzfl.zza("22", new zzof(new zzjb()));
        zzfl.zza("45", new zzof(new zzjc()));
        zzfl.zza("46", new zzof(new zzjd()));
        zzfl.zza("36", new zzof(new zzje()));
        zzfl.zza("43", new zzof(new zzjf()));
        zzfl.zza("38", new zzof(new zzjg()));
        zzfl.zza("44", new zzof(new zzjh()));
        zzfl.zza("41", new zzof(new zzji()));
        zzfl.zza(RoomMasterTable.DEFAULT_ID, new zzof(new zzjj()));
        zza(zza.CONTAINS, new zzlw());
        zza(zza.ENDS_WITH, new zzlx());
        zza(zza.EQUALS, new zzly());
        zza(zza.GREATER_EQUALS, new zzlz());
        zza(zza.GREATER_THAN, new zzma());
        zza(zza.LESS_EQUALS, new zzmb());
        zza(zza.LESS_THAN, new zzmc());
        zza(zza.REGEX, new zzme());
        zza(zza.STARTS_WITH, new zzmf());
        zzok.zzc("advertiserId", new zzof(new zzkp(context)));
        zzok.zzc("advertiserTrackingEnabled", new zzof(new zzkq(context)));
        zzok.zzc("adwordsClickReferrer", new zzof(new zzkr(context, zzfg)));
        zzok.zzc("applicationId", new zzof(new zzks(context)));
        zzok.zzc("applicationName", new zzof(new zzkt(context)));
        zzok.zzc("applicationVersion", new zzof(new zzku(context)));
        zzok.zzc("applicationVersionName", new zzof(new zzkv(context)));
        zzok.zzc("arbitraryPixieMacro", new zzof(new zzkm(1, zzfl)));
        zzok.zzc("carrier", new zzof(new zzkw(context)));
        zzok.zzc("constant", new zzof(new zzje()));
        zzok.zzc("containerId", new zzof(new zzkx(new zzom(str))));
        zzok.zzc("containerVersion", new zzof(new zzkx(new zzom(zznm.getVersion()))));
        zzok.zzc("customMacro", new zzof(new zzkk(new zzfi(this, null))));
        zzok.zzc("deviceBrand", new zzof(new zzla()));
        zzok.zzc("deviceId", new zzof(new zzlb(context)));
        zzok.zzc("deviceModel", new zzof(new zzlc()));
        zzok.zzc("deviceName", new zzof(new zzld()));
        zzok.zzc("encode", new zzof(new zzle()));
        zzok.zzc("encrypt", new zzof(new zzlf()));
        zzok.zzc("event", new zzof(new zzky()));
        zzok.zzc("eventParameters", new zzof(new zzlg(zzfg)));
        zzok.zzc(P2PHeader.versionKey, new zzof(new zzlh()));
        zzok.zzc("hashcode", new zzof(new zzli()));
        zzok.zzc("installReferrer", new zzof(new zzlj(context)));
        zzok.zzc("join", new zzof(new zzlk()));
        zzok.zzc("language", new zzof(new zzll()));
        zzok.zzc("locale", new zzof(new zzlm()));
        zzok.zzc("adWordsUniqueId", new zzof(new zzlo(context)));
        zzok.zzc("osVersion", new zzof(new zzlp()));
        zzok.zzc("platform", new zzof(new zzlq()));
        zzok.zzc("random", new zzof(new zzlr()));
        zzok.zzc("regexGroup", new zzof(new zzls()));
        zzok.zzc("resolution", new zzof(new zzlu(context)));
        zzok.zzc("runtimeVersion", new zzof(new zzlt()));
        zzok.zzc("sdkVersion", new zzof(new zzlv()));
        this.zzapa = new zzkz();
        zzok.zzc("currentTime", new zzof(this.zzapa));
        zzok.zzc("userProperty", new zzof(new zzln(context, zzfg)));
        zzok.zzc("arbitraryPixel", new zzof(new zzmi(zzec.zzp(context))));
        zzok.zzc("customTag", new zzof(new zzkk(new zzfh(this, null))));
        zzok.zzc("universalAnalytics", new zzof(new zzmj(context, zzfg)));
        zzok.zzc("queueRequest", new zzof(new zzmg(zzec.zzp(context))));
        zzok.zzc("sendMeasurement", new zzof(new zzmh(zzcm, zzfg)));
        zzok.zzc("arbitraryPixieTag", new zzof(new zzkm(0, zzfl)));
        zzok.zzc("suppressPassthrough", new zzof(new zzko(context, zzfg)));
        zzok2.zzc("decodeURI", new zzof(new zzkf()));
        zzok2.zzc("decodeURIComponent", new zzof(new zzkg()));
        zzok2.zzc("encodeURI", new zzof(new zzkh()));
        zzok2.zzc("encodeURIComponent", new zzof(new zzki()));
        zzok2.zzc("log", new zzof(new zzkn()));
        zzok2.zzc("isArray", new zzof(new zzkj()));
        for (zzgy zzgy : zznu.zzmb()) {
            zzgy.zza(this.zzaow);
            this.zzaow.zza(zzgy.getName(), new zzof(zzgy));
        }
        zzok zzok3 = new zzok(new HashMap(1));
        zzok3.zzc("mobile", this.zzaox);
        zzok3.zzc("common", this.zzaoy);
        this.zzaow.zza("gtmUtils", zzok3);
        zzok zzok4 = new zzok(new HashMap((Map) this.zzaox.value()));
        zzok4.zzmi();
        zzok zzok5 = new zzok(new HashMap((Map) this.zzaoy.value()));
        zzok5.zzmi();
        if (this.zzaow.has("main") && (this.zzaow.zzca("main") instanceof zzof)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzok3);
            zzoo.zza(this.zzaow, new zzol("main", arrayList));
        }
        this.zzaox.zzc("base", zzok4);
        this.zzaoy.zzc("base", zzok5);
        zzok3.zzmi();
        this.zzaox.zzmi();
        this.zzaoy.zzmi();
    }

    public final zzoa<?> zzbx(String str) {
        if (!this.zzaoz.contains(str)) {
            this.zzaka = 0;
            return zzby(str);
        }
        String obj = this.zzaoz.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 77 + String.valueOf(obj).length());
        sb.append("Macro cycle detected.  Current macro reference: ");
        sb.append(str);
        sb.append(". Previous macro references: ");
        sb.append(obj);
        throw new IllegalStateException(sb.toString());
    }

    public final void zzb(zzee zzee) {
        IllegalStateException e;
        zzoa zzod;
        this.zzaow.zza("gtm.globals.eventName", new zzom(zzee.zzkf()));
        this.zzapa.zza(zzee);
        this.zzapb = zzee;
        HashSet<zzno> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        for (zznr zznr : this.zzaov.zzls()) {
            if (!zznr.zzly().isEmpty() || !zznr.zzlz().isEmpty()) {
                String valueOf = String.valueOf(zznr);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Evaluating trigger ");
                sb.append(valueOf);
                zzev.zzab(sb.toString());
                Iterator<zzno> it = zznr.zzlx().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zzno next = it.next();
                        zzoa<?> zzoa = (zzoa) hashMap.get(next);
                        if (zzoa == null) {
                            zzoa = zza(next);
                            hashMap.put(next, zzoa);
                        }
                        if (zzoa != zzog.zzaul) {
                            if (((Boolean) ((zzod) zzoa).value()).booleanValue()) {
                                zzod = new zzod(false);
                                break;
                            }
                        } else {
                            zzod = zzog.zzaul;
                            break;
                        }
                    } else {
                        Iterator<zzno> it2 = zznr.zzlw().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                zzod = new zzod(true);
                                break;
                            }
                            zzno next2 = it2.next();
                            zzoa<?> zzoa2 = (zzoa) hashMap.get(next2);
                            if (zzoa2 == null) {
                                zzoa2 = zza(next2);
                                hashMap.put(next2, zzoa2);
                            }
                            if (zzoa2 != zzog.zzaul) {
                                if (!((Boolean) ((zzod) zzoa2).value()).booleanValue()) {
                                    zzod = new zzod(false);
                                    break;
                                }
                            } else {
                                zzod = zzog.zzaul;
                                break;
                            }
                        }
                    }
                }
                if (zzod == zzog.zzaul) {
                    String valueOf2 = String.valueOf(zznr);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 41);
                    sb2.append("Error encounted while evaluating trigger ");
                    sb2.append(valueOf2);
                    zzea.zzb(sb2.toString(), this.zzrm);
                    if (!zznr.zzlz().isEmpty()) {
                        String valueOf3 = String.valueOf(zznr.zzlz());
                        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 15);
                        sb3.append("Blocking tags: ");
                        sb3.append(valueOf3);
                        zzev.zzab(sb3.toString());
                        hashSet2.addAll(zznr.zzlz());
                    }
                } else if (((Boolean) ((zzod) zzod).value()).booleanValue()) {
                    String valueOf4 = String.valueOf(zznr);
                    StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf4).length() + 19);
                    sb4.append("Trigger is firing: ");
                    sb4.append(valueOf4);
                    zzev.zzab(sb4.toString());
                    if (!zznr.zzly().isEmpty()) {
                        String valueOf5 = String.valueOf(zznr.zzly());
                        StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf5).length() + 34);
                        sb5.append("Adding tags to firing candidates: ");
                        sb5.append(valueOf5);
                        zzev.zzab(sb5.toString());
                        hashSet.addAll(zznr.zzly());
                    }
                    if (!zznr.zzlz().isEmpty()) {
                        String valueOf6 = String.valueOf(zznr.zzlz());
                        StringBuilder sb6 = new StringBuilder(String.valueOf(valueOf6).length() + 24);
                        sb6.append("Blocking disabled tags: ");
                        sb6.append(valueOf6);
                        zzev.zzab(sb6.toString());
                        hashSet2.addAll(zznr.zzlz());
                    }
                }
            } else {
                String valueOf7 = String.valueOf(zznr);
                StringBuilder sb7 = new StringBuilder(String.valueOf(valueOf7).length() + 64);
                sb7.append("Trigger is not being evaluated since it has no associated tags: ");
                sb7.append(valueOf7);
                zzev.zzab(sb7.toString());
            }
        }
        hashSet.removeAll(hashSet2);
        boolean z = false;
        for (zzno zzno : hashSet) {
            this.zzaoz.clear();
            String valueOf8 = String.valueOf(zzno);
            StringBuilder sb8 = new StringBuilder(String.valueOf(valueOf8).length() + 21);
            sb8.append("Executing firing tag ");
            sb8.append(valueOf8);
            zzev.zzab(sb8.toString());
            try {
                zzi(zzh(zzno.zzlu()));
                zznx zznx = zzno.zzlu().get(zzb.DISPATCH_ON_FIRE.toString());
                if (zznx != null && zznx.getType() == 8 && ((Boolean) zznx.getValue()).booleanValue()) {
                    try {
                        String valueOf9 = String.valueOf(zzno);
                        StringBuilder sb9 = new StringBuilder(String.valueOf(valueOf9).length() + 36);
                        sb9.append("Tag configured to dispatch on fire: ");
                        sb9.append(valueOf9);
                        zzev.zzab(sb9.toString());
                        z = true;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        z = true;
                        String valueOf10 = String.valueOf(zzno);
                        StringBuilder sb10 = new StringBuilder(String.valueOf(valueOf10).length() + 19);
                        sb10.append("Error firing tag ");
                        sb10.append(valueOf10);
                        sb10.append(": ");
                        zzea.zza(sb10.toString(), e, this.zzrm);
                    }
                }
            } catch (IllegalStateException e3) {
                e = e3;
                String valueOf102 = String.valueOf(zzno);
                StringBuilder sb102 = new StringBuilder(String.valueOf(valueOf102).length() + 19);
                sb102.append("Error firing tag ");
                sb102.append(valueOf102);
                sb102.append(": ");
                zzea.zza(sb102.toString(), e, this.zzrm);
            }
        }
        this.zzaow.remove("gtm.globals.eventName");
        if (zzee.zzki()) {
            String zzkf = zzee.zzkf();
            StringBuilder sb11 = new StringBuilder(String.valueOf(zzkf).length() + 35);
            sb11.append("Log passthrough event ");
            sb11.append(zzkf);
            sb11.append(" to Firebase.");
            zzev.zzab(sb11.toString());
            try {
                this.zzamx.logEventInternalNoInterceptor(zzee.zzkh(), zzee.zzkf(), zzee.zzkg(), zzee.currentTimeMillis());
            } catch (RemoteException e4) {
                zzea.zza("Error calling measurement proxy: ", e4, this.zzrm);
            }
        } else {
            String zzkf2 = zzee.zzkf();
            StringBuilder sb12 = new StringBuilder(String.valueOf(zzkf2).length() + 63);
            sb12.append("Non-passthrough event ");
            sb12.append(zzkf2);
            sb12.append(" doesn't get logged to Firebase directly.");
            zzev.zzab(sb12.toString());
        }
        if (z) {
            zzev.zzab("Dispatch called for dispatchOnFire tags.");
            dispatch();
        }
    }

    private final void zza(zza zza, zzgz zzgz) {
        this.zzaox.zzc(zzgw.zza(zza), new zzof(zzgz));
    }

    public final void dispatch() {
        zzec.zzp(this.zzrm).dispatch();
    }

    private final Map<String, zzoa<?>> zzh(Map<String, zznx> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, zznx> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), zza(entry.getValue()));
        }
        return hashMap;
    }

    private final zzoa<?> zza(zznx zznx) {
        switch (zznx.getType()) {
            case 1:
                try {
                    return new zzoe(Double.valueOf(Double.parseDouble((String) zznx.getValue())));
                } catch (NumberFormatException unused) {
                    return new zzom((String) zznx.getValue());
                }
            case 2:
                List<zznx> list = (List) zznx.getValue();
                ArrayList arrayList = new ArrayList(list.size());
                for (zznx zznx2 : list) {
                    arrayList.add(zza(zznx2));
                }
                return new zzoh(arrayList);
            case 3:
                Map map = (Map) zznx.getValue();
                HashMap hashMap = new HashMap(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    zzoa<?> zza = zza((zznx) entry.getKey());
                    hashMap.put(zzha.zzd(zza), zza((zznx) entry.getValue()));
                }
                return new zzok(hashMap);
            case 4:
                zzoa<?> zzby = zzby((String) zznx.getValue());
                if (!(zzby instanceof zzom) || zznx.zzmd().isEmpty()) {
                    return zzby;
                }
                String str = (String) ((zzom) zzby).value();
                for (Integer num : zznx.zzmd()) {
                    int intValue = num.intValue();
                    if (intValue != 12) {
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unsupported Value Escaping: ");
                        sb.append(intValue);
                        zzev.zzav(sb.toString());
                    } else {
                        str = zzbz(str);
                    }
                }
                return new zzom(str);
            case 5:
                return new zzom((String) zznx.getValue());
            case 6:
                return new zzoe(Double.valueOf(((Integer) zznx.getValue()).doubleValue()));
            case 7:
                StringBuilder sb2 = new StringBuilder();
                for (zznx zznx3 : (List) zznx.getValue()) {
                    sb2.append(zzha.zzd(zza(zznx3)));
                }
                return new zzom(sb2.toString());
            case 8:
                return new zzod((Boolean) zznx.getValue());
            default:
                int type = zznx.getType();
                StringBuilder sb3 = new StringBuilder(52);
                sb3.append("Attempting to expand unknown Value type ");
                sb3.append(type);
                sb3.append(".");
                throw new IllegalStateException(sb3.toString());
        }
    }

    private final zzoa<?> zzby(String str) {
        this.zzaka++;
        String zzjg = zzjg();
        StringBuilder sb = new StringBuilder(String.valueOf(zzjg).length() + 31 + String.valueOf(str).length());
        sb.append(zzjg);
        sb.append("Beginning to evaluate variable ");
        sb.append(str);
        zzev.zzab(sb.toString());
        if (!this.zzaoz.contains(str)) {
            this.zzaoz.add(str);
            zzno zzck = this.zzaov.zzck(str);
            if (zzck != null) {
                zzoa<?> zzi = zzi(zzh(zzck.zzlu()));
                String zzjg2 = zzjg();
                StringBuilder sb2 = new StringBuilder(String.valueOf(zzjg2).length() + 25 + String.valueOf(str).length());
                sb2.append(zzjg2);
                sb2.append("Done evaluating variable ");
                sb2.append(str);
                zzev.zzab(sb2.toString());
                this.zzaka--;
                this.zzaoz.remove(str);
                return zzi;
            }
            this.zzaka--;
            this.zzaoz.remove(str);
            String zzjg3 = zzjg();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzjg3).length() + 36 + String.valueOf(str).length());
            sb3.append(zzjg3);
            sb3.append("Attempting to resolve unknown macro ");
            sb3.append(str);
            throw new IllegalStateException(sb3.toString());
        }
        this.zzaka--;
        String obj = this.zzaoz.toString();
        StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 77 + String.valueOf(obj).length());
        sb4.append("Macro cycle detected.  Current macro reference: ");
        sb4.append(str);
        sb4.append(". Previous macro references: ");
        sb4.append(obj);
        throw new IllegalStateException(sb4.toString());
    }

    private final zzoa<?> zza(zzno zzno) {
        this.zzaoz.clear();
        try {
            zzoa<?> zzi = zzi(zzh(zzno.zzlu()));
            if (zzi instanceof zzod) {
                return zzi;
            }
            zzea.zza("Predicate must return a boolean value", this.zzrm);
            return new zzod(false);
        } catch (IllegalStateException unused) {
            zzev.zzav("Error evaluating predicate.");
            return zzog.zzaul;
        }
    }

    private final zzoa zzi(Map<String, zzoa<?>> map) {
        zzol zzol;
        if (map == null) {
            zzea.zza("executeFunctionCall: cannot access the function parameters.", this.zzrm);
            return zzog.zzaum;
        }
        zzoa<?> zzoa = map.get(zzb.FUNCTION.toString());
        if (!(zzoa instanceof zzom)) {
            zzea.zza("No function id in properties", this.zzrm);
            return zzog.zzaum;
        }
        String str = (String) ((zzom) zzoa).value();
        if (this.zzaow.has(str)) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, zzoa<?>> entry : map.entrySet()) {
                if (entry.getKey().startsWith("vtp_")) {
                    hashMap.put(entry.getKey().substring(4), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new zzok(hashMap));
            zzol = new zzol(str, arrayList);
        } else {
            String zzcc = zzgw.zzcc(str);
            if (zzcc != null && this.zzaox.zzcn(zzcc)) {
                zzol = zzd(str, map);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
                sb.append("functionId '");
                sb.append(str);
                sb.append("' is not supported");
                zzea.zza(sb.toString(), this.zzrm);
                return zzog.zzaum;
            }
        }
        if (zzol == null) {
            zzea.zza("Internal error: failed to convert function to a valid statement", this.zzrm);
            return zzog.zzaum;
        }
        String valueOf = String.valueOf(zzol.zzmj());
        zzev.zzab(valueOf.length() != 0 ? "Executing: ".concat(valueOf) : new String("Executing: "));
        zzoa zza = zzoo.zza(this.zzaow, zzol);
        if (!(zza instanceof zzog)) {
            return zza;
        }
        zzog zzog = (zzog) zza;
        return zzog.zzmh() ? (zzoa) zzog.value() : zza;
    }

    private final zzol zzd(String str, Map<String, zzoa<?>> map) {
        try {
            return zzgw.zza(str, map, this.zzaow);
        } catch (RuntimeException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(message).length());
            sb.append("Incorrect keys for function ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzev.zzav(sb.toString());
            return null;
        }
    }

    private static String zzbz(String str) {
        try {
            return URLEncoder.encode(str, Key.STRING_CHARSET_NAME).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            zzev.zza("Escape URI: unsupported encoding", e);
            return str;
        }
    }

    private final String zzjg() {
        if (this.zzaka <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzaka));
        for (int i = 2; i < this.zzaka; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }
}

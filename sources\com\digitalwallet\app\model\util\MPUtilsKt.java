package com.digitalwallet.app.model.util;

import com.digitalwallet.app.model.Body;
import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.InitHandshakeData;
import com.digitalwallet.app.model.JoinLobby;
import com.digitalwallet.app.model.LobbyInvite;
import com.digitalwallet.app.model.MPContent;
import com.digitalwallet.app.model.MPType;
import com.digitalwallet.app.model.MPTypeToken;
import com.digitalwallet.app.model.P2PHeader;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.Register;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.security.SecureUtilKt;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.utilities.AppType;
import com.nimbusds.jwt.SignedJWT;
import io.reactivex.Maybe;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.value.ArrayValue;
import org.msgpack.value.BinaryValue;
import org.msgpack.value.BooleanValue;
import org.msgpack.value.ImmutableMapValue;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.MapValue;
import org.msgpack.value.StringValue;
import org.msgpack.value.Value;
import timber.log.Timber;

public final class MPUtilsKt {
    private static final Timber.Tree log;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MPTypeToken.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MPTypeToken.INVITE_LOBBY.ordinal()] = 1;
            iArr[MPTypeToken.JOIN_LOBBY.ordinal()] = 2;
            iArr[MPTypeToken.HOLDING_RESPONSE.ordinal()] = 3;
            iArr[MPTypeToken.HOLDING_REQUEST.ordinal()] = 4;
            iArr[MPTypeToken.REGISTER.ordinal()] = 5;
            iArr[MPTypeToken.HANDSHAKE.ordinal()] = 6;
            iArr[MPTypeToken.HEADER.ordinal()] = 7;
            iArr[MPTypeToken.BODY.ordinal()] = 8;
            int[] iArr2 = new int[MPTypeToken.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MPTypeToken.HANDSHAKE.ordinal()] = 1;
            iArr2[MPTypeToken.HEADER.ordinal()] = 2;
            iArr2[MPTypeToken.BODY.ordinal()] = 3;
            iArr2[MPTypeToken.REGISTER.ordinal()] = 4;
            iArr2[MPTypeToken.INVITE_LOBBY.ordinal()] = 5;
            iArr2[MPTypeToken.JOIN_LOBBY.ordinal()] = 6;
            iArr2[MPTypeToken.HOLDING_REQUEST.ordinal()] = 7;
            iArr2[MPTypeToken.HOLDING_RESPONSE.ordinal()] = 8;
        }
    }

    static {
        Timber.Tree tag = Timber.tag("MPUtils");
        Intrinsics.checkNotNullExpressionValue(tag, "Timber.tag(\"MPUtils\")");
        log = tag;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static final byte[] pack(Map<String, ? extends Object> map, MessageBufferPacker messageBufferPacker, boolean z, UUID uuid, HandshakeService handshakeService) {
        messageBufferPacker.packMapHeader(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            messageBufferPacker.packString(key);
            boolean z2 = value instanceof Map;
            if (z2) {
                byte[] bArr = null;
                if (!Intrinsics.areEqual(key, P2PMessage.contentsKey) || !z) {
                    if (z2) {
                        bArr = value;
                    }
                    Map map2 = (Map) bArr;
                    if (map2 == null || pack(map2, messageBufferPacker, z, uuid, handshakeService) == null) {
                        throw new IllegalStateException(((Map) value).getClass() + " is not supported. Add it to the pack function or change the type of the " + key + " field");
                    }
                } else {
                    MessageBufferPacker newDefaultBufferPacker = MessagePack.newDefaultBufferPacker();
                    Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                    Intrinsics.checkNotNullExpressionValue(newDefaultBufferPacker, "encPacker");
                    byte[] pack = pack((Map) value, newDefaultBufferPacker, z, uuid, handshakeService);
                    if (uuid != null) {
                        if (handshakeService != null) {
                            bArr = handshakeService.encryptFor(pack, uuid);
                        }
                        if (bArr != null) {
                            messageBufferPacker.packBinaryHeader(bArr.length).writePayload(bArr);
                        }
                    }
                    throw new IllegalStateException("Something went wrong in the encryption");
                }
            } else if (value instanceof String) {
                messageBufferPacker.packString((String) value);
            } else if (value instanceof Boolean) {
                messageBufferPacker.packBoolean(((Boolean) value).booleanValue());
            } else if (value instanceof byte[]) {
                byte[] bArr2 = (byte[]) value;
                messageBufferPacker.packBinaryHeader(bArr2.length).writePayload(bArr2);
            } else if (value instanceof UUID) {
                messageBufferPacker.packString(value.toString());
            } else if (value instanceof PublicKey) {
                PublicKey publicKey = (PublicKey) value;
                messageBufferPacker.packBinaryHeader(publicKey.getEncoded().length).writePayload(publicKey.getEncoded());
            } else if (value instanceof Integer) {
                messageBufferPacker.packInt(((Number) value).intValue());
            } else if (value instanceof SignedJWT) {
                messageBufferPacker.packString(((SignedJWT) value).serialize());
            } else if (value instanceof List) {
                List list = (List) value;
                messageBufferPacker.packArrayHeader(list.size());
                for (Object obj : (Iterable) value) {
                    if (obj instanceof byte[]) {
                        byte[] bArr3 = (byte[]) obj;
                        messageBufferPacker.packBinaryHeader(bArr3.length).writePayload(bArr3);
                    } else if (obj instanceof String) {
                        messageBufferPacker.packString((String) obj);
                    } else {
                        throw new IllegalStateException(list.getClass() + " is not supported. Add it to the pack function or change the type of the " + key + " field");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else if (value == 0) {
                messageBufferPacker.packNil();
            } else {
                throw new IllegalStateException(value.getClass() + " is not supported. Add it to the pack function or change the type of the " + key + " field");
            }
        }
        messageBufferPacker.close();
        byte[] byteArray = messageBufferPacker.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "packer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] serialize$default(P2PMessage p2PMessage, HandshakeService handshakeService, UUID uuid, int i, Object obj) {
        if ((i & 2) != 0) {
            uuid = null;
        }
        return serialize(p2PMessage, handshakeService, uuid);
    }

    public static final <T extends MPContent> byte[] serialize(P2PMessage<T> p2PMessage, HandshakeService handshakeService, UUID uuid) {
        UUID uuid2;
        UUID uuid3;
        KeyPair keyPair;
        Intrinsics.checkNotNullParameter(p2PMessage, "$this$serialize");
        Intrinsics.checkNotNullParameter(handshakeService, "handshakeService");
        if (p2PMessage.getEncrypted()) {
            MessageBufferPacker newDefaultBufferPacker = MessagePack.newDefaultBufferPacker();
            newDefaultBufferPacker.packMapHeader(4).packString(P2PMessage.headerKey);
            Map<String, Object> asMap = p2PMessage.getHeader().asMap();
            MessageBufferPacker newDefaultBufferPacker2 = MessagePack.newDefaultBufferPacker();
            Intrinsics.checkNotNullExpressionValue(newDefaultBufferPacker2, "MessagePack.newDefaultBufferPacker()");
            boolean encrypted = p2PMessage.getEncrypted();
            if (uuid != null) {
                uuid2 = uuid;
            } else {
                uuid2 = p2PMessage.getHeader().getDestinationID();
            }
            newDefaultBufferPacker.writePayload(pack(asMap, newDefaultBufferPacker2, encrypted, uuid2, handshakeService));
            Body<T> body = p2PMessage.getBody();
            boolean encrypted2 = p2PMessage.getEncrypted();
            if (uuid != null) {
                uuid3 = uuid;
            } else {
                uuid3 = p2PMessage.getHeader().getDestinationID();
            }
            byte[] serialize = serialize(body, encrypted2, handshakeService, uuid3);
            UUID destinationID = p2PMessage.getHeader().getDestinationID();
            if (destinationID == null || (keyPair = handshakeService.getEphKeyPairs().get(destinationID)) == null) {
                throw new IllegalStateException("Unable to find required keypair for " + p2PMessage.getHeader().getDestinationID());
            }
            PrivateKey privateKey = keyPair.getPrivate();
            Objects.requireNonNull(privateKey, "null cannot be cast to non-null type java.security.interfaces.ECPrivateKey");
            byte[] signPayload = SecureUtilKt.signPayload((ECPrivateKey) privateKey, serialize, new SecureRandom());
            if (uuid == null) {
                uuid = p2PMessage.getHeader().getDestinationID();
            }
            byte[] encryptFor = handshakeService.encryptFor(serialize, uuid);
            newDefaultBufferPacker.packString(P2PMessage.contentsKey).packBinaryHeader(encryptFor.length).writePayload(encryptFor);
            newDefaultBufferPacker.packString(P2PMessage.signKey).packBinaryHeader(signPayload.length).writePayload(signPayload);
            newDefaultBufferPacker.packString(P2PMessage.encryptedKey).packBoolean(p2PMessage.getEncrypted());
            byte[] byteArray = newDefaultBufferPacker.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "packer.toByteArray()");
            return byteArray;
        }
        Map<String, Object> asMap2 = p2PMessage.asMap();
        MessageBufferPacker newDefaultBufferPacker3 = MessagePack.newDefaultBufferPacker();
        Intrinsics.checkNotNullExpressionValue(newDefaultBufferPacker3, "MessagePack.newDefaultBufferPacker()");
        boolean encrypted3 = p2PMessage.getEncrypted();
        if (uuid == null) {
            uuid = p2PMessage.getHeader().getDestinationID();
        }
        return pack(asMap2, newDefaultBufferPacker3, encrypted3, uuid, handshakeService);
    }

    public static final <T extends MPContent> byte[] serialize(Body<T> body, boolean z, HandshakeService handshakeService, UUID uuid) {
        Intrinsics.checkNotNullParameter(body, "$this$serialize");
        Map<String, Object> asMap = body.asMap();
        MessageBufferPacker newDefaultBufferPacker = MessagePack.newDefaultBufferPacker();
        Intrinsics.checkNotNullExpressionValue(newDefaultBufferPacker, "MessagePack.newDefaultBufferPacker()");
        return pack(asMap, newDefaultBufferPacker, z, uuid, handshakeService);
    }

    public static final MapValue toMPMapValue(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toMPMapValue");
        ImmutableMapValue asMapValue = MessagePack.newDefaultUnpacker(bArr).unpackValue().asMapValue();
        Intrinsics.checkNotNullExpressionValue(asMapValue, "MessagePack.newDefaultUn…npackValue().asMapValue()");
        return asMapValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v15, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x033e, code lost:
        if (r4 != 0) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0538, code lost:
        if (r6.equals(com.digitalwallet.app.model.P2PHeader.sourceIdKey) != false) goto L_0x0562;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0552, code lost:
        if (r6.equals(com.digitalwallet.app.model.P2PHeader.destinationIdKey) != false) goto L_0x0562;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0559, code lost:
        if (r6.equals(com.digitalwallet.app.model.P2PHeader.responseIdKey) != false) goto L_0x0562;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0560, code lost:
        if (r6.equals(com.digitalwallet.app.model.P2PHeader.messageIdKey) != false) goto L_0x0562;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0562, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "value");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x056b, code lost:
        if (r0.isStringValue() == false) goto L_0x057e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x056d, code lost:
        r0 = r0.asStringValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0571, code lost:
        if (r0 == null) goto L_0x0578;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0573, code lost:
        r0 = r0.asString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        if (r4 != 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0578, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0579, code lost:
        r0 = java.util.UUID.fromString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x057e, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0196, code lost:
        if (r4 != 0) goto L_0x0198;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f0 A[Catch:{ Exception -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fe A[Catch:{ Exception -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010b  */
    public static final MPType deserializeToMP(MapValue mapValue, MPTypeToken mPTypeToken) {
        Object obj;
        StringValue asStringValue;
        String asString;
        MapValue asMapValue;
        MPType deserializeToMP;
        StringValue asStringValue2;
        String asString2;
        StringValue asStringValue3;
        String asString3;
        String str;
        Value value;
        StringValue asStringValue4;
        StringValue asStringValue5;
        String asString4;
        StringValue asStringValue6;
        String asString5;
        StringValue asStringValue7;
        String asString6;
        String str2;
        Value value2;
        StringValue asStringValue8;
        String str3;
        ArrayList arrayList;
        HoldingResponseStatus holdingResponseStatus;
        StringValue asStringValue9;
        String asString7;
        ArrayValue asArrayValue;
        Value value3;
        StringValue asStringValue10;
        Intrinsics.checkNotNullParameter(mapValue, "$this$deserializeToMP");
        Intrinsics.checkNotNullParameter(mPTypeToken, "into");
        int i = 0;
        SignedJWT signedJWT = null;
        switch (WhenMappings.$EnumSwitchMapping$1[mPTypeToken.ordinal()]) {
            case 1:
                Map<Value, Value> map = mapValue.map();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(map, "it");
                for (Map.Entry<Value, Value> entry : map.entrySet()) {
                    Value key = entry.getKey();
                    Value value4 = entry.getValue();
                    String obj2 = key.toString();
                    int hashCode = obj2.hashCode();
                    if (hashCode != 3373) {
                        if (hashCode != 3522646) {
                            if (hashCode == 499093403) {
                                if (!obj2.equals(InitHandshakeData.pubKeyKey)) {
                                }
                            }
                        } else if (!obj2.equals(InitHandshakeData.saltKey)) {
                        }
                    } else if (!obj2.equals(InitHandshakeData.ivKey)) {
                    }
                    String obj3 = key.toString();
                    byte[] asByteArray = value4.asBinaryValue().asByteArray();
                    Intrinsics.checkNotNullExpressionValue(asByteArray, "value.asBinaryValue().asByteArray()");
                    linkedHashMap.put(obj3, asByteArray);
                }
                byte[] bArr = (byte[]) linkedHashMap.get(InitHandshakeData.pubKeyKey);
                if (bArr != null) {
                    byte[] bArr2 = (byte[]) linkedHashMap.get(InitHandshakeData.ivKey);
                    if (bArr2 != null) {
                        byte[] bArr3 = (byte[]) linkedHashMap.get(InitHandshakeData.saltKey);
                        if (bArr3 != null) {
                            return new InitHandshakeData(bArr, bArr2, bArr3);
                        }
                        throw new IllegalStateException("message did not contain recognizable salt");
                    }
                    throw new IllegalStateException("message did not contain recognizable iv");
                }
                throw new IllegalStateException("message did not contain recognizable key");
            case 2:
                Map<Value, Value> map2 = mapValue.map();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Intrinsics.checkNotNullExpressionValue(map2, "map");
                for (Map.Entry<Value, Value> entry2 : map2.entrySet()) {
                    Value key2 = entry2.getKey();
                    Value value5 = entry2.getValue();
                    String obj4 = key2.toString();
                    String obj5 = key2.toString();
                    switch (obj5.hashCode()) {
                        case -1440013470:
                            break;
                        case -633138916:
                            break;
                        case 306545065:
                            break;
                        case 351608024:
                            if (obj5.equals(P2PHeader.versionKey)) {
                                obj = Integer.valueOf(value5.asIntegerValue().asInt());
                                break;
                            }
                            obj = Unit.INSTANCE;
                            break;
                        case 1746327158:
                            break;
                        default:
                            obj = Unit.INSTANCE;
                            break;
                    }
                    linkedHashMap2.put(obj4, obj);
                }
                Object obj6 = linkedHashMap2.get(P2PHeader.versionKey);
                if (!(obj6 instanceof Integer)) {
                    obj6 = null;
                }
                Integer num = (Integer) obj6;
                if (num != null) {
                    int intValue = num.intValue();
                    Object obj7 = linkedHashMap2.get(P2PHeader.messageIdKey);
                    if (!(obj7 instanceof UUID)) {
                        obj7 = null;
                    }
                    UUID uuid = (UUID) obj7;
                    if (uuid != null) {
                        Object obj8 = linkedHashMap2.get(P2PHeader.sourceIdKey);
                        if (!(obj8 instanceof UUID)) {
                            obj8 = null;
                        }
                        UUID uuid2 = (UUID) obj8;
                        if (uuid2 != null) {
                            Object obj9 = linkedHashMap2.get(P2PHeader.responseIdKey);
                            if (!(obj9 instanceof UUID)) {
                                obj9 = null;
                            }
                            UUID uuid3 = (UUID) obj9;
                            Object obj10 = linkedHashMap2.get(P2PHeader.destinationIdKey);
                            if (obj10 instanceof UUID) {
                                signedJWT = obj10;
                            }
                            return new P2PHeader(intValue, uuid, uuid3, uuid2, (UUID) signedJWT);
                        }
                        throw new IllegalStateException("header did not contain recognizable source id");
                    }
                    throw new IllegalStateException("header did not contain recognizable message id");
                }
                throw new IllegalStateException("header did not contain recognizable version");
            case 3:
                Map<Value, Value> map3 = mapValue.map();
                Intrinsics.checkNotNullExpressionValue(map3, "this.map()");
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map3.size()));
                for (T t : map3.entrySet()) {
                    linkedHashMap3.put(t.getKey().toString(), t.getValue());
                }
                Value value6 = (Value) linkedHashMap3.get("type");
                if (!(value6 == null || (asStringValue = value6.asStringValue()) == null || (asString = asStringValue.asString()) == null)) {
                    Objects.requireNonNull(asString, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = asString.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                    if (upperCase != null) {
                        MPTypeToken valueOf = MPTypeToken.valueOf(upperCase);
                        switch (WhenMappings.$EnumSwitchMapping$0[valueOf.ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                Value value7 = (Value) linkedHashMap3.get(Body.contentsKey);
                                if (value7 == null || (asMapValue = value7.asMapValue()) == null || (deserializeToMP = deserializeToMP(asMapValue, valueOf)) == null) {
                                    throw new IllegalStateException("failed to deserialize expected handshake data from " + linkedHashMap3);
                                }
                                String name = valueOf.name();
                                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                                String lowerCase = name.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                Objects.requireNonNull(deserializeToMP, "null cannot be cast to non-null type com.digitalwallet.app.model.MPContent");
                                return new Body(lowerCase, (MPContent) deserializeToMP);
                            case 7:
                            case 8:
                                throw new IllegalStateException("invalid type for body " + valueOf);
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                throw new IllegalStateException("unrecognized type from " + linkedHashMap3);
            case 4:
                Map<Value, Value> map4 = mapValue.map();
                Intrinsics.checkNotNullExpressionValue(map4, "this.map()");
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
                for (T t2 : map4.entrySet()) {
                    linkedHashMap4.put(t2.getKey().toString(), t2.getValue());
                }
                Value value8 = (Value) linkedHashMap4.get(Register.personaKey);
                if (!(value8 == null || (asStringValue2 = value8.asStringValue()) == null || (asString2 = asStringValue2.asString()) == null)) {
                    Objects.requireNonNull(asString2, "null cannot be cast to non-null type java.lang.String");
                    String upperCase2 = asString2.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "(this as java.lang.String).toUpperCase()");
                    if (upperCase2 != null) {
                        return new Register(AppType.valueOf(upperCase2));
                    }
                }
                throw new IllegalStateException("Failed to parse persona from " + linkedHashMap4);
            case 5:
                Map<Value, Value> map5 = mapValue.map();
                Intrinsics.checkNotNullExpressionValue(map5, "this.map()");
                LinkedHashMap linkedHashMap5 = new LinkedHashMap(MapsKt.mapCapacity(map5.size()));
                for (T t3 : map5.entrySet()) {
                    linkedHashMap5.put(t3.getKey().toString(), t3.getValue());
                }
                Value value9 = (Value) linkedHashMap5.get("holdingType");
                if (!(value9 == null || (asStringValue3 = value9.asStringValue()) == null || (asString3 = asStringValue3.asString()) == null)) {
                    Objects.requireNonNull(asString3, "null cannot be cast to non-null type java.lang.String");
                    String upperCase3 = asString3.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase3, "(this as java.lang.String).toUpperCase()");
                    if (upperCase3 != null) {
                        HoldingType[] values = HoldingType.values();
                        ArrayList arrayList2 = new ArrayList(values.length);
                        for (HoldingType holdingType : values) {
                            arrayList2.add(holdingType.name());
                        }
                        if (arrayList2.contains(upperCase3)) {
                            HoldingType valueOf2 = HoldingType.valueOf(upperCase3);
                            Value value10 = (Value) linkedHashMap5.get("requesterJWS");
                            if (!(value10 == null || !value10.isStringValue() || (value = (Value) linkedHashMap5.get("requesterJWS")) == null || (asStringValue4 = value.asStringValue()) == null || (str = asStringValue4.asString()) == null)) {
                                if (str.length() == 0) {
                                    i = 1;
                                    break;
                                }
                            }
                            str = null;
                            if (str != null) {
                                signedJWT = SignedJWT.parse(str);
                            }
                            return new LobbyInvite(valueOf2, signedJWT);
                        }
                        throw new IllegalStateException(upperCase3 + " not a recognized holding type");
                    }
                }
                throw new IllegalStateException("failed to parse holding type string");
            case 6:
                Map<Value, Value> map6 = mapValue.map();
                Intrinsics.checkNotNullExpressionValue(map6, "this.map()");
                LinkedHashMap linkedHashMap6 = new LinkedHashMap(MapsKt.mapCapacity(map6.size()));
                for (T t4 : map6.entrySet()) {
                    linkedHashMap6.put(t4.getKey().toString(), t4.getValue());
                }
                Value value11 = (Value) linkedHashMap6.get("holdingType");
                if (!(value11 == null || (asStringValue5 = value11.asStringValue()) == null || (asString4 = asStringValue5.asString()) == null)) {
                    Objects.requireNonNull(asString4, "null cannot be cast to non-null type java.lang.String");
                    String upperCase4 = asString4.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase4, "(this as java.lang.String).toUpperCase()");
                    if (upperCase4 != null) {
                        HoldingType[] values2 = HoldingType.values();
                        ArrayList arrayList3 = new ArrayList(values2.length);
                        int length = values2.length;
                        while (i < length) {
                            arrayList3.add(values2[i].name());
                            i++;
                        }
                        if (arrayList3.contains(upperCase4)) {
                            HoldingType valueOf3 = HoldingType.valueOf(upperCase4);
                            Value value12 = (Value) linkedHashMap6.get("name");
                            if (!(value12 == null || (asStringValue6 = value12.asStringValue()) == null || (asString5 = asStringValue6.asString()) == null)) {
                                return new JoinLobby(valueOf3, asString5);
                            }
                            throw new IllegalStateException("unable to parse name fomr " + linkedHashMap6);
                        }
                        throw new IllegalStateException(upperCase4 + " not a recognized holding type");
                    }
                }
                throw new IllegalStateException("failed to parse holding type string");
            case 7:
                Map<Value, Value> map7 = mapValue.map();
                Intrinsics.checkNotNullExpressionValue(map7, "this.map()");
                LinkedHashMap linkedHashMap7 = new LinkedHashMap(MapsKt.mapCapacity(map7.size()));
                for (T t5 : map7.entrySet()) {
                    linkedHashMap7.put(t5.getKey().toString(), t5.getValue());
                }
                Value value13 = (Value) linkedHashMap7.get(RequestHolding.sharingCodeKey);
                if (value13 == null || (asStringValue7 = value13.asStringValue()) == null || (asString6 = asStringValue7.asString()) == null) {
                    throw new IllegalStateException("failed to parse sharingCode string");
                }
                Value value14 = (Value) linkedHashMap7.get("requesterJWS");
                if (!(value14 == null || !value14.isStringValue() || (value2 = (Value) linkedHashMap7.get("requesterJWS")) == null || (asStringValue8 = value2.asStringValue()) == null || (str2 = asStringValue8.asString()) == null)) {
                    if (str2.length() == 0) {
                        i = 1;
                        break;
                    }
                }
                str2 = null;
                if (str2 != null) {
                    signedJWT = SignedJWT.parse(str2);
                }
                return new RequestHolding(asString6, signedJWT);
            case 8:
                Map<Value, Value> map8 = mapValue.map();
                Intrinsics.checkNotNullExpressionValue(map8, "this.map()");
                LinkedHashMap linkedHashMap8 = new LinkedHashMap(MapsKt.mapCapacity(map8.size()));
                for (T t6 : map8.entrySet()) {
                    linkedHashMap8.put(t6.getKey().toString(), t6.getValue());
                }
                Value value15 = (Value) linkedHashMap8.get(ShareHolding.holdingKey);
                if (!(value15 == null || !value15.isStringValue() || (value3 = (Value) linkedHashMap8.get(ShareHolding.holdingKey)) == null || (asStringValue10 = value3.asStringValue()) == null || (str3 = asStringValue10.asString()) == null)) {
                    if (str3.length() == 0) {
                        i = 1;
                        break;
                    }
                }
                str3 = null;
                try {
                    Value value16 = (Value) linkedHashMap8.get(ShareHolding.assetDataKey);
                    if (!(value16 == null || (asArrayValue = value16.asArrayValue()) == null)) {
                        ArrayValue<Value> arrayValue = asArrayValue;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayValue, 10));
                        for (Value value17 : arrayValue) {
                            arrayList4.add(value17.asBinaryValue().asByteArray());
                        }
                        arrayList = arrayList4;
                        Value value18 = (Value) linkedHashMap8.get("status");
                        if (!(value18 == null || (asStringValue9 = value18.asStringValue()) == null || (asString7 = asStringValue9.asString()) == null)) {
                            if (asString7 == null) {
                                String upperCase5 = asString7.toUpperCase();
                                Intrinsics.checkNotNullExpressionValue(upperCase5, "(this as java.lang.String).toUpperCase()");
                                holdingResponseStatus = HoldingResponseStatus.valueOf(upperCase5);
                                if (holdingResponseStatus != null) {
                                    if (str3 != null) {
                                        signedJWT = SignedJWT.parse(str3);
                                    }
                                    return new ShareHolding(holdingResponseStatus, signedJWT, arrayList);
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        holdingResponseStatus = HoldingResponseStatus.DENIED;
                        if (str3 != null) {
                        }
                        return new ShareHolding(holdingResponseStatus, signedJWT, arrayList);
                    }
                } catch (Exception unused) {
                }
                arrayList = null;
                try {
                    Value value182 = (Value) linkedHashMap8.get("status");
                    if (asString7 == null) {
                    }
                } catch (Exception unused2) {
                    holdingResponseStatus = HoldingResponseStatus.DENIED;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ Maybe deserializeToMessage$default(byte[] bArr, HandshakeService handshakeService, UUID uuid, int i, Object obj) {
        if ((i & 2) != 0) {
            uuid = null;
        }
        return deserializeToMessage(bArr, handshakeService, uuid);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0152  */
    public static final Maybe<P2PMessage<?>> deserializeToMessage(byte[] bArr, HandshakeService handshakeService, UUID uuid) {
        Object obj;
        Object obj2;
        MPType deserializeToMP;
        P2PHeader p2PHeader;
        Body body;
        UUID uuid2;
        MapValue mPMapValue;
        Value value;
        BinaryValue asBinaryValue;
        BinaryValue asBinaryValue2;
        Intrinsics.checkNotNullParameter(bArr, "$this$deserializeToMessage");
        Intrinsics.checkNotNullParameter(handshakeService, "handshakeService");
        try {
            ImmutableValue unpackValue = MessagePack.newDefaultUnpacker(bArr).unpackValue();
            log.d("Unpacked: " + unpackValue.toJson(), new Object[0]);
            Map<Value, Value> map = unpackValue.asMapValue().map();
            Intrinsics.checkNotNullExpressionValue(map, "unpackedValue\n        .asMapValue()\n        .map()");
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (T t : map.entrySet()) {
                linkedHashMap.put(t.getKey().toString(), t.getValue());
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                Value value2 = (Value) entry.getValue();
                int hashCode = str.hashCode();
                if (hashCode != -1221270899) {
                    if (hashCode == 1613773252 && str.equals(P2PMessage.encryptedKey)) {
                        BooleanValue asBooleanValue = value2.asBooleanValue();
                        Intrinsics.checkNotNullExpressionValue(asBooleanValue, "value.asBooleanValue()");
                        linkedHashMap2.put(str, Boolean.valueOf(asBooleanValue.getBoolean()));
                    }
                } else if (str.equals(P2PMessage.headerKey)) {
                    linkedHashMap2.put(str, value2.asMapValue());
                }
            }
            Object obj3 = linkedHashMap2.get(P2PMessage.encryptedKey);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            MPType mPType = null;
            if (((Boolean) obj3).booleanValue()) {
                Value value3 = (Value) linkedHashMap.get(P2PMessage.contentsKey);
                if (!(value3 == null || (asBinaryValue2 = value3.asBinaryValue()) == null)) {
                    obj = asBinaryValue2.asByteArray();
                    linkedHashMap2.put(P2PMessage.contentsKey, obj);
                    Object obj4 = linkedHashMap2.get(P2PMessage.encryptedKey);
                    Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                    linkedHashMap2.put(P2PMessage.signKey, (((Boolean) obj4).booleanValue() || (value = (Value) linkedHashMap.get(P2PMessage.signKey)) == null || (asBinaryValue = value.asBinaryValue()) == null) ? null : asBinaryValue.asByteArray());
                    obj2 = linkedHashMap2.get(P2PMessage.headerKey);
                    if (!(obj2 instanceof MapValue)) {
                        obj2 = null;
                    }
                    MapValue mapValue = (MapValue) obj2;
                    deserializeToMP = mapValue != null ? deserializeToMP(mapValue, MPTypeToken.HEADER) : null;
                    if (!(deserializeToMP instanceof P2PHeader)) {
                        deserializeToMP = null;
                    }
                    p2PHeader = (P2PHeader) deserializeToMP;
                    if (p2PHeader != null) {
                        Object obj5 = linkedHashMap2.get(P2PMessage.encryptedKey);
                        if (!(obj5 instanceof Boolean)) {
                            obj5 = null;
                        }
                        Boolean bool = (Boolean) obj5;
                        if (bool != null) {
                            boolean booleanValue = bool.booleanValue();
                            Object obj6 = linkedHashMap2.get(P2PMessage.signKey);
                            if (!(obj6 instanceof byte[])) {
                                obj6 = null;
                            }
                            byte[] bArr2 = (byte[]) obj6;
                            if (bArr2 == null) {
                                if (!booleanValue) {
                                    bArr2 = null;
                                } else {
                                    throw new IllegalStateException("Encrypted value missing signature");
                                }
                            }
                            if (booleanValue) {
                                byte[] bArr3 = (byte[]) linkedHashMap2.get(P2PMessage.contentsKey);
                                if (bArr3 != null) {
                                    if (uuid != null) {
                                        uuid2 = uuid;
                                    } else {
                                        uuid2 = p2PHeader.getSourceID();
                                    }
                                    byte[] decryptFor = handshakeService.decryptFor(bArr3, uuid2);
                                    if (decryptFor != null) {
                                        Map<UUID, ECPublicKey> publicKeys = handshakeService.getPublicKeys();
                                        if (uuid == null) {
                                            uuid = p2PHeader.getSourceID();
                                        }
                                        ECPublicKey eCPublicKey = publicKeys.get(uuid);
                                        if (bArr2 != null) {
                                            Objects.requireNonNull(eCPublicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
                                            if (!SecureUtilKt.verifyPayload(eCPublicKey, decryptFor, bArr2)) {
                                                throw new SecurityException("failed to verify contents");
                                            } else if (!(decryptFor == null || (mPMapValue = toMPMapValue(decryptFor)) == null)) {
                                                mPType = deserializeToMP(mPMapValue, MPTypeToken.BODY);
                                            }
                                        } else {
                                            throw new IllegalStateException("unable to find  required signature");
                                        }
                                    }
                                }
                                Objects.requireNonNull(mPType, "null cannot be cast to non-null type com.digitalwallet.app.model.Body<*>");
                                body = (Body) mPType;
                            } else {
                                Object obj7 = linkedHashMap2.get(P2PMessage.contentsKey);
                                if (!(obj7 instanceof MapValue)) {
                                    obj7 = null;
                                }
                                MapValue mapValue2 = (MapValue) obj7;
                                MPType deserializeToMP2 = mapValue2 != null ? deserializeToMP(mapValue2, MPTypeToken.BODY) : null;
                                if (deserializeToMP2 instanceof Body) {
                                    mPType = deserializeToMP2;
                                }
                                body = (Body) mPType;
                            }
                            if (body != null) {
                                Maybe<P2PMessage<?>> just = Maybe.just(new P2PMessage(p2PHeader, body, booleanValue, bArr2));
                                Intrinsics.checkNotNullExpressionValue(just, "unpackedValue\n        .a…ed, signature))\n        }");
                                return just;
                            }
                            throw new IllegalStateException("Could not find a body object");
                        }
                        throw new IllegalStateException("could not parse valid encrypted value from message");
                    }
                    throw new IllegalStateException("could not parse valid header from message");
                }
            } else {
                Value value4 = (Value) linkedHashMap.get(P2PMessage.contentsKey);
                if (value4 != null) {
                    obj = value4.asMapValue();
                    linkedHashMap2.put(P2PMessage.contentsKey, obj);
                    Object obj42 = linkedHashMap2.get(P2PMessage.encryptedKey);
                    Objects.requireNonNull(obj42, "null cannot be cast to non-null type kotlin.Boolean");
                    linkedHashMap2.put(P2PMessage.signKey, (((Boolean) obj42).booleanValue() || (value = (Value) linkedHashMap.get(P2PMessage.signKey)) == null || (asBinaryValue = value.asBinaryValue()) == null) ? null : asBinaryValue.asByteArray());
                    obj2 = linkedHashMap2.get(P2PMessage.headerKey);
                    if (!(obj2 instanceof MapValue)) {
                    }
                    MapValue mapValue3 = (MapValue) obj2;
                    if (mapValue3 != null) {
                    }
                    if (!(deserializeToMP instanceof P2PHeader)) {
                    }
                    p2PHeader = (P2PHeader) deserializeToMP;
                    if (p2PHeader != null) {
                    }
                }
            }
            obj = null;
            linkedHashMap2.put(P2PMessage.contentsKey, obj);
            Object obj422 = linkedHashMap2.get(P2PMessage.encryptedKey);
            Objects.requireNonNull(obj422, "null cannot be cast to non-null type kotlin.Boolean");
            linkedHashMap2.put(P2PMessage.signKey, (((Boolean) obj422).booleanValue() || (value = (Value) linkedHashMap.get(P2PMessage.signKey)) == null || (asBinaryValue = value.asBinaryValue()) == null) ? null : asBinaryValue.asByteArray());
            obj2 = linkedHashMap2.get(P2PMessage.headerKey);
            if (!(obj2 instanceof MapValue)) {
            }
            MapValue mapValue32 = (MapValue) obj2;
            if (mapValue32 != null) {
            }
            if (!(deserializeToMP instanceof P2PHeader)) {
            }
            p2PHeader = (P2PHeader) deserializeToMP;
            if (p2PHeader != null) {
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.toString());
        }
    }
}

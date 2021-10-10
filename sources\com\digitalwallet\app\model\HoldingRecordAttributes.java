package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.digitalwallet.utilities.ServerTypeKt;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import timber.log.Timber;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 ½\u00012\u00020\u0001:\u0002½\u0001B»\u0002\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0003\u0010\f\u001a\u00020\u0004\u0012\b\b\u0003\u0010\r\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0004\u0012\u000e\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003\u0012\u000e\b\u0003\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\u000e\b\u0003\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003\u0012\b\b\u0003\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0003\u0012\u0010\b\u0002\u0010#\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`$¢\u0006\u0002\u0010%J\u0007\u0010\u0001\u001a\u00020.J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u0003HÆ\u0003J\u0012\u0010\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`$HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0004HÆ\u0003JÀ\u0002\u0010¥\u0001\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u00042\b\b\u0003\u0010\u000f\u001a\u00020\u00042\b\b\u0003\u0010\u0010\u001a\u00020\u00042\u000e\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u000e\b\u0003\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u000e\b\u0003\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00042\b\b\u0003\u0010\u0018\u001a\u00020\u00042\b\b\u0003\u0010\u0019\u001a\u00020\u00042\b\b\u0003\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0010\b\u0002\u0010#\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`$HÆ\u0001J\u000b\u0010¦\u0001\u001a\u00030§\u0001HÖ\u0001J\b\u0010¨\u0001\u001a\u00030©\u0001J\u0016\u0010ª\u0001\u001a\u00020.2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001HÖ\u0003J\u0010\u0010­\u0001\u001a\u00030®\u0001H\u0000¢\u0006\u0003\b¯\u0001J\u0007\u0010°\u0001\u001a\u00020\u0004J\n\u0010±\u0001\u001a\u00030§\u0001H\u0002J\b\u0010²\u0001\u001a\u00030³\u0001J\u000b\u0010´\u0001\u001a\u00030§\u0001HÖ\u0001J\u0011\u0010µ\u0001\u001a\u00020.2\b\u0010¶\u0001\u001a\u00030©\u0001J\n\u0010·\u0001\u001a\u00020\u0004HÖ\u0001J\u001f\u0010¸\u0001\u001a\u00030¹\u00012\b\u0010º\u0001\u001a\u00030»\u00012\b\u0010¼\u0001\u001a\u00030§\u0001HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\u00020.¢\u0006\u000e\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u001b\u00104\u001a\u0004\u0018\u000105¢\u0006\u0010\n\u0002\u00109\u0012\u0004\b6\u00100\u001a\u0004\b7\u00108R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0017\u0010;\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u00100\u001a\u0004\b=\u0010'R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0017\u0010?\u001a\u00020@8F¢\u0006\f\u0012\u0004\bA\u00100\u001a\u0004\bB\u0010CR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010*R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010'R\u0017\u0010F\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u00100\u001a\u0004\bH\u0010'R\u0011\u0010I\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bJ\u0010'R\u0017\u0010K\u001a\u00020\u00048F¢\u0006\f\u0012\u0004\bL\u00100\u001a\u0004\bM\u0010'R\u0017\u0010N\u001a\u00020\u00048F¢\u0006\f\u0012\u0004\bO\u00100\u001a\u0004\bP\u0010'R\u0017\u0010Q\u001a\u00020.¢\u0006\u000e\n\u0000\u0012\u0004\bR\u00100\u001a\u0004\bS\u00102R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010'R\u0017\u0010U\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u00100\u001a\u0004\bW\u0010'R\u0017\u0010X\u001a\u00020Y¢\u0006\u000e\n\u0000\u0012\u0004\bZ\u00100\u001a\u0004\b[\u0010\\R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010'R\u0017\u0010^\u001a\u00020.¢\u0006\u000e\n\u0000\u0012\u0004\b_\u00100\u001a\u0004\b^\u00102R\u0011\u0010`\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\ba\u0010'R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010'R\u0016\u0010 \u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010'R\u0016\u0010\u001f\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010'R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010'R\u0017\u0010f\u001a\u00020\u00048F¢\u0006\f\u0012\u0004\bg\u00100\u001a\u0004\bh\u0010'R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010'R\u0017\u0010j\u001a\u00020\u00048F¢\u0006\f\u0012\u0004\bk\u00100\u001a\u0004\bl\u0010'R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010*R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010*R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010*R\u001e\u0010#\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`$8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010'R\u0017\u0010q\u001a\u00020.¢\u0006\u000e\n\u0000\u0012\u0004\br\u00100\u001a\u0004\bs\u00102R\u0017\u0010t\u001a\u00020.¢\u0006\u000e\n\u0000\u0012\u0004\bu\u00100\u001a\u0004\bv\u00102R\u0017\u0010w\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bx\u00100\u001a\u0004\by\u0010'R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010'R\u0017\u0010{\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u00100\u001a\u0004\b}\u0010'R\u0016\u0010\u001d\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010'R\u0016\u0010\u001c\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010'R\u0017\u0010\u001b\u001a\u00020\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010'R\u0017\u0010\u001e\u001a\u00020\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010'R\u0017\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010'R\u001a\u0010\u0001\u001a\u00020\u00048F¢\u0006\u000e\u0012\u0005\b\u0001\u00100\u001a\u0005\b\u0001\u0010'R\u0012\u0010\u0007\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010'R\u0013\u0010\u0001\u001a\u00020.8F¢\u0006\u0007\u001a\u0005\b\u0001\u00102¨\u0006¾\u0001"}, d2 = {"Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "Landroid/os/Parcelable;", "permissions", "", "", "authority", "Lcom/digitalwallet/app/model/Authority;", "type", "deprecatedSubType", "subtype", "domain", "expiry", "_firstName", "_lastName", "name", "dateOfBirth", "holdingState", "emailContact", "Lcom/digitalwallet/app/model/HoldingEmail;", "phoneContact", "Lcom/digitalwallet/app/model/HoldingPhone;", "addresses", "Lcom/digitalwallet/app/model/HoldingAddress;", "identifier", "licenceKind", "startDateTime", "length", "strSolarHotWater", "strGridConnect", "strBattery", "strStandAlone", "licenceConditions", "licenceClass", "quotas", "Lcom/digitalwallet/app/model/KangarooHarvesterQuota;", RequestHolding.sharingCodeKey, "Lcom/digitalwallet/app/model/SharingCode;", "(Ljava/util/List;Lcom/digitalwallet/app/model/Authority;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "get_firstName", "()Ljava/lang/String;", "get_lastName", "getAddresses", "()Ljava/util/List;", "getAuthority", "()Lcom/digitalwallet/app/model/Authority;", "battery", "", "getBattery$annotations", "()V", "getBattery", "()Z", "getDateOfBirth", "dayToExpire", "", "getDayToExpire$annotations", "getDayToExpire", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeprecatedSubType", "dobFormatted", "getDobFormatted$annotations", "getDobFormatted", "getDomain", "durationType", "Lcom/digitalwallet/app/model/DurationType;", "getDurationType$annotations", "getDurationType", "()Lcom/digitalwallet/app/model/DurationType;", "getEmailContact", "getExpiry", "expiryDateFormatted", "getExpiryDateFormatted$annotations", "getExpiryDateFormatted", "firstName", "getFirstName", "fullName", "getFullName$annotations", "getFullName", "fullNameCapitalized", "getFullNameCapitalized$annotations", "getFullNameCapitalized", "gridConnect", "getGridConnect$annotations", "getGridConnect", "getHoldingState", "holdingStateToDisplay", "getHoldingStateToDisplay$annotations", "getHoldingStateToDisplay", "holdingStateType", "Lcom/digitalwallet/app/model/HoldingState;", "getHoldingStateType$annotations", "getHoldingStateType", "()Lcom/digitalwallet/app/model/HoldingState;", "getIdentifier", "isHoldingExpired", "isHoldingExpired$annotations", "lastName", "getLastName", "getLength", "getLicenceClass", "getLicenceConditions", "getLicenceKind", "licenceKindToDisplay", "getLicenceKindToDisplay$annotations", "getLicenceKindToDisplay", "getName", "nameLastCapitalized", "getNameLastCapitalized$annotations", "getNameLastCapitalized", "getPermissions", "getPhoneContact", "getQuotas", "getSharingCode", "solarHotWater", "getSolarHotWater$annotations", "getSolarHotWater", "standAlone", "getStandAlone$annotations", "getStandAlone", "startDateFormatted", "getStartDateFormatted$annotations", "getStartDateFormatted", "getStartDateTime", "startTimeFormatted", "getStartTimeFormatted$annotations", "getStartTimeFormatted", "getStrBattery", "getStrGridConnect", "getStrSolarHotWater", "getStrStandAlone", "getSubtype", "subtypeDisplayName", "getSubtypeDisplayName$annotations", "getSubtypeDisplayName", "getType", "validForDate", "getValidForDate", "checkTypeValidity", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "embeddedHoldingType", "Lcom/digitalwallet/app/model/HoldingType;", "equals", "other", "", "getDomainType", "Lcom/digitalwallet/app/model/DomainType;", "getDomainType$app_citizenProdRelease", "getExpiryText", "getMaxDaysToShowExpiry", "getSubTypeEnum", "Lcom/digitalwallet/app/model/SubType;", "hashCode", "showExpiryWarning", "holdingType", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingRecordAttributes implements Parcelable {
    private static final String AUTHORITY_TYPE_STR = "AGENCY_GRANT";
    private static final String CITIZEN_TYPE_STR = "AGENCY_HOLDING";
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final String _firstName;
    private final String _lastName;
    private final List<HoldingAddress> addresses;
    private final Authority authority;
    private final boolean battery;
    private final String dateOfBirth;
    private final Long dayToExpire;
    @Json(name = "subType")
    private final String deprecatedSubType;
    private final String dobFormatted;
    @Json(name = "domain")
    private final String domain;
    private final List<HoldingEmail> emailContact;
    @Json(name = "expiry")
    private final String expiry;
    private final String expiryDateFormatted;
    private final boolean gridConnect;
    private final String holdingState;
    private final String holdingStateToDisplay;
    private final HoldingState holdingStateType;
    private final String identifier;
    private final boolean isHoldingExpired;
    private final String length;
    @Json(name = "licenceClass")
    private final String licenceClass;
    @Json(name = "licenceConditions")
    private final String licenceConditions;
    private final String licenceKind;
    private final String name;
    private final List<String> permissions;
    private final List<HoldingPhone> phoneContact;
    @Json(name = "quotas")
    private final List<KangarooHarvesterQuota> quotas;
    @Json(name = RequestHolding.sharingCodeKey)
    private final String sharingCode;
    private final boolean solarHotWater;
    private final boolean standAlone;
    private final String startDateFormatted;
    private final String startDateTime;
    private final String startTimeFormatted;
    @Json(name = "battery")
    private final String strBattery;
    @Json(name = "gridConnect")
    private final String strGridConnect;
    @Json(name = "solarHotWater")
    private final String strSolarHotWater;
    @Json(name = "standAlone")
    private final String strStandAlone;
    @Json(name = "subtype")
    private final String subtype;
    private final String type;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            Authority authority = parcel.readInt() != 0 ? (Authority) Authority.CREATOR.createFromParcel(parcel) : null;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((HoldingEmail) HoldingEmail.CREATOR.createFromParcel(parcel));
                readInt--;
                readString10 = readString10;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((HoldingPhone) HoldingPhone.CREATOR.createFromParcel(parcel));
                readInt2--;
                arrayList = arrayList;
            }
            int readInt3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt3);
            while (readInt3 != 0) {
                arrayList3.add((HoldingAddress) HoldingAddress.CREATOR.createFromParcel(parcel));
                readInt3--;
                arrayList2 = arrayList2;
            }
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            String readString17 = parcel.readString();
            String readString18 = parcel.readString();
            String readString19 = parcel.readString();
            String readString20 = parcel.readString();
            int readInt4 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(readInt4);
            while (readInt4 != 0) {
                arrayList4.add((KangarooHarvesterQuota) KangarooHarvesterQuota.CREATOR.createFromParcel(parcel));
                readInt4--;
                arrayList3 = arrayList3;
            }
            return new HoldingRecordAttributes(createStringArrayList, authority, readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, arrayList, arrayList2, arrayList3, readString11, readString12, readString13, readString14, readString15, readString16, readString17, readString18, readString19, readString20, arrayList4, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new HoldingRecordAttributes[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            int[] iArr = new int[HoldingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HoldingType.FISHING_LICENCE.ordinal()] = 1;
            iArr[HoldingType.AMBULANCE_VICTORIA.ordinal()] = 2;
            int[] iArr2 = new int[HoldingState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[HoldingState.COMING_SOON.ordinal()] = 1;
            iArr2[HoldingState.NOT_YET_ACTIVE.ordinal()] = 2;
            iArr2[HoldingState.RECENTLY_EXPIRED.ordinal()] = 3;
            iArr2[HoldingState.EXPIRED.ordinal()] = 4;
            iArr2[HoldingState.PROVISIONAL.ordinal()] = 5;
            iArr2[HoldingState.CURRENT.ordinal()] = 6;
            iArr2[HoldingState.SUSPENDED.ordinal()] = 7;
            iArr2[HoldingState.CANCELLED.ordinal()] = 8;
            iArr2[HoldingState.EXPIRING_SOON.ordinal()] = 9;
            iArr2[HoldingState.ACTIVE.ordinal()] = 10;
            iArr2[HoldingState.VALID.ordinal()] = 11;
            iArr2[HoldingState.AUTHORISED.ordinal()] = 12;
            iArr2[HoldingState.DEAUTHORISED.ordinal()] = 13;
            iArr2[HoldingState.INTERNAL.ordinal()] = 14;
            int[] iArr3 = new int[HoldingState.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[HoldingState.ACTIVE.ordinal()] = 1;
            iArr3[HoldingState.EXPIRING_SOON.ordinal()] = 2;
            iArr3[HoldingState.RECENTLY_EXPIRED.ordinal()] = 3;
            iArr3[HoldingState.EXPIRED.ordinal()] = 4;
            int[] iArr4 = new int[HoldingType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[HoldingType.SOLAR_INSTALLER.ordinal()] = 1;
            iArr4[HoldingType.KANGAROO_HARVESTER.ordinal()] = 2;
            int[] iArr5 = new int[DurationType.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[DurationType.DAY_3.ordinal()] = 1;
            iArr5[DurationType.DAY_28.ordinal()] = 2;
            int[] iArr6 = new int[AppType.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[AppType.AUTHORITY.ordinal()] = 1;
            iArr6[AppType.CITIZEN.ordinal()] = 2;
        }
    }

    public HoldingRecordAttributes() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
    }

    public static /* synthetic */ HoldingRecordAttributes copy$default(HoldingRecordAttributes holdingRecordAttributes, List list, Authority authority2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list2, List list3, List list4, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, List list5, String str21, int i, Object obj) {
        return holdingRecordAttributes.copy((i & 1) != 0 ? holdingRecordAttributes.permissions : list, (i & 2) != 0 ? holdingRecordAttributes.authority : authority2, (i & 4) != 0 ? holdingRecordAttributes.type : str, (i & 8) != 0 ? holdingRecordAttributes.deprecatedSubType : str2, (i & 16) != 0 ? holdingRecordAttributes.subtype : str3, (i & 32) != 0 ? holdingRecordAttributes.domain : str4, (i & 64) != 0 ? holdingRecordAttributes.expiry : str5, (i & 128) != 0 ? holdingRecordAttributes._firstName : str6, (i & 256) != 0 ? holdingRecordAttributes._lastName : str7, (i & 512) != 0 ? holdingRecordAttributes.name : str8, (i & 1024) != 0 ? holdingRecordAttributes.dateOfBirth : str9, (i & 2048) != 0 ? holdingRecordAttributes.holdingState : str10, (i & 4096) != 0 ? holdingRecordAttributes.emailContact : list2, (i & 8192) != 0 ? holdingRecordAttributes.phoneContact : list3, (i & 16384) != 0 ? holdingRecordAttributes.addresses : list4, (i & 32768) != 0 ? holdingRecordAttributes.identifier : str11, (i & 65536) != 0 ? holdingRecordAttributes.licenceKind : str12, (i & 131072) != 0 ? holdingRecordAttributes.startDateTime : str13, (i & 262144) != 0 ? holdingRecordAttributes.length : str14, (i & 524288) != 0 ? holdingRecordAttributes.strSolarHotWater : str15, (i & 1048576) != 0 ? holdingRecordAttributes.strGridConnect : str16, (i & 2097152) != 0 ? holdingRecordAttributes.strBattery : str17, (i & 4194304) != 0 ? holdingRecordAttributes.strStandAlone : str18, (i & 8388608) != 0 ? holdingRecordAttributes.licenceConditions : str19, (i & 16777216) != 0 ? holdingRecordAttributes.licenceClass : str20, (i & 33554432) != 0 ? holdingRecordAttributes.quotas : list5, (i & 67108864) != 0 ? holdingRecordAttributes.sharingCode : str21);
    }

    public static /* synthetic */ void getBattery$annotations() {
    }

    public static /* synthetic */ void getDayToExpire$annotations() {
    }

    public static /* synthetic */ void getDobFormatted$annotations() {
    }

    public static /* synthetic */ void getDurationType$annotations() {
    }

    public static /* synthetic */ void getExpiryDateFormatted$annotations() {
    }

    public static /* synthetic */ void getFullName$annotations() {
    }

    public static /* synthetic */ void getFullNameCapitalized$annotations() {
    }

    public static /* synthetic */ void getGridConnect$annotations() {
    }

    public static /* synthetic */ void getHoldingStateToDisplay$annotations() {
    }

    public static /* synthetic */ void getHoldingStateType$annotations() {
    }

    public static /* synthetic */ void getLicenceKindToDisplay$annotations() {
    }

    public static /* synthetic */ void getNameLastCapitalized$annotations() {
    }

    public static /* synthetic */ void getSolarHotWater$annotations() {
    }

    public static /* synthetic */ void getStandAlone$annotations() {
    }

    public static /* synthetic */ void getStartDateFormatted$annotations() {
    }

    public static /* synthetic */ void getStartTimeFormatted$annotations() {
    }

    public static /* synthetic */ void getSubtypeDisplayName$annotations() {
    }

    public static /* synthetic */ void isHoldingExpired$annotations() {
    }

    public final List<String> component1() {
        return this.permissions;
    }

    public final String component10() {
        return this.name;
    }

    public final String component11() {
        return this.dateOfBirth;
    }

    public final String component12() {
        return this.holdingState;
    }

    public final List<HoldingEmail> component13() {
        return this.emailContact;
    }

    public final List<HoldingPhone> component14() {
        return this.phoneContact;
    }

    public final List<HoldingAddress> component15() {
        return this.addresses;
    }

    public final String component16() {
        return this.identifier;
    }

    public final String component17() {
        return this.licenceKind;
    }

    public final String component18() {
        return this.startDateTime;
    }

    public final String component19() {
        return this.length;
    }

    public final Authority component2() {
        return this.authority;
    }

    public final String component20() {
        return this.strSolarHotWater;
    }

    public final String component21() {
        return this.strGridConnect;
    }

    public final String component22() {
        return this.strBattery;
    }

    public final String component23() {
        return this.strStandAlone;
    }

    public final String component24() {
        return this.licenceConditions;
    }

    public final String component25() {
        return this.licenceClass;
    }

    public final List<KangarooHarvesterQuota> component26() {
        return this.quotas;
    }

    public final String component27() {
        return this.sharingCode;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.deprecatedSubType;
    }

    public final String component5() {
        return this.subtype;
    }

    public final String component6() {
        return this.domain;
    }

    public final String component7() {
        return this.expiry;
    }

    public final String component8() {
        return this._firstName;
    }

    public final String component9() {
        return this._lastName;
    }

    public final HoldingRecordAttributes copy(@Json(name = "permissions") List<String> list, @Json(name = "authority") Authority authority2, @Json(name = "type") String str, String str2, String str3, String str4, String str5, @Json(name = "firstName") String str6, @Json(name = "lastName") String str7, @Json(name = "name") String str8, @Json(name = "dateOfBirth") String str9, @Json(name = "state") String str10, @Json(name = "emailContacts") List<HoldingEmail> list2, @Json(name = "phoneContacts") List<HoldingPhone> list3, @Json(name = "addresses") List<HoldingAddress> list4, @Json(name = "agencyIdentifier") String str11, @Json(name = "kind") String str12, @Json(name = "startDateTime") String str13, @Json(name = "length") String str14, String str15, String str16, String str17, String str18, String str19, String str20, List<KangarooHarvesterQuota> list5, String str21) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "deprecatedSubType");
        Intrinsics.checkNotNullParameter(str3, "subtype");
        Intrinsics.checkNotNullParameter(str4, "domain");
        Intrinsics.checkNotNullParameter(str5, "expiry");
        Intrinsics.checkNotNullParameter(str6, "_firstName");
        Intrinsics.checkNotNullParameter(str7, "_lastName");
        Intrinsics.checkNotNullParameter(str8, "name");
        Intrinsics.checkNotNullParameter(str9, "dateOfBirth");
        Intrinsics.checkNotNullParameter(str10, "holdingState");
        Intrinsics.checkNotNullParameter(list2, "emailContact");
        Intrinsics.checkNotNullParameter(list3, "phoneContact");
        Intrinsics.checkNotNullParameter(list4, "addresses");
        Intrinsics.checkNotNullParameter(str11, "identifier");
        Intrinsics.checkNotNullParameter(str12, "licenceKind");
        Intrinsics.checkNotNullParameter(str13, "startDateTime");
        Intrinsics.checkNotNullParameter(str14, "length");
        Intrinsics.checkNotNullParameter(str15, "strSolarHotWater");
        Intrinsics.checkNotNullParameter(str16, "strGridConnect");
        Intrinsics.checkNotNullParameter(str17, "strBattery");
        Intrinsics.checkNotNullParameter(str18, "strStandAlone");
        Intrinsics.checkNotNullParameter(str19, "licenceConditions");
        Intrinsics.checkNotNullParameter(str20, "licenceClass");
        Intrinsics.checkNotNullParameter(list5, "quotas");
        return new HoldingRecordAttributes(list, authority2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list2, list3, list4, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, list5, str21);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HoldingRecordAttributes)) {
            return false;
        }
        HoldingRecordAttributes holdingRecordAttributes = (HoldingRecordAttributes) obj;
        return Intrinsics.areEqual(this.permissions, holdingRecordAttributes.permissions) && Intrinsics.areEqual(this.authority, holdingRecordAttributes.authority) && Intrinsics.areEqual(this.type, holdingRecordAttributes.type) && Intrinsics.areEqual(this.deprecatedSubType, holdingRecordAttributes.deprecatedSubType) && Intrinsics.areEqual(this.subtype, holdingRecordAttributes.subtype) && Intrinsics.areEqual(this.domain, holdingRecordAttributes.domain) && Intrinsics.areEqual(this.expiry, holdingRecordAttributes.expiry) && Intrinsics.areEqual(this._firstName, holdingRecordAttributes._firstName) && Intrinsics.areEqual(this._lastName, holdingRecordAttributes._lastName) && Intrinsics.areEqual(this.name, holdingRecordAttributes.name) && Intrinsics.areEqual(this.dateOfBirth, holdingRecordAttributes.dateOfBirth) && Intrinsics.areEqual(this.holdingState, holdingRecordAttributes.holdingState) && Intrinsics.areEqual(this.emailContact, holdingRecordAttributes.emailContact) && Intrinsics.areEqual(this.phoneContact, holdingRecordAttributes.phoneContact) && Intrinsics.areEqual(this.addresses, holdingRecordAttributes.addresses) && Intrinsics.areEqual(this.identifier, holdingRecordAttributes.identifier) && Intrinsics.areEqual(this.licenceKind, holdingRecordAttributes.licenceKind) && Intrinsics.areEqual(this.startDateTime, holdingRecordAttributes.startDateTime) && Intrinsics.areEqual(this.length, holdingRecordAttributes.length) && Intrinsics.areEqual(this.strSolarHotWater, holdingRecordAttributes.strSolarHotWater) && Intrinsics.areEqual(this.strGridConnect, holdingRecordAttributes.strGridConnect) && Intrinsics.areEqual(this.strBattery, holdingRecordAttributes.strBattery) && Intrinsics.areEqual(this.strStandAlone, holdingRecordAttributes.strStandAlone) && Intrinsics.areEqual(this.licenceConditions, holdingRecordAttributes.licenceConditions) && Intrinsics.areEqual(this.licenceClass, holdingRecordAttributes.licenceClass) && Intrinsics.areEqual(this.quotas, holdingRecordAttributes.quotas) && Intrinsics.areEqual(this.sharingCode, holdingRecordAttributes.sharingCode);
    }

    public int hashCode() {
        List<String> list = this.permissions;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Authority authority2 = this.authority;
        int hashCode2 = (hashCode + (authority2 != null ? authority2.hashCode() : 0)) * 31;
        String str = this.type;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.deprecatedSubType;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subtype;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.domain;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.expiry;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this._firstName;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this._lastName;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.name;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.dateOfBirth;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.holdingState;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        List<HoldingEmail> list2 = this.emailContact;
        int hashCode13 = (hashCode12 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<HoldingPhone> list3 = this.phoneContact;
        int hashCode14 = (hashCode13 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<HoldingAddress> list4 = this.addresses;
        int hashCode15 = (hashCode14 + (list4 != null ? list4.hashCode() : 0)) * 31;
        String str11 = this.identifier;
        int hashCode16 = (hashCode15 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.licenceKind;
        int hashCode17 = (hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.startDateTime;
        int hashCode18 = (hashCode17 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.length;
        int hashCode19 = (hashCode18 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.strSolarHotWater;
        int hashCode20 = (hashCode19 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.strGridConnect;
        int hashCode21 = (hashCode20 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.strBattery;
        int hashCode22 = (hashCode21 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.strStandAlone;
        int hashCode23 = (hashCode22 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.licenceConditions;
        int hashCode24 = (hashCode23 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.licenceClass;
        int hashCode25 = (hashCode24 + (str20 != null ? str20.hashCode() : 0)) * 31;
        List<KangarooHarvesterQuota> list5 = this.quotas;
        int hashCode26 = (hashCode25 + (list5 != null ? list5.hashCode() : 0)) * 31;
        String str21 = this.sharingCode;
        if (str21 != null) {
            i = str21.hashCode();
        }
        return hashCode26 + i;
    }

    public String toString() {
        return "HoldingRecordAttributes(permissions=" + this.permissions + ", authority=" + this.authority + ", type=" + this.type + ", deprecatedSubType=" + this.deprecatedSubType + ", subtype=" + this.subtype + ", domain=" + this.domain + ", expiry=" + this.expiry + ", _firstName=" + this._firstName + ", _lastName=" + this._lastName + ", name=" + this.name + ", dateOfBirth=" + this.dateOfBirth + ", holdingState=" + this.holdingState + ", emailContact=" + this.emailContact + ", phoneContact=" + this.phoneContact + ", addresses=" + this.addresses + ", identifier=" + this.identifier + ", licenceKind=" + this.licenceKind + ", startDateTime=" + this.startDateTime + ", length=" + this.length + ", strSolarHotWater=" + this.strSolarHotWater + ", strGridConnect=" + this.strGridConnect + ", strBattery=" + this.strBattery + ", strStandAlone=" + this.strStandAlone + ", licenceConditions=" + this.licenceConditions + ", licenceClass=" + this.licenceClass + ", quotas=" + this.quotas + ", sharingCode=" + this.sharingCode + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeStringList(this.permissions);
        Authority authority2 = this.authority;
        if (authority2 != null) {
            parcel.writeInt(1);
            authority2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.type);
        parcel.writeString(this.deprecatedSubType);
        parcel.writeString(this.subtype);
        parcel.writeString(this.domain);
        parcel.writeString(this.expiry);
        parcel.writeString(this._firstName);
        parcel.writeString(this._lastName);
        parcel.writeString(this.name);
        parcel.writeString(this.dateOfBirth);
        parcel.writeString(this.holdingState);
        List<HoldingEmail> list = this.emailContact;
        parcel.writeInt(list.size());
        for (HoldingEmail holdingEmail : list) {
            holdingEmail.writeToParcel(parcel, 0);
        }
        List<HoldingPhone> list2 = this.phoneContact;
        parcel.writeInt(list2.size());
        for (HoldingPhone holdingPhone : list2) {
            holdingPhone.writeToParcel(parcel, 0);
        }
        List<HoldingAddress> list3 = this.addresses;
        parcel.writeInt(list3.size());
        for (HoldingAddress holdingAddress : list3) {
            holdingAddress.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.identifier);
        parcel.writeString(this.licenceKind);
        parcel.writeString(this.startDateTime);
        parcel.writeString(this.length);
        parcel.writeString(this.strSolarHotWater);
        parcel.writeString(this.strGridConnect);
        parcel.writeString(this.strBattery);
        parcel.writeString(this.strStandAlone);
        parcel.writeString(this.licenceConditions);
        parcel.writeString(this.licenceClass);
        List<KangarooHarvesterQuota> list4 = this.quotas;
        parcel.writeInt(list4.size());
        for (KangarooHarvesterQuota kangarooHarvesterQuota : list4) {
            kangarooHarvesterQuota.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.sharingCode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x020e, code lost:
        if ((r1 != null && r1.longValue() <= 0) != false) goto L_0x0210;
     */
    public HoldingRecordAttributes(@Json(name = "permissions") List<String> list, @Json(name = "authority") Authority authority2, @Json(name = "type") String str, String str2, String str3, String str4, String str5, @Json(name = "firstName") String str6, @Json(name = "lastName") String str7, @Json(name = "name") String str8, @Json(name = "dateOfBirth") String str9, @Json(name = "state") String str10, @Json(name = "emailContacts") List<HoldingEmail> list2, @Json(name = "phoneContacts") List<HoldingPhone> list3, @Json(name = "addresses") List<HoldingAddress> list4, @Json(name = "agencyIdentifier") String str11, @Json(name = "kind") String str12, @Json(name = "startDateTime") String str13, @Json(name = "length") String str14, String str15, String str16, String str17, String str18, String str19, String str20, List<KangarooHarvesterQuota> list5, String str21) {
        String str22;
        Intrinsics.checkNotNullParameter(list, "permissions");
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "deprecatedSubType");
        Intrinsics.checkNotNullParameter(str3, "subtype");
        Intrinsics.checkNotNullParameter(str4, "domain");
        Intrinsics.checkNotNullParameter(str5, "expiry");
        Intrinsics.checkNotNullParameter(str6, "_firstName");
        Intrinsics.checkNotNullParameter(str7, "_lastName");
        Intrinsics.checkNotNullParameter(str8, "name");
        Intrinsics.checkNotNullParameter(str9, "dateOfBirth");
        Intrinsics.checkNotNullParameter(str10, "holdingState");
        Intrinsics.checkNotNullParameter(list2, "emailContact");
        Intrinsics.checkNotNullParameter(list3, "phoneContact");
        Intrinsics.checkNotNullParameter(list4, "addresses");
        Intrinsics.checkNotNullParameter(str11, "identifier");
        Intrinsics.checkNotNullParameter(str12, "licenceKind");
        Intrinsics.checkNotNullParameter(str13, "startDateTime");
        Intrinsics.checkNotNullParameter(str14, "length");
        Intrinsics.checkNotNullParameter(str15, "strSolarHotWater");
        Intrinsics.checkNotNullParameter(str16, "strGridConnect");
        Intrinsics.checkNotNullParameter(str17, "strBattery");
        Intrinsics.checkNotNullParameter(str18, "strStandAlone");
        Intrinsics.checkNotNullParameter(str19, "licenceConditions");
        Intrinsics.checkNotNullParameter(str20, "licenceClass");
        Intrinsics.checkNotNullParameter(list5, "quotas");
        this.permissions = list;
        this.authority = authority2;
        this.type = str;
        this.deprecatedSubType = str2;
        this.subtype = str3;
        this.domain = str4;
        this.expiry = str5;
        this._firstName = str6;
        this._lastName = str7;
        this.name = str8;
        this.dateOfBirth = str9;
        this.holdingState = str10;
        this.emailContact = list2;
        this.phoneContact = list3;
        this.addresses = list4;
        this.identifier = str11;
        this.licenceKind = str12;
        this.startDateTime = str13;
        this.length = str14;
        this.strSolarHotWater = str15;
        this.strGridConnect = str16;
        this.strBattery = str17;
        this.strStandAlone = str18;
        this.licenceConditions = str19;
        this.licenceClass = str20;
        this.quotas = list5;
        this.sharingCode = str21;
        HoldingState fromStateString = HoldingState.Companion.fromStateString(str10);
        this.holdingStateType = fromStateString;
        this.startDateFormatted = DateFormattingHelper.INSTANCE.toDate(str13);
        this.startTimeFormatted = DateFormattingHelper.INSTANCE.tryParseToShowTime(str13);
        this.expiryDateFormatted = DateFormattingHelper.INSTANCE.toDate(str5);
        this.dayToExpire = DateFormattingHelper.getTimeDifference$default(DateFormattingHelper.INSTANCE, null, str5, false, 5, null);
        this.dobFormatted = DateFormattingHelper.INSTANCE.toDate(str9);
        int i = WhenMappings.$EnumSwitchMapping$1[fromStateString.ordinal()];
        boolean z = false;
        switch (i) {
            case 1:
                str22 = "Coming soon";
                break;
            case 2:
                str22 = "Not yet active";
                break;
            case 3:
            case 4:
                str22 = "Expired";
                break;
            case 5:
                str22 = "Provisional";
                break;
            case 6:
                str22 = "Current";
                break;
            case 7:
                str22 = "Suspended";
                break;
            case 8:
                str22 = "Cancelled";
                break;
            case 9:
                str22 = "Expiring Soon";
                break;
            case 10:
                str22 = "Active";
                break;
            case 11:
                str22 = "Valid";
                break;
            case 12:
                str22 = "Authorised";
                break;
            case 13:
                str22 = "De-authorised";
                break;
            case 14:
                str22 = "???";
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Could not handle ");
                sb.append(str10);
                sb.append(" - expected one of ");
                HoldingState[] values = HoldingState.values();
                ArrayList arrayList = new ArrayList(values.length);
                for (HoldingState holdingState2 : values) {
                    arrayList.add(holdingState2.name());
                }
                sb.append(arrayList);
                Timber.w(sb.toString(), new Object[0]);
                str22 = "";
                break;
        }
        this.holdingStateToDisplay = str22;
        this.solarHotWater = Intrinsics.areEqual(this.strSolarHotWater, "true");
        this.gridConnect = Intrinsics.areEqual(this.strGridConnect, "true");
        this.battery = Intrinsics.areEqual(this.strBattery, "true");
        this.standAlone = Intrinsics.areEqual(this.strStandAlone, "true");
        if (this.holdingStateType != HoldingState.EXPIRED) {
            Long timeDifference$default = DateFormattingHelper.getTimeDifference$default(DateFormattingHelper.INSTANCE, null, this.expiry, false, 1, null);
        }
        z = true;
        this.isHoldingExpired = z;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Unknown variable types count: 1 */
    public /* synthetic */ HoldingRecordAttributes(List list, Authority authority2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list2, List list3, List list4, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, List list5, String str21, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r56, r3, (i & 16384) != 0 ? CollectionsKt.listOf(new HoldingAddress(null, null, null, null, null, null, null, 127, null)) : list4, (32768 & i) != 0 ? r29 : str11, (i & 65536) != 0 ? r29 : str12, (i & 131072) != 0 ? r29 : str13, (i & 262144) != 0 ? r29 : str14, (i & 524288) != 0 ? r20 : str15, (i & 1048576) != 0 ? r20 : str16, (i & 2097152) != 0 ? r20 : str17, (i & 4194304) == 0 ? str18 : r20, (i & 8388608) != 0 ? r29 : str19, (i & 16777216) != 0 ? r29 : str20, (i & 33554432) != 0 ? CollectionsKt.emptyList() : list5, (i & 67108864) != 0 ? null : str21);
        String str22;
        List list6;
        ?? r5;
        List list7;
        List list8;
        List emptyList = (i & 1) != 0 ? CollectionsKt.emptyList() : list;
        Authority authority3 = (i & 2) != 0 ? null : authority2;
        String str23 = (i & 4) != 0 ? "" : str;
        String str24 = (i & 8) != 0 ? "" : str2;
        String str25 = (i & 16) != 0 ? "" : str3;
        String str26 = (i & 32) != 0 ? "" : str4;
        String str27 = (i & 64) != 0 ? "" : str5;
        String str28 = (i & 128) != 0 ? "" : str6;
        String str29 = (i & 256) != 0 ? "" : str7;
        String str30 = (i & 512) != 0 ? "" : str8;
        String str31 = (i & 1024) != 0 ? "" : str9;
        String str32 = (i & 2048) != 0 ? "INTERNAL" : str10;
        if ((i & 4096) != 0) {
            str22 = "";
            r5 = 0;
            list6 = CollectionsKt.listOf(new HoldingEmail(null, 1, null));
        } else {
            str22 = "";
            r5 = 0;
            list6 = list2;
        }
        if ((i & 8192) != 0) {
            list7 = list6;
            list8 = CollectionsKt.listOf(new HoldingPhone(r5, 1, r5));
        } else {
            list7 = list6;
            list8 = list3;
        }
        String str33 = "false";
    }

    public final List<String> getPermissions() {
        return this.permissions;
    }

    public final Authority getAuthority() {
        return this.authority;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDeprecatedSubType() {
        return this.deprecatedSubType;
    }

    public final String getSubtype() {
        return this.subtype;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getExpiry() {
        return this.expiry;
    }

    public final String get_firstName() {
        return this._firstName;
    }

    public final String get_lastName() {
        return this._lastName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getHoldingState() {
        return this.holdingState;
    }

    public final List<HoldingEmail> getEmailContact() {
        return this.emailContact;
    }

    public final List<HoldingPhone> getPhoneContact() {
        return this.phoneContact;
    }

    public final List<HoldingAddress> getAddresses() {
        return this.addresses;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getLicenceKind() {
        return this.licenceKind;
    }

    public final String getStartDateTime() {
        return this.startDateTime;
    }

    public final String getLength() {
        return this.length;
    }

    public final String getStrSolarHotWater() {
        return this.strSolarHotWater;
    }

    public final String getStrGridConnect() {
        return this.strGridConnect;
    }

    public final String getStrBattery() {
        return this.strBattery;
    }

    public final String getStrStandAlone() {
        return this.strStandAlone;
    }

    public final String getLicenceConditions() {
        return this.licenceConditions;
    }

    public final String getLicenceClass() {
        return this.licenceClass;
    }

    public final List<KangarooHarvesterQuota> getQuotas() {
        return this.quotas;
    }

    public final String getSharingCode() {
        return this.sharingCode;
    }

    public final String getLastName() {
        String str = this._lastName;
        if (str.length() == 0) {
            str = (String) CollectionsKt.last((List) new Regex("\\s").split(this.name, 0));
        }
        return str;
    }

    public final String getFirstName() {
        String str = this._firstName;
        if (str.length() == 0) {
            str = (String) CollectionsKt.first((List) new Regex("\\s").split(this.name, 0));
        }
        return str;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/model/HoldingRecordAttributes$Companion;", "", "()V", "AUTHORITY_TYPE_STR", "", "CITIZEN_TYPE_STR", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Holding.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final SubType getSubTypeEnum() {
        if (this.subtype.length() > 0) {
            return SubType.Companion.fromString(this.subtype);
        }
        return SubType.Companion.fromString(this.deprecatedSubType);
    }

    public final HoldingType embeddedHoldingType() {
        SubType subTypeEnum = getSubTypeEnum();
        if (subTypeEnum == SubType.AMBULANCE_MEMBERSHIP) {
            return HoldingType.AMBULANCE_VICTORIA;
        }
        if (subTypeEnum == SubType.FISHING_LICENCE) {
            return HoldingType.FISHING_LICENCE;
        }
        if (subTypeEnum == SubType.AUTHORITY) {
            return HoldingType.AUTHORITY;
        }
        if (subTypeEnum == SubType.DEFAULT_LICENCE) {
            return getDomainType$app_citizenProdRelease().getHoldingType$app_citizenProdRelease();
        }
        if (subTypeEnum == SubType.WWC_VOLUNTEER) {
            return HoldingType.WWC_CHECK;
        }
        if (subTypeEnum == SubType.KANGAROO_HARVESTER) {
            return HoldingType.KANGAROO_HARVESTER;
        }
        if (SubType.Companion.getWorksafeTypes().contains(subTypeEnum)) {
            return HoldingType.WORKSAFE_LICENCE;
        }
        return HoldingType.UNKNOWN;
    }

    public final HoldingState getHoldingStateType() {
        return this.holdingStateType;
    }

    public final DurationType getDurationType() {
        return DurationType.Companion.fromLicenceKind(this.licenceKind);
    }

    public final String getSubtypeDisplayName() {
        String displayName = getSubTypeEnum().getDisplayName();
        return displayName != null ? displayName : "UNKNOWN";
    }

    public final String getStartDateFormatted() {
        return this.startDateFormatted;
    }

    public final String getStartTimeFormatted() {
        return this.startTimeFormatted;
    }

    public final String getExpiryDateFormatted() {
        return this.expiryDateFormatted;
    }

    public final Long getDayToExpire() {
        return this.dayToExpire;
    }

    public final String getDobFormatted() {
        return this.dobFormatted;
    }

    public final boolean getValidForDate() {
        Date tryParse$default;
        Date tryParse$default2 = DateFormattingHelper.tryParse$default(DateFormattingHelper.INSTANCE, this.expiry, false, 2, null);
        if (tryParse$default2 == null || (tryParse$default = DateFormattingHelper.tryParse$default(DateFormattingHelper.INSTANCE, this.startDateTime, false, 2, null)) == null) {
            return false;
        }
        Date date = tryParse$default2;
        Date date2 = new Date();
        if (date2.compareTo((Object) tryParse$default) >= 0 && date2.compareTo((Object) date) <= 0) {
            return true;
        }
        return false;
    }

    public final String getFullName() {
        return getFirstName() + ' ' + getLastName();
    }

    public final String getFullNameCapitalized() {
        String fullName = getFullName();
        Objects.requireNonNull(fullName, "null cannot be cast to non-null type java.lang.String");
        String upperCase = fullName.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public final String getNameLastCapitalized() {
        List split$default = StringsKt.split$default((CharSequence) this.name, new String[]{" "}, false, 0, 6, (Object) null);
        String str = (String) CollectionsKt.last(split$default);
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return CollectionsKt.joinToString$default(CollectionsKt.plus((Collection) split$default.subList(0, CollectionsKt.getLastIndex(split$default)), (Object) upperCase), " ", null, null, 0, null, null, 62, null);
    }

    public final String getLicenceKindToDisplay() {
        int i = WhenMappings.$EnumSwitchMapping$0[embeddedHoldingType().ordinal()];
        if (i == 1) {
            String str = this.licenceKind + " licence";
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        } else if (i != 2) {
            return this.licenceKind;
        } else {
            String str2 = this.length + ' ' + this.licenceKind;
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = str2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            return lowerCase2;
        }
    }

    public final String getHoldingStateToDisplay() {
        return this.holdingStateToDisplay;
    }

    public final boolean getSolarHotWater() {
        return this.solarHotWater;
    }

    public final boolean getGridConnect() {
        return this.gridConnect;
    }

    public final boolean getBattery() {
        return this.battery;
    }

    public final boolean getStandAlone() {
        return this.standAlone;
    }

    public final boolean showExpiryWarning(HoldingType holdingType) {
        Intrinsics.checkNotNullParameter(holdingType, "holdingType");
        int i = WhenMappings.$EnumSwitchMapping$3[holdingType.ordinal()];
        if (i == 1 || i == 2) {
            return false;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$2[this.holdingStateType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            Long l = this.dayToExpire;
            if (l == null || l.longValue() > ((long) getMaxDaysToShowExpiry())) {
                return false;
            }
        } else if (!(i2 == 3 || i2 == 4)) {
            return false;
        }
        return true;
    }

    public final boolean isHoldingExpired() {
        return this.isHoldingExpired;
    }

    private final int getMaxDaysToShowExpiry() {
        int i = WhenMappings.$EnumSwitchMapping$4[getDurationType().ordinal()];
        if (i != 1) {
            return i != 2 ? 30 : 7;
        }
        return 1;
    }

    public final boolean checkTypeValidity() {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$5[ServerTypeKt.getAppType().ordinal()];
        if (i == 1) {
            str = AUTHORITY_TYPE_STR;
        } else if (i == 2) {
            str = CITIZEN_TYPE_STR;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Intrinsics.areEqual(this.type, str);
    }

    public final DomainType getDomainType$app_citizenProdRelease() {
        String str = this.domain;
        DomainType domainType = DomainType.UNKNOWN;
        try {
            domainType = DomainType.valueOf(str);
        } catch (Throwable unused) {
        }
        return domainType;
    }

    public final String getExpiryText() {
        if (this.isHoldingExpired) {
            return "Expired. Tap to review";
        }
        Long l = this.dayToExpire;
        if (l != null && l.longValue() == 0) {
            return "Expires today";
        }
        Long l2 = this.dayToExpire;
        if (l2 != null && l2.longValue() == 1) {
            return "Expires in " + this.dayToExpire + " day";
        }
        return "Expires in " + this.dayToExpire + " days";
    }
}

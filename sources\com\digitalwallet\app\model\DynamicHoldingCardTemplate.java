package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010E\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\t\u0010F\u001a\u00020'HÖ\u0001J\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020'HÖ\u0001J\t\u0010L\u001a\u00020\rHÖ\u0001J\u0019\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020'HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u0019\u0010!\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\u00020'¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0019\u0010-\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u000f\u001a\u0004\b/\u0010\u0011R\u0019\u00100\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u000f\u001a\u0004\b2\u0010\u0011R\u0019\u00103\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u000f\u001a\u0004\b5\u0010\u0011R\u0019\u00106\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u000f\u001a\u0004\b8\u0010\u0011R\u0019\u00109\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u000f\u001a\u0004\b;\u0010\u0011R\u0019\u0010<\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u000f\u001a\u0004\b>\u0010\u0011R\u0019\u0010?\u001a\u0004\u0018\u00010\r¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u000f\u001a\u0004\bA\u0010\u0011¨\u0006R"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;", "Landroid/os/Parcelable;", "templateType", "Lcom/digitalwallet/app/model/DynamicHoldingTemplateType;", "textStyle", "Lcom/digitalwallet/app/model/DynamicHoldingTextStyle;", "fields", "", "Lcom/digitalwallet/app/model/DynamicHoldingField;", "(Lcom/digitalwallet/app/model/DynamicHoldingTemplateType;Lcom/digitalwallet/app/model/DynamicHoldingTextStyle;Ljava/util/List;)V", "getFields", "()Ljava/util/List;", "label1", "", "getLabel1$annotations", "()V", "getLabel1", "()Ljava/lang/String;", "label2", "getLabel2$annotations", "getLabel2", "label3", "getLabel3$annotations", "getLabel3", "label4", "getLabel4$annotations", "getLabel4", "label5", "getLabel5$annotations", "getLabel5", "label6", "getLabel6$annotations", "getLabel6", "main", "getMain$annotations", "getMain", "getTemplateType", "()Lcom/digitalwallet/app/model/DynamicHoldingTemplateType;", "textColor", "", "getTextColor$annotations", "getTextColor", "()I", "getTextStyle", "()Lcom/digitalwallet/app/model/DynamicHoldingTextStyle;", MessageBundle.TITLE_ENTRY, "getTitle$annotations", "getTitle", "value1", "getValue1$annotations", "getValue1", "value2", "getValue2$annotations", "getValue2", "value3", "getValue3$annotations", "getValue3", "value4", "getValue4$annotations", "getValue4", "value5", "getValue5$annotations", "getValue5", "value6", "getValue6$annotations", "getValue6", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class DynamicHoldingCardTemplate implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<DynamicHoldingField> fields;
    private final String label1;
    private final String label2;
    private final String label3;
    private final String label4;
    private final String label5;
    private final String label6;
    private final String main;
    private final DynamicHoldingTemplateType templateType;
    private final int textColor;
    private final DynamicHoldingTextStyle textStyle;
    private final String title;
    private final String value1;
    private final String value2;
    private final String value3;
    private final String value4;
    private final String value5;
    private final String value6;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            DynamicHoldingTemplateType dynamicHoldingTemplateType = (DynamicHoldingTemplateType) Enum.valueOf(DynamicHoldingTemplateType.class, parcel.readString());
            DynamicHoldingTextStyle dynamicHoldingTextStyle = (DynamicHoldingTextStyle) Enum.valueOf(DynamicHoldingTextStyle.class, parcel.readString());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((DynamicHoldingField) DynamicHoldingField.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new DynamicHoldingCardTemplate(dynamicHoldingTemplateType, dynamicHoldingTextStyle, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DynamicHoldingCardTemplate[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DynamicHoldingTextStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DynamicHoldingTextStyle.LIGHT.ordinal()] = 1;
            iArr[DynamicHoldingTextStyle.DARK.ordinal()] = 2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.DynamicHoldingCardTemplate */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DynamicHoldingCardTemplate copy$default(DynamicHoldingCardTemplate dynamicHoldingCardTemplate, DynamicHoldingTemplateType dynamicHoldingTemplateType, DynamicHoldingTextStyle dynamicHoldingTextStyle, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            dynamicHoldingTemplateType = dynamicHoldingCardTemplate.templateType;
        }
        if ((i & 2) != 0) {
            dynamicHoldingTextStyle = dynamicHoldingCardTemplate.textStyle;
        }
        if ((i & 4) != 0) {
            list = dynamicHoldingCardTemplate.fields;
        }
        return dynamicHoldingCardTemplate.copy(dynamicHoldingTemplateType, dynamicHoldingTextStyle, list);
    }

    public static /* synthetic */ void getLabel1$annotations() {
    }

    public static /* synthetic */ void getLabel2$annotations() {
    }

    public static /* synthetic */ void getLabel3$annotations() {
    }

    public static /* synthetic */ void getLabel4$annotations() {
    }

    public static /* synthetic */ void getLabel5$annotations() {
    }

    public static /* synthetic */ void getLabel6$annotations() {
    }

    public static /* synthetic */ void getMain$annotations() {
    }

    public static /* synthetic */ void getTextColor$annotations() {
    }

    public static /* synthetic */ void getTitle$annotations() {
    }

    public static /* synthetic */ void getValue1$annotations() {
    }

    public static /* synthetic */ void getValue2$annotations() {
    }

    public static /* synthetic */ void getValue3$annotations() {
    }

    public static /* synthetic */ void getValue4$annotations() {
    }

    public static /* synthetic */ void getValue5$annotations() {
    }

    public static /* synthetic */ void getValue6$annotations() {
    }

    public final DynamicHoldingTemplateType component1() {
        return this.templateType;
    }

    public final DynamicHoldingTextStyle component2() {
        return this.textStyle;
    }

    public final List<DynamicHoldingField> component3() {
        return this.fields;
    }

    public final DynamicHoldingCardTemplate copy(@Json(name = "template") DynamicHoldingTemplateType dynamicHoldingTemplateType, DynamicHoldingTextStyle dynamicHoldingTextStyle, List<DynamicHoldingField> list) {
        Intrinsics.checkNotNullParameter(dynamicHoldingTemplateType, "templateType");
        Intrinsics.checkNotNullParameter(dynamicHoldingTextStyle, "textStyle");
        Intrinsics.checkNotNullParameter(list, "fields");
        return new DynamicHoldingCardTemplate(dynamicHoldingTemplateType, dynamicHoldingTextStyle, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicHoldingCardTemplate)) {
            return false;
        }
        DynamicHoldingCardTemplate dynamicHoldingCardTemplate = (DynamicHoldingCardTemplate) obj;
        return Intrinsics.areEqual(this.templateType, dynamicHoldingCardTemplate.templateType) && Intrinsics.areEqual(this.textStyle, dynamicHoldingCardTemplate.textStyle) && Intrinsics.areEqual(this.fields, dynamicHoldingCardTemplate.fields);
    }

    public int hashCode() {
        DynamicHoldingTemplateType dynamicHoldingTemplateType = this.templateType;
        int i = 0;
        int hashCode = (dynamicHoldingTemplateType != null ? dynamicHoldingTemplateType.hashCode() : 0) * 31;
        DynamicHoldingTextStyle dynamicHoldingTextStyle = this.textStyle;
        int hashCode2 = (hashCode + (dynamicHoldingTextStyle != null ? dynamicHoldingTextStyle.hashCode() : 0)) * 31;
        List<DynamicHoldingField> list = this.fields;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DynamicHoldingCardTemplate(templateType=" + this.templateType + ", textStyle=" + this.textStyle + ", fields=" + this.fields + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.templateType.name());
        parcel.writeString(this.textStyle.name());
        List<DynamicHoldingField> list = this.fields;
        parcel.writeInt(list.size());
        for (DynamicHoldingField dynamicHoldingField : list) {
            dynamicHoldingField.writeToParcel(parcel, 0);
        }
    }

    public DynamicHoldingCardTemplate(@Json(name = "template") DynamicHoldingTemplateType dynamicHoldingTemplateType, DynamicHoldingTextStyle dynamicHoldingTextStyle, List<DynamicHoldingField> list) {
        int i;
        String str;
        T t;
        T t2;
        T t3;
        T t4;
        T t5;
        T t6;
        T t7;
        T t8;
        T t9;
        T t10;
        T t11;
        T t12;
        T t13;
        T t14;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Intrinsics.checkNotNullParameter(dynamicHoldingTemplateType, "templateType");
        Intrinsics.checkNotNullParameter(dynamicHoldingTextStyle, "textStyle");
        Intrinsics.checkNotNullParameter(list, "fields");
        this.templateType = dynamicHoldingTemplateType;
        this.textStyle = dynamicHoldingTextStyle;
        this.fields = list;
        int i2 = WhenMappings.$EnumSwitchMapping$0[dynamicHoldingTextStyle.ordinal()];
        if (i2 == 1) {
            i = -1;
        } else if (i2 == 2) {
            i = ViewCompat.MEASURED_STATE_MASK;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.textColor = i;
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getId() == DynamicHoldingFieldID.TITLE) {
                z14 = true;
                continue;
            } else {
                z14 = false;
                continue;
            }
            if (z14) {
                break;
            }
        }
        T t15 = t;
        this.title = t15 != null ? t15.getValue() : null;
        Iterator<T> it2 = this.fields.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (t2.getId() == DynamicHoldingFieldID.MAIN) {
                z13 = true;
                continue;
            } else {
                z13 = false;
                continue;
            }
            if (z13) {
                break;
            }
        }
        T t16 = t2;
        this.main = t16 != null ? t16.getValue() : null;
        Iterator<T> it3 = this.fields.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it3.next();
            if (t3.getId() == DynamicHoldingFieldID.LABEL1) {
                z12 = true;
                continue;
            } else {
                z12 = false;
                continue;
            }
            if (z12) {
                break;
            }
        }
        T t17 = t3;
        this.label1 = t17 != null ? t17.getValue() : null;
        Iterator<T> it4 = this.fields.iterator();
        while (true) {
            if (!it4.hasNext()) {
                t4 = null;
                break;
            }
            t4 = it4.next();
            if (t4.getId() == DynamicHoldingFieldID.VALUE1) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        T t18 = t4;
        this.value1 = t18 != null ? t18.getValue() : null;
        Iterator<T> it5 = this.fields.iterator();
        while (true) {
            if (!it5.hasNext()) {
                t5 = null;
                break;
            }
            t5 = it5.next();
            if (t5.getId() == DynamicHoldingFieldID.LABEL2) {
                z10 = true;
                continue;
            } else {
                z10 = false;
                continue;
            }
            if (z10) {
                break;
            }
        }
        T t19 = t5;
        this.label2 = t19 != null ? t19.getValue() : null;
        Iterator<T> it6 = this.fields.iterator();
        while (true) {
            if (!it6.hasNext()) {
                t6 = null;
                break;
            }
            t6 = it6.next();
            if (t6.getId() == DynamicHoldingFieldID.VALUE2) {
                z9 = true;
                continue;
            } else {
                z9 = false;
                continue;
            }
            if (z9) {
                break;
            }
        }
        T t20 = t6;
        this.value2 = t20 != null ? t20.getValue() : null;
        Iterator<T> it7 = this.fields.iterator();
        while (true) {
            if (!it7.hasNext()) {
                t7 = null;
                break;
            }
            t7 = it7.next();
            if (t7.getId() == DynamicHoldingFieldID.LABEL3) {
                z8 = true;
                continue;
            } else {
                z8 = false;
                continue;
            }
            if (z8) {
                break;
            }
        }
        T t21 = t7;
        this.label3 = t21 != null ? t21.getValue() : null;
        Iterator<T> it8 = this.fields.iterator();
        while (true) {
            if (!it8.hasNext()) {
                t8 = null;
                break;
            }
            t8 = it8.next();
            if (t8.getId() == DynamicHoldingFieldID.VALUE3) {
                z7 = true;
                continue;
            } else {
                z7 = false;
                continue;
            }
            if (z7) {
                break;
            }
        }
        T t22 = t8;
        this.value3 = t22 != null ? t22.getValue() : null;
        Iterator<T> it9 = this.fields.iterator();
        while (true) {
            if (!it9.hasNext()) {
                t9 = null;
                break;
            }
            t9 = it9.next();
            if (t9.getId() == DynamicHoldingFieldID.LABEL4) {
                z6 = true;
                continue;
            } else {
                z6 = false;
                continue;
            }
            if (z6) {
                break;
            }
        }
        T t23 = t9;
        this.label4 = t23 != null ? t23.getValue() : null;
        Iterator<T> it10 = this.fields.iterator();
        while (true) {
            if (!it10.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it10.next();
            if (t10.getId() == DynamicHoldingFieldID.VALUE4) {
                z5 = true;
                continue;
            } else {
                z5 = false;
                continue;
            }
            if (z5) {
                break;
            }
        }
        T t24 = t10;
        this.value4 = t24 != null ? t24.getValue() : null;
        Iterator<T> it11 = this.fields.iterator();
        while (true) {
            if (!it11.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it11.next();
            if (t11.getId() == DynamicHoldingFieldID.LABEL5) {
                z4 = true;
                continue;
            } else {
                z4 = false;
                continue;
            }
            if (z4) {
                break;
            }
        }
        T t25 = t11;
        this.label5 = t25 != null ? t25.getValue() : null;
        Iterator<T> it12 = this.fields.iterator();
        while (true) {
            if (!it12.hasNext()) {
                t12 = null;
                break;
            }
            t12 = it12.next();
            if (t12.getId() == DynamicHoldingFieldID.VALUE5) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        T t26 = t12;
        this.value5 = t26 != null ? t26.getValue() : null;
        Iterator<T> it13 = this.fields.iterator();
        while (true) {
            if (!it13.hasNext()) {
                t13 = null;
                break;
            }
            t13 = it13.next();
            if (t13.getId() == DynamicHoldingFieldID.LABEL6) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        T t27 = t13;
        this.label6 = t27 != null ? t27.getValue() : null;
        Iterator<T> it14 = this.fields.iterator();
        while (true) {
            if (!it14.hasNext()) {
                t14 = null;
                break;
            }
            t14 = it14.next();
            if (t14.getId() == DynamicHoldingFieldID.VALUE6) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t28 = t14;
        this.value6 = t28 != null ? t28.getValue() : str;
    }

    public final DynamicHoldingTemplateType getTemplateType() {
        return this.templateType;
    }

    public final DynamicHoldingTextStyle getTextStyle() {
        return this.textStyle;
    }

    public final List<DynamicHoldingField> getFields() {
        return this.fields;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMain() {
        return this.main;
    }

    public final String getLabel1() {
        return this.label1;
    }

    public final String getValue1() {
        return this.value1;
    }

    public final String getLabel2() {
        return this.label2;
    }

    public final String getValue2() {
        return this.value2;
    }

    public final String getLabel3() {
        return this.label3;
    }

    public final String getValue3() {
        return this.value3;
    }

    public final String getLabel4() {
        return this.label4;
    }

    public final String getValue4() {
        return this.value4;
    }

    public final String getLabel5() {
        return this.label5;
    }

    public final String getValue5() {
        return this.value5;
    }

    public final String getLabel6() {
        return this.label6;
    }

    public final String getValue6() {
        return this.value6;
    }
}

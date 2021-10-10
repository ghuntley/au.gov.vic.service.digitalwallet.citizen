package com.digitalwallet.app.viewmodel.main;

import android.text.Editable;
import androidx.databinding.ObservableField;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.model.Profile;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/NicknameViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "buttonEnabled", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getButtonEnabled", "()Landroidx/databinding/ObservableField;", "hasNickname", "getHasNickname", "()Z", "nickname", "", "getNickname", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/viewmodel/main/NicknameView;", "getView", "()Lcom/digitalwallet/app/viewmodel/main/NicknameView;", "setView", "(Lcom/digitalwallet/app/viewmodel/main/NicknameView;)V", "nicknameChanged", "", "e", "Landroid/text/Editable;", "save", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: NicknameViewModel.kt */
public final class NicknameViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion(null);
    private AuthenticationUtility authenticationUtility;
    private final ObservableField<Boolean> buttonEnabled = new ObservableField<>(Boolean.valueOf(getHasNickname()));
    private final ObservableField<String> nickname;
    public NicknameView view;

    @Inject
    public NicknameViewModel(AuthenticationUtility authenticationUtility2) {
        Intrinsics.checkNotNullParameter(authenticationUtility2, "authenticationUtility");
        this.authenticationUtility = authenticationUtility2;
        this.nickname = new ObservableField<>(Companion.defaultNickname(authenticationUtility2));
    }

    public final NicknameView getView() {
        NicknameView nicknameView = this.view;
        if (nicknameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        return nicknameView;
    }

    public final void setView(NicknameView nicknameView) {
        Intrinsics.checkNotNullParameter(nicknameView, "<set-?>");
        this.view = nicknameView;
    }

    public final ObservableField<String> getNickname() {
        return this.nickname;
    }

    public final ObservableField<Boolean> getButtonEnabled() {
        return this.buttonEnabled;
    }

    private final boolean getHasNickname() {
        String str = this.nickname.get();
        return !(str == null || StringsKt.isBlank(str));
    }

    public final void nicknameChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "e");
        this.buttonEnabled.set(Boolean.valueOf(getHasNickname()));
    }

    public final void save() {
        String str = this.nickname.get();
        if (str == null || StringsKt.isBlank(str)) {
            NicknameView nicknameView = this.view;
            if (nicknameView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
            }
            nicknameView.showWarning();
            return;
        }
        AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
        String str2 = this.nickname.get();
        Intrinsics.checkNotNull(str2);
        authenticationUtility2.setNickname(str2);
        NicknameView nicknameView2 = this.view;
        if (nicknameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        nicknameView2.done();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/NicknameViewModel$Companion;", "", "()V", "defaultNickname", "", "authUtil", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "generateNickname", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: NicknameViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String defaultNickname(AuthenticationUtility authenticationUtility) {
            Intrinsics.checkNotNullParameter(authenticationUtility, "authUtil");
            String nickname = authenticationUtility.getNickname();
            if (nickname.length() == 0) {
                nickname = NicknameViewModel.Companion.generateNickname(authenticationUtility);
            }
            return nickname;
        }

        private final String generateNickname(AuthenticationUtility authenticationUtility) {
            String name;
            List<String> split;
            String str;
            Profile profile = authenticationUtility.getProfile();
            if (profile == null || (name = profile.getName()) == null || (split = new Regex("\\s").split(name, 2)) == null) {
                return "";
            }
            if (split.isEmpty()) {
                str = "";
            } else if (split.size() == 1) {
                str = StringsKt.capitalize(split.get(0));
            } else {
                str = StringsKt.capitalize(split.get(0)) + ' ' + Character.toUpperCase(StringsKt.first(split.get(1)));
            }
            if (str != null) {
                return str;
            }
            return "";
        }
    }
}

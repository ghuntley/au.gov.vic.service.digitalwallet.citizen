package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;

/* compiled from: CapturedTypeConstructor.kt */
public interface CapturedTypeConstructor extends TypeConstructor, CapturedTypeConstructorMarker {
    TypeProjection getProjection();
}

package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* compiled from: JsonDataEncoderBuilder */
final /* synthetic */ class JsonDataEncoderBuilder$$Lambda$1 implements ObjectEncoder {
    private static final JsonDataEncoderBuilder$$Lambda$1 instance = new JsonDataEncoderBuilder$$Lambda$1();

    private JsonDataEncoderBuilder$$Lambda$1() {
    }

    public static ObjectEncoder lambdaFactory$() {
        return instance;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        JsonDataEncoderBuilder.lambda$static$0(obj, objectEncoderContext);
    }
}

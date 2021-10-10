package com.nimbusds.jose;

public interface PayloadTransformer<T> {
    T transform(Payload payload);
}

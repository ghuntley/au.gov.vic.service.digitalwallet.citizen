package com.github.ajalt.reprint.core;

public enum AuthenticationFailureReason {
    NO_HARDWARE,
    HARDWARE_UNAVAILABLE,
    NO_FINGERPRINTS_REGISTERED,
    SENSOR_FAILED,
    LOCKED_OUT,
    TIMEOUT,
    AUTHENTICATION_FAILED,
    UNKNOWN
}

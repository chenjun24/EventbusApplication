package com.cj.eventbusapplication.eventbus;

import androidx.annotation.NonNull;

public interface Emitter<T> {
    void onNext(@NonNull T value);

    void onError(@NonNull Throwable error);

    void onComplete();
}

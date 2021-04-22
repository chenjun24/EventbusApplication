package com.cj.eventbusapplication.eventbus;

import androidx.annotation.NonNull;

public interface ObservableOnSubscribe<T> {
    void subscribe(@NonNull Emitter<T> e);
}

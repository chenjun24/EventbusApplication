package com.cj.eventbusapplication.eventbus;

import androidx.annotation.NonNull;

public class CreateEmitter<T> implements Emitter<T> {
    private Observer<? super T> observer;

    public CreateEmitter(Observer<? super T> observer) {
        this.observer = observer;
    }

    @Override
    public void onNext(@NonNull T value) {
        observer.onNext(value);
    }

    @Override
    public void onError(@NonNull Throwable error) {
        observer.onError(error);
    }

    @Override
    public void onComplete() {
        observer.onComplete();
    }
}

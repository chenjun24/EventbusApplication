package com.cj.eventbusapplication.eventbus;

public abstract class Observable<T> implements ObservableSource<T>{

    @Override
    public final void subscribe(Observer<? super T> observer) {
         subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<? super T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
          return new ObservableCreate<>(source);
    }
}

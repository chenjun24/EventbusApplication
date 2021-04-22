package com.cj.eventbusapplication.eventbus;

public class ObservableCreate<T> extends Observable<T>{
    final ObservableOnSubscribe<T> observableOnSubscribe;

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.observableOnSubscribe = observableOnSubscribe;
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
         CreateEmitter<T> createEmitter = new CreateEmitter<T>(observer);
        observer.onSubscribe();
        observableOnSubscribe.subscribe(createEmitter);
    }
}

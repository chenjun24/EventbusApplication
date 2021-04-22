package com.cj.eventbusapplication.eventbus;

import androidx.annotation.NonNull;

public class TestRxJava {
    public static void main(String[] args){
       /* ObservableSource<Man> observableSource = new ObservableSource<Man>() {

            @Override
            public void subscribe(Observer<? super Man> observer) {

            }
        };
        Observer<Person> observer = new Observer<Person>() {

            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Person woman) {

            }


            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        observableSource.subscribe(observer);*/
        Observable.create(new ObservableOnSubscribe<Man>() {
            @Override
            public void subscribe(@NonNull Emitter<Man> e) {

            }
        }).subscribe(new Observer<Man>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Man man) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}

package com.cj.eventbusapplication.eventbus;

public interface Observer<T> {
  void onSubscribe();
  void onNext(T t);
  void onError(Throwable throwable);
  void onComplete();
}

package com.cj.eventbusapplication.eventbus;

public interface ObservableSource<T> {
   void subscribe(Observer<? super T> observer);
}

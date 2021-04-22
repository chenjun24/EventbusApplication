package com.cj.eventbusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cj.eventbusapplication.databinding.ActivityMainBinding;
import com.cj.eventbusapplication.eventbus.EventBusMgr;
import com.cj.eventbusapplication.eventbus.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBusMgr.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBusMgr.unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = false,priority = 1)
    public void onMessageEvent1(MessageEvent messageEvent){
        Log.d(TAG, "onMessageEvent1: msg--->"+messageEvent.msg+", current thread:"+Thread.currentThread().getName());
    }
    @Subscribe(threadMode = ThreadMode.ASYNC,sticky = false,priority = 2)
    public void onMessageEvent2(MessageEvent messageEvent){
        Log.d(TAG, "onMessageEvent2: msg--->"+messageEvent.msg+", current thread:"+Thread.currentThread().getName());
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND,sticky = false,priority = 3)
    public void onMessageEvent3(MessageEvent messageEvent){
        Log.d(TAG, "onMessageEvent3: msg--->"+messageEvent.msg+", current thread:"+Thread.currentThread().getName());
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = false,priority =4)
    public void onMessageEvent4(MessageEvent messageEvent){
        Log.d(TAG, "onMessageEvent4: msg--->"+messageEvent.msg+", current thread:"+Thread.currentThread().getName());
    }
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED,sticky = false,priority = 5)
    public void onMessageEvent5(MessageEvent messageEvent){
        Log.d(TAG, "onMessageEvent5: msg--->"+messageEvent.msg+", current thread:"+Thread.currentThread().getName());
    }

    public void send(View view) {
        EventBusMgr.post(new MessageEvent("event msg"));
    }

    public void testAsyncTask(View view) {
        new AsyncTask<Void,Void,Integer>(){

            @Override
            protected Integer doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled(Integer integer) {
                super.onCancelled(integer);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        }.execute();
    }
}
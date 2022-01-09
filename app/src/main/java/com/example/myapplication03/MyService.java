package com.example.myapplication03;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyService  extends IntentService {
    public MyService() {
        super("MyService");
    }
    //  functia pt calcul sir fibbonaci
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        String message = intent.getStringExtra("message");// iau stringul scris
        int  fibNum =Integer.parseInt(message);//  convertesc String la Int  pentru a face calculul termenului
        int messagef=fib(fibNum);// fac calculul
        intent.setAction(MainActivity4.FILTER_ACTION_KEY);
        //This wait can be for downloading, sending a request, decoding a file etc.
        SystemClock.sleep(5000);

        String resultMessage = "The Result String  after 6 seconds of processing.." + messagef;// afisez  mesajul( termenul calculate)
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent.putExtra("broadcastMessage", resultMessage));
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(getApplicationContext(), "Intent SERVICE CREATED", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Intent SERVICE DESTROYED", Toast.LENGTH_SHORT).show();
    }

}

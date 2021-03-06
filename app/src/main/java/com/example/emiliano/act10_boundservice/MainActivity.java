package com.example.emiliano.act10_boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Servicio mService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Intent intent = new Intent(this, Servicio.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
}

public void pararIntent(View view){
        if (mBound){
            unbindService((mConnection));
            mBound = false;
            Toast.makeText(this, "Servicio desconectado", Toast.LENGTH_SHORT).show();
    }
}

public void iniciarIntent(View view) {
    if (!mBound) {
        Intent intent = new Intent(this, Servicio.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        Toast.makeText(this, "Se inicio Servicio", Toast.LENGTH_SHORT).show();
    }
}
public void IniciarService(View view){
        if(mBound){
            pararIntent(View view);
        }else{
            iniciarIntent(View view);
        }
}
private ServiceConnection mConnection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        @Override
                public  void onServiceConnected(ComponentName className, IBinder service){
            Servicio.cliente binder = (Servicio.cliente) service;
            mService = binder.getService();
            mBound = true;
        }
        @Override
                public void onServiceDisconnected(ComponentName arg0){
            mBound = false;
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
}


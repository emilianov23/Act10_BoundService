package com.example.emiliano.act10_boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class Servicio extends Service {
    private  final Binder cli = new  cliente();

    public class  cliente extends  Binder{
        Servicio getService(){
            return  Servicio.this;
        }
    }
    public  Servicio(){

    }
    @Override
    public IBinder onBind(Intent intent){
        return  cli;
    }
}

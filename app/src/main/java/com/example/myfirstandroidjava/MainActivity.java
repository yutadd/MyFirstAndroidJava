package com.example.myfirstandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    boolean error=false;
    Socket s=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","helloworld");
        Thread th=new Thread(){

            @Override
            public void run(){
                while(!error){
                    try{
                    ServerSocket ss=new ServerSocket(25565);
                    s=ss.accept();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        th.start();
    }
}
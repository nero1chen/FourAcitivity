package com.example.csh.fouracitivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    String string;
   /* public void load(){
        FileInputStream in = null ;
        BufferedReader reader = null ;
        StringBuilder content = new StringBuilder();
        int a=0;
        try{
            in = openFileInput("XINXI.text");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine())!=null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        a++;
        if(a%2==0)
        string = content.toString();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnWrite = (Button)findViewById(R.id.button1);
        final EditText text1 = (EditText)findViewById(R.id.text1) ;
        final EditText text2 = (EditText)findViewById(R.id.text2) ;

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = 0 ;
                FileOutputStream out = null;
                BufferedWriter writer = null;
                FileInputStream in = null;
                BufferedReader reader = null;
                try{
                    in = openFileInput("X.txt");
                    reader = new BufferedReader(new InputStreamReader(in));
                    String line = "";
                    String number=text1.getText().toString();
                    //System.out.println("1");
                    while ((line = reader.readLine())!=null){
                        if(line.equals(number)){
                            //Log.d("save:",line+text1+line.equals(text1));
                            flag=1;
                            break;
                        }
                    }
                    if(flag == 0) {
                        out = openFileOutput("X.txt", Context.MODE_APPEND);
                        writer = new BufferedWriter(new OutputStreamWriter(out));
                        writer.write(text1.getText().toString() + "\r\n");
                        writer.write(text2.getText().toString() + "\r\n");
                    }
                    else
                        Toast.makeText(MainActivity.this, "存在相同学号", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try{
                        if(writer != null)
                            writer.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            /*    int flag=0;
                FileInputStream in = null;
                OutputStream out = null;
                try{
                    FileOutputStream fos=openFileOutput("X.txt",MODE_APPEND);
                    out = new BufferedOutputStream(new FileOutputStream(String.valueOf(fos)));
                    String text = text1.getText().toString()+"\r\n";
                    String text3 = text2.getText().toString()+"\r\n";
                    out.write(text.getBytes(StandardCharsets.UTF_8));
                    out.write(text3.getBytes(StandardCharsets.UTF_8));
                    /*try{
                        in = openFileInput("X.text");
                        reader = new BufferedReader(new InputStreamReader(in));
                        String line = "";
                        while ((line = reader.readLine())!=null){
                            if(line.equals(text)){
                                flag=1;
                                break;
                            }
                        }
                        if (flag == 0) {

                        }
                        else
                            Toast.makeText(MainActivity.this, "存在相同学号", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                    }*/
                }
        });
        Button btnRead = (Button)findViewById(R.id.button2);

            btnRead.setOnClickListener(new View.OnClickListener() {
         @Override
          /*    public void onClick(View v){
                BufferedReader reader = null;
                StringBuilder content = new StringBuilder();
                try{
                    FileInputStream in = openFileInput("MyFileName.text");
                    reader = new BufferedReader(new InputStreamReader(in));
                    String line = "";
                    while ((line = reader.readLine()) != null){
                        Toast.makeText(MainActivity.this, line, Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if (reader != null){
                        try{
                            reader.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                return;content.toString();
            }
            });*/
            public void onClick(View v) {
                FileInputStream in = null;
                int a = 0;
           //  String[] array = new String[100];
                BufferedReader reader = null;
                try {
                    in = openFileInput("X.txt");
                    reader = new BufferedReader(new InputStreamReader(in));
                    String line = "";
                    while ((line = reader.readLine()) != null) {

                        if (a%2 == 0) {
                            Toast.makeText(MainActivity.this, "学号" + line, Toast.LENGTH_SHORT).show();
                            // array[a] = line;

                        }
                            else
                            Toast.makeText(MainActivity.this,"姓名"+ line, Toast.LENGTH_SHORT).show();
                        a++;
                    }
                  /*  for (int b=0;b<a;b+=2){
                        for(int i = 0;i<100;i++) {
                            if (array[a] == array[i] && a != i) {
                                Toast.makeText(MainActivity.this, "存在相同学号", Toast.LENGTH_SHORT).show();
                                        break;
                            }
                        }
                    }*/
                }
                   catch(Exception e) {
                        e.printStackTrace();
                    }
                finally {
                    if (reader!=null){
                        try {
                        reader.close();
                    }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    /*     public void onClick(View v) {
             FileInputStream in = null;
             BufferedReader reader = null;
             StringBuilder content = new StringBuilder();
             try {
                 in = oepnFileInput("MyFlieName.text");
                 reader = new BufferedReader(new InputStreamReader(in));
                 String line = "";
                 while ((line = reader.readLine()) != null) {
                     content.append(line);
                 }
                 Toast.makeText(MainActivity.this, content.toString(), Toast.LENGTH_LONG).show();
             }
             catch (Exception e) {
                 e.printStackTrace();
             }
                 finally {
                     if(reader != null)
                         try {
                             reader.close();
                         }catch (Exception e){
                             e.printStackTrace();
                }
             }
         }*/

    }
}

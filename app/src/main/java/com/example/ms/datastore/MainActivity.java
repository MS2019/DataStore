package com.example.ms.datastore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private String MyFileName = "xxx.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btWrite = (Button)findViewById(R.id.bt_write);
        Button btRead = (Button)findViewById(R.id.bt_read);

        btWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream fileOutputStream = openFileOutput(MyFileName,MODE_PRIVATE);
                    OutputStream out = new BufferedOutputStream(fileOutputStream);
                    String content = "Number 2015010367 Name ms";
                    try {
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                    }finally {
                        if(out!=null){
                            out.close();
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        btRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream fileInputStream = openFileInput(MyFileName);
                    InputStream in = new BufferedInputStream(fileInputStream);

                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try{
                        while((c=in.read())!=-1){
                            stringBuilder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_SHORT).show();
                    }finally {
                        if(in!=null) in.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}

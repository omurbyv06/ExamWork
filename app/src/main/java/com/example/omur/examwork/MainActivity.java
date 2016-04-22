package com.example.omur.examwork;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    TextView mytextview;

    private ListView list ;
    private ArrayList<String> alist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button playmusic = (Button) findViewById(R.id.b1);
        mytextview = (TextView) findViewById(R.id.t1);

        playmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp = MediaPlayer.create(MainActivity.this, R.raw.vol1);
                mp.start();


            }
        });

        fileRead();

    }

    private void fileRead() {
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.city));
        String allText = "";
        while (scan.hasNext()) {
            String line = scan.nextLine();
            allText += line;
        }

        mytextview.setText(allText);
        scan.close();
    }




}
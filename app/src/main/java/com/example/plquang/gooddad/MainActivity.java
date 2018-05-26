package com.example.plquang.gooddad;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {
ImageView pop;
    int idpop ;
    private static  int SPLASH_TIME_OUT = 1000;
    ImageView imgCha;
ImageView img1,img2,img3,img4,img5;
    ProgressBar progressBar;
    ArrayList<Integer> ViecNha;
    ArrayList<Integer> LuaChon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ViecNha = new ArrayList<>();
        ViecNha.add(R.drawable.viecnha_1);
        ViecNha.add(R.drawable.viecnha_2);
        ViecNha.add(R.drawable.viecnha_3);
        ViecNha.add(R.drawable.viecnha_4);
        ViecNha.add(R.drawable.viecnha_5);
        progressBar.setProgress(0);
        XuLy();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LuaChon.get(0) != idpop)
                {
                    progressBar.setProgress(progressBar.getProgress()+10);
                }
                XuLy();
            }

        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LuaChon.get(1) != idpop) progressBar.setProgress(progressBar.getProgress()+10);
                XuLy();
            }

        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LuaChon.get(2) != idpop) progressBar.setProgress(progressBar.getProgress()+10);
                XuLy();
            }

        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LuaChon.get(3) != idpop) progressBar.setProgress(progressBar.getProgress()+10);
                XuLy();
            }

        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LuaChon.get(4) != idpop) progressBar.setProgress(progressBar.getProgress()+10);
                XuLy();
            }

        });

    }
    public void XuLy()
    {


        int i =0;
        if(progressBar.getProgress()==100) {
            imgCha.setImageResource(R.drawable.father_sad);

        }
        LuaChon = new ArrayList<>();
        while(i<5) {
            boolean flag = true;

            Random random = new Random();
            int rd = random.nextInt(5);
            for (int j = 0; j < i; j++)
                if (rd == LuaChon.get(j))
                    flag = false;

            if (flag) {
                LuaChon.add(rd);
                i++;
            }
        }
        Random random = new Random();
        int rd = random.nextInt(5);
        idpop=rd;

        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);

        img3.setVisibility(View.INVISIBLE);

        img4.setVisibility(View.INVISIBLE);

        img5.setVisibility(View.INVISIBLE);
        pop.setVisibility(View.INVISIBLE);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);

                img3.setVisibility(View.VISIBLE);

                img4.setVisibility(View.VISIBLE);

                img5.setVisibility(View.VISIBLE);
                pop.setVisibility(View.VISIBLE);

            }
        },SPLASH_TIME_OUT);

        pop.setImageResource(ViecNha.get(rd));
        img1.setImageResource(ViecNha.get(LuaChon.get(0)));
        img2.setImageResource(ViecNha.get(LuaChon.get(1)));
        img3.setImageResource(ViecNha.get(LuaChon.get(2)));
        img4.setImageResource(ViecNha.get(LuaChon.get(3)));
        img5.setImageResource(ViecNha.get(LuaChon.get(4)));



    }

    public void AnhXa()
    {pop=(ImageView) findViewById(R.id.pop);
       progressBar=(ProgressBar) findViewById(R.id.progressBarNong);
        img1=(ImageView) findViewById(R.id.imageView1);
        img2=(ImageView) findViewById(R.id.imageView2);
        img3=(ImageView) findViewById(R.id.imageView3);
        img4=(ImageView) findViewById(R.id.imageView4);
        img5=(ImageView) findViewById(R.id.imageView5);
        imgCha=(ImageView) findViewById(R.id.Cha);


    }
}

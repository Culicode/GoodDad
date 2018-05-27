package com.example.plquang.gooddad;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {
    ImageView pop;
    int idpop;
    public static String ket_qua;
     Animation myAnim;
    ArrayList<String> noidung;
    boolean isplaying;
    Dialog dialog;
     private static int SPLASH_TIME_OUT = 1000;
    ImageView imgCha;
    ImageView img1, img2, img3, img4, img5,sach1,sach2,sach3;
    ProgressBar progressBar;
    TextView diem, textcountdown;
    int Diem;
    int cd;

    ArrayList<Integer> ViecNha;
    ArrayList<Integer> LuaChon;
    long count = SPLASH_TIME_OUT;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
        noidung=new ArrayList<>();
        noidung.add("Nóng giận khiến bạn dễ xảy ra bạo lực và ngủ ở Sofa");
        noidung.add("Nóng giận khiến bạn mắc các bệnh về gan, tim mạch...");
        noidung.add("Nóng giận khiến bạn khó làm lành các mối quan hệ đổ vỡ.");
        Diem = 0;
        isplaying = true;
        AnhXa();

        diem.setText(String.valueOf(Diem));
        ViecNha = new ArrayList<>();
        ViecNha.add(R.drawable.viecnha_1);
        ViecNha.add(R.drawable.viecnha_2);
        ViecNha.add(R.drawable.viecnha_3);
        ViecNha.add(R.drawable.viecnha_4);
        ViecNha.add(R.drawable.viecnha_5);
        progressBar.setProgress(0);

        XuLy();
        startcd();
    sach1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             countDownTimer.cancel();
             progressBar.setProgress(progressBar.getProgress() - 30);

             showAlertDialog(noidung.get(0));
             sach1.setVisibility(View.INVISIBLE);
    }
});
sach2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        countDownTimer.cancel();
        progressBar.setProgress(progressBar.getProgress() - 30);
        showAlertDialog(noidung.get(1));
        sach2.setVisibility(View.INVISIBLE);
    }
});
sach3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        countDownTimer.cancel();
        progressBar.setProgress(progressBar.getProgress() - 30);
        showAlertDialog(noidung.get(2));
        sach3.setVisibility(View.INVISIBLE);
    }
});
        img1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

               img1.startAnimation(myAnim);
                if (LuaChon.get(0) != idpop) {
                    progressBar.setProgress(progressBar.getProgress() + 10);
                }
                else
                { progressBar.setProgress(progressBar.getProgress()- 5);
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
                myAnim.cancel();
            }

        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img2.startAnimation(myAnim);
                if (LuaChon.get(1) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {progressBar.setProgress(progressBar.getProgress()- 5);
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
                myAnim.cancel();
            }

        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img3.startAnimation(myAnim);
                if (LuaChon.get(2) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {progressBar.setProgress(progressBar.getProgress()- 5);
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
                myAnim.cancel();
            }

        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img4.startAnimation(myAnim);
                if (LuaChon.get(3) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {progressBar.setProgress(progressBar.getProgress()- 5);
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
                myAnim.cancel();
            }

        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img5.startAnimation(myAnim);
                if (LuaChon.get(4) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {progressBar.setProgress(progressBar.getProgress()- 5);
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
                myAnim.cancel();
            }

        });

    }

    public void startcd() {
        countDownTimer.start();
        cd = 20;
    }

    public void resetcd() {
        countDownTimer.cancel();

        countDownTimer.start();
        cd = 20;
    }
//    public void showDialog() {
//        dialog = new Dialog(MainActivity.this);
//        dialog.setTitle("Kết quả:");
//        dialog.setContentView();
//        dialog.show();
//    }

    public void XuLy() {
        int i = 0;
      //  if (isplaying == false)
      //      return;
        if (progressBar.getProgress() >= 100) {

            countDownTimer.cancel();
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
            img5.setVisibility(View.INVISIBLE);
            pop.setVisibility(View.INVISIBLE);
            imgCha.setImageResource(R.drawable.father_sad);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {  byExtras();}}, 1500);
            return ;
        }
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
        img3.setVisibility(View.VISIBLE);
        img4.setVisibility(View.VISIBLE);
        img5.setVisibility(View.VISIBLE);
        pop.setVisibility(View.VISIBLE);
        LuaChon = new ArrayList<>();

        while (i < 5) {
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
        idpop = rd;



        pop.setImageResource(ViecNha.get(rd));
        img1.setImageResource(ViecNha.get(LuaChon.get(0)));
        img2.setImageResource(ViecNha.get(LuaChon.get(1)));
        img3.setImageResource(ViecNha.get(LuaChon.get(2)));
        img4.setImageResource(ViecNha.get(LuaChon.get(3)));
        img5.setImageResource(ViecNha.get(LuaChon.get(4)));


    }
    public void showAlertDialog(String noidung){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tác hại nóng giận");
        builder.setMessage(noidung);
        builder.setCancelable(false);
        builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               startcd();
                XuLy();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void showAlertDialogKQ(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Kết Quả");
        builder.setMessage("Điểm: " + Diem);

        builder.setCancelable(false);
        builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startcd();
                XuLy();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        finish();

    }



    public void AnhXa() {
        pop = (ImageView) findViewById(R.id.pop);
        progressBar = (ProgressBar) findViewById(R.id.progressBarNong);
        textcountdown = (TextView) findViewById(R.id.countdown);
        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        imgCha = (ImageView) findViewById(R.id.Cha);
        sach1=(ImageView) findViewById(R.id.sach1);
        sach2=(ImageView) findViewById(R.id.sach2);
        sach3=(ImageView) findViewById(R.id.sach3);
        diem=(TextView) findViewById(R.id.textviewDiem);
        countDownTimer = new CountDownTimer(2000, 100) {
            @Override
            public void onTick(long l) {
                if (progressBar.getProgress() >= 100) {
                    cancel();
                    textcountdown.setText("");
                    return;
                }
                l = l - 100;
                textcountdown.setText(String.valueOf(l/1000) +'.'+ String.valueOf((l/100)%10));
            }

            @Override
            public void onFinish() {
                if (progressBar.getProgress() < 100)
                    startcd();
                else
                {
                    textcountdown.setText("");
                    return;
                }
                progressBar.setProgress(progressBar.getProgress()+10);
                XuLy();

            }
        };

    }

    public void byExtras(){
        overridePendingTransition(R.anim.out2,R.anim.in2);

        String d=String.valueOf(Diem);
        Intent intent2 = new Intent(MainActivity.this,Final.class);
        intent2.putExtra("ketqua",d);
        startActivity(intent2);
    }
}

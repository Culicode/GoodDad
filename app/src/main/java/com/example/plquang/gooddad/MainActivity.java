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
    ArrayList<String> noidung;
    boolean isplaying;
    Dialog dialog;
     private static int SPLASH_TIME_OUT = 1000;
    ImageView imgCha;
    ImageView img1, img2, img3, img4, img5,sach1,sach2,sach3;
    ProgressBar progressBar;
    TextView diem;
    int Diem;

    ArrayList<Integer> ViecNha;
    ArrayList<Integer> LuaChon;
    long count = SPLASH_TIME_OUT;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
               img1.startAnimation(myAnim);
                if (LuaChon.get(0) != idpop) {
                    progressBar.setProgress(progressBar.getProgress() + 10);
                }
                else
                {
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
            }

        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                img2.startAnimation(myAnim);
                if (LuaChon.get(1) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
            }

        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                img3.startAnimation(myAnim);
                if (LuaChon.get(2) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
            }

        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                img4.startAnimation(myAnim);
                if (LuaChon.get(3) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
            }

        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
                img5.startAnimation(myAnim);
                if (LuaChon.get(4) != idpop)
                    progressBar.setProgress(progressBar.getProgress() + 10);
                else
                {
                    Diem++;
                    diem.setText(String.valueOf(Diem));
                }
                XuLy();
                resetcd();
            }

        });
        startcd();
    }

    public void startcd() {
        countDownTimer.start();
    }

    public void resetcd() {
        countDownTimer.cancel();
        countDownTimer.start();
    }
//    public void showDialog() {
//        dialog = new Dialog(MainActivity.this);
//        dialog.setTitle("Kết quả:");
//        dialog.setContentView();
//        dialog.show();
//    }

    public void XuLy() {
        int i = 0;
        if (isplaying == false)
            return;
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
                public void run() {}}, 1000);
            isplaying = false;
           byExtras();
         //  Intent intent=new Intent(MainActivity.this,Final.class);
           // startActivity(intent);

            return ;
        }

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
                countDownTimer.start();
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
                countDownTimer.start();
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
        countDownTimer = new CountDownTimer(2500, 200) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressBar.setProgress(progressBar.getProgress()+10);
                XuLy();
                countDownTimer.start();
            }
        };

    }

    public void byExtras(){
        overridePendingTransition(R.anim.out,R.anim.in);

          String d=String.valueOf(Diem);
        Intent intent2 = new Intent(MainActivity.this,Final.class);
        intent2.putExtra("ketqua",d);
        startActivity(intent2);
    }
}

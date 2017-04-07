package com.example.a55.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView text;
    Button button4, button5, button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onStart () {
        super.onStart();
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button4.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        button6.setVisibility(View.INVISIBLE);

        text = (TextView)findViewById(R.id.textView1);

        SlowPrint("Хм..Похоже эта штука еще работает. Только..для чего она нужна? Нигде такие не видел\n");

        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        button4.setText("Промолчать"); button5.setText("Написать что-нибудь");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case (R.id.button4):
                        button4.setVisibility(View.INVISIBLE);
                        button5.setVisibility(View.INVISIBLE);
                        SlowPrint("Похоже на какой то механизм. Только очень компактный. Не зря хозяина дома называли профессором, раз он смог создать такое.\n");
                        SlowPrint("Только что он делает...\n");
                        button4.setVisibility(View.VISIBLE);
                        button5.setVisibility(View.VISIBLE);
                        button4.setText("Мне не менее интересно, что ты тут делаешь? Я думал это просто развлечение.");
                        button5.setText("Я способен на многое, а ты?");
                        button4.setVisibility(View.INVISIBLE);
                        button5.setVisibility(View.INVISIBLE);
                        break;
                    case (R.id.button5):
                        button4.setVisibility(View.INVISIBLE);
                        button5.setVisibility(View.INVISIBLE);
                        SlowPrint("О! Ты умеешь говорить? Возможно ты просто разумный механизм. Так для какой цели тебя собрали?\n");
                        SlowPrint("[Тихо] Профессор здесь явно не в пустую проводил столько времени. Может его и выгнали не зря...\n");
                        button6.setVisibility(View.VISIBLE);
                        button4.setVisibility(View.VISIBLE);
                        button5.setVisibility(View.VISIBLE);
                        button6.setText("Меня не собрали. Я родился, человек всё таки.");
                        button4.setText("А что тебе нужно?");
                        button5.setText("Универсальный помощник. Подходит в экстренных ситуациях.");
                        button6.setVisibility(View.INVISIBLE);
                        button4.setVisibility(View.INVISIBLE);
                        button5.setVisibility(View.INVISIBLE);
                        break;
                }

            }
        };

        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);

    }

    public void SlowPrint(String str) {
       final int PAUSE = 500;
       text = (TextView)findViewById(R.id.textView1);

           for (final char ch : str.toCharArray()) {
               /*text.append(Character.toString(ch));
               try {
                   Thread.sleep(PAUSE);
               }
               catch (InterruptedException e ) {}*/
               final Handler handler = new Handler();
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       // Do something after 500ms
                       text.append(Character.toString(ch));
                   }
               }, PAUSE);
           }
    }
}

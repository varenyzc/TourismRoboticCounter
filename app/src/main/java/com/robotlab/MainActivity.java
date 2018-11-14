package com.robotlab;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1_add,button1_remove,button2_add,button2_remove,button3_add,button3_remove,
        button4_add,button4_remove,button5_add,button5_remove,button6_add,button6_remove,button_amount,button_remove,
        button_timer1,button_timer2,button_timer3,button_stop;
    private TextView text1,text2,text3,text4,text5,text6,score;
    private int Score,score1,score2,score3,score4,score5,score6;
    private int recLen;
    private TextView timerView;
    Timer timer = new Timer();
    boolean Time =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1_add=findViewById(R.id.button1_add);
        button1_remove=findViewById(R.id.button1_remove);
        button2_add=findViewById(R.id.button2_add);
        button2_remove=findViewById(R.id.button2_remove);
        button3_add=findViewById(R.id.button3_add);
        button3_remove=findViewById(R.id.button3_remove);
        button4_add=findViewById(R.id.button4_add);
        button4_remove=findViewById(R.id.button4_remove);
        button5_add=findViewById(R.id.button5_add);
        button5_remove=findViewById(R.id.button5_remove);
        button6_add=findViewById(R.id.button6_add);
        button6_remove=findViewById(R.id.button6_remove);
        button_amount=findViewById(R.id.button_amount);
        button_remove=findViewById(R.id.button_remove);
        button_timer1=findViewById(R.id.button_time1);
        button_timer2=findViewById(R.id.button_time2);
        button_timer3=findViewById(R.id.button_time3);
        button_stop=findViewById(R.id.button_stop);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        text4=findViewById(R.id.text4);
        text5=findViewById(R.id.text5);
        text6=findViewById(R.id.text6);
        score=findViewById(R.id.score);
        timerView=findViewById(R.id.timerView);
        button1_add.setOnClickListener(this);
        button1_remove.setOnClickListener(this);
        button2_add.setOnClickListener(this);
        button2_remove.setOnClickListener(this);
        button3_add.setOnClickListener(this);
        button3_remove.setOnClickListener(this);
        button4_add.setOnClickListener(this);
        button4_remove.setOnClickListener(this);
        button5_add.setOnClickListener(this);
        button5_remove.setOnClickListener(this);
        button6_add.setOnClickListener(this);
        button6_remove.setOnClickListener(this);
        button_amount.setOnClickListener(this);
        button_remove.setOnClickListener(this);
        button_timer1.setOnClickListener(this);
        button_timer2.setOnClickListener(this);
        button_timer3.setOnClickListener(this);
        button_stop.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:{
                Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }break;
            case R.id.restart:{
                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }break;
            default:break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    ;   public TimerTask startTimer(){
    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    timerView.setText(""+recLen);
                    if(recLen == 0){
                            timer.cancel();
                            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                            long[] patter = {100, 1000, 1000, 1000};
                            vibrator.vibrate(patter, -1);
                            Toast.makeText(MainActivity.this,"时间到！",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        };
        return task;
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_time1:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Time==false){
                    recLen=101;
                    Time=true;
                    startTimer();
                    timer.schedule(startTimer(),0,1000);
                }
            }break;
            case R.id.button_time2:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Time==false){
                    recLen=131;
                    Time=true;
                    startTimer();
                    timer.schedule(startTimer(),0,1000);
                }
            }break;
            case R.id.button_time3:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if (Time == false) {
                    recLen=151;
                    Time=true;
                    startTimer();
                    timer.schedule(startTimer(),0,1000);
                }
            }break;
            case R.id.button_stop:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Time == true){
                    Time = false;
                    timer.cancel();
                    button_stop.setText("计时归零");
                }
                else if(Time == false){
                    Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            }break;
            case R.id.button1_add:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text1.getText().toString())<10){
                    score1+=1;Score+=15;text1.setText(Integer.toString(score1));}
            }break;
            case R.id.button1_remove:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text1.getText().toString())>0){
                    score1-=1;Score-=15;text1.setText(Integer.toString(score1));
                }break;}
            case R.id.button2_add:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text2.getText().toString())<2){
                    score2+=1;Score+=40;text2.setText(Integer.toString(score2));}
            }break;
            case R.id.button2_remove:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text2.getText().toString())>0){
                    score2-=1;Score-=40;text2.setText(Integer.toString(score2));
                }break;}
            case R.id.button3_add:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text3.getText().toString())<4){
                    score3+=1;Score+=90;text3.setText(Integer.toString(score3));}
            }break;
            case R.id.button3_remove:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text3.getText().toString())>0){
                    score3-=1;Score-=90;text3.setText(Integer.toString(score3));
                }break;}
            case R.id.button4_add:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text4.getText().toString())<10){
                    score4+=1;Score+=11;text4.setText(Integer.toString(score4));}
            }break;
            case R.id.button4_remove:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text4.getText().toString())>0){
                    score4-=1;Score-=11;text4.setText(Integer.toString(score4));
                }break;}
            case R.id.button5_add:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text5.getText().toString())<6){
                    score5+=1;Score+=1000;text5.setText(Integer.toString(score5));}
            }break;
            case R.id.button5_remove:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text5.getText().toString())>0){
                    score5-=1;Score-=1000;text5.setText(Integer.toString(score5));
                }break;}
            case R.id.button6_add:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text6.getText().toString())<2){
                    score6+=1;Score+=200;text6.setText(Integer.toString(score6));
                }
            }break;
            case R.id.button6_remove:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                if(Integer.parseInt(text6.getText().toString())>0){
                    score6-=1;Score-=200; text6.setText(Integer.toString(score6));
                }
            }break;
            case R.id.button_amount:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                score.setText(Integer.toString(Score));
            }break;
            case R.id.button_remove:{
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(20);
                text1.setText("0");
                text2.setText("0");
                text3.setText("0");
                text4.setText("0");
                text5.setText("0");
                text6.setText("0");
                score.setText("");
                score1=0;score2=0;score3=0;score4=0;score5=0;score6=0;Score=0;
            }break;
            default:break;
            }
        }
    }


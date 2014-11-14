package com.example.ingfuentes.mobileclassone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class AgeActivity extends Activity {
    TimerTask myTimerTask;
    Timer myTimer = new Timer();
    TextView textview;
    private int nCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        textview = (TextView)findViewById(R.id.myAge);
        textview.setText(getIntent().getStringExtra("value"));
        doTimerTask();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_age, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void nextView(View view){
        Intent next = new Intent(this,ImageActivity.class);
        startActivity(next);
    }

    public void doTimerTask(){
        myTimerTask = new TimerTask() {
            @Override
            public void run() {
                if(nCounter == 0)
                {
                    nCounter++;
                    textview.setTextColor(getResources().getColor(R.color.Red));
                }
                else if(nCounter == 1)
                {
                    textview.setTextColor(getResources().getColor(R.color.Green));
                    nCounter++;
                }
                else {
                    textview.setTextColor(getResources().getColor(R.color.Blue));
                    nCounter = 0;
                }
            }
        };
        myTimer.schedule(myTimerTask,200,500);
    }
}

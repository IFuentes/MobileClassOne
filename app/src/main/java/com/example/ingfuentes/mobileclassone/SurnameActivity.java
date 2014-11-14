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

public class SurnameActivity extends Activity {
    TimerTask myTimerTask;
    Timer myTimer = new Timer();
    TextView textview;
    private int nCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surname);
        textview = (TextView)findViewById(R.id.mySurname);
        textview.setText(getIntent().getStringExtra("value"));
        doTimerTask();
    } //Ends OnCreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_surname, menu);
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
        Intent next = new Intent(this,AgeActivity.class);
        startActivity(next);
    }

    public void doTimerTask(){
        myTimerTask = new TimerTask() {
            @Override
            public void run() {
                if(nCounter == 0)
                {
                    nCounter++;
                    textview.setText("");
                }
                else
                {
                    textview.setText(getIntent().getStringExtra("value"));
                    nCounter = 0;
                }
            }
        };
        myTimer.schedule(myTimerTask,200,500);
    }
}

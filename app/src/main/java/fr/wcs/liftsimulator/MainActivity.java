package fr.wcs.liftsimulator;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            new MoveLift().execute(floor);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                goToFloor(0);
                break;
            case R.id.button1:
                goToFloor(1);
                break;
            case R.id.button2:
                goToFloor(2);
                break;
            case R.id.button3:
                goToFloor(3);
                break;
            case R.id.button4:
                goToFloor(4);
                break;
            case R.id.button5:
                goToFloor(5);
                break;
            case R.id.button6:
                goToFloor(6);
                break;
            case R.id.button7:
                goToFloor(7);
                break;
            case R.id.button8:
                goToFloor(8);
                break;
            case R.id.button9:
                goToFloor(9);
                break;

        }
    }

 public class MoveLift extends AsyncTask <Integer, Void, Integer> {

     @Override
     protected Integer doInBackground(Integer... integers) {
         Integer floor = integers[0];
         SystemClock.sleep(3000);
         return floor;
     }

     @Override
     protected void onPostExecute(Integer floor) {
         super.onPostExecute(floor);
         isLiftMoving = true;
         currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
         TextView floorCount = (TextView) findViewById(R.id.floor_count);
         floorCount.setText(String.valueOf(currentFloor));
         moveNextFloor(floor);
         isLiftMoving = false;
     }

 }


}

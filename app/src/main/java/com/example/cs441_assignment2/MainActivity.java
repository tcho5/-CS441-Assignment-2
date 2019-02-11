package com.example.cs441_assignment2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private float downX, upX;
    private float downY, upY;
    private int MIN_DISTANCE = 70;
    private Button startButton, resetButton, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15;
    private List<Boolean> checkEmptyList;
    private List<Integer> valuesList;
   

    int value = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkEmptyList=new ArrayList<Boolean>(Arrays.asList(new Boolean[15]));
        valuesList = new ArrayList<Integer>(Arrays.asList(new Integer[15]));
        Collections.fill(checkEmptyList, Boolean.TRUE);
        Collections.fill(valuesList, 0);  //Initialize all values in buttons to 0's

        startButton = findViewById(R.id.startButton);
        resetButton = findViewById(R.id.resetButton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);

        startButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.startButton:
                startButton.setText("STARTED");
                checkEmptyList.set(11, Boolean.FALSE);
                checkEmptyList.set(13, Boolean.FALSE);
                valuesList.set(11, 2);
                valuesList.set(13, 2);
                button11.setText(Integer.toString(valuesList.get(11)));
                button13.setText(Integer.toString(valuesList.get(13)));
                break;
            case R.id.resetButton:
                startButton.setText("START");
                Collections.fill(checkEmptyList, Boolean.TRUE);
                Collections.fill(valuesList, 0);
                button0.setText("");
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
                button10.setText("");
                button11.setText("");
                button12.setText("");
                button13.setText("");
                button14.setText("");
                button15.setText("");
                break;
            case R.id.button0:
                button0.setText(Integer.toString(value));
                value *= 2;
                break;
            case R.id.button1:
                button0.setText(Integer.toString(value));
                value *= 2;
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
            case R.id.button11:
                break;
            case R.id.button12:
                break;
            case R.id.button13:
                break;
            case R.id.button14:
                break;
            case R.id.button15:
            default:
                value = 2;
                break;

        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                upX = event.getX();
                upY = event.getY();
                float deltaX = upX - downX;
                float deltaY = upY - downY;
                if(deltaX > MIN_DISTANCE){
                    Toast.makeText(this, "Left to Right swipe [Next]", Toast.LENGTH_SHORT).show ();
                }
                else if(Math.abs(deltaX) > MIN_DISTANCE){
                    Toast.makeText(this, "Right to Left swipe [Next]", Toast.LENGTH_SHORT).show ();
                }else if(deltaY > MIN_DISTANCE){
                    Toast.makeText(this, "Top to Bottom swipe [Next]", Toast.LENGTH_SHORT).show ();
                }else if(Math.abs(deltaY) > MIN_DISTANCE){
                    Toast.makeText(this, "Bottom to Top [Next]", Toast.LENGTH_SHORT).show ();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

}

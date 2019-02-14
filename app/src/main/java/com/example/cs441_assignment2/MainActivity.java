package com.example.cs441_assignment2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private float downX, upX;
    private float downY, upY;
    private int totalScore = 0;
    private int MIN_DISTANCE = 70;
    private int level = 0;
    private TextView currentScore;
    private Button startButton, resetButton, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15;
    private Button easyMode, hardMode;
    private List<Boolean> checkEmptyList;
    private List<Integer> valuesList;
    private List<Button> buttonList;

    public void bottomToTopSwipe(){
        int val;
        String stringval;
        for(int i = 0; i < 4; i++){
            if(buttonList.get(i+12).getText() == buttonList.get(i+8).getText() && buttonList.get(i+8).getText() != ""){
                stringval = buttonList.get(i+8).getText().toString();
                val = Integer.parseInt(stringval) * 2;
                totalScore += val;
                buttonList.get(i+12).setText("");
                buttonList.get(i+8).setText(String.valueOf(val));
                if(buttonList.get(i+4).getText() == buttonList.get(i).getText() && buttonList.get(i).getText() != ""){
                    stringval = buttonList.get(i).getText().toString();
                    val = Integer.parseInt(stringval) * 2;
                    totalScore += val;
                    buttonList.get(i+4).setText("");
                    buttonList.get(i).setText(String.valueOf(val));
                }
            }
            else if(buttonList.get(i+4).getText() == buttonList.get(i+8).getText() && buttonList.get(i+4).getText() != ""){
                buttonList.get(i+8).setText("");
                stringval = buttonList.get(i+4).getText().toString();
                val = Integer.parseInt(stringval) * 2;
                totalScore += val;
                buttonList.get(i+4).setText(String.valueOf(val));
            }
            else if(buttonList.get(i+4).getText() == buttonList.get(i).getText() && buttonList.get(i).getText() != ""){
                stringval = buttonList.get(i).getText().toString();
                val = Integer.parseInt(stringval) * 2;
                totalScore += val;
                buttonList.get(i+4).setText("");
                buttonList.get(i).setText(String.valueOf(val));
            }
        }
    }

    public void topToBottomSwipe(){
        int val;
        String stringVal;
        for(int i = 0; i < 4; i++){
            if(buttonList.get(i+4).getText() == buttonList.get(i) && buttonList.get(i).getText() != ""){
                stringVal = buttonList.get(i+4).getText().toString();
                val = Integer.parseInt(stringVal) * 2;
                totalScore += val;
                buttonList.get(i+4).setText(String.valueOf(val));
                buttonList.get(i).setText("");
                if(buttonList.get(i + 8).getText() == buttonList.get(i+12).getText() && buttonList.get(i+8).getText() != ""){
                    stringVal = buttonList.get(i+12).getText().toString();
                    val = Integer.parseInt(stringVal) * 2;
                    totalScore += val;
                    buttonList.get(i+12).setText(String.valueOf(val));
                    buttonList.get(i+8).setText("");
                }

            }
            else if(buttonList.get(i+4).getText() == buttonList.get(i+8).getText() && buttonList.get(i+4).getText() != ""){
                stringVal = buttonList.get(i+8).getText().toString();
                val = Integer.parseInt(stringVal) * 2;
                totalScore += val;
                buttonList.get(i+8).setText(String.valueOf(val));
                buttonList.get(i+4).setText("");
                
            }
            else if(buttonList.get(i+8).getText() == buttonList.get(i+12).getText() && buttonList.get(i+8).getText() != ""){
                stringVal = buttonList.get(i+12).getText().toString();
                val = Integer.parseInt(stringVal) * 2;
                totalScore += val;
                buttonList.get(i+12).setText(String.valueOf(val));
                buttonList.get(i+8).setText("");
                
            }
        }
    }

    public void rightToLeftSwipe(){
        int val;
        String stringVal;
        for(int i = 0; i < 16; i+=4){
            if(buttonList.get(i+3).getText() == buttonList.get(i+2).getText() && buttonList.get(i+3).getText() != ""){
                stringVal = buttonList.get(i+2).getText().toString();
                val = Integer.parseInt(stringVal) * 2;
                totalScore += val;
                buttonList.get(i+2).setText(String.valueOf(val));
                buttonList.get(i+3).setText("");
                if(buttonList.get(i+1).getText() == buttonList.get(i).getText() && buttonList.get(i).getText() != ""){
                    stringVal = buttonList.get(i).getText().toString();
                    val = Integer.parseInt(stringVal) * 2;
                    totalScore += val;
                    buttonList.get(i).setText(String.valueOf(val));
                    buttonList.get(i+1).setText("");
                }
            }
            else if(buttonList.get(i+1).getText() == buttonList.get(i+2).getText() && buttonList.get(i+1).getText() != ""){
                stringVal = buttonList.get(i+1).getText().toString();
                val = Integer.parseInt(stringVal) * 2;
                totalScore += val;
                buttonList.get(i+1).setText(String.valueOf(val));
                buttonList.get(i+2).setText("");
            }
            else if(buttonList.get(i).getText() == buttonList.get(i+1).getText() && buttonList.get(i).getText() != ""){
                stringVal = buttonList.get(i).getText().toString();
                val = Integer.parseInt(stringVal) * 2;
                totalScore += val;
                buttonList.get(i).setText(String.valueOf(val));
                buttonList.get(i+1).setText("");
            }
        }

    }

    public void leftToRightSwipe(){
            int val;
            String stringVal;
            for(int i = 0; i < 16; i+=4){
                if(buttonList.get(i).getText() == buttonList.get(i+1).getText() && buttonList.get(i).getText() != ""){
                    stringVal = buttonList.get(i).getText().toString();
                    val = Integer.parseInt(stringVal) * 2;
                    totalScore += val;
                    buttonList.get(i+1).setText(String.valueOf(val));
                    buttonList.get(i).setText("");
                    if(buttonList.get(i+2).getText() == buttonList.get(i+3).getText() && buttonList.get(i+2).getText() != ""){
                        stringVal = buttonList.get(i+2).getText().toString();
                        val = Integer.parseInt(stringVal) * 2;
                        totalScore += val;
                        buttonList.get(i+3).setText(String.valueOf(val));
                        buttonList.get(i+2).setText("");
                    }
                }
                else if(buttonList.get(i+1).getText() == buttonList.get(i+2).getText() && buttonList.get(i+1).getText() != ""){
                    stringVal = buttonList.get(i+1).getText().toString();
                    val = Integer.parseInt(stringVal) * 2;
                    totalScore += val;
                    buttonList.get(i+2).setText(stringVal.valueOf(val));
                    buttonList.get(i+1).setText("");
                }
                else if(buttonList.get(i+2).getText() == buttonList.get(i+3).getText() && buttonList.get(i+2).getText() != ""){
                    stringVal = buttonList.get(i+2).getText().toString();
                    val = Integer.parseInt(stringVal) * 2;
                    totalScore += val;
                    buttonList.get(i+3).setText(stringVal.valueOf(val));
                    buttonList.get(i+2).setText("");
                }
        }                                                                                                                   
    }

    public void shiftbottomToTop(){
        int ind = 0;
        int count = 0;
        while(true){
            if(ind%4==0 && ind != 0){
               if(0==count){
                   break;
               }
               ind = 0;
               count = 0;
            }
            if(buttonList.get(ind).getText() == "" && buttonList.get(ind+4).getText() != ""){
               buttonList.get(ind).setText(buttonList.get(ind+4).getText().toString());
               buttonList.get(ind+4).setText("");
               count+=1;
            }
            if(buttonList.get(ind + 4).getText() == "" && buttonList.get(ind+8).getText() != ""){
               buttonList.get(ind+4).setText(buttonList.get(ind+8).getText().toString());
               buttonList.get(ind+8).setText("");
               count+=1;
            }
            if(buttonList.get(ind + 8).getText() == "" && buttonList.get(ind+12).getText() != ""){
               buttonList.get(ind+8).setText(buttonList.get(ind+12).getText().toString());
               buttonList.get(ind+12).setText("");
               count+=1;
            }                                                                                  
            ind+=1;
        }
    }

    public void shiftTopToBottom(){
        int ind = 0;
        int count = 0;
        while(true){
            if(ind%4==0 && ind != 0){
               if(0==count){
                   break;
               }
               ind = 0;
               count = 0;
            }
            if(buttonList.get(ind).getText() != "" && buttonList.get(ind+4).getText() == ""){
               buttonList.get(ind+4).setText(buttonList.get(ind).getText().toString());
               buttonList.get(ind).setText("");
               count+=1;
            }
            if(buttonList.get(ind+4).getText() != "" && buttonList.get(ind+8).getText() == ""){
               buttonList.get(ind+8).setText(buttonList.get(ind+4).getText().toString());
               buttonList.get(ind+4).setText("");
               count+=1;
            }
            if(buttonList.get(ind+8).getText() != "" && buttonList.get(ind+12).getText() == ""){
               buttonList.get(ind+12).setText(buttonList.get(ind+8).getText().toString());
               buttonList.get(ind+8).setText("");
               count+=1;                                                                        
            }                                                                                   
            ind+=1;
        }
    }

    public void shiftRightToLeft(){
        int ind = 0;
        int count = 0;
        while(true){
            if(ind%16 == 0 && ind != 0){
                if(0==count){
                    break;
                }
                ind = 0;
                count = 0;
            }
            if(buttonList.get(ind + 1).getText() != "" && buttonList.get(ind).getText() == ""){
                buttonList.get(ind).setText(buttonList.get(ind+1).getText().toString());
                buttonList.get(ind+1).setText("");
                count+=1;
            }
            if(buttonList.get(ind + 2).getText() != "" && buttonList.get(ind+1).getText() == ""){
                buttonList.get(ind+1).setText(buttonList.get(ind+2).getText().toString());
                buttonList.get(ind+2).setText("");
                count+=1;
            }
            if(buttonList.get(ind+3).getText() != "" && buttonList.get(ind+2).getText() == ""){
                buttonList.get(ind+2).setText(buttonList.get(ind+3).getText().toString());
                buttonList.get(ind+3).setText("");
                count+=1;                                                                      
            }
            ind+=4;
        }
    }
    public void shiftLeftToRight(){
        int ind = 0;
        int count = 0;
        while(true){
            if(ind%16==0 && ind != 0){
                if(0==count){
                    break;
                }
                ind = 0;
                count = 0;
            }
            if(buttonList.get(ind + 1).getText() == "" && buttonList.get(ind).getText() != ""){
                buttonList.get(ind + 1).setText(buttonList.get(ind).getText().toString());
                buttonList.get(ind).setText("");
                count+=1;
            }
            if(buttonList.get(ind + 2).getText() == "" && buttonList.get(ind + 1).getText() != "") {
                buttonList.get(ind + 2).setText(buttonList.get(ind+1).getText().toString());
                buttonList.get(ind+1).setText("");
                count+=1;
            }
            if(buttonList.get(ind+3).getText() == "" && buttonList.get(ind+2).getText() != ""){
                buttonList.get(ind + 3).setText(buttonList.get(ind+2).getText().toString());
                buttonList.get(ind+2).setText("");
                count+=1;                                                                            
            }
            ind+=4;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentScore = findViewById(R.id.score);
        checkEmptyList = new ArrayList<Boolean>(Arrays.asList(new Boolean[16]));
        valuesList = new ArrayList<Integer>(Arrays.asList(new Integer[16]));
        buttonList = new ArrayList<Button>();
        Collections.fill(checkEmptyList, Boolean.TRUE);
        Collections.fill(valuesList, 0);  //Initialize all values in buttons to 0's
        easyMode = findViewById(R.id.easyMode);
        hardMode = findViewById(R.id.hardMode);
        
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
        Collections.addAll(buttonList, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15);
        startButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        easyMode.setOnClickListener(this);
        hardMode.setOnClickListener(this);
    }


    public void insertNew(){
        while(true){
            Random rand = new Random();
            int randomNumber = rand.nextInt(16);
            if(buttonList.get(randomNumber).getText() == ""){
                buttonList.get(randomNumber).setText("2");
                break;
            }
        }                                                     
    }
    public boolean checkGameOver(){
        boolean isGameOver = true;
        for(int i = 0; i < 16; i++){
            if(buttonList.get(i).getText() == ""){
                isGameOver = false;
            }
        }
        return isGameOver;
    }

    @Override
    public void onClick(View v) {
        String currentScoreString = "Score: 0"; 
        switch(v.getId()){
            case R.id.startButton:
                currentScore.setText(currentScoreString);
                totalScore = 0;
                checkEmptyList.set(11, Boolean.FALSE);
                checkEmptyList.set(13, Boolean.FALSE);
                valuesList.set(11, 2);
                valuesList.set(13, 2);
                buttonList.get(11).setText("2");
                buttonList.get(13).setText("2");
                buttonList.get(0).setText("");
                buttonList.get(1).setText("");
                buttonList.get(2).setText("");
                buttonList.get(3).setText("");
                buttonList.get(4).setText("");
                buttonList.get(5).setText("");
                buttonList.get(6).setText("");
                buttonList.get(7).setText("");
                buttonList.get(8).setText("");
                buttonList.get(9).setText("");
                buttonList.get(10).setText("");
                buttonList.get(12).setText("");
                buttonList.get(14).setText("");
                buttonList.get(15).setText("");
                break;
            case R.id.resetButton:
                currentScore.setText(currentScoreString);
                totalScore = 0;
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

            case R.id.easyMode:
                currentScore.setText(currentScoreString);
                totalScore = 0;
                checkEmptyList.set(11, Boolean.FALSE);
                checkEmptyList.set(13, Boolean.FALSE);
                valuesList.set(11, 2);
                valuesList.set(13, 2);
                buttonList.get(11).setText("1024");
                buttonList.get(13).setText("512");
                buttonList.get(0).setText("256");
                buttonList.get(1).setText("");
                buttonList.get(2).setText("");
                buttonList.get(3).setText("128");
                buttonList.get(4).setText("");
                buttonList.get(5).setText("");
                buttonList.get(6).setText("");
                buttonList.get(7).setText("");
                buttonList.get(8).setText("");
                buttonList.get(9).setText("");
                buttonList.get(10).setText("");
                buttonList.get(12).setText("");
                buttonList.get(14).setText("");
                buttonList.get(15).setText("256");
                level = -1;
                break;
            case R.id.hardMode:
                currentScore.setText(currentScoreString); 
                totalScore = 0;                           
                checkEmptyList.set(11, Boolean.FALSE);    
                checkEmptyList.set(13, Boolean.FALSE);    
                valuesList.set(11, 2);                    
                valuesList.set(13, 2);                    
                buttonList.get(11).setText("2");
                buttonList.get(13).setText("2");
                buttonList.get(0).setText("");
                buttonList.get(1).setText("");            
                buttonList.get(2).setText("-1");
                buttonList.get(3).setText("");
                buttonList.get(4).setText("");            
                buttonList.get(5).setText("");            
                buttonList.get(6).setText("-1");
                buttonList.get(7).setText("");            
                buttonList.get(8).setText("-1");
                buttonList.get(9).setText("");            
                buttonList.get(10).setText("-1");
                buttonList.get(12).setText("");           
                buttonList.get(14).setText("");           
                buttonList.get(15).setText("-1");
                level = 1;
                break;
            case R.id.button0:
                break;
            case R.id.button1:
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
                break;

        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        boolean checkGameOver;            
        String str;
        String currentScoreString = "Score: ";
        switch(event.getAction()){
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
                    shiftLeftToRight();
                    leftToRightSwipe();
                    checkGameOver = checkGameOver();                                           
                    if(checkGameOver==true){                                                   
                        Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show();          
                        return super.onTouchEvent(event);                                      
                    }                                                                          
                    shiftLeftToRight();
                    insertNew();
                    str = String.valueOf(totalScore);
                    currentScoreString += str;
                    currentScore.setText(currentScoreString);
//                    Toast.makeText(this, "Left to Right swipe [Next]", Toast.LENGTH_SHORT).show ();
                }
                else if(Math.abs(deltaX) > MIN_DISTANCE){
                    shiftRightToLeft();
                    rightToLeftSwipe();
                    checkGameOver = checkGameOver();                                           
                    if(checkGameOver==true){                                                   
                        Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show();          
                        return super.onTouchEvent(event);                                      
                    }                                                                          
                    shiftRightToLeft();
                    insertNew();
                    str = String.valueOf(totalScore);        
                    currentScoreString += str;               
                    currentScore.setText(currentScoreString);

//                    Toast.makeText(this, "Right to Left swipe [Next]", Toast.LENGTH_SHORT).show ();
                }else if(deltaY > MIN_DISTANCE){
                    shiftTopToBottom();
                    topToBottomSwipe();
                    checkGameOver = checkGameOver();                                           
                    if(checkGameOver==true){                                                   
                        Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show();          
                        return super.onTouchEvent(event);                                      
                    }                                                                          
                    shiftTopToBottom();
                    insertNew();;
                    str = String.valueOf(totalScore);        
                    currentScoreString += str;               
                    currentScore.setText(currentScoreString);
//                    Toast.makeText(this, "Top to Bottom swipe [Next]", Toast.LENGTH_SHORT).show ();
                }else if(Math.abs(deltaY) > MIN_DISTANCE){
                    shiftbottomToTop();
                    bottomToTopSwipe();
                    checkGameOver = checkGameOver();                                           
                    if(checkGameOver==true){                                                   
                        Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show();          
                        return super.onTouchEvent(event);                                      
                    }                                                                          
                    shiftbottomToTop();
                    insertNew();
                    str = String.valueOf(totalScore);        
                    currentScoreString += str;               
                    currentScore.setText(currentScoreString);
//                    Toast.makeText(this, "Bottom to Top [Next]", Toast.LENGTH_SHORT).show ();
                }
                break;
        }

        return super.onTouchEvent(event);
    }
}

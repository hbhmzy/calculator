package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_input;
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_clear;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divided;
    Button btn_point;
    Button btn_eql;
    Button btn_del;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_clear = findViewById(R.id.btn_clear);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divided = findViewById(R.id.btn_divided);
        btn_point = findViewById(R.id.btn_point);
        btn_eql = findViewById(R.id.btn_eql);
        btn_del = findViewById(R.id.btn_del);
        edit_input = findViewById(R.id.edit_input);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divided.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_eql.setOnClickListener(this);
        btn_del.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str=edit_input.getText().toString();
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if(flag){
                    flag=false;
                    str="";
                    edit_input.setText("");
                }
                edit_input.setText(str+((Button)v).getText());
                break;

            case R.id.btn_plus:
            case R.id.btn_divided:
            case R.id.btn_multiply:
            case R.id.btn_minus:
                if(flag){
                    flag=false;
                    str="";
                    edit_input.setText("");
                }
                edit_input.setText(str+" "+((Button)v).getText()+" ");
                break;

            case R.id.btn_del:
                if(flag) {
                    flag = false;
                    str = "";
                    edit_input.setText("");
                }else if (str!=null&&!str.equals("")){
                    edit_input.setText(str.substring(0,str.length()-1));
                }

                break;
            case R.id.btn_clear:
                edit_input.setText("");
                break;

            case R.id.btn_eql:
                Getresoult();
                break;

            default:
                break;
        }

        }

    private void Getresoult() {
        String exp=edit_input.getText().toString();
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(flag){
            flag=false;
            return;
        }
        flag=true;
        double result=0;
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        if(!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=d1+d2;

            }else if(op.equals("-")){
                result=d1-d2;

            }else if(op.equals("X")){
                result=d1*d2;

            }else if(op.equals("÷")){
                if(d2==0){
                    result=0;
                }else{
                    result=d1/d2;
                }

            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
                int r=(int)result;
                edit_input.setText(r+"");
            }else{
                edit_input.setText(result+"");
            }

        }else if(!s1.equals("")&&s2.equals("")){
            edit_input.setText(exp);
        }else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=0+d2;
            }else if(op.equals("-")){
                result=0-d2;
            }else if(op.equals("×")){
                result=0;
            }else if(op.equals("÷")){
                result=0;
            }
            if(!s2.contains(".")){
                int r=(int)result;
                edit_input.setText(r+"");
            }else{
                edit_input.setText(result+"");
            }
        }else{
            edit_input.setText("");
        }


    }

}


package com.example.project30516;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text1,text2;
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton rdodog,rdorab,rdocat;
    Button btnOK,btn1,btn2;
    ImageView imgpet;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = findViewById(R.id.Text1);
        chkAgree = findViewById(R.id.ChkAgree);
        text2 = findViewById(R.id.Text2);
        rGroup1 = findViewById(R.id.Rgroup);
        rdodog = findViewById(R.id.Rdodog);
        rdocat = findViewById(R.id.Rdocat);
        rdorab = findViewById(R.id.Rdorab);
        btnOK = findViewById(R.id.btnOK);
        imgpet = findViewById(R.id.Img);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked()==true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgpet.setVisibility(View.VISIBLE);
                }else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgpet.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.Rdodog:
                        imgpet.setImageResource(R.drawable.oreo);break;
                    case R.id.Rdocat:
                        imgpet.setImageResource(R.drawable.pie);break;
                    case R.id.Rdorab:
                        imgpet.setImageResource(R.drawable.q10);break;
                    default:
                        Toast.makeText(MainActivity.this,"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                chkAgree.setChecked(false);
                rdorab.setChecked(false);
                rdodog.setChecked(false);
                rdocat.setChecked(false);
                imgpet.setImageResource(0);
                break;
            case R.id.btn2:
                this.finish();
        }
    }
}
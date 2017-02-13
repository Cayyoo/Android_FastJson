package com.example.fastjson;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button tv_01,tv_02,tv_03,tv_04,tv_05,tv_06,tv_07;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();
    }

    public void initView(){
        tv_01= (Button) this.findViewById(R.id.tv_one);
        tv_02= (Button) this.findViewById(R.id.tv_two);
        tv_03= (Button) this.findViewById(R.id.tv_three);
        tv_04= (Button) this.findViewById(R.id.tv_four);
        tv_05= (Button) this.findViewById(R.id.tv_five);
        tv_06= (Button) this.findViewById(R.id.tv_six);
        tv_07= (Button) this.findViewById(R.id.tv_seven);

        tv_01.setOnClickListener(this);
        tv_02.setOnClickListener(this);
        tv_03.setOnClickListener(this);
        tv_04.setOnClickListener(this);
        tv_05.setOnClickListener(this);
        tv_06.setOnClickListener(this);
        tv_07.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_one:
                JSonUtils.JSONArrayMethod();
                Toast.makeText(this,"JSONArray",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_two:
                JSonUtils.JSONObjectMethod();
                Toast.makeText(this,"JSONObject",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_three:
                JSonUtils.parseMethod();
                Toast.makeText(this,"parse",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_four:
                JSonUtils.parseObjectMethod();
                Toast.makeText(this,"parseObject",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_five:
                JSonUtils.parseArrayMethod();
                Toast.makeText(this,"parseArray",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_six:
                JSonUtils.toJSONMethod();
                Toast.makeText(this,"toJSON",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_seven:
                JSonUtils.toJsonStringMethod();
                Toast.makeText(this,"toJsonString",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}

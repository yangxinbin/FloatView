package com.example.yangxb.floatview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_on;
    private Button btn_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        btn_on = (Button) findViewById(R.id.btn_on);
        btn_on.setOnClickListener(this);
        btn_off = (Button) findViewById(R.id.btn_off);
        btn_off.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent mIntent = new Intent(MainActivity.this, MainService.class);;
        switch (v.getId()) {
            case R.id.btn_on:
                mIntent.putExtra(MainService.OPERATION, MainService.OPERATION_SHOW);
                startService(mIntent);
                Toast.makeText(MainActivity.this, "悬浮框已开启~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_off:
                stopService(mIntent);
                Toast.makeText(MainActivity.this, "悬浮框已关闭~", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

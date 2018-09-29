package com.example.zhaohaojie.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class Main2Activity extends AppCompatActivity {

    private TextView mOffTextView;
    private Handler mOffHandler;
    private Timer mOffTime;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        //获取按钮的数据
        Button button_close = findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 添加按钮响应事件
                Toast.makeText(Main2Activity.this,"this will close soon.",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        //获取上一个activity的数据
        Intent it = getIntent();
        Integer time  = it.getIntExtra("length",0);
        Toast.makeText(this, "从上一个activity中获取的事件参数 ： "+time, Toast.LENGTH_LONG).show();
    }

//    void initDialog(){
//
//        mOffTextView = new TextView(this);
//
//        mDialog = new AlertDialog.Builder(this)
//                .setTitle("提示")
//                .setCancelable(false)
//                .setView(mOffTextView) ////
//
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        mOffTime.cancel();
//                        off();////关闭后的一些操作
//                    }
//                })
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                        mOffTime.cancel();
//                    }
//                })
//                .create();
//        mDialog.show();
//        mDialog.setCanceledOnTouchOutside(false);
//
//        mOffHandler = new Handler() {
//            public void handleMessage(Message msg) {
//
//                if (msg.what > 0) {
//
//                    //动态显示倒计时
//                    mOffTextView.setText("    即将关闭："+msg.what);
//
//                } else {
//                    //倒计时结束自动关闭
//
//                    if(mDialog!=null){
//                        mDialog.dismiss();
//                    }
//                    off();//关闭后的操作
//
//                    mOffTime.cancel();
//                }
//                super.handleMessage(msg);
//            }
//
//        };
//
//        //////倒计时
//
//        mOffTime = new Timer(true);
//        TimerTask tt = new TimerTask() {
//            int countTime = 10;
//            public void run() {
//                if (countTime > 0) {
//                    countTime--;
//                }
//                Message msg = new Message();
//                msg.what = countTime;
//                mOffHandler.sendMessage(msg);
//            }
//        };
//        mOffTime.schedule(tt, 1000, 1000);
//    }

}

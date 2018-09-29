package com.example.zhaohaojie.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * 如果不设置AndroidManifest.xml 中的
     * <intent-filter>
     *              <action android:name="android.intent.action.MAIN" />
     *              <category android:name="android.intent.category.LAUNCHER" />
     * </intent-filter>
     *
     * 就不能加载主活动，只有支付宝活动才会有挂起的程序。
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加lay层
        setContentView(R.layout.first_layout);
        // 添加button
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent virtualIntent = new Intent("com.example.activitytest.ACTION_START");
                virtualIntent.putExtra("length",12);
                virtualIntent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(virtualIntent);
//                Intent toIntent = new Intent(MainActivity.this,Main2Activity.class);
//                toIntent.putExtra("length",22);
//                startActivity(toIntent);

            }
        });
    }

    // 添加自定义菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     *  定义菜单点击响应事件
     *  1.关闭主线程
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"u click add",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"u click remove",Toast.LENGTH_LONG).show();
                break;
            case R.id.close_item:
                //关闭activity
                finish();
                break;
            default:
        }
        return true;
    }
}

package com.example.leiyang.mynotification;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by LeiYang on 2016/8/12 0012.
 */
public class MyTest extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mytest);

    }

    public void doClick(View view) {
        Toast.makeText(this, "You Are The Best!", Toast.LENGTH_SHORT).show();
    }
}

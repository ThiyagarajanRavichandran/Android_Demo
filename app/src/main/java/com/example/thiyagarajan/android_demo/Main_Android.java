package com.example.thiyagarajan.android_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.intent.Intent_Demo;
import com.example.toolbar.ToolBar_Demo;

public class Main_Android extends ActionBarActivity implements View.OnClickListener {
    Button bn_ToolBar = null, bn_Intent = null;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__android);
        findViewById();
        setOnclickListener(this);

    }

    private void setOnclickListener(Main_Android main_android) {
        bn_ToolBar.setOnClickListener(main_android);
        bn_Intent.setOnClickListener(main_android);
    }

    private void findViewById() {
        bn_ToolBar = (Button) findViewById(R.id.bn_ToolBar);
        bn_Intent = (Button) findViewById(R.id.bn_Intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main__android, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bn_ToolBar:
                intent = new Intent(Main_Android.this, ToolBar_Demo.class);
                break;
            case R.id.bn_Intent:
                intent = new Intent(Main_Android.this, Intent_Demo.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}

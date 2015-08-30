package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.thiyagarajan.android_demo.R;

public class Intent_Demo extends ActionBarActivity implements View.OnClickListener {
Button bn_Sms=null;
    Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent__demo);
        findViewById();
        setOnclickListener(this);
    }
private void findViewById()
    {
        bn_Sms=(Button)findViewById(R.id.bn_Sms);
    }
    private void setOnclickListener(Intent_Demo intent_demo) {
        bn_Sms.setOnClickListener(intent_demo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent__demo, menu);
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
switch (v.getId())
{
    case R.id.bn_Sms:
intent=new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:"));
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address", new String("0123456789;3393993300"));
        intent.putExtra("sms_body","Hai");
        break;
}
        startActivity(intent);
    }
}

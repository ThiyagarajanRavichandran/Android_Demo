package com.example.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thiyagarajan.android_demo.R;

public class ToolBar_Demo extends ActionBarActivity {

    Toolbar toolbar = null;
    Intent intent = null;
    Navigation_Fragment navigation_fragment = null;
    DrawerLayout drawerLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar__demo);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        navigation_fragment = (Navigation_Fragment) getSupportFragmentManager().findFragmentById(R.id.Navigation_fragment);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation_fragment.setup(R.id.Navigation_fragment, drawerLayout, toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tool_bar__demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:

                break;
            case R.id.next:
                intent = new Intent(ToolBar_Demo.this, Menu_Next.class);
                startActivity(intent);
                break;
        }
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}

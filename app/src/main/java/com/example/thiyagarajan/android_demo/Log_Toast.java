package com.example.thiyagarajan.android_demo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by THIYAGARAJAN on 20-08-2015.
 */
public class Log_Toast {

    public static void Toast(Context context,String sMessage)
    {
        Toast.makeText(context,sMessage,Toast.LENGTH_SHORT).show();
    }
}

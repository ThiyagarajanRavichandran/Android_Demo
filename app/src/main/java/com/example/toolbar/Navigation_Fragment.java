package com.example.toolbar;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thiyagarajan.android_demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Navigation_Fragment extends Fragment {

    private ActionBarDrawerToggle actionBarDrawerToggle = null;
    private DrawerLayout drawerLayout = null;
    public static final String sFile_PrefName = "My_Pref";
    public static final String sKEY_USER_LERANED = "user_drawer_learned";
    public boolean mUser_Drawer;
    public boolean onSavedInstance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    View viewgroup;

    public Navigation_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser_Drawer = Boolean.valueOf(readFrompref(getActivity(), sKEY_USER_LERANED, "false"));
        if (savedInstanceState != null) {
            onSavedInstance = true;
        } else {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_, container, false);
    }


    public void setup(int iNavigation_FragmentId, final DrawerLayout drawerLayout, final Toolbar toolbar) {
        this.drawerLayout = drawerLayout;
        viewgroup = getActivity().findViewById(iNavigation_FragmentId);
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                
                getActivity().invalidateOptionsMenu();
                
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
if (!mUser_Drawer) {
                    mUser_Drawer = true;
                    storedTopref(getActivity(), sKEY_USER_LERANED, mUser_Drawer + "");
                }
                getActivity().invalidateOptionsMenu();
                
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset<0.6)
                {
                    toolbar.setAlpha(1-slideOffset);
                }
            }
        };

        if (!mUser_Drawer && !onSavedInstance) {
            drawerLayout.openDrawer(viewgroup);
        }
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();
            }
        });

    }

    public void storedTopref(Context context, String sPref_Name, String sPref_Value) {
        sharedPreferences = context.getSharedPreferences(sFile_PrefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(sPref_Name, sPref_Value);
        editor.apply();
    }

    public String readFrompref(Context context, String sPref_Name, String sDefalut_Value) {
        sharedPreferences = context.getSharedPreferences(sFile_PrefName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(sPref_Name, sDefalut_Value);
    }
}

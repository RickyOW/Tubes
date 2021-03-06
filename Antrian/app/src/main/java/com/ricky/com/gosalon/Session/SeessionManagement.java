package com.ricky.com.gosalon.Session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ricky.com.gosalon.LoginActivity;

import java.util.HashMap;

public class SeessionManagement {

    private SharedPreferences mSharedPreferences;//Shred preferences
    private  SharedPreferences.Editor mEditor;//editor for sp
    Context mContext;//contect
    int PRIVATE_MODE;//shred pref mode

    private static final String PREF_NAME = "SharedPrefLatihan";
    private static final String IS_LOGIN = "Isloggedin";
    public static final String KEY_ID = "id";
    public static final String KEY_LEVEL = "level";
//    private static final String KEY_PASSWORD = "password";


    public SeessionManagement(Context mContext){
        this.mContext = mContext;
        mSharedPreferences = this.mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mSharedPreferences.edit();
    }

    public void createLoginSession(String id, String level){
        mEditor.putBoolean(IS_LOGIN,true);
        mEditor.putString(KEY_ID, id);
        //mEditor.putString(KEY_PASSWORD,pass);
        mEditor.putString(KEY_LEVEL,level );
        mEditor.commit();
    }
    public HashMap<String, String> getUserInformation(){

        HashMap<String,String> user = new HashMap<String, String>();
        // user id
        user.put(KEY_ID, mSharedPreferences.getString(KEY_ID, null));
        // user nama
        //user.put(KEY_ID, mSharedPreferences.getString(KEY_ID, null));
        return user;
    }

    public HashMap<String, String> getLevelInformation(){

        HashMap<String,String> user = new HashMap<String, String>();
        // user id
        user.put(KEY_ID, mSharedPreferences.getString(KEY_ID, null));
//         user level
        user.put(KEY_LEVEL, mSharedPreferences.getString(KEY_LEVEL, null));
//         return user
        return user;
    }
    public boolean isLoggedIn(){
        return mSharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();
        Intent i = new Intent(mContext, LoginActivity.class);
        mEditor.putBoolean(IS_LOGIN,false);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);


    }

}

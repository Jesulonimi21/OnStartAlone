package com.jesulonimi.user.onstartalone;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=getSharedPreferences("prefs",MODE_PRIVATE);
        boolean value=sharedPreferences.getBoolean("firstStart",true);
        if(value){
            showAlertDialog();
        }

    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this).
                setTitle("Only on first start")
                .setMessage("please dismiss")
                .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sharedPreferences=getSharedPreferences("prefs",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putBoolean("firstStart",false);
                        editor.apply();
                        dialog.dismiss();
                    }
                }).create().show();

    }
}

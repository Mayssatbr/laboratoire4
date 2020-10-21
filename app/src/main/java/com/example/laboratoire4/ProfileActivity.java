package com.example.laboratoire4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.EditText;
import android.view.View;
import android.util.Log;


public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void SetTeamIcon(View view){
        Intent returnIntent=new Intent();
        ImageView selectedImage=(ImageView)view;
        returnIntent.putExtra("imageID",selectedImage.getId());
        setResult(RESULT_OK,returnIntent);
        finish();

    }

}
package com.example.laboratoire4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Intent data;
    private int requestCode;
    private int resultCode;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        protected void onActivityResult( int requestCode,int resultCode,Intent data) {
            this.requestCode = requestCode;
            this.resultCode = resultCode;
            this.data = data;

            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_CANCELED) return;
            ImageView avatarImage = (ImageView) findViewById(R.id.avatar);
            String drawableName = "avatar";
            switch (data.getIntExtra("imageID", R.id.avatar)) {
                case R.id.avatar:
                    drawableName = "avatar";
                    break;
                case R.id.bmw:
                    drawableName = "bmw";
                    break;
                case R.id.mercedes:
                    drawableName = "mercedes";
                    break;
                case R.id.porshe:
                    drawableName = "porshe";
                    break;
                case R.id.maserati:
                    drawableName = "maserati";
                    break;
                case R.id.ferrari:
                    drawableName = "ferrari";
                    break;
                default:
                    drawableName="avatar";
                    break;
            }
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);

        }

        public void OnOpenInGoogleMaps(View view){
            EditText brandAddress=(EditText)findViewById(R.id.zip_code);
            Uri gmmIntentUri=Uri.parse("http://maps.google.co.in/maps?q="+brandAddress.getText());
            Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        public void OnSetAvatarButton(View view){
            Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
            startActivityForResult(intent,0);

        }





}
package com.mike.intents;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class SecondActivity extends AppCompatActivity {
    Button songa, calling, messaging, mailing, picture, sharing, dialing, mpesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        songa = findViewById(R.id.btnmove);
        calling = findViewById(R.id.btncall);
        messaging = findViewById(R.id.btnsms);
        mailing = findViewById(R.id.btnmail);
        picture = findViewById(R.id.btncamera);
        sharing = findViewById(R.id.btnshare);
        dialing = findViewById(R.id.btndial);
        mpesa = findViewById(R.id.btnpesa);
        songa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        calling.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent piga = new Intent(Intent.ACTION_CALL);
                piga.setData(Uri.parse("tel:0710326580"));

                startActivity(piga);
            }
        });
        messaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri tumasms = Uri.parse("tel:0710326580");
                Intent sms = new Intent(Intent.ACTION_VIEW,tumasms);
                sms.putExtra("sms_body","Niaje Brathe");
                sms.setType("vnd.android-dir/mms-sms");
                startActivity(sms);
            }
        });
        mailing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent sendmail = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","mikemutuma664@gmail.com",null));
               sendmail.putExtra(Intent.EXTRA_SUBJECT,"Job Application");
               sendmail.putExtra(Intent.EXTRA_TEXT,"This is my body");
               startActivity(Intent.createChooser(sendmail,"You are sending an email"));
            }
        });
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takepic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takepic,0);
            }
        });
        sharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"Download app on www.xxx.com");
                share.setType("text/plain");
                startActivity(share);
            }
        });
        dialing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent piga = new Intent(Intent.ACTION_DIAL);
                piga.setData(Uri.parse("tel:"));
                startActivity(piga);
            }
        });
        mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pesa = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if (pesa !=null){
                    startActivity(pesa);
                }else {
                    Toast.makeText(SecondActivity.this, "No STK Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

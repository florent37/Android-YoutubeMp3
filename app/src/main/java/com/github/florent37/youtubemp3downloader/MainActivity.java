package com.github.florent37.youtubemp3downloader;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(0, 0);

        final Intent intent = getIntent();
        if (intent != null) {
            final Bundle extras = intent.getExtras();
            if (extras != null) {
                final String url = extras.getString("android.intent.extra.TEXT");
                new RxPermissions(this)
                        .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(aBoolean -> {
                            startService(new Intent(MainActivity.this, MainService.class)
                                    .putExtra(MainService.URL, url)
                            );
                            intent.getExtras().clear();
                            finish();
                        });
            } else {
                finish();
            }
        } else {
            finish();
        }
    }
}

package com.github.florent37.youtubemp3downloader;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.github.florent37.youtubemp3downloader.dagger.AppComponent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainService extends IntentService {

    public static final String URL = "URL";
    @Inject
    DownloadPresenter downloadPresenter;

    public MainService() {
        super("MainService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(getApplicationContext(), "downloading... :", Toast.LENGTH_LONG).show());

        if (downloadPresenter == null) {
            AppComponent.from(this).inject(this);
        }
        final String stringExtra = intent.getStringExtra(URL);
        downloadPresenter.download(stringExtra)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(video -> {
                    Toast.makeText(getApplicationContext(), "downloaded :" + video.getTitle(), Toast.LENGTH_SHORT).show();
                }, throwable -> {
                    Toast.makeText(getApplicationContext(), "error :" + stringExtra, Toast.LENGTH_SHORT).show();
                });
    }


}

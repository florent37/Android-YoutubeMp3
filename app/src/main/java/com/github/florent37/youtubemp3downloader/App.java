package com.github.florent37.youtubemp3downloader;

import android.app.Application;

import com.github.florent37.youtubemp3downloader.dagger.AppComponent;
import com.github.florent37.youtubemp3downloader.dagger.AppModule;
import com.github.florent37.youtubemp3downloader.dagger.DaggerAppComponent;

/**
 * Created by florentchampigny on 17/03/2017.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

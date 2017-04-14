package com.github.florent37.youtubemp3downloader.dagger;

import android.content.Context;

import com.github.florent37.youtubemp3downloader.App;
import com.github.florent37.youtubemp3downloader.MainActivity;
import com.github.florent37.youtubemp3downloader.MainService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by florentchampigny on 17/03/2017.
 */

@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {

    public static AppComponent from(Context context){
        return ((App) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(MainActivity mainActivity);

    public abstract void inject(MainService mainService);
}

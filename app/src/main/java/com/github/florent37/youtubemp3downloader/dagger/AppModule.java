package com.github.florent37.youtubemp3downloader.dagger;

import android.content.Context;

import com.github.florent37.youtubemp3downloader.repository.UrlRepository;
import com.github.florent37.youtubemp3downloader.repository.UrlRepositoryImpl;
import com.github.florent37.youtubemp3downloader.repository.FileDownloaderRepository;
import com.github.florent37.youtubemp3downloader.repository.FileDownloaderRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by florentchampigny on 17/03/2017.
 */

@Module
public class AppModule {

    private final Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @Singleton
    public Context provideAppContext() {
        return appContext;
    }

    @Provides
    public UrlRepository provideDownloadRepository(OkHttpClient okHttpClient) {
        return new UrlRepositoryImpl(okHttpClient);
    }

    @Provides
    public FileDownloaderRepository provideFileDownloaderRepository(OkHttpClient okHttpClient) {
        return new FileDownloaderRepositoryImpl(okHttpClient);
    }

}

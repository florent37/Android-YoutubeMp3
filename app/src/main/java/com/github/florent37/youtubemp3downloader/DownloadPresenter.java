package com.github.florent37.youtubemp3downloader;

import android.content.Context;
import android.util.Log;

import com.github.florent37.youtubemp3downloader.repository.FileDownloaderRepository;
import com.github.florent37.youtubemp3downloader.repository.UrlRepository;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by florentchampigny on 17/03/2017.
 */

public class DownloadPresenter {

    private final Context appContext;
    private final UrlRepository urlRepository;
    private final FileDownloaderRepository fileDownloaderRepository;

    @Inject
    public DownloadPresenter(Context appContext, UrlRepository urlRepository, FileDownloaderRepository fileDownloaderRepository) {
        this.appContext = appContext;
        this.urlRepository = urlRepository;
        this.fileDownloaderRepository = fileDownloaderRepository;
    }

    public Observable<Video> download(String youtubeShared) {
        return urlRepository.getDownloadUrl(youtubeShared)
                .flatMap((video) -> fileDownloaderRepository.download(appContext, video));
    }
}

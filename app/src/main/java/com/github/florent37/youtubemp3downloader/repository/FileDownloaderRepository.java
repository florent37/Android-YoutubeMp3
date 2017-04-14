package com.github.florent37.youtubemp3downloader.repository;

import android.content.Context;

import com.github.florent37.youtubemp3downloader.Video;

import java.io.File;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by florentchampigny on 17/03/2017.
 */

public interface FileDownloaderRepository {

    Observable<Video> download(Context context, Video video);
}

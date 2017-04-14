package com.github.florent37.youtubemp3downloader.repository;

import com.github.florent37.youtubemp3downloader.model.Video;

import io.reactivex.Observable;

/**
 * Created by florentchampigny on 17/03/2017.
 */

public interface UrlRepository {

    Observable<Video> getDownloadUrl(String youtubeUrl);

}

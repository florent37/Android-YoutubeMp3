package com.github.florent37.youtubemp3downloader.repository;

import com.github.florent37.youtubemp3downloader.RxOkHttp;
import com.github.florent37.youtubemp3downloader.Video;

import org.json.JSONObject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;

/**
 * Created by florentchampigny on 17/03/2017.
 */

public class UrlRepositoryImpl implements UrlRepository {

    private static final String URL = "www.youtubeinmp3.com/fetch/?format=JSON&video=%s";
    private static final String LINK = "link";
    private static final String TITLE = "title";

    private final OkHttpClient okHttpClient;

    public UrlRepositoryImpl(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Observable<Video> getDownloadUrl(final String youtubeUrl) {
        return RxOkHttp.with(okHttpClient)
                .get(String.format(URL, youtubeUrl))
                .map(response -> response.body().string())
                .map(json -> {
                    final JSONObject jsonObject = new JSONObject(json);

                    final String title = jsonObject.getString(TITLE);
                    final String link = jsonObject.getString(LINK);

                    return new Video(title, link);
                });
    }
}

package com.github.florent37.youtubemp3downloader;

import java.io.IOException;

import io.reactivex.Observable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by florentchampigny on 17/03/2017.
 */

public class RxOkHttp {

    private final OkHttpClient okHttpClient;

    public RxOkHttp(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public static RxOkHttp with(OkHttpClient okHttpClient) {
        return new RxOkHttp(okHttpClient);
    }

    public Observable<Response> get(final String url) {
        return Observable.create(emitter -> {

            final String adress;
            if (!url.startsWith("http://")) {
                adress = "http://" + url;
            } else {
                adress = url;
            }

            final Request request = new Request.Builder()
                    .get()
                    .url(adress)
                    .build();

            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    emitter.onError(e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    emitter.onNext(response);
                    emitter.onComplete();
                }
            });
        });
    }
}
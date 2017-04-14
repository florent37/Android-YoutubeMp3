package com.github.florent37.youtubemp3downloader;

import org.json.JSONObject;

/**
 * Created by florentchampigny on 17/03/2017.
 */

public class Video {
    private String title;
    private String link;

    public Video(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}

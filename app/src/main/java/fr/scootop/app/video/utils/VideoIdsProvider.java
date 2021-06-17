package fr.scootop.app.video.utils;

import java.util.Random;

public class VideoIdsProvider {

    private static String[] videoIds = {"cCNmMm3Tbzo", "IPdUshUP8BE", "fnUqm4FfAA4", "5DhINO-NFbg","1ciOnOwl9k4","CAnuIkvGyKQ","Oi-G_ZTiIqU","qYUPZXMjAIQ"};
    private static String[] liveVideoIds = {"TL6tbyeQfD8"};
    private static Random random = new Random();

    public static String getNextVideoId() {
        return videoIds[random.nextInt(videoIds.length)];
    }

    public static String getNextLiveVideoId() {
        return liveVideoIds[random.nextInt(liveVideoIds.length)];
    }
}

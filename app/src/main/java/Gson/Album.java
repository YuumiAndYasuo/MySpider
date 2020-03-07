package Gson;

import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("albumID")
    public String albumID;
    @SerializedName("imgID")
    public String imgID;
    @SerializedName("logID")
    public String logID;
    @SerializedName("myUrl")
    public String myUrl;
    @SerializedName("originUrl")
    public String originUrl;

    public String getAlbumID() {
        return albumID;
    }

    public String getImgID() {
        return imgID;
    }

    public String getLogID() {
        return logID;
    }

    public String getMyUrl() {
        return myUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }
}

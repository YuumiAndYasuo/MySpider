package Utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import Gson.Album;

public class Utility {
    public static List<Album> handleAlbumResponse(String response){
        Gson gson=new Gson();

        Type listType=new TypeToken<List<Album>>(){}.getType();
        List<Album> albumList=gson.fromJson(response,listType);
        return albumList;

    }
}

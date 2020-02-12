package com.example.nsundov.barcodescanner;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Utils {



    public void saveOrderedCollection(Context context, ArrayList<String> collection, String key){
        JSONArray jsonArray = new JSONArray(collection);
        SharedPreferences.Editor editor =  context.getSharedPreferences("prefs", Context.MODE_PRIVATE).edit();
        editor.putString(key, jsonArray.toString());
        editor.commit();
    }

    public ArrayList<String> loadOrderedCollection(Context context, String key){
        ArrayList arrayList = new ArrayList<String>();
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(context.getSharedPreferences("prefs", Context.MODE_PRIVATE).getString(key, "[]"));
            for (int i = 0; i < jsonArray.length(); i++) {
                arrayList.add(jsonArray.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void DeleteItemInHistory(Context context, int index){
        ArrayList arrayList = loadOrderedCollection(context, "history");
        arrayList.remove(index);
        JSONArray jsonArray = new JSONArray(arrayList);
        SharedPreferences.Editor editor =  context.getSharedPreferences("prefs", Context.MODE_PRIVATE).edit();
        editor.putString("history", jsonArray.toString());
        editor.commit();
    }

}

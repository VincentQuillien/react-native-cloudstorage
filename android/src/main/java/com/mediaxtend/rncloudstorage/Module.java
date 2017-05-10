package com.mediaxtend.rncloudstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class Module extends ReactContextBaseJavaModule {

    public static final String PREFERENCES_KEY = "com.mediaxtend.rncloudstorage.PREFERENCE_KEY";
    private SharedPreferences sharedPreferences;


    public Module(ReactApplicationContext reactContext) {
        super(reactContext);
        sharedPreferences = reactContext.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
    }

    @Override
    public String getName() {
        return "CloudStorage";
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void getItem(String key, Promise promise) {
        promise.resolve(sharedPreferences.getString(key, ""));
    }

    @ReactMethod
    public void setItem(String key, String value, Promise promise) {
        sharedPreferences.edit().putString(key, value).apply();
        promise.resolve(null);
    }

    @ReactMethod
    public void removeItem(String key, Promise promise) {
        sharedPreferences.edit().remove(key).apply();
        promise.resolve(null);
    }
}
package com.beastpotato.potato.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.beastpotato.potato.api.net.ApiRequest;
import com.beastpotato.potato.api.net.DebugResponseModel;

public class ExampleActivity extends AppCompatActivity {
    private static String TAG = "ExampleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Log.i("ExampleActivity", "Hello");
        TextView tv = (TextView) findViewById(R.id.text);
        SimpleStringAccessor sup = new SimpleStringAccessor();//generated based on @Assessor annotation in SimpleObject.java
        tv.setText(sup.getSimpleString());

        //Network test
        GetVideosInfoApiRequest request = new GetVideosInfoApiRequest(this);//Generated based on @Endpoint annotation in GetVideosInfo.java
        Log.i(TAG, "sending request...");
        request.send(new ApiRequest.RequestCompletion<DebugResponseModel>() {
            @Override
            public void onResponse(DebugResponseModel data) {
                Log.i(TAG, data.toString());
            }

            @Override
            public void onError(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });
    }
}
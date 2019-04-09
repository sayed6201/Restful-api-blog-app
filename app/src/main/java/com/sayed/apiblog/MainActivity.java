package com.sayed.apiblog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.reflect.TypeToken;
import com.sayed.apiblog.app.AppController;
import com.sayed.apiblog.model.Post;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;





public class MainActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);


    }


    public void clicker(View v){

//        // Post request
//        String tag_json_obj = "json_obj_req";
//        String url ="http://10.0.2.2/projects/api-vue-lara/public/api/article";
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("title", "title from Android");
//        params.put("body", "Android body good one");
//
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
//                url, new JSONObject(params),
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        textView.setText(response.toString());
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//
//            }
//        });
//
//// Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);


//        // PUT request
//        String tag_json_obj = "json_obj_req";
//        String url ="http://10.0.2.2/projects/api-vue-lara/public/api/article";
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("id", "42");
//        params.put("title", "title from Android updated");
//        params.put("body", "ola");
//
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT,
//                url, new JSONObject(params),
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        textView.setText(response.toString());
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//
//            }
//        });
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);


//        //delete request
//        String tag_json_obj = "json_obj_req";
//        String url ="http://10.0.2.2/projects/api-vue-lara/public/api/article/42";
//
//
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.DELETE,
//                url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        textView.setText(response.toString());
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//
//            }
//        });
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);



    }

    public void viewPosts(View v){
        Intent i = new Intent(MainActivity.this,ViewActivity.class);
        startActivity(i);
    }


}

package com.sayed.apiblog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.sayed.apiblog.Adapter.ListAdapterWithRecycleView;
import com.sayed.apiblog.app.AppController;
import com.sayed.apiblog.model.Links;
import com.sayed.apiblog.model.Meta;
import com.sayed.apiblog.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    Button prev,nxt;
    TextView viewPage;
    private RecyclerView recyclerView;
    ListAdapterWithRecycleView listAdapterWithRecycleView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Post> postArrayList;
    Links link;
    Meta meta;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        prev = findViewById(R.id.prevBtn);
        nxt = findViewById(R.id.nxtBtn);
        viewPage = findViewById(R.id.viewText);
        recyclerView =(RecyclerView) findViewById(R.id.recycleListView);

        postArrayList = new ArrayList<>();
        gson = new Gson();

        getAllPosts();

    }

    public void searchAction(View v){
        Intent i = new Intent(ViewActivity.this,SearchActivity.class);
        startActivity(i);
    }

    public void pagination(){
        if(link.getPrev() == null){
            prev.setClickable(false);
        }else {
            prev.setClickable(true);
        }
        if(link.getNext() == null){
            nxt.setClickable(false);
        }else {
            nxt.setClickable(true);
        }
        viewPage.setText(meta.getCurrent_page()+" of "+meta.getLast_page());
    }

    public void viewClicker(View v){

        if(v.getId() == R.id.prevBtn){
            getAllPosts(link.getPrev());
        }
        if(v.getId() == R.id.nxtBtn){
            getAllPosts(link.getNext());
        }
    }

    public void getAllPosts(){
        //getting all the posts
        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";
        String url ="http://10.0.2.2/projects/api-vue-lara/public/api/articles";

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        pDialog.hide();
                        try {
////                            textView.setText(response.getJSONObject("links").getString("first")+"");
//                            textView.setText(response.getJSONArray("data").get(3).toString()+"");

                            link = gson.fromJson(String.valueOf(response.getJSONObject("links")),Links.class);
                            meta = gson.fromJson(String.valueOf(response.getJSONObject("meta")),Meta.class);
                            JSONArray posts = response.getJSONArray("data");

                            for (int i = 0; i < posts.length(); i++) {
                                Post post = (Post) gson.fromJson(String.valueOf(posts.getJSONObject(i)), Post.class);
                                postArrayList.add(post);
                            }

                            pagination();

                            listAdapterWithRecycleView = new ListAdapterWithRecycleView(ViewActivity.this,postArrayList);
                            linearLayoutManager = new LinearLayoutManager(ViewActivity.this,LinearLayoutManager.VERTICAL,false);
                            LinearLayoutManager layoutManager=new LinearLayoutManager(ViewActivity.this);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(listAdapterWithRecycleView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("response", "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    public void getAllPosts( String url){
        //getting all the posts
        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";
//        String url ="http://10.0.2.2/projects/api-vue-lara/public/api/articles";

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        pDialog.hide();
                        try {
////                            textView.setText(response.getJSONObject("links").getString("first")+"");
//                            textView.setText(response.getJSONArray("data").get(3).toString()+"");

                            link = gson.fromJson(String.valueOf(response.getJSONObject("links")),Links.class);
                            meta = gson.fromJson(String.valueOf(response.getJSONObject("meta")),Meta.class);
                            JSONArray posts = response.getJSONArray("data");

                            postArrayList.clear();

                            for (int i = 0; i < posts.length(); i++) {
                                Post post = (Post) gson.fromJson(String.valueOf(posts.getJSONObject(i)), Post.class);
                                postArrayList.add(post);
                            }

                            pagination();

                            listAdapterWithRecycleView = new ListAdapterWithRecycleView(ViewActivity.this,postArrayList);
                            linearLayoutManager = new LinearLayoutManager(ViewActivity.this,LinearLayoutManager.VERTICAL,false);
                            LinearLayoutManager layoutManager=new LinearLayoutManager(ViewActivity.this);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            recyclerView.setAdapter(listAdapterWithRecycleView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("response", "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }


}

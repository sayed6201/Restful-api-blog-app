package com.sayed.apiblog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sayed.apiblog.model.Post;
import com.sayed.apiblog.utils.GlideApp;

public class DisplayActivity extends AppCompatActivity {

    TextView postTitleTv,postBodyTv;
    ImageView postIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        postIv = findViewById(R.id.post_iv);
        postTitleTv = findViewById(R.id.post_title_tv);
        postBodyTv = findViewById(R.id.post_tv);

        Intent i = getIntent();
        Post post = (Post) i.getSerializableExtra("postObj");

        postTitleTv.setText(post.getTitle());
        postBodyTv.setText(post.getBody());
        GlideApp.with(DisplayActivity.this)
                .load("http://10.0.2.2/projects/api-vue-lara/public/images/"+post.getImage())
                .override(1000, 1000)
                .placeholder(R.drawable.blog)
                .error(R.drawable.blog)
                .into(postIv);

    }
}

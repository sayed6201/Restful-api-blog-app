package com.sayed.apiblog.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sayed.apiblog.DisplayActivity;
import com.sayed.apiblog.R;
import com.sayed.apiblog.model.Post;
import com.sayed.apiblog.utils.GlideApp;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by anildeshpande on 8/19/17.
 */

public class ListAdapterWithRecycleView extends RecyclerView.Adapter<ListAdapterWithRecycleView.PersonViewHolder> {

    private static final String TAG = ListAdapterWithRecycleView.class.getSimpleName();

    private List<Post> postList;
    private Context context;

    public ListAdapterWithRecycleView(Context context,List<Post> postList){
        this.postList = postList;
        this.context=context;
    }


    //LAyout inflater
    @Override
    public PersonViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.post_view_layout,parent,false);
        return new PersonViewHolder(view);
    }


    //DATABINDING
    @Override
    public void onBindViewHolder(final PersonViewHolder holder, int position) {

        Post post = postList.get(position);

        holder.textViewTitle.setText(post.getTitle());
        holder.textViewBody.setText(post.getBody().substring(0, 80)+"....");
        GlideApp.with(context)
                .load("http://10.0.2.2/projects/api-vue-lara/public/images/"+post.getImage())
                .override(1000, 1000)
                .placeholder(R.drawable.blog)
                .error(R.drawable.blog)
                .into(holder.postCiv);

        //if u use arrayList
        //holder.fundTextView.setText(fund.get(position).toString());
        //holder.nameTextView.setText(name.get(position));

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTitle;
        public TextView textViewBody;
        public CircleImageView postCiv;

        public PersonViewHolder(View view){
            super(view);
            textViewTitle = (TextView)view.findViewById(R.id.titleTv);
            textViewBody=(TextView)view.findViewById(R.id.bodyTv);
            postCiv = view.findViewById(R.id.post_civ);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
//                    Toast.makeText(context, postList.get(pos).getImage()+"", Toast.LENGTH_SHORT).show();

//                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){

                        Intent i = new Intent(context, DisplayActivity.class);
                        i.putExtra("postObj",postList.get(pos));
                        context.startActivity(i);

                    }
                }
            });

        }
    }
}

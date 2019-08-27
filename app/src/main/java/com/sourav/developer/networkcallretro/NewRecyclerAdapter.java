package com.sourav.developer.networkcallretro;

import android.view.LayoutInflater;

import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sourav.developer.networkcallretro.databinding.ItemCommentListBinding;
import com.sourav.developer.networkcallretro.databinding.ItemListBinding;

import java.util.List;

public class NewRecyclerAdapter extends RecyclerView.Adapter<NewRecyclerAdapter.NewViewHolder> {


    private List<Post> data ;
    private List<Comment> commentData;
    private Post post;

    NewRecyclerAdapter() {

    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemListBinding binding = DataBindingUtil
                .inflate(inflater,
                        R.layout.item_list,
                        parent,
                        false);
        return new NewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        //Post posts = data.get(position);
        Post post = getPostData();
        //Comment comment = commentData.get(position);
        holder.bind(post);
    }

    void setData(List<Post> data){
        this.data = data;
    }

    void setComments(List<Comment> comments){
        this.commentData = comments;
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public void setPostData(Post post) {
        this.post = post;
    }
    private Post getPostData(){
        return post;
    }

    class NewViewHolder extends RecyclerView.ViewHolder {

        ItemListBinding listBinding;

        NewViewHolder(@NonNull ItemListBinding listBinding) {
            super(listBinding.getRoot());
            this.listBinding = listBinding;
        }

        void bind(Post posts){
            listBinding.setPost(posts);
            listBinding.executePendingBindings();

        }
    }
}

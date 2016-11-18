package com.islavdroid.stackoverflowapi.UserAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.islavdroid.stackoverflowapi.R;
import com.islavdroid.stackoverflowapi.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class RecUsersAdapter extends RecyclerView.Adapter<RecUsersAdapter.UsersViewHolder> {

    List<User>users =new ArrayList<>();

    public RecUsersAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user,parent,false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
       holder.userLocation.setText("Location: "+users.get(position).getLocation());
        holder.userReputation.setText("Reputation: "+users.get(position).getReputation());
        holder.username.setText("Username: "+users.get(position).getUsername());

        Iterator<Map.Entry<String,Integer>>it =
                users.get(position).getBadges().entrySet().iterator();
        Map.Entry<String,Integer>pair =it.next();
        holder.goldenBadge.setText(pair.getKey() + " : ");
        holder.goldenValue.setText(pair.getValue().toString());

        pair=it.next();
        holder.silverBadge.setText(pair.getKey() + " : ");
        holder.silverValue.setText(pair.getValue().toString());
        pair=it.next();
        holder.bronzeBadge.setText(pair.getKey() + " : ");
        holder.bronzeValue.setText(pair.getValue().toString());

    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UsersViewHolder extends RecyclerView.ViewHolder{
LinearLayout usersLayuot;
        TextView username,userReputation,userLocation,goldenBadge,
        goldenValue,silverBadge,silverValue,bronzeBadge,bronzeValue;
        public UsersViewHolder(View itemView) {
            super(itemView);
            usersLayuot =(LinearLayout)itemView.findViewById(R.id.usersLayout);
            userReputation =(TextView)itemView.findViewById(R.id.userReputation);
            userLocation =(TextView)itemView.findViewById(R.id.userLocation);
            goldenBadge =(TextView)itemView.findViewById(R.id.goldenBadge);
            goldenValue =(TextView)itemView.findViewById(R.id.goldenValue);
            silverBadge =(TextView)itemView.findViewById(R.id.silverBadge);
            silverValue =(TextView)itemView.findViewById(R.id.silverValue);
            bronzeBadge =(TextView)itemView.findViewById(R.id.bronzeBadge);
            bronzeValue =(TextView)itemView.findViewById(R.id.bronzeValue);
            username =(TextView)itemView.findViewById(R.id.userName);

        }
    }
}

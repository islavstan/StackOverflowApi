package com.islavdroid.stackoverflowapi.UserAdapter;

import android.content.Context;

import com.islavdroid.stackoverflowapi.model.User;

import java.util.List;



public class UserAdapter {
    private List<User>users;
    private Context context;
    private int rowLayout;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public UserAdapter(List<User> users, Context context, int rowLayout) {
        this.users = users;
        this.context = context;
        this.rowLayout = rowLayout;
    }
}

package com.example.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    public FriendsAdapter(Context context, int resourceID, ArrayList<Friend> friends) {
        super(context, resourceID, friends);
        this.friends = friends;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        TextView name = convertView.findViewById(R.id.name);
        name.setText(friends.get(position).getName());

        ImageView avatar = convertView.findViewById(R.id.avatarImage);
        avatar.setImageResource(friends.get(position).getDrawableId());

        return convertView;
    }

    @Override
    public Friend getItem(int position) {
        return super.getItem(position);
    }
}

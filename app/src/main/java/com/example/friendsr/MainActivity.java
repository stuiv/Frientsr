/*
* Program name: Friendsr
* by:           Robert Houten
*
* Friendsr is a social media platform for royals from Westeros.
* Are from a royal family and from westeros? Then you are in luck.
*
* mainActivity.java holds an overview of all the characters.
* If you click on a character you can see their profile with bio and rating.
* */


package com.example.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.AdapterView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    FriendsAdapter adapter;
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friends.add(new Friend("Arya", "hi, i'm Arya", R.drawable.arya));
        friends.add(new Friend("Cersei", "hi, i'm Cersei", R.drawable.cersei));
        friends.add(new Friend("Daenerys", "hi, i'm Daenerys", R.drawable.daenerys));
        friends.add(new Friend("Jaime", "hi, i'm Jaime", R.drawable.jaime));
        friends.add(new Friend("Jon", "Knows nothing", R.drawable.jon));
        friends.add(new Friend("Jorah", "hi, i'm Jorah", R.drawable.jorah));
        friends.add(new Friend("Margaery", "hi, i'm Margaery", R.drawable.margaery));
        friends.add(new Friend("Melisandre", "hi, i'm Melisandre", R.drawable.melisandre));
        friends.add(new Friend("Sansa", "hi, i'm Sansa", R.drawable.sansa));
        friends.add(new Friend("Tyrion", "hi, i'm Tyrion", R.drawable.tyrion));

        adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gv = findViewById(R.id.friendsGrid);

        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new GridItemClickListener());

    }
    // THe rating of the character is saved so
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

        }
    }
}

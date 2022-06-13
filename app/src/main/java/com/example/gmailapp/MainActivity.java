package com.example.gmailapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ImporEm.ItemClickInterface {

    List<Email> emails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails = new ArrayList<>();

        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "My School",
                "Result", "A++++++", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_green_24dp", "drawable",getPackageName()), "Minh Nam",
                "Chuyển tiền cho bạn", "Hôm qua minh lỡ chuyển nhầm 100000000000$, mong bạn trả lại", "11:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_slightblue_24dp", "drawable",getPackageName()), "GeeksforGeeks",
                "[Update from all company]", "Thanks! TryHard go go", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_yellow_24dp", "drawable",getPackageName()), "Cisco Networking Academy",
                "Join Part-Two Special Gaming Feature", "Find a broadcast in your time zone, and register to attend!  ", "70:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "noreply",
                "Submit My Exercise", "This contest is prepared by Moscow Olympiad Scientific Committee that you may know by Moscow Team Olympiad, Moscow Olympiad for Young Students and Metropolises Olympiad. Do not miss the round! ", "10:48pm", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_green_24dp", "drawable",getPackageName()), "Đại học bách khoa Hà Nội",
                "Học Phí", "Tiền học của bạn đã quá hạn!", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_slightblue_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "My School",
                "Result", "A++++++", "12:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_green_24dp", "drawable",getPackageName()), "Minh Nam",
                "Chuyển tiền cho bạn", "Hôm qua minh lỡ chuyển nhầm 100000000000$, mong bạn trả lại", "11:00am", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_slightblue_24dp", "drawable",getPackageName()), "GeeksforGeeks",
                "[Update from all company]", "Thanks! TryHard go go", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_yellow_24dp", "drawable",getPackageName()), "Cisco Networking Academy",
                "Join Part-Two Special Gaming Feature", "Find a broadcast in your time zone, and register to attend!  ", "70:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_red_24dp", "drawable",getPackageName()), "noreply",
                "Submit My Exercise", "This contest is prepared by Moscow Olympiad Scientific Committee that you may know by Moscow Team Olympiad, Moscow Olympiad for Young Students and Metropolises Olympiad. Do not miss the round! ", "10:48pm", true));
        emails.add(new Email(getResources().getIdentifier("ic_circle_green_24dp", "drawable",getPackageName()), "Đại học bách khoa Hà Nội",
                "Học Phí", "Tiền học của bạn đã quá hạn!", "12:00am", false));
        emails.add(new Email(getResources().getIdentifier("ic_circle_slightblue_24dp", "drawable",getPackageName()), "Educative io",
                "Buy course", "Thanks! TryHard go go", "12:00am", true));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ImporEm adapter = new ImporEm(emails, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu,menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.ic_menu_black_34dp);    //Icon muốn hiện thị
        actionBar.setDisplayUseLogoEnabled(true);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void OnItemClick(int position) {
        Log.v("TAG", "Item " + position + " is clicked.");
    }

}
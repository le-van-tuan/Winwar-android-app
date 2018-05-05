package com.winwar.winwar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.winwar.winwar.adapter.ContentAdapter;
import com.winwar.winwar.pages.Window10;
import com.winwar.winwar.pages.Window7;
import com.winwar.winwar.pages.Window8;
import com.winwar.winwar.pages.Window98;
import com.winwar.winwar.pages.WindowVista;
import com.winwar.winwar.pages.WindowXp;

public class InstallActivity extends AppCompatActivity {
    private TabLayout myTab;
    private ViewPager myPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install);


        myTab = findViewById(R.id.MyTabs);
        myPage = findViewById(R.id.MyPage);

        myTab.setupWithViewPager(myPage);

        setUpInstallWindowViewPager(myPage);
    }

    private void setUpInstallWindowViewPager(ViewPager viewPager){
        ContentAdapter contentAdapter = new ContentAdapter(this.getSupportFragmentManager());

        contentAdapter.addFragmentPage(new Window7(), "Window 7");
        contentAdapter.addFragmentPage(new Window8(), "Window 8");
        contentAdapter.addFragmentPage(new Window10(), "Window 10");
        contentAdapter.addFragmentPage(new WindowXp(), "Window XP");
        contentAdapter.addFragmentPage(new Window98(), "Window 98");
        contentAdapter.addFragmentPage(new WindowVista(), "Window Vista");

        viewPager.setAdapter(contentAdapter);
    }

}

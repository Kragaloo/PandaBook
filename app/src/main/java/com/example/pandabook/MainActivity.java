package com.example.pandabook;

import static java.time.LocalDate.now;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.example.pandabook.ac.HealthFragment;
import com.example.pandabook.ac.LeisureFragment;
import com.example.pandabook.ac.LifeFragment;
import com.example.pandabook.ac.PandaFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.ArrayList;

import com.example.pandabook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Button healthBtn, lifeBtn, leisureBtn, startBtn, stopBtn, pauseBtn;
    private ActivityMap activityData;
    private LifeFragment lifeFragment;
    private HealthFragment healthFragment;
    private LeisureFragment leisureFragment;
    private PandaFragment currentFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        healthBtn = (Button) findViewById(R.id.healthBtn);
        lifeBtn = (Button) findViewById(R.id.lifeBtn);
        leisureBtn = (Button) findViewById(R.id.leisureBtn);

        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        pauseBtn = (Button) findViewById(R.id.pauseBtn);

        //stopBtn.setEnabled(false);
        //startBtn.setEnabled(false);

        lifeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeFragment = new LifeFragment();
                replaceFragment(lifeFragment);
                currentFragment = lifeFragment;
            }
        });

        healthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                healthFragment = new HealthFragment();
                replaceFragment(healthFragment);
                currentFragment = healthFragment;
            }
        });

        leisureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leisureFragment = new LeisureFragment();
                replaceFragment(leisureFragment);
                currentFragment = leisureFragment;
            }
        });


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDate today = LocalDate.now();
                Activity todayEntry = activityData.getActivityMap().get(today);
                if (todayEntry== null){
                    todayEntry = new Activity();
                    activityData.getActivityMap().put(today, todayEntry);
                }
                ArrayList<ActivityInstance> list = todayEntry.getActivityInstanceList();
                if (list == null) {
                    list = new ArrayList<ActivityInstance>();
                    todayEntry.setActivityInstanceList(list);

                }
                ActivityInstance instance = new ActivityInstance();
                instance.setActivityCategory(currentFragment.getCategory());
                instance.setActivityName(currentFragment.getActivityName());
                instance.setStartTime(LocalDateTime.now());
                list.add(instance);

//                v.setEnabled(false);

  //              findViewById(R.id.stopBtn).setEnabled(true);
                Log.d("PandaBook", "activityData = " + activityData);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDate today = LocalDate.now();
                Activity todayEntry = activityData.getActivityMap().get(today);
                if (todayEntry!= null){
                    ArrayList<ActivityInstance> list = todayEntry.getActivityInstanceList();
                    if (list != null) {

                        ActivityInstance instance = findInstance(list, currentFragment.getCategory(), currentFragment.getActivityName());
                        if(instance != null) {
                            instance.setActivityCategory(currentFragment.getCategory());
                            instance.setActivityName(currentFragment.getActivityName());
                            instance.setEndTime(LocalDateTime.now());
                            // v.setEnabled(false);
                            // findViewById(R.id.startBtn).setEnabled(true);
                        }
                }
            }
                Log.d("PandaBook", "activityData = " + activityData);
        }});

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_diary, R.id.nav_fitness, R.id.nav_progress)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        activityData = new ActivityMap();
    }

    private ActivityInstance findInstance(ArrayList<ActivityInstance> list, String category, String activityName) {
        ActivityInstance instance = null;
        for (ActivityInstance x:list){
            if ((category.equals(x.getActivityCategory())) && (activityName.equals((x.getActivityName()))) && (x.getStartTime()!= null)){
                instance = x;
                break;
            }
        }
        return instance;
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Framelayout, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
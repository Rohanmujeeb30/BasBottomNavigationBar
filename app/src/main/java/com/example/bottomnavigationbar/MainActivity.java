package com.example.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            //Jab items limited ho toh items select hotay hain click nh hotay hai. Aur yeh bottomnavigation ka method hai.

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();
                //Menu items ki id agayi yahan

                if(id==R.id.nav_home){
        //Frame Layout ko load karrahay hain yahan.
                /*FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.containerr, new Fragmentone());
                transaction.commit();*/
                loadFrag(new Fragmentone(), false);
            }
            else if (id==R.id.nav_Search){
                loadFrag(new Second_Fragment(), false);

            }else if (id==R.id.nav_contact){
                loadFrag(new Third_Fragment(), false);
            }else if (id==R.id.nav_notifications){
                loadFrag(new Fourth_Fragment(),false);
            }else{ //profile
                loadFrag(new Fifth_Fragment(),true);
            }
                return true;
            }
        });

        //Is line se first profile item  khulega by default pehla item khulta hai but yahan hamne profile ko khulwaya hai.
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);


    }
    //Method isliye banaya ta k hamay 4 lines baar baar na likhni pade conditions me:
    //Fragment variable isliye liya hai taa k 1st parameter me conditions me jo fragment load karwana hai woh object se call hojayengay.
    //Boolean is liye liya hai taa k sirf pehla fragment add ho aur baaki replace ho.
    public void loadFrag(Fragment fragment, boolean flag){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (flag)
        transaction.add(R.id.containerr, fragment);
        else
            transaction.replace(R.id.containerr, fragment);
        transaction.commit();
    }
}
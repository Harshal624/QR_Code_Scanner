package tfws.mobileapps.navigationbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class HistoryQR extends Fragment {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.historyqr,container,false);


        navigationView = view.findViewById(R.id.navigationView);
        drawerLayout = view.findViewById(R.id.drawer);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        //setSupportActionBar(toolbar);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
       // toggle = new ActionBarDrawerToggle(container.getContext(),drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        //drawerLayout.addDrawerListener(toggle);
        //toggle.syncState();
       // navigationView.setNavigationItemSelectedListener(this);

        return inflater.inflate(R.layout.historyqr,container,false);
    }
}

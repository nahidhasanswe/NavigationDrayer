package nahid.example.com.navigationdrayer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  NavigationView navigationView;
    private EditText firstName, secondName;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // connect with xml to EditText
        firstName = (EditText)findViewById(R.id.firstname);
        secondName = (EditText)findViewById(R.id.secondname);

        //connect with Button
        calculateButton= (Button)findViewById(R.id.calculatebutton);




    final FragmentManager fragmentManager=getFragmentManager();
          fragmentManager.beginTransaction().replace(R.id.main_fragement,new calculator()).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.main_fragement,new calculator()).commit();
                navigationView.getMenu().getItem(0).setChecked(true);
                navigationView.setCheckedItem(R.id.calculate);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setCheckedItem(R.id.calculate);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "This is Setting", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id==R.id.Exit){
            Toast.makeText(MainActivity.this, "This is Exit", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fragmentManager=getFragmentManager();

        View view=getCurrentFocus();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about) {

            fragmentManager.beginTransaction().replace(R.id.main_fragement,new about_fragement()).commit();

        } else if (id == R.id.nav_share) {

            Snackbar.make(view, "Coming Soon. Connect with us", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        } else if (id == R.id.nav_send) {

            Snackbar.make(view, "Coming Soon. Connect with us", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if (id == R.id.contact) {

            fragmentManager.beginTransaction().replace(R.id.main_fragement, new contact_fragement()).commit();

        }else if (id == R.id.calculate) {

            fragmentManager.beginTransaction().replace(R.id.main_fragement,new calculator()).commit();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

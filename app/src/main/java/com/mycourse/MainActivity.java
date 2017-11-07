package com.mycourse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mycourse.adapter.MainFragmentAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String[] ListViewArray = {"行业经济产业动态,行业经济行业新闻","行业经济产业动态,行业经济行业新闻","行业经济产业动态","gad"};
    private ListView listview1,listview2;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    MainFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // initListview();
        initToolbar();
        initFab();
        initViewPager(0,0);
    }
    private void initViewPager(int SectionIndex,int ColumnIndex) {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter=new MainFragmentAdapter(getSupportFragmentManager(),SectionIndex);
        mViewPager.setAdapter(adapter);
        mTabLayout.setTabMode((TabLayout.MODE_SCROLLABLE));//设置TabLayout的模式为滚动模式
        //与viepager进行绑定,TabLayout的标签页通过PagerAdapter的getPagerTitle方法获取
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(ColumnIndex);
    }
    private void initFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
/*
    private void initListview() {
        listview1 = (ListView)findViewById(R.id.list1);
        listview1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListViewArray));
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(MainActivity.this,"您选择了" + ListViewArray[position], Toast.LENGTH_LONG).show();
            }
        });
        listview2 = (ListView)findViewById(R.id.list2);
        listview2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListViewArray));
        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(MainActivity.this,"您选择了" + ListViewArray[position], Toast.LENGTH_LONG).show();
            }
        });
    }
*/
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.course_cpv:
                // LayoutInflater inflater=getLayoutInflater();
                //View v=inflater.inflate(R.layout.layout_cpv,null,false).
               // MainActivity.this.setContentView(R.layout.layout_cpv);
                break;
            case R.id.course_paa:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

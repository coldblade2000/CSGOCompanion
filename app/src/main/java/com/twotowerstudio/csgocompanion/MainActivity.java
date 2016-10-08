package com.twotowerstudio.csgocompanion;



import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements fragment_main.OnFragmentInteractionListener, AK47Fragment.OnFragmentInteractionListener ,M4A4Fragment.OnFragmentInteractionListener
        /**implements NavigationView.OnNavigationItemSelectedListener*/ {

    /**
     *
     * Libraries:
     * Koral - Show GIFs - https://github.com/koral--/android-gif-drawable
     */
    private DrawerLayout mDrawerLayout;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    TextView tvID;
    FrameLayout flMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //final Fragment Fragment = new Fragment();
        final M4A4Fragment m4a4Fragment = new M4A4Fragment();
        final AK47Fragment ak47Fragment = new AK47Fragment();
        final FAMASFragment famasFragment = new FAMASFragment();
        final AUGFragment augFragment = new AUGFragment();
        final GalilFragment galilFragment = new GalilFragment();
        final UMP45Fragment ump45Fragment = new UMP45Fragment();


        /**FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);

        flMain = (FrameLayout) findViewById(R.id.flMain);

        final fragment_main mainfragment = new fragment_main();

         final Bundle abBundle = new Bundle();
        abBundle.putInt("layoutId", R.layout.fragment_home_and_updates);
        mainfragment.setArguments(abBundle);

        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        fT.add(R.id.flMain, mainfragment).commit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //navigationView.setNavigationItemSelectedListener(this);

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        View view = View.inflate(getApplicationContext(), R.layout.header, null);
        expandableList.addHeaderView(view, null, false);
        /**expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);
                } else {
                    boolean animateExpansion = false;
                    parent.expandGroup(groupPosition, animateExpansion);
                }
                //telling the listView we have handled the group click, and don't want the default actions.
                return true;
            }
        });*/
        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                //Log.d("DEBUG", "submenu item clicked");
                //tvID.setText(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                Log.d("DEBUG", "Something clicked");
                FragmentTransaction destroyFT = getSupportFragmentManager().beginTransaction();
                FragmentTransaction listFT = getSupportFragmentManager().beginTransaction();
                destroyFT.remove(mainfragment).commit();
                fragment_main mainfragment2 = new fragment_main();
                Bundle abcBundle = new Bundle();
                switch (groupPosition){
                    case 0:
                        if(childPosition==0){
                            //M4A4
                            getSupportFragmentManager().beginTransaction().replace(R.id.flMain, m4a4Fragment).commit();
                            getSupportActionBar().setTitle("M4A4");


                        }else if(childPosition==1){
                            //AK47
                            getSupportFragmentManager().beginTransaction().replace(R.id.flMain, ak47Fragment).commit();
                            getSupportActionBar().setTitle("AK47");

                        }else if(childPosition==2){
                            //AWP
                        }else if(childPosition==3){
                            //M4A1-S
                        }else if(childPosition==4){
                            //SSG 08
                        }else if(childPosition==5){
                            //Galil AR
                            getSupportFragmentManager().beginTransaction().replace(R.id.flMain, galilFragment).commit();
                            getSupportActionBar().setTitle("Galil AR");
                        }else if(childPosition==6){
                            //FAMAS
                            getSupportFragmentManager().beginTransaction().replace(R.id.flMain, famasFragment).commit();
                            getSupportActionBar().setTitle("FAMAS");
                        }else if(childPosition==7){
                            //AUG
                            getSupportFragmentManager().beginTransaction().replace(R.id.flMain, augFragment).commit();
                            getSupportActionBar().setTitle("AUG");
                        }else if(childPosition==8){

                        }else if(childPosition==9){

                        }else if(childPosition==10){

                        }
                    break;

                    case 1:
                        if(childPosition==0){
                            //UMP-45
                            getSupportFragmentManager().beginTransaction().replace(R.id.flMain, ump45Fragment).commit();
                            getSupportActionBar().setTitle("UMP-45");
                        } else if(childPosition==1){
                            //MP7
                        }else if(childPosition==2){
                            //MP9
                        }else if(childPosition==3){
                            //PP-Bizon
                        }else if(childPosition==4){
                            //P90
                        }else if(childPosition==5){
                            //MAC-10
                        }
                    break;

                    case 2:

                    break;

                    case 3:

                    break;

                    case 4:

                    break;

                    case 5:

                    break;

                }



                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                //Log.d("DEBUG", "heading clicked");
                navigationView.invalidate();
                navigationView.requestLayout();
                expandableList.invalidate();
                expandableList.requestLayout();
                return false;
            }
        });
    }

    private void setupDrawerContent(NavigationView navigationView) {
        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setIconName("Rifles");
        //item1.setIconImg(android.R.drawable.ic_delete);
        // Adding data header
        listDataHeader.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setIconName("Submachine Guns");
        //item2.setIconImg(android.R.drawable.ic_delete);
        listDataHeader.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setIconName("~~Heavy Weapons~~");
        //item3.setIconImg(android.R.drawable.ic_delete);
        listDataHeader.add(item3);

        ExpandedMenuModel item4 = new ExpandedMenuModel();
        item4.setIconName("~~Pistols~~");
        //item3.setIconImg(android.R.drawable.ic_delete);
        listDataHeader.add(item4);

        ExpandedMenuModel item5 = new ExpandedMenuModel();
        item5.setIconName("~~Grenades~~");
        //item3.setIconImg(android.R.drawable.ic_delete);
        listDataHeader.add(item5);

        ExpandedMenuModel item6 = new ExpandedMenuModel();
        item6.setIconName("~~Gear~~");
        //item3.setIconImg(android.R.drawable.ic_delete);
        listDataHeader.add(item6);

        // TODO: Keep changing the exclamation marks when a gun is done
        //Rifles
        List<String> assaultRifles = new ArrayList<String>();
        assaultRifles.add("M4A4");
        assaultRifles.add("AK-47");
        assaultRifles.add("~~AWP~~");
        assaultRifles.add("~~M4A1-S~~");
        assaultRifles.add("~~SSG 08~~");
        assaultRifles.add("Galil AR");
        assaultRifles.add("FAMAS");
        assaultRifles.add("AUG");
        assaultRifles.add("~~SCAR-20~~");
        assaultRifles.add("~~SG 553~~");

        //Submachine Guns
        List<String> submachineGuns = new ArrayList<String>();
        submachineGuns.add("UMP-45");
        submachineGuns.add("~~MP7~~");
        submachineGuns.add("~~MP9~~");
        submachineGuns.add("~~PP-Bizon~~");
        submachineGuns.add("~~P90~~");
        submachineGuns.add("~~MAC-10~~");

        //heavy Weapons
        List<String> heavyWeapons = new ArrayList<String>();
        heavyWeapons.add("M249");
        heavyWeapons.add("Negev");
        heavyWeapons.add("Nova");
        heavyWeapons.add("XM1014");
        heavyWeapons.add("Sawed-Off");
        heavyWeapons.add("MAG-7");

        //Pistols
        List<String> pistols = new ArrayList<String>();
        pistols.add("USP-S");
        pistols.add("Glock-18");
        pistols.add("Desert Eagle");
        pistols.add("Dual Berettas");
        pistols.add("P250");
        pistols.add("Tec-9");
        pistols.add("CZ75 Auto");
        pistols.add("R8 Revolver");
        pistols.add("Five-SeveN");
        pistols.add("P2000");

        //Grenades
        List<String> grenades = new ArrayList<String>();
        grenades.add("Molotov");
        grenades.add("Incendiary");
        grenades.add("Decoy");
        grenades.add("HE Grenade");
        grenades.add("Flashbang");
        grenades.add("Smoke");

        //Gear
        List<String> gear = new ArrayList<String>();
        gear.add("Kevlar Vest");
        gear.add("Kevlar Vest + Helmet");
        gear.add("Zeus x27");
        gear.add("Defuse Kit");

        listDataChild.put(listDataHeader.get(0), assaultRifles);// Header, Child data
        listDataChild.put(listDataHeader.get(1), submachineGuns);
        listDataChild.put(listDataHeader.get(2), heavyWeapons);
        listDataChild.put(listDataHeader.get(3), pistols);
        listDataChild.put(listDataHeader.get(4), grenades);
        listDataChild.put(listDataHeader.get(5), gear);

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
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /**if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

package com.example.myapp;

import android.app.*;
import android.content.res.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.widget.*;
import android.view.*;
import android.widget.*;

public class MyActivity extends Activity {

private String[] mCats = new String[]{"Caturday", "Catur Sunday", "Paws Tuesday", "Tailz Wednesday"};
private String[] mCatTypes = new String[]{"Tabby", "Calico", "Grumpy Cat"};
private DrawerLayout          mDrawerLayout;
private ListView              mDrawerList;
private ActionBarDrawerToggle mDrawerToggle;
private ListView              mListCatTypes;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main);
  mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
  mDrawerList = (ListView) findViewById(R.id.left_drawer);
  mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(MyActivity.this, "Tapped me " + mCats[position], Toast.LENGTH_SHORT).show();
      // This would be where you would launch a new activity!
    }
  });

  // Set the adapter for the list view
  mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                                                  R.layout.drawer_list_item, mCats));



  mDrawerToggle = new ActionBarDrawerToggle(
      this,                  /* host Activity */
      mDrawerLayout,         /* DrawerLayout object */
      R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
      R.string.drawer_open,  /* "open drawer" description */
      R.string.drawer_close  /* "close drawer" description */
  )
  {

    /** Called when a drawer has settled in a completely closed state. */
    public void onDrawerClosed(View view) {
      super.onDrawerClosed(view);
      getActionBar().setTitle("Closed Drawer");
    }

    /** Called when a drawer has settled in a completely open state. */
    public void onDrawerOpened(View drawerView) {
      super.onDrawerOpened(drawerView);
      getActionBar().setTitle("Open Drawer");
    }
  };

  // Set the drawer toggle as the DrawerListener
  mDrawerLayout.setDrawerListener(mDrawerToggle);

  getActionBar().setDisplayHomeAsUpEnabled(true);
  getActionBar().setHomeButtonEnabled(true);


  // Main list
  mListCatTypes = (ListView) findViewById(R.id.cat_types_list);

  mListCatTypes.setAdapter(new ArrayAdapter<String>(this,
                                                    R.layout.main_list_item, mCatTypes));

}

@Override
protected void onPostCreate(Bundle savedInstanceState) {
  super.onPostCreate(savedInstanceState);
  // Sync the toggle state after onRestoreInstanceState has occurred.
  mDrawerToggle.syncState();
}

@Override
public void onConfigurationChanged(Configuration newConfig) {
  super.onConfigurationChanged(newConfig);
  mDrawerToggle.onConfigurationChanged(newConfig);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
  // Pass the event to ActionBarDrawerToggle, if it returns
  // true, then it has handled the app icon touch event
  if (mDrawerToggle.onOptionsItemSelected(item)) {
    return true;
  }
  // Handle your other action bar items...

  return super.onOptionsItemSelected(item);
}

}

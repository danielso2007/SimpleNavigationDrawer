package br.com.example.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import br.com.example.R;
import br.com.example.fragments.HomeFragment;
import br.com.example.fragments.MailFragment;
import br.com.example.fragments.SettingsFragment;
import br.com.example.utils.Utils;

public class MainActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	private NavigationDrawerFragment mNavigationDrawerFragment;

	private CharSequence mTitle;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(final int position) {
		FragmentManager fragmentManager = getFragmentManager();
		if (position == 0) {
			fragmentManager.beginTransaction().replace(R.id.container, HomeFragment.newInstance()).commit();
		} else if (position == 1) {
			fragmentManager.beginTransaction().replace(R.id.container, MailFragment.newInstance()).commit();
		} else if (position == 2) {
			fragmentManager.beginTransaction().replace(R.id.container, SettingsFragment.newInstance()).commit();
		}
	}

	public void onSectionAttached(final int number) {
		System.out.println(mTitle);  
		  switch (number) {  
		  case 1:  
		   mTitle = getString(R.string.title_section1);  
		   break;  
		  case 2:  
		   mTitle = getString(R.string.title_section2);  
		   break;  
		  case 3:  
		   mTitle = getString(R.string.title_section3);  
		   break;  
		  }  
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static class PlaceholderFragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";

		public static PlaceholderFragment newInstance(final int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}

		@Override
		public void onAttach(final Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}
	
	private boolean back = false;
	
	@Override
	public void onBackPressed() {
		if (!back) {
			((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawers();
			back = true;
			Utils.ShowToast(getApplicationContext(), getResources().getString(R.string.message_back_pressed));
		} else {
			super.onBackPressed();
		}
	}

}

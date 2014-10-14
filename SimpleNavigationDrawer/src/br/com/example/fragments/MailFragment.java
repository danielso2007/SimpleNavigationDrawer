package br.com.example.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.example.R;
import br.com.example.activities.MainActivity;

public class MailFragment extends Fragment {

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static MailFragment newInstance() {
		MailFragment fragment = new MailFragment();
		return fragment;
	}

	public MailFragment() {
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_mail, container, false);
		return rootView;
	}

	@Override
	public void onAttach(final Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(1);
	}

}

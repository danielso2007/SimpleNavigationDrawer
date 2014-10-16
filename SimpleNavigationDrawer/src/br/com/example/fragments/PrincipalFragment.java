package br.com.example.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import br.com.example.R;
import br.com.example.activities.MainActivity;
import br.com.example.adapter.PrincipalListAdapter;
import br.com.example.enumerators.TipoIconPesquisa;
import br.com.example.model.list.Movie;

public class PrincipalFragment extends Fragment {

	private ProgressDialog pDialog;
	private List<Movie> movieList = new ArrayList<Movie>();
	private ListView listView;
	private PrincipalListAdapter adapter;
	
	public static PrincipalFragment newInstance() {
		PrincipalFragment fragment = new PrincipalFragment();
		return fragment;
	}

	public PrincipalFragment() {
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_principal, container, false);
		
		pDialog = new ProgressDialog(getActivity());
		pDialog.setMessage(getString(R.string.string_loading));
		pDialog.show();
		
		criarDados();
		
		listView = (ListView) rootView.findViewById(R.id.listPesquisas);
		adapter = new PrincipalListAdapter(getActivity(), movieList);
		listView.setAdapter(adapter);
		
		hidePDialog();
		
		return rootView;
	}

	@Override
	public void onAttach(final Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(0);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		hidePDialog();
	}

	private void hidePDialog() {
		if (pDialog != null) {
			pDialog.dismiss();
			pDialog = null;
		}
	}
	
	private void criarDados() {
		Movie movie = new Movie();
		movie.setTitle("Auto Posto Valdevez Ltda.");
		movie.setIcon(TipoIconPesquisa.GAS);
		movie.setRating(2.2d);
		movie.setYear(2014);
		ArrayList<String> genre = new ArrayList<String>();
		genre.add("Estrada do Pau Ferro");
		genre.add("1128");
		movie.setGenre(genre);

		movieList.add(movie);

		movie = new Movie();
		movie.setTitle("Auto Posto Tirol Ltda.");
		movie.setIcon(TipoIconPesquisa.OIL_CHECK);
		movie.setRating(5.2d);
		movie.setYear(2014);
		genre = new ArrayList<String>();
		genre.add("Estrada do Bananal");
		genre.add("301 Freguesia");
		movie.setGenre(genre);

		movieList.add(movie);

		movie = new Movie();
		movie.setTitle("Auto Posto Pistao Ltda.");
		movie.setIcon(TipoIconPesquisa.OIL);
		movie.setRating(2.2d);
		movie.setYear(2014);
		genre = new ArrayList<String>();
		genre.add("Estrada do Tindiba");
		genre.add("530");
		movie.setGenre(genre);

		movieList.add(movie);

		movie = new Movie();
		movie.setTitle("Auto Posto Rio 92 Ltda.");
		movie.setIcon(TipoIconPesquisa.GAS_CHECK);
		movie.setRating(4.2d);
		movie.setYear(2014);
		genre = new ArrayList<String>();
		genre.add("Rua Andre Rocha");
		genre.add("777");
		movie.setGenre(genre);

		movieList.add(movie);

		movie = new Movie();
		movie.setTitle("Auto Posto Max Ltda.");
		movie.setIcon(TipoIconPesquisa.GAS_ERROR);
		movie.setRating(4.2d);
		movie.setYear(2014);
		genre = new ArrayList<String>();
		genre.add("Rua Andre Rocha");
		genre.add("654");
		movie.setGenre(genre);

		movieList.add(movie);

		movie = new Movie();
		movie.setTitle("Auto Posto AOC Ltda.");
		movie.setIcon(TipoIconPesquisa.OIL);
		movie.setRating(4.2d);
		movie.setYear(2014);
		genre = new ArrayList<String>();
		genre.add("Rua Andre Rocha");
		genre.add("321");
		movie.setGenre(genre);

		movieList.add(movie);

		movie = new Movie();
		movie.setTitle("Auto Posto Powerade Ltda.");
		movie.setIcon(TipoIconPesquisa.GAS);
		movie.setRating(4.2d);
		movie.setYear(2014);
		genre = new ArrayList<String>();
		genre.add("Rua Andre Rocha");
		genre.add("358");
		movie.setGenre(genre);

		movieList.add(movie);
	}

}

package br.com.example.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.example.R;
import br.com.example.enumerators.TipoIconPesquisa;
import br.com.example.model.list.Movie;

public class PrincipalListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> movieItems;

    public PrincipalListAdapter(Activity activity, List<Movie> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        Movie m = movieItems.get(position);

        if (TipoIconPesquisa.GAS.equals(m.getIcon())) {
            imageView.setImageResource(R.drawable.gas_icon);
        } else if (TipoIconPesquisa.GAS_CHECK.equals(m.getIcon())) {
            imageView.setImageResource(R.drawable.gas_icon_check);
        } else if (TipoIconPesquisa.GAS_ERROR.equals(m.getIcon())) {
            imageView.setImageResource(R.drawable.gas_icon_error);
        } else if (TipoIconPesquisa.OIL.equals(m.getIcon())) {
            imageView.setImageResource(R.drawable.oil_icon);
        } else if (TipoIconPesquisa.OIL_CHECK.equals(m.getIcon())) {
            imageView.setImageResource(R.drawable.oil_icon_check);
        } else if (TipoIconPesquisa.OIL_ERROR.equals(m.getIcon())) {
            imageView.setImageResource(R.drawable.oil_icon_error);
        }

        // title
        title.setText(m.getTitle());

        // rating
        rating.setText("Rating: " + String.valueOf(m.getRating()));

        // genre
        String genreStr = "";
        for (String str : m.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0, genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);

        // release year
        year.setText(String.valueOf(m.getYear()));

        return convertView;
    }

}

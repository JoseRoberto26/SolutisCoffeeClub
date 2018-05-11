package solutis.jose.com.solutiscoffeeclub_mobile;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CafeAdapter extends ArrayAdapter<Capsula> {

    private final Context context;
    private final ArrayList<Capsula> capsulas;

    public CafeAdapter(@NonNull Context context, ArrayList<Capsula> capsulas) {
        super(context, R.layout.linha, capsulas);
        this.context = context;
        this.capsulas = capsulas;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView marcaCafe = (TextView) rowView.findViewById(R.id.textMarca);
        TextView saborCafe = (TextView) rowView.findViewById(R.id.textSabor);
        TextView doseCafe = (TextView) rowView.findViewById(R.id.textDoses);
        ImageView image = (ImageView) rowView.findViewById(R.id.imageCafe);

        image.setImageResource(R.drawable.coffee);
        marcaCafe.setText(capsulas.get(position).getMarca());
        doseCafe.setText(capsulas.get(position).getDoses().toString());
        saborCafe.setText(capsulas.get(position).getSabor());

        return rowView;
    }

}

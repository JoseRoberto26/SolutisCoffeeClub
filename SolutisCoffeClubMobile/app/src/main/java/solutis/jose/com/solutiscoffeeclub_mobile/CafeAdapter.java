package solutis.jose.com.solutiscoffeeclub_mobile;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import solutis.jose.com.solutiscoffeeclub_mobile.Retrofit.RetrofitConf;

public class CafeAdapter extends ArrayAdapter<Capsula> {

    private final Context context;
    private final ArrayList<Capsula> capsulas;


    public CafeAdapter(@NonNull Context context, ArrayList<Capsula> capsulas) {
        super(context, R.layout.linha, capsulas);
        this.context = context;
        this.capsulas = capsulas;
    }


    @Override
    public View getView(final int position, final View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        FloatingActionButton deleteButton = rowView.findViewById(R.id.deleteCafe);
        FloatingActionButton editButton = rowView.findViewById(R.id.editCafe);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Long id = capsulas.get(position).getId();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Call<Boolean> call = new RetrofitConf().getCapsulaController().deleteCapsula(id);
                        try{
                            call.execute();
                            Log.d("CreateEditActivity", "entrou");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                capsulas.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "Café deletado ", Toast.LENGTH_LONG).show();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                 Capsula capsula = capsulas.get(position);
                 Intent intent = new Intent(getContext(), CreateEditActivity.class);
                 intent.putExtra("capsula",capsula);
                 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 getContext().startActivity(intent);
            }
        });


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

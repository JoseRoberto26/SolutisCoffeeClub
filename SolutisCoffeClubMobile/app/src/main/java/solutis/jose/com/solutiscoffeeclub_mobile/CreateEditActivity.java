package solutis.jose.com.solutiscoffeeclub_mobile;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import solutis.jose.com.solutiscoffeeclub_mobile.Retrofit.RetrofitConf;

public class CreateEditActivity extends AppCompatActivity {

    FloatingActionButton confirmButton;
    FloatingActionButton cancelButton;
    TextInputEditText campoMarca;
    TextInputEditText campoSabor;
    TextInputEditText campoDoses;
    Capsula novaCapsula;
    Capsula capsula;
    Boolean edit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
             capsula = (Capsula) extras.getSerializable("capsula");
             edit = true;
        }
        confirmButton = findViewById(R.id.floatingActionButtonOk);
        cancelButton = findViewById(R.id.floatingActionButtonCancel);

        novaCapsula = new Capsula();

        campoMarca = findViewById(R.id.marcaInput);
        campoSabor = findViewById(R.id.saborInput);
        campoDoses = findViewById(R.id.doseInput);

        if(capsula != null) {
            campoMarca.setText(capsula.getMarca());
            campoSabor.setText(capsula.getSabor());
            campoDoses.setText(capsula.getDoses().toString());
            novaCapsula = capsula;
        }

        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(CreateEditActivity.this, MainActivity.class);
                startActivity(ob);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    novaCapsula.setMarca(campoMarca.getText().toString());
                    novaCapsula.setSabor(campoSabor.getText().toString());
                    novaCapsula.setDoses(Integer.parseInt(campoDoses.getText().toString()));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Call<Capsula> call = new RetrofitConf().getCapsulaController().postCapsula(novaCapsula);
                        try{
                            call.execute();
                            Log.d("CreateEditActivity", "entrou");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                if(edit){
                    Intent ob = new Intent( CreateEditActivity.this, MainActivity.class);
                    startActivity(ob);
                    Toast.makeText(getBaseContext(), "Café editado  com sucesso!", Toast.LENGTH_LONG).show();

                }
                clear();
                Toast.makeText(getBaseContext(), "Café criado com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

    }
    private void clear(){
        campoMarca.setText("");
        campoSabor.setText("");
        campoDoses.setText("");
    }

}

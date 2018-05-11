package solutis.jose.com.solutiscoffeeclub_mobile;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import solutis.jose.com.solutiscoffeeclub_mobile.Retrofit.RetrofitConf;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addButton;
    private ArrayList<Capsula> capsulas;
    private ListView listaCafe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_main);

        capsulas = new ArrayList<>();

        listaCafe = findViewById(R.id.listView);

        addButton = findViewById(R.id.floatingActionButton2);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent ob = new Intent(MainActivity.this, CreateEditActivity.class);
                startActivity(ob);
            }
        });

        final Handler mainHandler = new Handler(getBaseContext().getMainLooper());
        final Runnable run = new Runnable() {
            @Override
            public void run() {
                final ArrayAdapter adapter = new CafeAdapter(getBaseContext(), capsulas);
                listaCafe.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {
                Call<ArrayList<Capsula>> call = new RetrofitConf().getCapsulaController().getCapsulas();
                try{
                    capsulas = (call.execute().body());

                    mainHandler.post(run);

                    Log.d("teste", capsulas.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //menu.getItem(0).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.sair:
                System.exit(0);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }


}

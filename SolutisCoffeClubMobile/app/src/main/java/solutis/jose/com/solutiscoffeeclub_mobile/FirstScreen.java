package solutis.jose.com.solutiscoffeeclub_mobile;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends AppCompatActivity {

    Button  enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().hide();
        setTheme(R.style.MenuTheme);
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_first_screen);
        enterButton = (Button)findViewById(R.id.homeButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent ob = new Intent(FirstScreen.this, MainActivity.class);
                startActivity(ob);
            }
        });
    }
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("----main activity---onStart---");
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onPause(){
        super.onPause();

    }

}

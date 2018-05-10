package solutis.jose.com.solutiscoffeeclub_mobile;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateEditActivity extends AppCompatActivity {

    FloatingActionButton confirmButton;
    FloatingActionButton cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit);
        confirmButton = (FloatingActionButton)findViewById(R.id.floatingActionButtonOk);
        cancelButton = (FloatingActionButton)findViewById(R.id.floatingActionButtonCancel);
    }
}

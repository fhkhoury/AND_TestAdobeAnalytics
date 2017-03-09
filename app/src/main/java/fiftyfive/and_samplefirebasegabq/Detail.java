package fiftyfive.and_samplefirebasegabq;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Detail extends AppCompatActivity {

    Context context = getApplicationContext();
    //Définition du toast
    CharSequence text = "CALL MADE !";
    int duration = Toast.LENGTH_LONG;
    Toast toast = Toast.makeText(context, text, duration);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast.show();
            }
        });

        Button infos = (Button) findViewById(R.id.informations);
        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Detail.this, Informations.class);
                startActivity(i);
            }
        });
    }

}

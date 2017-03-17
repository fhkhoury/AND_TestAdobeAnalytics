package fiftyfive.and_testadobeanalytics;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adobe.mobile.*;

import java.util.HashMap;

public class Detail extends AppCompatActivity {

    private HashMap<String, Object> contextData = new HashMap<String, Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Context context = getApplicationContext();
        //Définition du toast
        CharSequence text = "CALL MADE !";
        int duration = Toast.LENGTH_LONG;
        final Toast toast = Toast.makeText(context, text, duration);

        setContentView(R.layout.activity_detail);

        Button call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contextData.put("Pluto", "Wouaf");
                Analytics.trackAction("Call", contextData);
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

    @Override
    public void onResume(){
        super.onResume();
        Config.collectLifecycleData(this);
    }

    @Override
    public void onPause(){
        super.onPause();
        Config.pauseCollectingLifecycleData();
    }

}

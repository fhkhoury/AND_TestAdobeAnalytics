package fiftyfive.and_testadobeanalytics;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.adobe.mobile.*;

import java.util.HashMap;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;
    private HashMap<String, Object> contextData = new HashMap<String, Object>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Allow the SDK access to the application context
        Config.setContext(this.getApplicationContext());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, HomePage.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onResume(){
        super.onResume();
        this.contextData.put("coucou", "Mickey");
        Config.collectLifecycleData(this, this.contextData);
    }

    @Override
    public void onPause(){
        super.onPause();
        Config.pauseCollectingLifecycleData();
    }
}

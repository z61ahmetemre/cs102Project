    package com.example.ahmet.billib;

    import android.app.FragmentManager;
    import android.app.FragmentTransaction;
    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Toast;

    import java.util.ArrayList;

    import static android.R.attr.fragment;
    import static android.R.id.message;
    import static android.provider.AlarmClock.EXTRA_MESSAGE;
    import static com.example.ahmet.billib.R.id.rules_button;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Button rules = (Button) findViewById(R.id.rules_button);
            rules.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, RulesActivity.class);
                    startActivity(myIntent);
                }
            });
            Button notifications = (Button) findViewById(R.id.notification_button);
            notifications.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent2 = new Intent(MainActivity.this, NotificationActivity.class);
                    startActivity(myIntent2);
                }
            });
        }

         @Override
        protected void onResume()
         {
             super.onResume();
         }

         @Override
        protected void onPause()
         {
             super.onPause();
         }

         protected void onDestroy()
         {
             super.onDestroy();
         }

         public ArrayList<Book> search( String str)
         {
             return null;
         }


    }

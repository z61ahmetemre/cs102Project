    package com.example.ahmet.billib;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
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

         public String rules()
         {
             return "rules";
         }
    }

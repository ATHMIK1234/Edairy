package com.example.edairy;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
public class MenuAppCompatActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.list,menu);
        return true;
    }
    public void handleread(MenuItem item) {
        //Toast.makeText(this, "handleread", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,read.class);
        startActivity(i);
    }
    public void handlewrite(MenuItem item) {
        Intent i=new Intent(this,home.class);
        startActivity(i);
    }

    public void handledelete(MenuItem item) {
        Intent i=new Intent(this,delete.class);
        startActivity(i);
    }
}

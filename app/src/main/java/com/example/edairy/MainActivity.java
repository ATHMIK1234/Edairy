package com.example.edairy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText le1, le2;
    String ls1, ls2;
    Userdb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        le1 = findViewById(R.id.editTextText);
        le2 = findViewById(R.id.editTextTextPassword);
        db = new Userdb(this);
    }

    public void reg(View view) {
        Intent i = new Intent(MainActivity.this, register.class);
        startActivity(i);
    }
    public void log(View view) {
        ls1 = le1.getText().toString();
        ls2 = le2.getText().toString();
        String loc = db.retrv(ls1);
        if (ls2.equals(loc)) {
            Toast.makeText(this, "Login Succefull", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,home.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}

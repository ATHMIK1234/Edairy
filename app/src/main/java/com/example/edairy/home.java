package com.example.edairy;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Date;
public class home extends MenuAppCompatActivity {
    EditText he1,he2;
    Button hb1;
    Userdb db;
    String hs1,hs2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        he1=findViewById(R.id.editTextDate);
        he2=findViewById(R.id.editTextTextMultiLine);
        hb1=findViewById(R.id.button3);
        db=new Userdb(this);
        Date d = new Date();
        CharSequence s  = DateFormat.format("dd/M/yyyy", d.getTime());
        he1.setText(s);
    }
    public void hsave(View view) {
        hs1=he1.getText().toString();
        hs2=he2.getText().toString();
        db.hsavedata(hs1,hs2);
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(R.id.action_w);
        return super.onPrepareOptionsMenu(menu);
    }
}
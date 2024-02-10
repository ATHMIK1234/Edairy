package com.example.edairy;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;
public class delete extends MenuAppCompatActivity {
    EditText de1;
    String ds1;
    Userdb db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        de1=findViewById(R.id.editTextDate3);
        db=new Userdb(this);

    }
    public void datepic(View view) {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dp=new DatePickerDialog(delete.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        de1.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                },mYear,mMonth,mDay);
        dp.show();
    }
    public void delete(View view) {
        ds1=de1.getText().toString();
        String d=db.dele(ds1);
        int i=Integer.parseInt(d);
        if (i>0) {
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Data Not found", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(R.id.action_d);
        return super.onPrepareOptionsMenu(menu);
    }
}
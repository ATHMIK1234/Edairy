package com.example.edairy;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;
public class read extends MenuAppCompatActivity {
    EditText re1;
    String rs1;
    Userdb db;
    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        re1=findViewById(R.id.editTextDate2);
        db=new Userdb(this);
        tv=findViewById(R.id.textView);
    }
    public void read(View view) {
        rs1=re1.getText().toString();
        String vi=db.view(rs1);
        tv.setText(vi);
    }
    public void datepic(View view) {
        Date d=new Date();
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dp=new DatePickerDialog(read.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        re1.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                },mYear,mMonth,mDay);
        dp.show();
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(R.id.action_r);
        return super.onPrepareOptionsMenu(menu);
    }
}
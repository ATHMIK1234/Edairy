package com.example.edairy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class register extends AppCompatActivity {
    EditText Re1,Re2,Re3;
    Button Rb1;
    Userdb db;
    String Rsemail,Rspass,Rspassconfi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Re1=findViewById(R.id.Remail);
        Re2=findViewById(R.id.Rpass);
        Re3=findViewById(R.id.Rpassconfi);
        Rb1=findViewById(R.id.Rbutton);
        db=new Userdb(this);

    }
    public void Rsave(View view) {
        Rsemail=Re1.getText().toString();
        Rspass=Re2.getText().toString();
        Rspassconfi=Re3.getText().toString();
        if (Rspass.equals(Rspassconfi)){
            if (!isValidPassword(Rspass,Rsemail)) {
                Toast.makeText(register.this, "User name Password Does not match the rules", Toast.LENGTH_LONG).show();
            }
            else {
                db.Rsavedata(Rsemail, Rspass);
                Toast.makeText(this, Rsemail + "--" + Rspass + "Saved Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(register.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
    private Boolean isValidPassword(String rspass, String rsemail) {
        if (rsemail.length()<10){
            return false;
        }
        if (rspass.length() < 8) {
            return false;
        }
        return true;
    }
}
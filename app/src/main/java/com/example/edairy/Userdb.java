package com.example.edairy;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Userdb extends SQLiteOpenHelper {
    SQLiteDatabase sq;
    String res="";
    String result;

    public Userdb(
            Context context
    ) {
        super(context, "Edairy.db", null, 1);
        sq=getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user(email_number text,password text)");
        sqLiteDatabase.execSQL("create table data(Date text,Text text)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void Rsavedata(String rsemail, String rspass) {
        ContentValues cv=new ContentValues();
        cv.put("email_number",rsemail);
        cv.put("password",rspass);
        sq.insert("user",null,cv);
    }
    public String retrv(String ls1) {
        Cursor c;
        c=sq.query("user",null,"email_number=?",new String[]{ls1},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1){
            return "No Data";
        }
        String l= c.getString(c.getColumnIndex("password"));
        return l;
    }
    public void hsavedata(String hs1, String hs2) {
        ContentValues cv=new ContentValues();
        cv.put("Date",hs1);
        cv.put("Text",hs2);
        sq.insert("data",null,cv);
    }
    public String view(String rs1) {
        Cursor c;
        c=sq.query("data",null,"Date=?",new String[]{rs1},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1){
            return "No Data";
        }
        do {
            res += c.getString(c.getColumnIndex("Text")) + "\n" ;
        }while (c.moveToNext());
        return res;
    }
    public String dele(String ds1) {
       result = String.valueOf(sq.delete("data","Date = '"+ds1+"'",null));
       return result;
    }
}

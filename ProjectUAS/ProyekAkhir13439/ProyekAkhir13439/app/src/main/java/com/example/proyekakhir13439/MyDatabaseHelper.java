package com.example.proyekakhir13439;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "CShoesPencucian.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "pesanan";
    private static final String COLUMN_ID = "no_id";
    private static final String COLUMN_NAMA = "nama_pemesan";
    private static final String COLUMN_TLP = "tlp_pemesan";
    private static final String COLUMN_MEREK = "merek_sepatu";
    private static final String COLUMN_WARNA = "warna_sepatu";
    private static final String COLUMN_UKURAN = "ukuran_sepatu";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAMA + " TEXT, " +
                COLUMN_TLP + " TEXT, " +
                COLUMN_MEREK + " TEXT, " +
                COLUMN_WARNA + " TEXT, " +
                COLUMN_UKURAN + " TEXT);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addPesanan(String nama, String tlp, String merek, String warna, String ukuran){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAMA, nama);
        cv.put(COLUMN_TLP, tlp);
        cv.put(COLUMN_MEREK, merek);
        cv.put(COLUMN_WARNA, warna);
        cv.put(COLUMN_UKURAN, ukuran);

        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String nama, String tlp, String merek, String warna, String ukuran){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAMA, nama);
        cv.put(COLUMN_TLP, tlp);
        cv.put(COLUMN_MEREK, merek);
        cv.put(COLUMN_WARNA, warna);
        cv.put(COLUMN_UKURAN, ukuran);

        long result = db.update(TABLE_NAME, cv, "no_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    //menghapus dalah satu baris data
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "no_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
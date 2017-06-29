package com.xyz.employeeadb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashmi Chhabria on 9/28/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase db;

    DatabaseHandler(Context context) {
        super(context, "EmployeeDatabase", null, 2);
        Log.d("DB123", "Database Created/Opened");
        this.context = context;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE employee (eId INTEGER PRIMARY KEY, eName TEXT)";
        db.execSQL(s);
        Log.d("DB123", "TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String d = "DROP TABLE IF EXISTS employee";
        db.execSQL(d);
        Log.d("DB123", "TABLE DROPPED");
        onCreate(db);
    }

    public void addEmployee(Employee e) {
        ContentValues values = new ContentValues();
        values.put("eid", e.getEid());
        values.put("ename", e.getEname());
        db.insert("employee", null, values);
    }

    public List<Employee> getAllEmployees() {
        Cursor cursor = db.query("employee", new String[]{"eid", "ename"}, null, null, null, null, null);

        List<Employee> e = new ArrayList<>();

        cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {

            do {
                String eid = cursor.getString(0);
                String ename = cursor.getString(1);
                Employee e1 = new Employee(Integer.parseInt(eid), ename);
                e.add(e1);
            }
            while (cursor.moveToNext());
        }
        return e;
    }

    public void deleteEmployee(int id) {
        db.delete("employee", "eid = " + id, null);
        Log.d("DB123", "DELETED");
    }

    public void updateEmployee(Employee e) {
        ContentValues values = new ContentValues();
        values.put("eid", e.getEid());
        values.put("ename", e.getEname());
        db.update("employee", values, "eid = " +e.getEid(), null);
    }


}

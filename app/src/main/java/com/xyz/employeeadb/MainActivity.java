package com.xyz.employeeadb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etId;
    EditText etName;
    Button btnAdd, btnUpdate, btnDelete;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = (EditText) findViewById(R.id.etId);
        etName = (EditText) findViewById(R.id.etName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        tvData = (TextView) findViewById(R.id.tvData);

        final DatabaseHandler db1 = new DatabaseHandler(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eid = Integer.parseInt(etId.getText().toString());
                String ename = etName.getText().toString();
                Employee e = new Employee(eid, ename);
                db1.addEmployee(e);

                StringBuffer ab = new StringBuffer();
                List<Employee> e1 = db1.getAllEmployees();
                for (Employee m : e1) {
                    ab.append(m.getEid() + " " + m.getEname() + "\n");
                }
                tvData.setText(ab.toString());
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eid= Integer.parseInt(etId.getText().toString());
                db1.deleteEmployee(eid);

                StringBuffer ab = new StringBuffer();
                List<Employee> e1 = db1.getAllEmployees();
                for (Employee m : e1) {
                    ab.append(m.getEid() + " " + m.getEname() + "\n");
                }
                tvData.setText(ab.toString());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eid = Integer.parseInt(etId.getText().toString());
                String ename = etName.getText().toString();
                Employee e = new Employee(eid, ename);
                db1.updateEmployee(e);

                StringBuffer ab = new StringBuffer();
                List<Employee> e1 = db1.getAllEmployees();
                for (Employee m : e1) {
                    ab.append(m.getEid() + " " + m.getEname() + "\n");
                }
                tvData.setText(ab.toString());
            }
        });

    }

}

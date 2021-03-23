package com.example.firebaseemployee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    TextView tv;
    DatabaseReference database;
    int counter = 0;
    int employeeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance().getReference("employees");
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        tv = findViewById(R.id.tv);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            employeeID = (int) snapshot.getChildrenCount();
            Employee emp;
            counter = 0;
            StringBuilder value = new StringBuilder();
            for (DataSnapshot ds: snapshot.getChildren()){
                emp = (Employee)ds.getValue(Employee.class);
                Log.i("MAINACTIVITY", counter + " - Firstname: " + emp.getFirstName() + "Lastname: " + emp.getLastName());
                value.append(emp.toString(Integer.toString(counter)));
                counter = counter+1;
                }
            tv.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + error.toException());
            }
        });
    }
    public void addEmployee (View view) {
        String employeeNum = Integer.toString(counter);
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();

        if (fName.isEmpty()) {
            firstName.setError("Please enter the First Name");
        }
        else if (lName.isEmpty()) {
            lastName.setError("Please enter the Last Name");
        }
        else {
            Employee emp = new Employee(
                    firstName.getText().toString(),
                    lastName.getText().toString()
            );
            database.child(String.valueOf(counter)).setValue(emp);
            firstName.setText("");
            lastName.setText("");

        }

    }


}


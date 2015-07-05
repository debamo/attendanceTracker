package com.example.owner.attendance_tracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owner.attendance_tracker.Data.UserHelper;


public class AddStudent extends ActionBarActivity {
    //private StudentDetails stu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText parents_name = (EditText) findViewById(R.id.editText2);
        final EditText mobile = (EditText) findViewById(R.id.editText3);
        final EditText address = (EditText) findViewById(R.id.editText4);
        Button add = (Button) findViewById(R.id.button);
        final UserHelper db = new UserHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.getWritableDatabase();
                String stud_name = name.getText().toString();
                String parent_name =parents_name.getText().toString();
                String mob = mobile.getText().toString();
                String addr = address.getText().toString();
                long result = db.insertStudent(stud_name,parent_name,mob,addr);
                Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.owner.project_attendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owner.project_attendance.Data.UserHelper;

public class NextStudent extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_main, container, false);
        final EditText name = (EditText) rootView.findViewById(R.id.editText);
        final EditText parents_name = (EditText) rootView.findViewById(R.id.editText2);
        final EditText mobile = (EditText) rootView.findViewById(R.id.editText3);
        final EditText address = (EditText) rootView.findViewById(R.id.editText4);
        Button add = (Button) rootView.findViewById(R.id.button);
        final UserHelper db = new UserHelper(this.getActivity());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.getWritableDatabase();
                String stud_name = name.getText().toString();
                String parent_name =parents_name.getText().toString();
                String mob = mobile.getText().toString();
                String addr = address.getText().toString();
                long result = db.insertStudent(stud_name,parent_name,mob,addr);
                db.close();
                Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }

}

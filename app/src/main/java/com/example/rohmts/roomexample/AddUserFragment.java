package com.example.rohmts.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText mEditTextId, mEditTextName, mEditTextEmail;
    private Button mButtonSave;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        mEditTextId = view.findViewById(R.id.editText_user_id);
        mEditTextName = view.findViewById(R.id.editText_user_name);
        mEditTextEmail = view.findViewById(R.id.editText_user_email);
        mButtonSave = view.findViewById(R.id.button_save_user);

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(mEditTextId.getText().toString().trim());
                String username = mEditTextName.getText().toString().trim();
                String useremail = mEditTextEmail.getText().toString().trim();

                User user = new User();
                user.setId(userId);
                user.setName(username);
                user.setEmail(useremail);

                //set data to db
                MainActivity.appDatabase.dataAccessObject().addUser(user);
                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();

                mEditTextId.setText("");
                mEditTextName.setText("");
                mEditTextEmail.setText("");
            }
        });

        return view;
    }

}

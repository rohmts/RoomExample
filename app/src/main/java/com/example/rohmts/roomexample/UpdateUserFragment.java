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
public class UpdateUserFragment extends Fragment {

    private EditText mEditTextId, mEditTextName, mEditTextEmail;
    private Button mButtonUpdate;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);
        mEditTextId = view.findViewById(R.id.editText_user_id);
        mEditTextName = view.findViewById(R.id.editText_user_name);
        mEditTextEmail = view.findViewById(R.id.editText_user_email);
        mButtonUpdate = view.findViewById(R.id.button_update_user);

        mButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(mEditTextId.getText().toString().trim());
                String name = mEditTextName.getText().toString().trim();
                String email = mEditTextEmail.getText().toString().trim();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.appDatabase.dataAccessObject().updateUser(user);

                Toast.makeText(getActivity(), "User updated!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}

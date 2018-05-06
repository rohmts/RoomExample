package com.example.rohmts.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {

    private EditText mEditTextDeleteUser;
    private Button mButtonDeleteUser;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        mEditTextDeleteUser = view.findViewById(R.id.editText_delete_user_id);
        mButtonDeleteUser = view.findViewById(R.id.button_delete_user);
        mButtonDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(mEditTextDeleteUser.getText().toString().trim());
                User user = new User();
                user.setId(id);
                MainActivity.appDatabase.dataAccessObject().deleteUser(user);

                Toast.makeText(getActivity(), "User deleted!", Toast.LENGTH_SHORT).show();
                mEditTextDeleteUser.setText("");
            }
        });
        return view;
    }

}

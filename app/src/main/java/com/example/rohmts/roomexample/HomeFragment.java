package com.example.rohmts.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button mButtonAddUser,mButtonReadUsers, mButtonUpdateUser, mButtonDeleteUser;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mButtonAddUser = view.findViewById(R.id.button_add_user);
        mButtonReadUsers = view.findViewById(R.id.button_read_users);
        mButtonUpdateUser = view.findViewById(R.id.button_update_user);
        mButtonDeleteUser = view.findViewById(R.id.button_delete_user);
        mButtonAddUser.setOnClickListener(this);
        mButtonReadUsers.setOnClickListener(this);
        mButtonUpdateUser.setOnClickListener(this);
        mButtonDeleteUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_read_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new ReadUsersFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new UpdateUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.button_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new DeleteUserFragment()).addToBackStack(null).commit();
                break;
        }
    }
}

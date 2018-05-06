package com.example.rohmts.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUsersFragment extends Fragment {

    private TextView mTextViewDisplayUserName;

    public ReadUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_users, container, false);
        mTextViewDisplayUserName = view.findViewById(R.id.textView_display_username);

        List<User> users = MainActivity.appDatabase.dataAccessObject().getUsers();
        String info = "";
        for (User user : users) {
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info+"\n\n"+"Id : "+id+"\nName : "+name+"\nEmail : "+email;
        }

        mTextViewDisplayUserName.setText(info);

        return view;
    }

}

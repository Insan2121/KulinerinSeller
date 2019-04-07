package com.example.kulinerinseller.features.mainscreen.account;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kulinerinseller.MainActivity;
import com.example.kulinerinseller.R;
import com.example.kulinerinseller.features.mainscreen.MainScreenActivity;
import com.example.kulinerinseller.features.transactionlist.TransactionList;

public class AccountFragment extends Fragment {
    String[] menu = {"Edit Profile", "Transaction List", "Reviews", "Logout"};
    public View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return view = inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = new ArrayAdapter<String>(MainScreenActivity.getInstance(),
                R.layout.account_listview, menu);

        ListView listView = view.findViewById(R.id.list_view_account);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Intent intent = new Intent(MainScreenActivity.getInstance(), TransactionList.class);
                    MainScreenActivity.getInstance().startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

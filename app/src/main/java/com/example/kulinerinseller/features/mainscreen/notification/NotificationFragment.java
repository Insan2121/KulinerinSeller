package com.example.kulinerinseller.features.mainscreen.notification;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerinseller.R;

public class NotificationFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        this.initChat();
//        chatRecyclerView = view.findViewById(R.id.recycler_view_chat);
//        chatRecyclerView.setLayoutManager(new LinearLayoutManager(
//                getActivity()
//        ));
//
//        chatRecyclerView.setHasFixedSize(true);
//        chatAdapter = new ChatAdapter(MainScreenActivity.getInstance() ,chats);
//        chatRecyclerView.setAdapter(chatAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

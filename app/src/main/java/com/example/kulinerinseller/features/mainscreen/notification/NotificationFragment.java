package com.example.kulinerinseller.features.mainscreen.notification;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kulinerinseller.R;
import com.example.kulinerinseller.features.mainscreen.MainScreenActivity;
import com.example.kulinerinseller.models.Notification;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    private RecyclerView chatRecyclerView;
    private NotificationAdapter chatAdapter;
    private ArrayList<Notification> notifications = new ArrayList<>();
    private View view;

    public NotificationFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return view = inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.initNotification();
        chatRecyclerView = view.findViewById(R.id.recycler_view_notification);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity()
        ));

        chatRecyclerView.setHasFixedSize(true);
        chatAdapter = new NotificationAdapter(MainScreenActivity.getInstance() ,notifications);
        chatRecyclerView.setAdapter(chatAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void initNotification() {
        this.notifications.add(new Notification());
        this.notifications.add(new Notification());
        this.notifications.add(new Notification());
        this.notifications.add(new Notification());
    }
}

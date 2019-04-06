package com.example.kulinerinseller.features.mainscreen.statistic;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.kulinerinseller.R;
import com.example.kulinerinseller.features.mainscreen.MainScreenActivity;
import com.example.kulinerinseller.models.Seller;

import java.util.ArrayList;

public class StatisticFragment extends Fragment {
    public ArrayList<Seller> topProducts =  new ArrayList<>();
    public RecyclerView topProductRecyclerView;
    public TopProductAdapter topProductAdapter;
    public View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return view = inflater.inflate(R.layout.fragment_statistic, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hideStatusBar();

        this.initTopProduct();
        topProductRecyclerView = view.findViewById(R.id.recycler_view_top_product);
        topProductRecyclerView.setLayoutManager(new GridLayoutManager(
                MainScreenActivity.getInstance(),
                2,
                GridLayoutManager.VERTICAL,
                false));
        topProductRecyclerView.setHasFixedSize(true);
        topProductAdapter = new TopProductAdapter(topProducts);
        topProductRecyclerView.setAdapter(topProductAdapter);
    }

    public void hideStatusBar() {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(MainScreenActivity.getInstance(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            MainScreenActivity.getInstance().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(MainScreenActivity.getInstance(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            MainScreenActivity.getInstance().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public void initTopProduct() {
        topProducts.add(new Seller());
        topProducts.add(new Seller());
        topProducts.add(new Seller());
        topProducts.add(new Seller());
        topProducts.add(new Seller());
        topProducts.add(new Seller());
        topProducts.add(new Seller());
        topProducts.add(new Seller());
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

package com.example.nsundov.barcodescanner;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends ListFragment {

    private ArrayAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();
    private SharedPreferences sharedPreferences;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sharedPreferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        list.clear();
        list.addAll(new Utils().loadOrderedCollection(getContext(), "history"));
        adapter.notifyDataSetChanged();

        return super.onCreateView(inflater, container, savedInstanceState);
    }



}

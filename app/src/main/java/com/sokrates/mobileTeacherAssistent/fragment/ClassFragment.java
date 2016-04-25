package com.sokrates.mobileTeacherAssistent.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Klasse;
import com.sokrates.mobileTeacherAssistent.listener.SelectionItemListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ClassFragment extends ListFragment {

    final String ATTRIBUTE_NAME_ID = "id";
    final String ATTRIBUTE_NAME_TITLE = "title";

    private SelectionItemListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
                ArrayList<Klasse> klassen = getArguments().getParcelableArrayList("klassen");
                ArrayList<Map<String, Object>> data = new ArrayList<>(klassen.size());
                Map<String, Object> m;

                for (Klasse kl : klassen) {
                    m = new HashMap<String, Object>();
                    m.put(ATTRIBUTE_NAME_ID, kl.getId().getKlId());
                    m.put(ATTRIBUTE_NAME_TITLE, kl.getKlName());
                    data.add(m);
                }
                String[] from = {ATTRIBUTE_NAME_ID, ATTRIBUTE_NAME_TITLE};
                int[] to = {R.id.idItemInvis, R.id.listText};
                SimpleAdapter sAdapter = new SimpleAdapter(getActivity().getApplicationContext(), data, R.layout.list_simple, from, to);
                setListAdapter(sAdapter);
        }catch (NullPointerException e){
            Toast.makeText(getActivity().getApplicationContext(), "Error", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Map<String, Object> obj = (Map<String, Object>)getListAdapter().getItem(position);
        mCallback.onItemSelected(obj);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (SelectionItemListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SelectionPositionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

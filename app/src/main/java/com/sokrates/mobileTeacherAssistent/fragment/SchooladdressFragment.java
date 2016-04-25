package com.sokrates.mobileTeacherAssistent.fragment;


import android.app.Activity;
import android.app.ListFragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Schuele;
import com.sokrates.mobileTeacherAssistent.domain.Schueleradresse;
import com.sokrates.mobileTeacherAssistent.domain.Schuelstandort;
import com.sokrates.mobileTeacherAssistent.listener.SelectionItemListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SchooladdressFragment extends ListFragment {

    private static final String ATTRIBUTE_NAME_FULLTEXT = "fulltext";
    private static final Integer MENU_ITEM_1 = 1;

    private SelectionItemListener mCallback;

    private SimpleAdapter sAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            ArrayList<Schuele> schooladdresses = getArguments().getParcelableArrayList("schooladdresses");
            ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(schooladdresses.size());
            Map<String, Object> m;

            for (Schuelstandort so : schooladdresses.get(0).getSchulstandort()) {
                m = new HashMap();

                String info = so.getSo_ORT() + ", "
                        + so.getSo_STRASSE() + ", "
                        + so.getSo_HAUSNR();

                m.put(ATTRIBUTE_NAME_FULLTEXT, info);
                data.add(m);
            }

            String[] from = {ATTRIBUTE_NAME_FULLTEXT};
            int[] to = {R.id.listText};
            sAdapter = new SimpleAdapter(getActivity().getApplicationContext(), data, R.layout.list_address, from, to);
            setListAdapter(sAdapter);
        }catch (NullPointerException e){
            Toast.makeText(getActivity().getApplicationContext(), "Error NullPointerException", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        registerForContextMenu(getListView());
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        //menu.setHeaderTitle("Menu");

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        Map<String, Object> obj = (Map<String, Object>) getListView().getItemAtPosition(info.position);
        menu.add(0, MENU_ITEM_1, 0, R.string.context_menu_5);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Map<String, Object> obj = (Map<String, Object>) getListView().getItemAtPosition(info.position);
        String address = "";
        if(obj.get(ATTRIBUTE_NAME_FULLTEXT) != null) {
            address = obj.get(ATTRIBUTE_NAME_FULLTEXT).toString();
            address = address.replace(' ', '+');
        }
        if(item.getItemId() == MENU_ITEM_1){
            try {
                Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
                startActivity(geoIntent);
            }catch (ActivityNotFoundException e){
                Toast.makeText(getActivity().getApplicationContext(), "Application not found", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onDetach() {
        super.onDetach();


    }
}

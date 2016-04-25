package com.sokrates.mobileTeacherAssistent.fragment;


import android.app.Activity;
import android.app.ListFragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.widget.Toast;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Schueleradresse;
import com.sokrates.mobileTeacherAssistent.listener.SelectionItemListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PupiladdressFragment extends ListFragment {

    private static final String ATTRIBUTE_NAME_ID = "id";
    private static final String ATTRIBUTE_NAME_FULLTEXT = "fulltext";
    private static final String ATTRIBUTE_NAME_TEL1 = "tel1";
    private static final String ATTRIBUTE_NAME_TEL2 = "tel2";
    private static final String ATTRIBUTE_NAME_ADDRESS = "address";

    private static final Integer MENU_ITEM_1 = 1;
    private static final Integer MENU_ITEM_2 = 2;
    private static final Integer MENU_ITEM_3 = 3;
    private static final Integer MENU_ITEM_4 = 4;
    private static final Integer MENU_ITEM_5 = 5;


    private SelectionItemListener mCallback;

    private SimpleAdapter sAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            ArrayList<Schueleradresse> pupiladdresses = getArguments().getParcelableArrayList("pupiladdresses");
            ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(pupiladdresses.size());
            Map<String, Object> m;

            for (Schueleradresse sa : pupiladdresses) {
                m = new HashMap();
                m.put(ATTRIBUTE_NAME_ID, sa.getId().getSa_ID());

                String info = "";
                info += sa.getSa_ART() + ": " + sa.getSa_ANREDE2();
                info += "\n" + sa.getSa_ORT() + ", " + sa.getSa_STRASSE() + ", " + sa.getSa_HAUSNR();
                if (sa.getSa_BERUF() != null) info += "\n" + sa.getSa_BERUF();
                if (sa.getSa_TEL1() != null) {
                    info += "\n" + "Telefon 1: " + sa.getSa_TEL1();
                    m.put(ATTRIBUTE_NAME_TEL1, sa.getSa_TEL1());
                }
                if (sa.getSa_TEL2() != null) {
                    info += "\n" + "Telefon 2: " + sa.getSa_TEL2();
                    m.put(ATTRIBUTE_NAME_TEL2, sa.getSa_TEL2());
                }
                if (sa.getSa_FAX() != null) info += "\n" + "Fax: " + sa.getSa_FAX();

                m.put(ATTRIBUTE_NAME_FULLTEXT, info);
                m.put(ATTRIBUTE_NAME_ADDRESS, sa.getSa_ORT() + " " + sa.getSa_STRASSE() + " " + sa.getSa_HAUSNR());
                data.add(m);
            }

            String[] from = {ATTRIBUTE_NAME_ID, ATTRIBUTE_NAME_FULLTEXT, ATTRIBUTE_NAME_TEL1, ATTRIBUTE_NAME_TEL2, ATTRIBUTE_NAME_ADDRESS};
            int[] to = {R.id.idItemInvis, R.id.listText, R.id.tel1Invis, R.id.tel2Invis, R.id.addressInvis};
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
        if(obj.get(ATTRIBUTE_NAME_TEL1) != null){
            menu.add(0, MENU_ITEM_1, 0, R.string.context_menu_1);
            menu.add(0, MENU_ITEM_2, 0, R.string.context_menu_2);
        }
        if(obj.get(ATTRIBUTE_NAME_TEL2) != null) {
            menu.add(0, MENU_ITEM_3, 0, R.string.context_menu_3);
            menu.add(0, MENU_ITEM_4, 0, R.string.context_menu_4);
        }
        if(obj.get(ATTRIBUTE_NAME_ADDRESS) != null) {
            menu.add(0, MENU_ITEM_5, 0, R.string.context_menu_5);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Map<String, Object> obj = (Map<String, Object>) getListView().getItemAtPosition(info.position);

        String telephone1 = "";
        String telephone2 = "";
        String address = "";

        if(obj.get(ATTRIBUTE_NAME_TEL1) != null) {
            telephone1 = getTelephone(obj.get(ATTRIBUTE_NAME_TEL1).toString());
        }
        if(obj.get(ATTRIBUTE_NAME_TEL2) != null) {
            telephone2 = getTelephone(obj.get(ATTRIBUTE_NAME_TEL2).toString());
        }
        if(obj.get(ATTRIBUTE_NAME_ADDRESS) != null) {
            address = obj.get(ATTRIBUTE_NAME_ADDRESS).toString();
            address = address.replace(' ', '+');
        }

        if(item.getItemId() == MENU_ITEM_1){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telephone1));
            startActivity(intent);

        } else if(item.getItemId() == MENU_ITEM_2){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telephone1));
            startActivity(intent);

        }else if(item.getItemId() == MENU_ITEM_3){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telephone2));
            startActivity(intent);

        }else if(item.getItemId() == MENU_ITEM_4){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telephone2));
            startActivity(intent);
        }else if(item.getItemId() == MENU_ITEM_5){
            try {
                Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
                startActivity(geoIntent);
            }catch (ActivityNotFoundException e){
                Toast.makeText(getActivity().getApplicationContext(), "Application not found", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onContextItemSelected(item);
    }

    public String getTelephone(String text){

        return text.replaceAll("[^\\d.]", "");
    }

    @Override
    public void onDetach() {
        super.onDetach();


    }
}

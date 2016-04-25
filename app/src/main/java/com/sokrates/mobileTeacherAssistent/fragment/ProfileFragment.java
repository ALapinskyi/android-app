package com.sokrates.mobileTeacherAssistent.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.listener.SelectionPositionListener;


public class ProfileFragment extends ListFragment {

    private SelectionPositionListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String itemKlassen = getResources().getString(R.string.item_klassen);
        String itemSchuelern = getResources().getString(R.string.item_schuelern);
        String[] item = {itemKlassen, itemSchuelern};
        ArrayAdapter<String> fileList = new ArrayAdapter<String>(getActivity(), R.layout.list_profile, item);
        setListAdapter(fileList);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        mCallback.onItemSelected(position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (SelectionPositionListener) activity;
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

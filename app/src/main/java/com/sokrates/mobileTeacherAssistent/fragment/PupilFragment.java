package com.sokrates.mobileTeacherAssistent.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.SimpleCursorAdapter;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Schueler;
import com.sokrates.mobileTeacherAssistent.listener.SelectionCursorListener;

import java.util.ArrayList;


public class PupilFragment extends ListFragment {

    private SelectionCursorListener mCallback;



    public static final String VALUE_COLUMN = "value_column";
    public static final String[] PROJECTION = new String[] {
            BaseColumns._ID,
            VALUE_COLUMN
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        final String ATTRIBUTE_NAME_ID = "_ID";
        final String ATTRIBUTE_NAME_FULLNAME = "DISPLAY_NAME";
        ArrayList<Schueler> schuelern = getArguments().getParcelableArrayList("pupils");

       /* ArrayList<Map<String, Object>> data = new ArrayList<>(schuelern.size());
        Map<String, Object> m;

        for(Schueler sk: schuelern){
            m = new HashMap();
            m.put(ATTRIBUTE_NAME_ID, sk.getSg_kennzahl());
            m.put(ATTRIBUTE_NAME_FULLNAME, sk.getSg_FAMNAME()+ " " + sk.getSg_VORNAME1());
            data.add(m);
        }*/

        String[] from = { ATTRIBUTE_NAME_ID, ATTRIBUTE_NAME_FULLNAME };
        int[] to = { R.id.idItemInvis, R.id.listText};
        //SimpleAdapter sAdapter = new SimpleAdapter(getActivity().getApplicationContext(), data, R.layout.list_simple, from, to);
        //setListAdapter(sAdapter);

        String[] columns = new String[] { ATTRIBUTE_NAME_ID, ATTRIBUTE_NAME_FULLNAME};

        MatrixCursor matrixCursor= new MatrixCursor(columns);
        getActivity().startManagingCursor(matrixCursor);

        for(Schueler sk: schuelern){
            matrixCursor.addRow(new Object[] { sk.getSg_kennzahl(), sk.getSg_FAMNAME()+ " " + sk.getSg_VORNAME1() });
        }

        /*SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(getActivity().getApplicationContext(), R.layout.list_simple, matrixCursor, from, to);*/
        setListAdapter(new AlphanumericAdapter(getActivity(), matrixCursor, from, to));

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setFastScrollAlwaysVisible(true);
        getListView().setFastScrollEnabled(true);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Map<String, Object> obj = (Map<String, Object>)getListAdapter().getItem(position);
        //Cursor cursor = (Cursor) l.getItemAtPosition(position);
        mCallback.onItemSelected(id);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (SelectionCursorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SelectionPositionListener");
        }
    }


    private class AlphanumericAdapter extends SimpleCursorAdapter implements SectionIndexer {

        private final AlphabetIndexer mAlphabetIndexer;

        public AlphanumericAdapter(Context context, Cursor cursor, String[] from, int[] to) {
            super(context, R.layout.list_simple, cursor, from, to);
            CharSequence alphabet = getString(R.string.alphabet);
            mAlphabetIndexer = new AlphabetIndexer(cursor, 1, alphabet);
        }

        @Override
        public Object[] getSections() {
            return mAlphabetIndexer.getSections();
        }

        @Override
        public int getPositionForSection(int sectionIndex) {
            return mAlphabetIndexer.getPositionForSection(sectionIndex);
        }

        @Override
        public int getSectionForPosition(int position) {
            return mAlphabetIndexer.getSectionForPosition(position);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}

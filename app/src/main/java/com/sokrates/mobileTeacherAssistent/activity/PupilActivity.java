package com.sokrates.mobileTeacherAssistent.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Schueler;
import com.sokrates.mobileTeacherAssistent.fragment.PupilFragment;
import com.sokrates.mobileTeacherAssistent.listener.SelectionCursorListener;
import com.sokrates.mobileTeacherAssistent.utils.JSONParser;
import com.sokrates.mobileTeacherAssistent.utils.ConnectUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class PupilActivity extends AbstractActivity implements SelectionCursorListener {

    private PupilFragment pupilFragment;

    protected Integer klId = -1;
    protected String login = "";
    protected String token = "";

     Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schueler);

        SharedPreferences pref_class = getSharedPreferences(PREFS_CLASS,MODE_PRIVATE);
        if(pref_class != null){
            klId = pref_class.getInt(CONST_KLID, 0);
        }

        SharedPreferences pref_login = getSharedPreferences(PREFS_LOGIN, MODE_PRIVATE);
        if(pref_login != null) {
            login = pref_login.getString(CONST_USERNAME, null);
            token = pref_login.getString(CONST_ACCESS_TOKEN, null);
        }
        SharedPreferences pref_activity = getSharedPreferences(PREFS_ACTIVITY, MODE_PRIVATE);
        String parentName = pref_activity.getString(PARENT_ACTIVITY, null);
        if(parentName != null && parentName.equals(PROFILE_ACTIVITY_NAME)){
            PupilTask pupilTask = new PupilTask(token);
            pupilTask.execute((Void) null);
        } else if(parentName != null && parentName.equals(CLASS_ACTIVITY_NAME)){
            ClassPupilTask classPupilTask = new ClassPupilTask(klId, token);
            classPupilTask.execute((Void) null);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schueler, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*if (id == R.id.action_settings) {
            createDialogSettings(PupilActivity.this);
            return true;
        }*/
        if (id == R.id.action_logout) {

            getSharedPreferences(PREFS_LOGIN, MODE_PRIVATE).edit().clear().commit();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(long id) {
        getSharedPreferences(PREFS_PUPIL, MODE_PRIVATE)
                .edit()
                .putLong(CONST_SG, id)
                .commit();

        Intent intent = new Intent(getApplicationContext(), PupiladdressActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        try {
            dialog.dismiss();
        }catch (NullPointerException e){

        }
        super.onStop();
    }

    public void createPupilFragment(String in){
        try {
            ArrayList<Schueler> pupils = (ArrayList<Schueler>) (List<?>) JSONParser.parseToList(in, Schueler.class);
            Collections.sort(pupils, new Comparator<Schueler>() {
                @Override
                public int compare(Schueler o1, Schueler o2) {
                    if (o1.getSg_FAMNAME() == o2.getSg_FAMNAME())
                        return 0;
                    if (o1.getSg_FAMNAME() == null)
                        return 1;
                    if (o2.getSg_FAMNAME() == null)
                        return -1;
                    return o1.getSg_FAMNAME().compareTo(o2.getSg_FAMNAME());
                }
            });
            Bundle args = new Bundle();
            args.putParcelableArrayList("pupils", pupils);
            pupilFragment = new PupilFragment();
            pupilFragment.setArguments(args);
            if (!isFinishing()) {
                getFragmentManager().beginTransaction()
                        .add(R.id.fragment_schueler_container, pupilFragment).commit();
            }
        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(), "Error NullPointerException", Toast.LENGTH_SHORT);
        }


    }

    public class PupilTask extends AsyncTask<Void, Void, String> {

        private String token;

        PupilTask(String token) {
            this.token = token;
        }
        @Override
        protected String doInBackground(Void... params) {

            HttpURLConnection httpURLConnection = null;
            boolean correctToken = true;
            String data = "";
            try {
                while(correctToken) {
                    correctToken = false;
                    String url = getPupilForTeacherUrl();
                    HashMap<String, String> paramsPOST = new HashMap<>();

                    SharedPreferences prefs = getSharedPreferences(PREFS_SCHOOL, MODE_PRIVATE);
                    Long su_kennzahl = prefs.getLong(CONST_SU_KENNZAHL, 0);

                    paramsPOST.put(CONST_SU, su_kennzahl.toString());
                    paramsPOST.put(CONST_ACCESS_TOKEN, token);
                    data = ConnectUtils.performPostCall(url, paramsPOST);
                    String newToken = requestErrors(data);
                    if(newToken != null && !newToken.equals(token)){
                        correctToken = false;
                        token = newToken;
                    }
                }
            } finally {
                if (null != httpURLConnection)
                    httpURLConnection.disconnect();
            }
            return data;
        }

        @Override
        protected  void onPostExecute(String result) {

            if (result != null) {
                createPupilFragment(result);
            }
        }

    }

    public class ClassPupilTask extends AsyncTask<Void, Void, String> {

        private final Integer klId;
        private String token;

        ClassPupilTask(Integer klId, String token) {
            this.klId = klId;
            this.token = token;
        }

        @Override
        protected String doInBackground(Void... params) {

            HttpURLConnection httpURLConnection = null;
            String data = "";
            boolean correctToken = false;
            try {
                while(!correctToken) {
                    correctToken = true;
                    String url = getPupilsByKlassUrl();
                    Log.i("GET_PUPILS_BY_CLASS", url);
                    HashMap<String, String> paramsPOST = new HashMap<>();
                    paramsPOST.put(CONST_KLID, klId.toString());

                    SharedPreferences prefs = getSharedPreferences(PREFS_SCHOOL, MODE_PRIVATE);
                    Long su_kennzahl = prefs.getLong(CONST_SU_KENNZAHL, 0);

                    paramsPOST.put(CONST_SU, su_kennzahl.toString());
                    paramsPOST.put(CONST_ACCESS_TOKEN, token);
                    data = ConnectUtils.performPostCall(url, paramsPOST);
                    requestErrors(data);

                }
            } finally {
                if (null != httpURLConnection)
                    httpURLConnection.disconnect();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {

            if (result != null) {
                createPupilFragment(result);
            }
        }
    }
}

package com.sokrates.mobileTeacherAssistent.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Schueleradresse;
import com.sokrates.mobileTeacherAssistent.fragment.PupiladdressFragment;
import com.sokrates.mobileTeacherAssistent.listener.SelectionItemListener;
import com.sokrates.mobileTeacherAssistent.utils.JSONParser;
import com.sokrates.mobileTeacherAssistent.utils.ConnectUtils;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PupiladdressActivity extends AbstractActivity implements SelectionItemListener {

    PupiladdressFragment pupiladdressFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupiladdress);

        SharedPreferences pref = getSharedPreferences(PREFS_PUPIL, MODE_PRIVATE);
        Long sgKennzahl = pref.getLong(CONST_SG, 0);

        SharedPreferences prefs = getSharedPreferences(PREFS_LOGIN, MODE_PRIVATE);
        String token = prefs.getString(CONST_ACCESS_TOKEN, null);

        PupiladdressTask pupiladdressTask = new PupiladdressTask(sgKennzahl, token);
        pupiladdressTask.execute((Void) null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pupiladdress, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*if (id == R.id.action_settings) {
            createDialogSettings(PupiladdressActivity.this);
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
    public void onItemSelected(Map<String, Object> obj) {
    }

    public void createPupilFragment(String in){
        try {
            ArrayList<Schueleradresse> pupiladdresses = (ArrayList<Schueleradresse>) (List<?>) JSONParser.parseToList(in, Schueleradresse.class);

            Bundle args = new Bundle();
            args.putParcelableArrayList("pupiladdresses", pupiladdresses);
            pupiladdressFragment = new PupiladdressFragment();
            pupiladdressFragment.setArguments(args);
            if (!isFinishing()) {
                getFragmentManager().beginTransaction()
                        .add(R.id.fragment_pupiladdress_container, pupiladdressFragment).commit();
            }
        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(), "Error NullPointerException", Toast.LENGTH_SHORT);
        }
    }

    public class PupiladdressTask extends AsyncTask<Void, Void, String>  {

        private final Long sg_kennzahl;
        private String token;

        PupiladdressTask( Long sg_kennzahl, String token) {
            this.sg_kennzahl = sg_kennzahl;
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
                    String url = getPupilAdressesUrl();
                    Log.i("GET_PUPIL_ADDRESSES", url);
                    HashMap<String, String> paramsPOST = new HashMap<>();
                    paramsPOST.put(CONST_SG, sg_kennzahl.toString());
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
}

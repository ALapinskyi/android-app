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
import com.sokrates.mobileTeacherAssistent.domain.Schuele;
import com.sokrates.mobileTeacherAssistent.domain.Schueleradresse;
import com.sokrates.mobileTeacherAssistent.domain.Schuelstandort;
import com.sokrates.mobileTeacherAssistent.fragment.PupiladdressFragment;
import com.sokrates.mobileTeacherAssistent.fragment.SchooladdressFragment;
import com.sokrates.mobileTeacherAssistent.listener.SelectionItemListener;
import com.sokrates.mobileTeacherAssistent.utils.ConnectUtils;
import com.sokrates.mobileTeacherAssistent.utils.JSONParser;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchooladdressActivity extends AbstractActivity implements SelectionItemListener {

    SchooladdressFragment schooladdressFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schooladdress);

        SharedPreferences prefs = getSharedPreferences(PREFS_LOGIN, MODE_PRIVATE);
        String token = prefs.getString(CONST_ACCESS_TOKEN, null);

        SchooladdressTask pupiladdressTask = new SchooladdressTask(token);
        pupiladdressTask.execute((Void) null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schooladdress, menu);
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
            ArrayList<Schuele> schooladdresses = (ArrayList<Schuele>) (List<?>) JSONParser.parseToList(in, Schuele.class);

            Bundle args = new Bundle();
            args.putParcelableArrayList("schooladdresses", schooladdresses);
            schooladdressFragment = new SchooladdressFragment();
            schooladdressFragment.setArguments(args);
            if (!isFinishing()) {
                getFragmentManager().beginTransaction()
                        .add(R.id.fragment_schooladdress_container, schooladdressFragment).commit();
            }
        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(), "Error NullPointerException", Toast.LENGTH_SHORT);
        }
    }

    public class SchooladdressTask extends AsyncTask<Void, Void, String>  {

        private String token;

        SchooladdressTask(String token) {
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
                    String url = getSchoolUrl();
                    Log.i("GET_SCHOOL_ADDRESSES", url);
                    HashMap<String, String> paramsPOST = new HashMap<>();
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

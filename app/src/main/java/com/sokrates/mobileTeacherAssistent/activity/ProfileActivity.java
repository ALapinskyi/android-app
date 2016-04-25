package com.sokrates.mobileTeacherAssistent.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Klasse;
import com.sokrates.mobileTeacherAssistent.domain.Schuele;
import com.sokrates.mobileTeacherAssistent.fragment.ClassFragment;
import com.sokrates.mobileTeacherAssistent.fragment.ProfileFragment;
import com.sokrates.mobileTeacherAssistent.listener.SelectionPositionListener;
import com.sokrates.mobileTeacherAssistent.utils.ConnectUtils;
import com.sokrates.mobileTeacherAssistent.utils.JSONParser;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileActivity extends AbstractActivity implements SelectionPositionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        SharedPreferences prefs = getSharedPreferences(PREFS_LOGIN,MODE_PRIVATE);
        String token = prefs.getString(CONST_ACCESS_TOKEN, null);

        ProfileTask profileTask = new ProfileTask(token);
        profileTask.execute((Void) null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {

            getSharedPreferences(PREFS_LOGIN, MODE_PRIVATE).edit().clear().commit();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        /*if (id == R.id.action_settings) {
            createDialogSettings(ProfileActivity.this);
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(int position) {

        switch (position) {
            case 0: {
                Intent intent = new Intent(getApplicationContext(), ClassActivity.class);
                startActivity(intent);
                break;
            }
            case 1: {
                getSharedPreferences(PREFS_ACTIVITY, MODE_PRIVATE)
                        .edit()
                        .putString(PARENT_ACTIVITY, PROFILE_ACTIVITY_NAME)
                        .commit();
                Intent intent = new Intent(getApplicationContext(), PupilActivity.class);
                startActivity(intent);
                break;
            }
            default:
                return;
        }
    }

    public void createProfileFragment(String in){
        try {
            ArrayList<Schuele> schuele = (ArrayList<Schuele>) (List<?>) JSONParser.parseToList(in, Schuele.class);

            setTitle(schuele.get(0).getSu_KENNZAHL() + " " + schuele.get(0).getSu_NAMEKURZ());

            TextView tv = (TextView)findViewById(R.id.addressFooter);
            tv.setText(schuele.get(0).getSchulstandort().get(0).getSo_ORT() + ", "
                    + schuele.get(0).getSchulstandort().get(0).getSo_STRASSE() + ", "
                    + schuele.get(0).getSchulstandort().get(0).getSo_HAUSNR());

            tv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SchooladdressActivity.class);
                    startActivity(intent);
                }
            });


            getSharedPreferences(PREFS_SCHOOL, MODE_PRIVATE)
                    .edit()
                    .putLong(CONST_SU_KENNZAHL, schuele.get(0).getSu_KENNZAHL())
                    .commit();

        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(), "Error NullPointerException", Toast.LENGTH_SHORT);
        }
    }

    public class ProfileTask extends AsyncTask<Void, Void, String> {

        private String token;

        ProfileTask(String token) {
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
                    Log.i("GET_SCHOOL", url);
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
                createProfileFragment(result);
            }
        }

    }
}

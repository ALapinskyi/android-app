package com.sokrates.mobileTeacherAssistent.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.domain.Klasse;
import com.sokrates.mobileTeacherAssistent.fragment.ClassFragment;
import com.sokrates.mobileTeacherAssistent.listener.SelectionItemListener;
import com.sokrates.mobileTeacherAssistent.utils.JSONParser;
import com.sokrates.mobileTeacherAssistent.utils.ConnectUtils;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassActivity extends AbstractActivity implements SelectionItemListener {

    private ClassFragment classFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasse);

        SharedPreferences prefs = getSharedPreferences(PREFS_LOGIN,MODE_PRIVATE);
        String login = prefs.getString(CONST_USERNAME, null);
        String token = prefs.getString(CONST_ACCESS_TOKEN, null);

        ClassesTask classesTask = new ClassesTask(token);
        classesTask.execute((Void) null);
    }

    @Override
    public void onItemSelected(Map<String, Object> obj) {
        getSharedPreferences(PREFS_CLASS,MODE_PRIVATE)
                .edit()
                .putInt(CONST_KLID, (int) obj.get("id"))
                .putString(CONST_KL_NAME, (String) obj.get("title"))
                .commit();
        getSharedPreferences(PREFS_ACTIVITY, MODE_PRIVATE)
                .edit()
                .putString(PARENT_ACTIVITY, CLASS_ACTIVITY_NAME)
                .commit();

        Intent intent = new Intent(getApplicationContext(), PupilActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_klasse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*if (id == R.id.action_settings) {
            createDialogSettings(ClassActivity.this);
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

    public void createClassFragment(String in){
        try {
            ArrayList<Klasse> klassen = (ArrayList<Klasse>) (List<?>) JSONParser.parseToList(in, Klasse.class);
            Bundle args = new Bundle();
            args.putParcelableArrayList("klassen", klassen);
            classFragment = new ClassFragment();
            classFragment.setArguments(args);
            if (!isFinishing()) {
                    getFragmentManager().beginTransaction()
                            .add(R.id.fragment_klasse_container, classFragment).commit();
            }
        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(), "Error NullPointerException", Toast.LENGTH_SHORT);
        }
    }

    public class ClassesTask extends AsyncTask<Void, Void, String>{

        private String token;

        ClassesTask(String token) {
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
                    String url = getKlassenAktuellUrl();
                    Log.i("GET_CLASSES", url);
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
                createClassFragment(result);
            }
        }

    }
}

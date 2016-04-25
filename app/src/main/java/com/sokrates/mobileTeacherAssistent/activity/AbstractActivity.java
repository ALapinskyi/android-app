package com.sokrates.mobileTeacherAssistent.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sokrates.mobileTeacherAssistent.R;
import com.sokrates.mobileTeacherAssistent.utils.ConnectUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;

public abstract class AbstractActivity extends AppCompatActivity {

    public static String PROTOCOL = "https";

    public static String IP_PORT = "www.sokrates-web.at";
    public static String PORT = "";

    public static String FOLDER = "/TSTTA/service/teacherservice";
    public static String FOLDER_OAUTH = "/TSTTA/oauth";

    public static final String PREFS_ACTIVITY = "activityDataFile";
    public static final String PARENT_ACTIVITY = "parentActivity";
    public static final String PROFILE_ACTIVITY_NAME = "ProfileActivity";
    public static final String CLASS_ACTIVITY_NAME = "ClassActivity";

    public static final String PREFS_CLASS = "classDataFile";
    public static final String CONST_KLID = "klId";
    public static final String CONST_KL_NAME = "kl_name";

    public static final String PREFS_PUPIL = "pupilDataFile";
    public static final String CONST_SG = "sg";

    public static final String PREFS_LOGIN = "loginDataFile";
    public static final String CONST_USERNAME = "username";
    public static final String CONST_PASSWORD = "password";
    public static final String CONST_ACCESS_TOKEN = "access_token";

    public static final String PREFS_SERVER = "serverDataFile";
    public static final String PREF_IP = "ip";
    public static final String PREF_PORT = "port";

    public static final String PREFS_SCHOOL = "schoolDataFile";
    public static final String CONST_SU_KENNZAHL = "su_kennzahl";

    public static final String CONST_SU = "su";

    public String getLoginUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER_OAUTH + "/token?";
    }
    public String getKlassenAktuellUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/klassenAktuell?";
    }

    public String getPupilForTeacherUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/getpupilforteacher?";
    }

    public String getPupilsByKlassUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/getpupilsbyklass?";
    }

    public String getPupilAdressesUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/getpupiladdress?";
    }

    public String getSchoolUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/school?";
    }

    public String requestErrors(String data){

        String newToken = null;
        try {
            Object json = new JSONTokener(data).nextValue();
        if(json instanceof JSONObject) {
            JSONObject object = new JSONObject(data);
            if(object.getString("oauth2ErrorCode").equals("invalid_token")){

                SharedPreferences pref = getSharedPreferences(PREFS_LOGIN,MODE_PRIVATE);
                String login = pref.getString(CONST_USERNAME, null);
                String password = pref.getString(CONST_PASSWORD, null);
                String urlToken = getLoginUrl();

                HashMap<String, String> paramsPOST = new HashMap<>();
                paramsPOST.put("grant_type", "password");
                paramsPOST.put("client_id", "restapp");
                paramsPOST.put("client_secret", "restapp");
                paramsPOST.put(CONST_USERNAME, login);
                paramsPOST.put(CONST_PASSWORD, password);

                String result = ConnectUtils.performPostCall(urlToken, paramsPOST);

                JSONObject obj = new JSONObject(result);
                try {
                    if (obj.getString("value") != null) {
                        newToken = obj.getString("value");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    newToken = "incorrectlogin";
                }
                if(newToken != null) {
                    pref.edit().putString(CONST_ACCESS_TOKEN, newToken).commit();
                    return newToken;
                }
            } /*else if (object.getString("code")!= null && object.getString("code").equals("E1")){
                getSharedPreferences(PREFS_LOGIN, MODE_PRIVATE).edit().clear().commit();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }*/
        }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newToken;
    }

}

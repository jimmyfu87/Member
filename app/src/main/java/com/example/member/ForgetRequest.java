package com.example.member;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ForgetRequest extends StringRequest {
    private  static String REGISTER_REQUEST_URL="https://nestled-section.000webhostapp.com/mail2.php";
    private Map<String,String> params;

    public ForgetRequest(String useremail, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("useremail", useremail);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
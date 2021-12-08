package com.example.lotto02.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lotto02.R;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class DashboardFragment extends Fragment {

//    private DashboardViewModel dashboardViewModel;
//    private FragmentDashboardBinding binding;

    TextView tv;
    Button bt;
    EditText et;
    String returnValue, drwNoDate, no1, no2, no3, no4, no5, no6, bonus, drwNo;
    JsonObject jsonObject;
    RequestQueue requestQueue;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        tv = getView().findViewById(R.id.tv);
//        et = getView().findViewById(R.id.et);
//        bt = getView().findViewById(R.id.bt);
        tv = v.findViewById(R.id.tv);
        et = v.findViewById(R.id.et);
        bt = v.findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLotto();
            }
        });
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getContext());
        }

        return v;
    }

    public void requestLotto(){
        drwNo = et.getText().toString();
        if(drwNo.equals("")){
            Toast.makeText(getContext(), "회차 번호를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + drwNo;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                jsonObject = (JsonObject) JsonParser.parseString(response);

                String returnValue = jsonObject.get("returnValue").getAsString();
                tv.setText(returnValue);
                if(returnValue.equalsIgnoreCase("fail")) {
                    tv.setText("없는 회차입니다");
                } else {
                    drwNoDate = "(" + jsonObject.get("drwNoDate") + ")";
                    no1 = "당첨번호 1 - " + jsonObject.get("drwtNo1");
                    no2 = "당첨번호 2 - " + jsonObject.get("drwtNo2");
                    no3 = "당첨번호 3 - " + jsonObject.get("drwtNo3");
                    no4 = "당첨번호 4 - " + jsonObject.get("drwtNo4");
                    no5 = "당첨번호 5 - " + jsonObject.get("drwtNo5");
                    no6 = "당첨번호 6 - " + jsonObject.get("drwtNo6");
                    bonus = "보너스 - " + jsonObject.get("bnusNo");
                    tv.setText(drwNo + "회차 당첨번호\n"+ drwNoDate + "\n\n" + no1 + "\n" + no2 + "\n" + no3 + "\n" + no4
                            + "\n" + no5 + "\n" + no6 + "\n" + bonus);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "존재하지 않는 회차 입니다", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }


}
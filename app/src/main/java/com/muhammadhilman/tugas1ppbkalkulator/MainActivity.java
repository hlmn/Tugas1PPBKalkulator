package com.muhammadhilman.tugas1ppbkalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.FloatProperty;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
//import android.view.

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private List<String> result = new ArrayList<>();
    protected String temp = "";
    protected Boolean temp2 = true;
    protected int angka, simbol;
    protected boolean pressedbtntype = false;
    protected String textstep = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.tombol1);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.tombol2);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.tombol3);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.tombol4);
        btn4.setOnClickListener(this);
        Button btn5 = (Button) findViewById(R.id.tombol5);
        btn5.setOnClickListener(this);
        Button btn6 = (Button) findViewById(R.id.tombol6);
        btn6.setOnClickListener(this);
        Button btn7 = (Button) findViewById(R.id.tombol7);
        btn7.setOnClickListener(this);
        Button btn8 = (Button) findViewById(R.id.tombol8);
        btn8.setOnClickListener(this);
        Button btn9 = (Button) findViewById(R.id.tombol9);
        btn9.setOnClickListener(this);
        Button btn0 = (Button) findViewById(R.id.tombol0);
        btn0.setOnClickListener(this);
//        Button btndot = (Button) findViewById(R.id.tomboldot);
//        btndot.setOnClickListener(this);
        Button btnequal = (Button) findViewById(R.id.tombolequal);
        btnequal.setOnClickListener(this);
        Button btnbagi = (Button) findViewById(R.id.tombolbagi);
        btnbagi.setOnClickListener(this);
        Button btnkali = (Button) findViewById(R.id.tombolkali);
        btnkali.setOnClickListener(this);
        Button btntambah = (Button) findViewById(R.id.tomboltambah);
        btntambah.setOnClickListener(this);
        Button btnkurang = (Button) findViewById(R.id.tombolkurang);
        btnkurang.setOnClickListener(this);
        Button btnreset = (Button) findViewById(R.id.tombolreset);
        btnreset.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {

        String testtt = "";
        Boolean flag = false;
        Boolean symflag = true;
        float hasilsementara = 0;

        EditText hasil = (EditText) findViewById(R.id.hasil);
        TextView step = (TextView) findViewById(R.id.step);
        Button btn = (Button) v;
        if(!(v.getId() == R.id.tombolequal || v.getId() == R.id.tombolreset)){
            textstep = textstep + btn.getText().toString();
//            step.setText(result.get(i));

            step.setText(textstep);
        }


        if(R.id.tombolreset == v.getId()){
            Log.d("debug", "apus");
            result.clear();
            testtt = "";
            flag = false;
            symflag = true;
            hasilsementara = 0;
            temp = "";
            temp2 = true;
            angka = 0;
            simbol = 0;
            pressedbtntype = false;
            textstep = "";

            hasil.setText("0");
            step.setText("");
            return;
        }

        if(!temp2) temp = "";

        if(NumberUtils.isCreatable(btn.getText().toString())){
            temp = temp + btn.getText().toString();
            temp2 = true;
            pressedbtntype = true;

        }
        else {
            if (!pressedbtntype) return;

            temp2 = false;
            pressedbtntype = false;

        }
        if(!temp2) {
//            if(v.getId() != R.id.tombolequal )
            if(!temp.equals("")) {
//                simbol++;
//                if(!pressedbtntype) return;
//                float temphasil = Float.parseFloat(result.get(0))*1;
                 result.add(temp);
            }
            if((angka != 0 && simbol != 0) && angka == simbol){
                Log.d("debug", "masuk");
                for (int i=0; i<simbol; i++) {
                    for(int j=0; j<result.size(); j++){
                        Log.d("debug", result.get(j));
                        if(result.get(j).equals("*")){
                            Log.d("debug", "kali");
                            float temphasil = Float.parseFloat(result.get(j-1))*Float.parseFloat(result.get(j+1));
                            Log.d("debug", Float.toString(temphasil));
                            Log.d("debug", "ea"+Float.toString(temphasil));
                            testtt = Float.toString(temphasil);
                            flag = true;
                            result.set(j-1, Float.toString(temphasil));
                            if(j != result.size()-1) {
                                result.remove(j + 1);
                                result.remove(j);
//                                simbol--;
//                                symflag = false;
                                break;

                            }

//                            a=result.size();
//                            break;
                        }
                        else if(result.get(j).equals("/")){
                            Log.d("debug", "bagi");
                            float temphasil = Float.parseFloat(result.get(j-1))/Float.parseFloat(result.get(j+1));
                            Log.d("debug", Float.toString(temphasil));
                            testtt = Float.toString(temphasil);
                            flag = true;
                            result.set(j-1, Float.toString(temphasil));
                            if(j != result.size()-1) {
                                result.remove(j + 1);
                                result.remove(j);
//                                simbol--;
//                                symflag = false;
                                break;

                            }

//                            a=result.size();
//                            break;

                        }
                        else flag = true;
//


                    }

                }
            }
//            if(symflag) {
                angka++;
                simbol++;
//            }

            Log.d("debug", "simbol : "+Float.toString(simbol));
            Log.d("debug", "angka : "+Float.toString(angka));

            if(v.getId() == R.id.tombolequal) {

                simbol=0;
                angka=0;
//                result.remove(result.size()-1);
//                temp2 = true;
                pressedbtntype = true;
            }
            else result.add(btn.getText().toString());
//            else result.add(btn.getText().toString());

//            flag = true;
        }



        if(flag) {
            Log.d("debug", "nanjing");
//            for (int i = 0; i < simbol; i++){
                for(int j = 0; j < result.size();j++){
                    if(j == result.size()-1) continue;
                    if(result.get(j).equals("+")){
                        if(j == 1)hasilsementara =  hasilsementara + (Float.parseFloat(result.get(j-1))+Float.parseFloat(result.get(j+1)));
                        else hasilsementara =  hasilsementara + (Float.parseFloat(result.get(j+1)));

                    }
                    else if(result.get(j).equals("-")){
                        if(j == 1)hasilsementara =  hasilsementara + (Float.parseFloat(result.get(j-1))-Float.parseFloat(result.get(j+1)));
                        else hasilsementara =  hasilsementara - (Float.parseFloat(result.get(j+1)));

                    }
                }
//            }

            if(hasilsementara == 0) hasil.setText(testtt);
            else hasil.setText(Float.toString(hasilsementara));


        }
        else {
            if(temp.equals("")){
                return;
            }
            hasil.setText(temp);
        }




//        String operation = ;
//        result.add(operation);
        Log.d("debug", result.toString());


    }



}

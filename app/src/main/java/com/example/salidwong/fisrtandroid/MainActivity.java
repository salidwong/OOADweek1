package com.example.salidwong.fisrtandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textins;
    TextView texttotal;
    EditText numcost;
    EditText numdown;
    Spinner numins;
    EditText numinterest;
    Integer int_ins = 0;
    Float insperm ;
    Float totalprice ;
    Integer m_interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textins = findViewById(R.id.Imtext);
        texttotal = findViewById(R.id.Totaltext);
        numcost = findViewById(R.id.Costinput);
        numdown = findViewById(R.id.Downinput);
        numins = findViewById(R.id.spinner);
        numinterest = findViewById(R.id.Interestinput);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Installmens, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void click(View view){
        Integer int_numcost = Integer.valueOf(numcost.getText().toString());
        Integer int_numdown = Integer.valueOf(numdown.getText().toString());
        Float float_numinterest = Float.valueOf(numinterest.getText().toString());
        int_ins = checkmonth(numins.getSelectedItem().toString());
        insperm = CalIns(int_numcost, int_numdown, float_numinterest);
        totalprice = CalTotal(int_numcost, int_numdown, float_numinterest);
        if (insperm  < 0 || totalprice < 0 ){
            textins.setText("Invalid");
            texttotal.setText("Invalid");
        }
        else {
            textins.setText(insperm.toString());
            texttotal.setText(totalprice.toString());
        }
        //tmp = numcost.getText().toString() + numdown.getText().toString() + numins.getSelectedItem().toString() + numinterest.getText().toString();

    }

    public void clear(View view){
        numcost.setText("");
        numdown.setText("");
        numinterest.setText("");
        textins.setText("");
        texttotal.setText("");
    }



    public Integer checkmonth(String s){
        if (s.equals("12 month")){
            int_ins = 12;
        }
        else if (s.equals("24 month")){
            int_ins = 24;
        }
        else if (s.equals("24 month")){
            int_ins = 24;
        }
        else if (s.equals("36 month")){
            int_ins = 36;
        }
        else if (s.equals("48 month")){
            int_ins = 48;
        }
        else if (s.equals("60 month")){
            int_ins = 60;
        }
        else if (s.equals("72 month")){
            int_ins = 72;
        }
        else if (s.equals("84 month")){
            int_ins = 84;
        }
        else if (s.equals("96 month")){
            int_ins = 96;
        }

        return int_ins;
    }

    public Float CalIns(Integer price, Integer down, Float interest){
        Float difinterest = (price - down) * ((interest/100) * (int_ins/12));
        Float interestpr = (price - down) + difinterest;
        Float installments =  interestpr/int_ins;

        return  installments;
    }

    public Float CalTotal(Integer price, Integer down, Float interest){
        Float res = down + (price - down) + (price - down) * ((interest/100) * (int_ins/12));
        return res;
    }
}

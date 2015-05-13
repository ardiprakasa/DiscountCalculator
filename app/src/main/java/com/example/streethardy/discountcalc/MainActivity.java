package com.example.streethardy.discountcalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button buttonHitung;
    EditText editTextHarga,editTextDiskon, editTextHasil;
    TextView warningText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        warningText= (TextView) findViewById(R.id.WarningText);
        warningText.setVisibility(TextView.INVISIBLE);
        editTextHarga= (EditText) findViewById(R.id.boxHarga);
        editTextHarga.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextDiskon.getText().toString().isEmpty())
                {

                }
               else if (Long.parseLong(editTextHarga.getText().toString()) < 0) {
                    editTextHarga.setText("harga tidak boleh negatif");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editTextDiskon= (EditText) findViewById(R.id.boxDiskon);
       editTextDiskon.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               if (editTextDiskon.getText().toString().isEmpty())
               {

               }
                else if (Long.parseLong(editTextDiskon.getText().toString()) < 45 || Long.parseLong(editTextDiskon.getText().toString()) > 75)
                {
                   warningText.setVisibility(TextView.VISIBLE);
                }
               else
                {
                    warningText.setVisibility(warningText.INVISIBLE);
                }
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
        editTextHasil= (EditText) findViewById(R.id.textResult);

        buttonHitung= (Button) findViewById(R.id.btnHitung);

        buttonHitung.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String harga=editTextHarga.getText().toString();
        String diskon=editTextDiskon.getText().toString();

        double hasil = Double.parseDouble(harga)-(Double.parseDouble(harga)*Double.parseDouble(diskon)/100);

        editTextHasil.setText(String.valueOf(hasil));
    }
}

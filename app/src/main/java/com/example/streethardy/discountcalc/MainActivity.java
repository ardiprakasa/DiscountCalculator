package com.example.streethardy.discountcalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button buttonHitung;
    EditText editTextHarga,editTextDiskon, editTextHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHarga= (EditText) findViewById(R.id.boxHarga);
        editTextDiskon= (EditText) findViewById(R.id.boxDiskon);
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
        if (id == R.id.action_settings) {
            return true;
        }

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

package com.example.okul.dosyaislemleri;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView textcihazID;
    TextView textCihazAdi;
    TextView textAgAdi;
    TextView textAgSifresi;
    Button OnayButton;
    EditText editcihazid;
    EditText editcihazadi;
    EditText editAgadi;
    EditText editsPass;
    SharedPreferences preferences;
    //preferences için bir nesne tanýmlýyorum.
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textcihazID=(TextView) findViewById(R.id.textcihazID);
        textCihazAdi=(TextView) findViewById(R.id.textCihazAdi);
        textAgAdi=(TextView) findViewById(R.id.textAgAdi);
        textAgSifresi=(TextView) findViewById(R.id.textAgSifresi);
        editcihazid=(EditText) findViewById(R.id.editcihazid);
        editcihazadi=(EditText) findViewById(R.id.editcihazadi);
        editAgadi=(EditText) findViewById(R.id.editAgadi);
        editsPass=(EditText) findViewById(R.id.editsPass);
        OnayButton=(Button) findViewById(R.id.OnayButton);
        preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = preferences.edit();
        String CihazID=preferences.getString("CihazID", "Cihaz ID Gir");
        editcihazid.setText(CihazID);
        textcihazID.setText(CihazID);
        String CihazAdi=preferences.getString("CihazAdi", "Cihaz Adý Gir");
        editcihazadi.setText(CihazAdi);
        textCihazAdi.setText(CihazAdi);
        String AgAdi=preferences.getString("AgAdi", "Að Adý Gir");
        editAgadi.setText(AgAdi);
        textAgAdi.setText(AgAdi);
        String AgSifresi=preferences.getString("AgSifresi", "Að Þifresi Gir");
        editsPass.setText(AgSifresi);
        textAgSifresi.setText(AgSifresi);
        OnayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("CihazID", editcihazid.getText().toString());
                editor.putString("CihazAdi", editcihazadi.getText().toString());
                editor.putString("AgAdi", editAgadi.getText().toString());
                editor.putString("AgSifresi", editsPass.getText().toString());
                editor.commit();

            }
        });
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
    /*private void SaveLastNumber(String LastNum){
        SharedPreferences prefSettings =  getSharedPreferences("HelloWorldPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefSettings.edit();
        editor.putString("LastNumber", LastNum);
        editor.commit();
    }*/
}

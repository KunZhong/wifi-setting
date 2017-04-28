package com.example.wifi_setting;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private SwitchCompat switchCompat;
    private WifiManager wifiManager;
    private WifiAdmin wifiAdmin;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();//高版本可以换成 ActionBar actionBar = getActionBar();
        actionBar.hide();

        init();

    }
    private void init(){
        switchCompat = (SwitchCompat) findViewById(R.id.switch_compat);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.switch_compat:

                        wifiManager.setWifiEnabled(isChecked);

                        if(isChecked){
                            Toast.makeText(MainActivity.this, "on", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
                        }
                    break;

                    default:
                        break;
                }
            }
        });
        wifiAdmin = new WifiAdmin(MainActivity.this);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        listView = (ListView) findViewById(R.id.listview);
    }
}

package com.example.wifi_setting;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.List;

/**
 * Created by user on 17-4-28.
 */

public class WifiAdmin {


    /* 定义一个WifiManager对象,提供Wifi管理的各种主要API，主要包含wifi的扫描、建立连接、配置信息等 */
    private WifiManager mWifiManager;

    // WIFIConfiguration描述WIFI的链接信息，包括SSID、SSID隐藏、password等的设置
    private List<WifiConfiguration> wifiConfigList;


    // 定义一个WifiInfo对象
    private WifiInfo mWifiInfo;

    public WifiAdmin(Context context) {

        // 获得WifiManager对象
        mWifiManager = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);

        // 取得WifiInfo对象
        mWifiInfo = mWifiManager.getConnectionInfo();

    }

    /* 打开wifi */
    public void openWifi() {
        if (!mWifiManager.isWifiEnabled()) {
            mWifiManager.setWifiEnabled(true);
        }
    }

    /* 关闭wifi */
    public void closeWifi() {
        if (!mWifiManager.isWifiEnabled()) {
            mWifiManager.setWifiEnabled(false);
        }
    }

    /* 检查当前wifi状态 * * @return */
    public int checkState() {
        return mWifiManager.getWifiState();
    }

}

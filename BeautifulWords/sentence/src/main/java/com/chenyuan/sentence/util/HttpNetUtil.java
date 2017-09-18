package com.chenyuan.sentence.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.chenyuan.sentence.receiver.NetWorkReceiver;

import java.util.ArrayList;
import java.util.List;

public enum HttpNetUtil {

    INSTANCE;

    private List<INetWorkReceiver> iNetWorkReceivers;
    private boolean isConnected = true;

    public void addNetWorkListener(INetWorkReceiver networkreceiver) {
        if (null == iNetWorkReceivers) {
            iNetWorkReceivers = new ArrayList<>();
        }
        iNetWorkReceivers.add(networkreceiver);
    }

    public void removeNetWorkListener(NetWorkReceiver listener) {
        if (iNetWorkReceivers != null) {
            iNetWorkReceivers.remove(listener);
        }
    }

    public void clearNetWorkListeners() {
        if (iNetWorkReceivers != null) {
            iNetWorkReceivers.clear();
        }
    }

    /**
     * 获取是否连接
     */
    public boolean isConnected() {
        return isConnected;
    }

    /**
     * 判断网络连接是否存在
     *
     * @param context
     */
    public void setConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            setConnected(false);

            if (iNetWorkReceivers != null) {
                for (int i = 0, z = iNetWorkReceivers.size(); i < z; i++) {
                    INetWorkReceiver listener = iNetWorkReceivers.get(i);
                    if (listener != null) {
                        listener.onConnected(false);
                    }
                }
            }
        }

        NetworkInfo info = manager.getActiveNetworkInfo();

        boolean connected = info != null && info.isConnected();
        setConnected(connected);

        if (iNetWorkReceivers != null) {
            for (int i = 0, z = iNetWorkReceivers.size(); i < z; i++) {
                INetWorkReceiver listener = iNetWorkReceivers.get(i);
                if (listener != null) {
                    listener.onConnected(connected);
                }
            }
        }
    }

    private void setConnected(boolean connected) {
        isConnected = connected;
    }

    public interface INetWorkReceiver {

        void onConnected(boolean collect);
    }
}
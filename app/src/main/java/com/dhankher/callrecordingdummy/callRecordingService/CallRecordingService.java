package com.dhankher.callrecordingdummy.callRecordingService;

import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.dhankher.callrecordingdummy.AdminReceiver;
import com.dhankher.callrecordingdummy.broadcastReceiver.CallBroadcastReceiver;

/**
 * Created by Dhankher on 3/7/2017.
 */
public class CallRecordingService extends Service {

    private static final String ACTION_IN = "android.intent.action.PHONE_STATE";
    private static final String ACTION_OUT = "android.intent.action.NEW_OUTGOING_CALL";
    private CallBroadcastReceiver callBroadcastReceiver;
    private static final int REQUEST_CODE = 0;
    private DevicePolicyManager mDPM;
    private ComponentName mAdminName;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d("service", "destroy");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            // Initiate DevicePolicyManager.
            mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
            mAdminName = new ComponentName(this, AdminReceiver.class);

            Intent intent1 = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent1.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mAdminName);
            intent1.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Click on Activate button to secure your application.");

        } catch (Exception e) {
            e.printStackTrace();

        }

    final IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_OUT);
        filter.addAction(ACTION_IN);
        this.callBroadcastReceiver = new CallBroadcastReceiver();
        this.registerReceiver(this.callBroadcastReceiver, filter);

        // if(terminate != null) {
        // stopSelf();
        // }
        return START_STICKY;
    }

}

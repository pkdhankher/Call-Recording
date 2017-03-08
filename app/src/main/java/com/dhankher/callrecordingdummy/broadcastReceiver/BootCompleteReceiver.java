package com.dhankher.callrecordingdummy.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dhankher.callrecordingdummy.callRecordingService.CallRecordingService;

/**
 * Created by Dhankher on 3/8/2017.
 */

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service = new Intent(context, CallRecordingService.class);
        context.startService(service);

    }

}

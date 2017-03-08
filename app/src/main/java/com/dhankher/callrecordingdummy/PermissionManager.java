package com.dhankher.callrecordingdummy;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Dhankher on 3/8/2017.
 */

public class PermissionManager {

    private Context context;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;


    public static boolean hasPermissions(Activity activity, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }



}
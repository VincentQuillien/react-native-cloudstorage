package com.mediaxtend.rncloudstorage;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;

/**
 * Created by vincent on 10/05/2017.
 */

public class Backup extends BackupAgentHelper {
    @Override
    public void onCreate() {
        SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this, Module.PREFERENCES_KEY);
        addHelper("backup preferences", helper);
    }
}

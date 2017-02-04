package com.dava.framework;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupManager;
import android.app.backup.RestoreObserver;
import android.app.backup.SharedPreferencesBackupHelper;

public class JNIBackupAgent
  extends BackupAgentHelper
{
  public static void Backup()
  {
    BackupManager localBackupManager = new BackupManager(JNIApplication.GetApplication().getApplicationContext());
    try
    {
      localBackupManager.dataChanged();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void Restore(RestoreObserver paramRestoreObserver)
  {
    BackupManager localBackupManager = new BackupManager(JNIApplication.GetApplication().getApplicationContext());
    try
    {
      localBackupManager.requestRestore(paramRestoreObserver);
      return;
    }
    catch (Exception paramRestoreObserver)
    {
      paramRestoreObserver.printStackTrace();
    }
  }
  
  public void onCreate()
  {
    SharedPreferencesBackupHelper localSharedPreferencesBackupHelper = new SharedPreferencesBackupHelper(this, new String[] { JNISharedPreferences.GetName() });
    addHelper(JNISharedPreferences.GetName(), localSharedPreferencesBackupHelper);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIBackupAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
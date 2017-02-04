package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class zzh
  implements DialogInterface.OnClickListener
{
  private final Activity mActivity;
  private final Intent mIntent;
  private final int zzaeU;
  private final Fragment zzajv;
  
  public zzh(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.mActivity = paramActivity;
    this.zzajv = null;
    this.mIntent = paramIntent;
    this.zzaeU = paramInt;
  }
  
  public zzh(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.mActivity = null;
    this.zzajv = paramFragment;
    this.mIntent = paramIntent;
    this.zzaeU = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.mIntent != null) && (this.zzajv != null)) {
        this.zzajv.startActivityForResult(this.mIntent, this.zzaeU);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (this.mIntent != null) {
          this.mActivity.startActivityForResult(this.mIntent, this.zzaeU);
        }
      }
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
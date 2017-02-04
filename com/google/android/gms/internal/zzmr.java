package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class zzmr
  extends Fragment
  implements DialogInterface.OnCancelListener
{
  private static final GoogleApiAvailability zzagU = ;
  private boolean mStarted;
  private boolean zzagV;
  private int zzagW = -1;
  private ConnectionResult zzagX;
  private final Handler zzagY = new Handler(Looper.getMainLooper());
  private zzmk zzagZ;
  private final SparseArray<zza> zzaha = new SparseArray();
  
  public static zzmr zza(FragmentActivity paramFragmentActivity)
  {
    zzx.zzcx("Must be called from main thread of process");
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      zzmr localzzmr = (zzmr)paramFragmentActivity.findFragmentByTag("GmsSupportLifecycleFrag");
      if (localzzmr != null)
      {
        paramFragmentActivity = localzzmr;
        if (!localzzmr.isRemoving()) {}
      }
      else
      {
        paramFragmentActivity = null;
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", paramFragmentActivity);
    }
  }
  
  private void zza(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (zza)this.zzaha.get(paramInt);
    if (localObject != null)
    {
      zzbE(paramInt);
      localObject = ((zza)localObject).zzahd;
      if (localObject != null) {
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
    zzpA();
  }
  
  public static zzmr zzb(FragmentActivity paramFragmentActivity)
  {
    zzmr localzzmr = zza(paramFragmentActivity);
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    paramFragmentActivity = localzzmr;
    if (localzzmr == null)
    {
      paramFragmentActivity = new zzmr();
      localFragmentManager.beginTransaction().add(paramFragmentActivity, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
      localFragmentManager.executePendingTransactions();
    }
    return paramFragmentActivity;
  }
  
  private void zzpA()
  {
    this.zzagV = false;
    this.zzagW = -1;
    this.zzagX = null;
    if (this.zzagZ != null)
    {
      this.zzagZ.unregister();
      this.zzagZ = null;
    }
    int i = 0;
    while (i < this.zzaha.size())
    {
      ((zza)this.zzaha.valueAt(i)).zzahc.connect();
      i += 1;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    int i = 0;
    while (i < this.zzaha.size())
    {
      ((zza)this.zzaha.valueAt(i)).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramInt1 = 0;
      do
      {
        for (;;)
        {
          if (paramInt1 == 0) {
            break label87;
          }
          zzpA();
          return;
          if (zzagU.isGooglePlayServicesAvailable(getActivity()) != 0) {
            break;
          }
          paramInt1 = i;
        }
        paramInt1 = i;
      } while (paramInt2 == -1);
      if (paramInt2 == 0) {
        this.zzagX = new ConnectionResult(13, null);
      }
    }
    label87:
    zza(this.zzagW, this.zzagX);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(this.zzagW, new ConnectionResult(13, null));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.zzagV = paramBundle.getBoolean("resolving_error", false);
      this.zzagW = paramBundle.getInt("failed_client_id", -1);
      if (this.zzagW >= 0) {
        this.zzagX = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.zzagV);
    if (this.zzagW >= 0)
    {
      paramBundle.putInt("failed_client_id", this.zzagW);
      paramBundle.putInt("failed_status", this.zzagX.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.zzagX.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.mStarted = true;
    if (!this.zzagV)
    {
      int i = 0;
      while (i < this.zzaha.size())
      {
        ((zza)this.zzaha.valueAt(i)).zzahc.connect();
        i += 1;
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.mStarted = false;
    int i = 0;
    while (i < this.zzaha.size())
    {
      ((zza)this.zzaha.valueAt(i)).zzahc.disconnect();
      i += 1;
    }
  }
  
  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zzaha.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Already managing a GoogleApiClient with id " + paramInt);
      paramOnConnectionFailedListener = new zza(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      this.zzaha.put(paramInt, paramOnConnectionFailedListener);
      if ((this.mStarted) && (!this.zzagV)) {
        paramGoogleApiClient.connect();
      }
      return;
    }
  }
  
  public void zzbE(int paramInt)
  {
    zza localzza = (zza)this.zzaha.get(paramInt);
    this.zzaha.remove(paramInt);
    if (localzza != null) {
      localzza.zzpC();
    }
  }
  
  private class zza
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int zzahb;
    public final GoogleApiClient zzahc;
    public final GoogleApiClient.OnConnectionFailedListener zzahd;
    
    public zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.zzahb = paramInt;
      this.zzahc = paramGoogleApiClient;
      this.zzahd = paramOnConnectionFailedListener;
      paramGoogleApiClient.registerConnectionFailedListener(this);
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(this.zzahb);
      paramPrintWriter.println(":");
      this.zzahc.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzmr.zzd(zzmr.this).post(new zzmr.zzb(zzmr.this, this.zzahb, paramConnectionResult));
    }
    
    public void zzpC()
    {
      this.zzahc.unregisterConnectionFailedListener(this);
      this.zzahc.disconnect();
    }
  }
  
  private class zzb
    implements Runnable
  {
    private final int zzahf;
    private final ConnectionResult zzahg;
    
    public zzb(int paramInt, ConnectionResult paramConnectionResult)
    {
      this.zzahf = paramInt;
      this.zzahg = paramConnectionResult;
    }
    
    public void run()
    {
      if ((!zzmr.zza(zzmr.this)) || (zzmr.zzb(zzmr.this))) {
        return;
      }
      zzmr.zza(zzmr.this, true);
      zzmr.zza(zzmr.this, this.zzahf);
      zzmr.zza(zzmr.this, this.zzahg);
      if (this.zzahg.hasResolution()) {
        try
        {
          int i = zzmr.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzmr.this);
          this.zzahg.startResolutionForResult(zzmr.this.getActivity(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          zzmr.zzc(zzmr.this);
          return;
        }
      }
      if (zzmr.zzpB().isUserResolvableError(this.zzahg.getErrorCode()))
      {
        GooglePlayServicesUtil.showErrorDialogFragment(this.zzahg.getErrorCode(), zzmr.this.getActivity(), zzmr.this, 2, zzmr.this);
        return;
      }
      if (this.zzahg.getErrorCode() == 18)
      {
        final Dialog localDialog = zzmr.zzpB().zza(zzmr.this.getActivity(), zzmr.this);
        zzmr.zza(zzmr.this, zzmk.zza(zzmr.this.getActivity().getApplicationContext(), new zzmk()
        {
          protected void zzpv()
          {
            zzmr.zzc(zzmr.this);
            localDialog.dismiss();
          }
        }));
        return;
      }
      zzmr.zza(zzmr.this, this.zzahf, this.zzahg);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
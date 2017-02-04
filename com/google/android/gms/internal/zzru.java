package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.List;

public class zzru
  extends zzj<zzrs>
{
  private final Context mContext;
  
  public zzru(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 45, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.mContext = paramContext;
  }
  
  private String zzmT()
  {
    try
    {
      Object localObject = this.mContext.getPackageManager();
      if (localObject == null) {
        return null;
      }
      localObject = ((PackageManager)localObject).getApplicationInfo(this.mContext.getPackageName(), 128);
      if (localObject == null) {
        return null;
      }
      localObject = ((ApplicationInfo)localObject).metaData;
      if (localObject == null) {
        return null;
      }
      localObject = (String)((Bundle)localObject).get("com.google.android.safetynet.API_KEY");
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public void zza(zzrr paramzzrr, List<Integer> paramList, int paramInt, String paramString)
    throws RemoteException
  {
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    ((zzrs)zzqs()).zza(paramzzrr, zzmT(), arrayOfInt, paramInt, paramString);
  }
  
  public void zza(zzrr paramzzrr, byte[] paramArrayOfByte)
    throws RemoteException
  {
    ((zzrs)zzqs()).zza(paramzzrr, paramArrayOfByte);
  }
  
  protected zzrs zzdR(IBinder paramIBinder)
  {
    return zzrs.zza.zzdQ(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.safetynet.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.safetynet.internal.ISafetyNetService";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
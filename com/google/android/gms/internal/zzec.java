package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzo.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

@zzha
class zzec
{
  zzo zzpz;
  zzu zzzM;
  zzgc zzzN;
  zzcl zzzO;
  zzn zzzP;
  
  void zzc(zzk paramzzk)
  {
    if (this.zzpz != null) {
      paramzzk.zza(new zza(this.zzpz));
    }
    if (this.zzzM != null) {
      paramzzk.zza(this.zzzM);
    }
    if (this.zzzN != null) {
      paramzzk.zza(this.zzzN);
    }
    if (this.zzzO != null) {
      paramzzk.zza(this.zzzO);
    }
    if (this.zzzP != null) {
      paramzzk.zza(this.zzzP);
    }
  }
  
  private class zza
    extends zzo.zza
  {
    zzo zzzQ;
    
    zza(zzo paramzzo)
    {
      this.zzzQ = paramzzo;
    }
    
    public void onAdClosed()
      throws RemoteException
    {
      this.zzzQ.onAdClosed();
      zzp.zzbI().zzdX();
    }
    
    public void onAdFailedToLoad(int paramInt)
      throws RemoteException
    {
      this.zzzQ.onAdFailedToLoad(paramInt);
    }
    
    public void onAdLeftApplication()
      throws RemoteException
    {
      this.zzzQ.onAdLeftApplication();
    }
    
    public void onAdLoaded()
      throws RemoteException
    {
      this.zzzQ.onAdLoaded();
    }
    
    public void onAdOpened()
      throws RemoteException
    {
      this.zzzQ.onAdOpened();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
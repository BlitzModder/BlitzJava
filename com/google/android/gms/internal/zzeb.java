package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzn.zza;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzo.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzu.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzha
class zzeb
{
  private final List<zza> zzpw = new LinkedList();
  
  void zza(final zzec paramzzec)
  {
    Handler localHandler = zzip.zzKO;
    Iterator localIterator = this.zzpw.iterator();
    while (localIterator.hasNext()) {
      localHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            this.zzzK.zzb(paramzzec);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzb.zzd("Could not propagate interstitial ad event.", localRemoteException);
          }
        }
      });
    }
  }
  
  void zzc(zzk paramzzk)
  {
    paramzzk.zza(new zzo.zza()
    {
      public void onAdClosed()
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzpz != null) {
              paramAnonymous2zzec.zzpz.onAdClosed();
            }
            zzp.zzbI().zzdX();
          }
        });
      }
      
      public void onAdFailedToLoad(final int paramAnonymousInt)
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzpz != null) {
              paramAnonymous2zzec.zzpz.onAdFailedToLoad(paramAnonymousInt);
            }
          }
        });
        zzb.v("Pooled interstitial failed to load.");
      }
      
      public void onAdLeftApplication()
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzpz != null) {
              paramAnonymous2zzec.zzpz.onAdLeftApplication();
            }
          }
        });
      }
      
      public void onAdLoaded()
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzpz != null) {
              paramAnonymous2zzec.zzpz.onAdLoaded();
            }
          }
        });
        zzb.v("Pooled interstitial loaded.");
      }
      
      public void onAdOpened()
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzpz != null) {
              paramAnonymous2zzec.zzpz.onAdOpened();
            }
          }
        });
      }
    });
    paramzzk.zza(new zzu.zza()
    {
      public void onAppEvent(final String paramAnonymousString1, final String paramAnonymousString2)
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzzM != null) {
              paramAnonymous2zzec.zzzM.onAppEvent(paramAnonymousString1, paramAnonymousString2);
            }
          }
        });
      }
    });
    paramzzk.zza(new zzgc.zza()
    {
      public void zza(final zzgb paramAnonymouszzgb)
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzzN != null) {
              paramAnonymous2zzec.zzzN.zza(paramAnonymouszzgb);
            }
          }
        });
      }
    });
    paramzzk.zza(new zzcl.zza()
    {
      public void zza(final zzck paramAnonymouszzck)
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzzO != null) {
              paramAnonymous2zzec.zzzO.zza(paramAnonymouszzck);
            }
          }
        });
      }
    });
    paramzzk.zza(new zzn.zza()
    {
      public void onAdClicked()
        throws RemoteException
      {
        zzeb.zza(zzeb.this).add(new zzeb.zza()
        {
          public void zzb(zzec paramAnonymous2zzec)
            throws RemoteException
          {
            if (paramAnonymous2zzec.zzzP != null) {
              paramAnonymous2zzec.zzzP.onAdClicked();
            }
          }
        });
      }
    });
  }
  
  static abstract interface zza
  {
    public abstract void zzb(zzec paramzzec)
      throws RemoteException;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzha
public class zzcs
  extends NativeAppInstallAd
{
  private final zzcr zzyo;
  private final List<NativeAd.Image> zzyp = new ArrayList();
  private final zzco zzyq;
  
  public zzcs(zzcr paramzzcr)
  {
    this.zzyo = paramzzcr;
    try
    {
      paramzzcr = this.zzyo.getImages();
      if (paramzzcr != null)
      {
        paramzzcr = paramzzcr.iterator();
        while (paramzzcr.hasNext())
        {
          zzcn localzzcn = zzd(paramzzcr.next());
          if (localzzcn != null) {
            this.zzyp.add(new zzco(localzzcn));
          }
        }
      }
      try
      {
        paramzzcr = this.zzyo.zzdD();
        if (paramzzcr == null) {
          break label129;
        }
        paramzzcr = new zzco(paramzzcr);
      }
      catch (RemoteException paramzzcr)
      {
        for (;;)
        {
          zzb.zzb("Failed to get icon.", paramzzcr);
          paramzzcr = null;
        }
      }
    }
    catch (RemoteException paramzzcr)
    {
      zzb.zzb("Failed to get image.", paramzzcr);
    }
    this.zzyq = paramzzcr;
  }
  
  public void destroy()
  {
    try
    {
      this.zzyo.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to destroy", localRemoteException);
    }
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = this.zzyo.getBody();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get body.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getCallToAction()
  {
    try
    {
      String str = this.zzyo.getCallToAction();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get call to action.", localRemoteException);
    }
    return null;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = this.zzyo.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get extras", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = this.zzyo.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public NativeAd.Image getIcon()
  {
    return this.zzyq;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return this.zzyp;
  }
  
  public CharSequence getPrice()
  {
    try
    {
      String str = this.zzyo.getPrice();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get price.", localRemoteException);
    }
    return null;
  }
  
  public Double getStarRating()
  {
    try
    {
      double d = this.zzyo.getStarRating();
      if (d == -1.0D) {
        return null;
      }
      return Double.valueOf(d);
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get star rating.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getStore()
  {
    try
    {
      String str = this.zzyo.getStore();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get store", localRemoteException);
    }
    return null;
  }
  
  zzcn zzd(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzcn.zza.zzt((IBinder)paramObject);
    }
    return null;
  }
  
  protected zzd zzdE()
  {
    try
    {
      zzd localzzd = this.zzyo.zzdE();
      return localzzd;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzha
public class zzcu
  extends NativeContentAd
{
  private final List<NativeAd.Image> zzyp = new ArrayList();
  private final zzct zzyr;
  private final zzco zzys;
  
  public zzcu(zzct paramzzct)
  {
    this.zzyr = paramzzct;
    try
    {
      paramzzct = this.zzyr.getImages();
      if (paramzzct != null)
      {
        paramzzct = paramzzct.iterator();
        while (paramzzct.hasNext())
        {
          zzcn localzzcn = zzd(paramzzct.next());
          if (localzzcn != null) {
            this.zzyp.add(new zzco(localzzcn));
          }
        }
      }
      try
      {
        paramzzct = this.zzyr.zzdH();
        if (paramzzct == null) {
          break label129;
        }
        paramzzct = new zzco(paramzzct);
      }
      catch (RemoteException paramzzct)
      {
        for (;;)
        {
          zzb.zzb("Failed to get icon.", paramzzct);
          paramzzct = null;
        }
      }
    }
    catch (RemoteException paramzzct)
    {
      zzb.zzb("Failed to get image.", paramzzct);
    }
    this.zzys = paramzzct;
  }
  
  public void destroy()
  {
    try
    {
      this.zzyr.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to destroy", localRemoteException);
    }
  }
  
  public CharSequence getAdvertiser()
  {
    try
    {
      String str = this.zzyr.getAdvertiser();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get attribution.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = this.zzyr.getBody();
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
      String str = this.zzyr.getCallToAction();
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
      Bundle localBundle = this.zzyr.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Failed to get extras", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = this.zzyr.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return this.zzyp;
  }
  
  public NativeAd.Image getLogo()
  {
    return this.zzys;
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
      zzd localzzd = this.zzyr.zzdE();
      return localzzd;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
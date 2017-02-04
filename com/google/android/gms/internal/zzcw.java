package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zzha
public class zzcw
  implements NativeCustomTemplateAd
{
  private final zzcv zzyt;
  
  public zzcw(zzcv paramzzcv)
  {
    this.zzyt = paramzzcv;
  }
  
  public List<String> getAvailableAssetNames()
  {
    try
    {
      List localList = this.zzyt.getAvailableAssetNames();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get available asset names.", localRemoteException);
    }
    return null;
  }
  
  public String getCustomTemplateId()
  {
    try
    {
      String str = this.zzyt.getCustomTemplateId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get custom template id.", localRemoteException);
    }
    return null;
  }
  
  public NativeAd.Image getImage(String paramString)
  {
    try
    {
      paramString = this.zzyt.zzT(paramString);
      if (paramString != null)
      {
        paramString = new zzco(paramString);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      zzb.zzb("Failed to get image.", paramString);
    }
    return null;
  }
  
  public CharSequence getText(String paramString)
  {
    try
    {
      paramString = this.zzyt.zzS(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzb.zzb("Failed to get string.", paramString);
    }
    return null;
  }
  
  public void performClick(String paramString)
  {
    try
    {
      this.zzyt.performClick(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      zzb.zzb("Failed to perform click.", paramString);
    }
  }
  
  public void recordImpression()
  {
    try
    {
      this.zzyt.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to record impression.", localRemoteException);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
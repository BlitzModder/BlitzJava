package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

@zzha
public final class zzev
  extends zzew.zza
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> zzBG;
  
  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzex zzah(String paramString)
    throws RemoteException
  {
    try
    {
      Object localObject = Class.forName(paramString, false, zzev.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject))
      {
        localObject = (com.google.ads.mediation.MediationAdapter)((Class)localObject).newInstance();
        return new zzfi((com.google.ads.mediation.MediationAdapter)localObject, (com.google.ads.mediation.NetworkExtras)this.zzBG.get(((com.google.ads.mediation.MediationAdapter)localObject).getAdditionalParametersType()));
      }
      if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject)) {
        return new zzfd((com.google.android.gms.ads.mediation.MediationAdapter)((Class)localObject).newInstance());
      }
      zzb.zzaH("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
  }
  
  public zzex zzaf(String paramString)
    throws RemoteException
  {
    return zzah(paramString);
  }
  
  public boolean zzag(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, zzev.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
  
  public void zze(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    this.zzBG = paramMap;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzv.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreetViewPanoramaView
  extends FrameLayout
{
  private StreetViewPanorama zzaPA;
  private final zzb zzaPM;
  
  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.zzaPM = new zzb(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzaPM = new zzb(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzaPM = new zzb(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.zzaPM = new zzb(this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  @Deprecated
  public final StreetViewPanorama getStreetViewPanorama()
  {
    if (this.zzaPA != null) {
      return this.zzaPA;
    }
    this.zzaPM.zzzh();
    if (this.zzaPM.zzts() == null) {
      return null;
    }
    try
    {
      this.zzaPA = new StreetViewPanorama(((zza)this.zzaPM.zzts()).zzzo().getStreetViewPanorama());
      return this.zzaPA;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
  {
    zzx.zzcx("getStreetViewPanoramaAsync() must be called on the main thread");
    this.zzaPM.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.zzaPM.onCreate(paramBundle);
    if (this.zzaPM.zzts() == null) {
      zza.zzb(this);
    }
  }
  
  public final void onDestroy()
  {
    this.zzaPM.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.zzaPM.onLowMemory();
  }
  
  public final void onPause()
  {
    this.zzaPM.onPause();
  }
  
  public final void onResume()
  {
    this.zzaPM.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.zzaPM.onSaveInstanceState(paramBundle);
  }
  
  static class zza
    implements StreetViewLifecycleDelegate
  {
    private final IStreetViewPanoramaViewDelegate zzaPN;
    private View zzaPO;
    private final ViewGroup zzaPm;
    
    public zza(ViewGroup paramViewGroup, IStreetViewPanoramaViewDelegate paramIStreetViewPanoramaViewDelegate)
    {
      this.zzaPN = ((IStreetViewPanoramaViewDelegate)zzx.zzy(paramIStreetViewPanoramaViewDelegate));
      this.zzaPm = ((ViewGroup)zzx.zzy(paramViewGroup));
    }
    
    public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      try
      {
        this.zzaPN.getStreetViewPanoramaAsync(new zzv.zza()
        {
          public void zza(IStreetViewPanoramaDelegate paramAnonymousIStreetViewPanoramaDelegate)
            throws RemoteException
          {
            paramOnStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(paramAnonymousIStreetViewPanoramaDelegate));
          }
        });
        return;
      }
      catch (RemoteException paramOnStreetViewPanoramaReadyCallback)
      {
        throw new RuntimeRemoteException(paramOnStreetViewPanoramaReadyCallback);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.zzaPN.onCreate(paramBundle);
        this.zzaPO = ((View)zze.zzp(this.zzaPN.getView()));
        this.zzaPm.removeAllViews();
        this.zzaPm.addView(this.zzaPO);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.zzaPN.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.zzaPN.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onPause()
    {
      try
      {
        this.zzaPN.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.zzaPN.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.zzaPN.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public IStreetViewPanoramaViewDelegate zzzo()
    {
      return this.zzaPN;
    }
  }
  
  static class zzb
    extends zza<StreetViewPanoramaView.zza>
  {
    private final Context mContext;
    private final List<OnStreetViewPanoramaReadyCallback> zzaPE = new ArrayList();
    private final StreetViewPanoramaOptions zzaPQ;
    protected zzf<StreetViewPanoramaView.zza> zzaPj;
    private final ViewGroup zzaPq;
    
    zzb(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    {
      this.zzaPq = paramViewGroup;
      this.mContext = paramContext;
      this.zzaPQ = paramStreetViewPanoramaOptions;
    }
    
    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      if (zzts() != null)
      {
        ((StreetViewPanoramaView.zza)zzts()).getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
        return;
      }
      this.zzaPE.add(paramOnStreetViewPanoramaReadyCallback);
    }
    
    protected void zza(zzf<StreetViewPanoramaView.zza> paramzzf)
    {
      this.zzaPj = paramzzf;
      zzzh();
    }
    
    public void zzzh()
    {
      if ((this.zzaPj != null) && (zzts() == null)) {}
      try
      {
        Object localObject = zzy.zzaP(this.mContext).zza(zze.zzB(this.mContext), this.zzaPQ);
        this.zzaPj.zza(new StreetViewPanoramaView.zza(this.zzaPq, (IStreetViewPanoramaViewDelegate)localObject));
        localObject = this.zzaPE.iterator();
        while (((Iterator)localObject).hasNext())
        {
          OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)((Iterator)localObject).next();
          ((StreetViewPanoramaView.zza)zzts()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
        this.zzaPE.clear();
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
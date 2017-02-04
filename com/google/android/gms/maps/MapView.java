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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzl.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView
  extends FrameLayout
{
  private GoogleMap zzaPf;
  private final zzb zzaPl;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.zzaPl = new zzb(this, paramContext, null);
    init();
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzaPl = new zzb(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    init();
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzaPl = new zzb(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    init();
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.zzaPl = new zzb(this, paramContext, paramGoogleMapOptions);
    init();
  }
  
  private void init()
  {
    setClickable(true);
  }
  
  @Deprecated
  public final GoogleMap getMap()
  {
    if (this.zzaPf != null) {
      return this.zzaPf;
    }
    this.zzaPl.zzzh();
    if (this.zzaPl.zzts() == null) {
      return null;
    }
    try
    {
      this.zzaPf = new GoogleMap(((zza)this.zzaPl.zzts()).zzzi().getMap());
      return this.zzaPf;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    zzx.zzcx("getMapAsync() must be called on the main thread");
    this.zzaPl.getMapAsync(paramOnMapReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.zzaPl.onCreate(paramBundle);
    if (this.zzaPl.zzts() == null) {
      zza.zzb(this);
    }
  }
  
  public final void onDestroy()
  {
    this.zzaPl.onDestroy();
  }
  
  public final void onEnterAmbient(Bundle paramBundle)
  {
    zzx.zzcx("onEnterAmbient() must be called on the main thread");
    this.zzaPl.onEnterAmbient(paramBundle);
  }
  
  public final void onExitAmbient()
  {
    zzx.zzcx("onExitAmbient() must be called on the main thread");
    this.zzaPl.onExitAmbient();
  }
  
  public final void onLowMemory()
  {
    this.zzaPl.onLowMemory();
  }
  
  public final void onPause()
  {
    this.zzaPl.onPause();
  }
  
  public final void onResume()
  {
    this.zzaPl.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.zzaPl.onSaveInstanceState(paramBundle);
  }
  
  static class zza
    implements MapLifecycleDelegate
  {
    private final ViewGroup zzaPm;
    private final IMapViewDelegate zzaPn;
    private View zzaPo;
    
    public zza(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
    {
      this.zzaPn = ((IMapViewDelegate)zzx.zzy(paramIMapViewDelegate));
      this.zzaPm = ((ViewGroup)zzx.zzy(paramViewGroup));
    }
    
    public void getMapAsync(final OnMapReadyCallback paramOnMapReadyCallback)
    {
      try
      {
        this.zzaPn.getMapAsync(new zzl.zza()
        {
          public void zza(IGoogleMapDelegate paramAnonymousIGoogleMapDelegate)
            throws RemoteException
          {
            paramOnMapReadyCallback.onMapReady(new GoogleMap(paramAnonymousIGoogleMapDelegate));
          }
        });
        return;
      }
      catch (RemoteException paramOnMapReadyCallback)
      {
        throw new RuntimeRemoteException(paramOnMapReadyCallback);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.zzaPn.onCreate(paramBundle);
        this.zzaPo = ((View)zze.zzp(this.zzaPn.getView()));
        this.zzaPm.removeAllViews();
        this.zzaPm.addView(this.zzaPo);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.zzaPn.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      try
      {
        this.zzaPn.onEnterAmbient(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onExitAmbient()
    {
      try
      {
        this.zzaPn.onExitAmbient();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.zzaPn.onLowMemory();
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
        this.zzaPn.onPause();
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
        this.zzaPn.onResume();
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
        this.zzaPn.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public IMapViewDelegate zzzi()
    {
      return this.zzaPn;
    }
  }
  
  static class zzb
    extends zza<MapView.zza>
  {
    private final Context mContext;
    protected zzf<MapView.zza> zzaPj;
    private final List<OnMapReadyCallback> zzaPk = new ArrayList();
    private final ViewGroup zzaPq;
    private final GoogleMapOptions zzaPr;
    
    zzb(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.zzaPq = paramViewGroup;
      this.mContext = paramContext;
      this.zzaPr = paramGoogleMapOptions;
    }
    
    public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      if (zzts() != null)
      {
        ((MapView.zza)zzts()).getMapAsync(paramOnMapReadyCallback);
        return;
      }
      this.zzaPk.add(paramOnMapReadyCallback);
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      if (zzts() != null) {
        ((MapView.zza)zzts()).onEnterAmbient(paramBundle);
      }
    }
    
    public void onExitAmbient()
    {
      if (zzts() != null) {
        ((MapView.zza)zzts()).onExitAmbient();
      }
    }
    
    protected void zza(zzf<MapView.zza> paramzzf)
    {
      this.zzaPj = paramzzf;
      zzzh();
    }
    
    public void zzzh()
    {
      if ((this.zzaPj != null) && (zzts() == null)) {
        try
        {
          MapsInitializer.initialize(this.mContext);
          Object localObject = zzy.zzaP(this.mContext).zza(zze.zzB(this.mContext), this.zzaPr);
          if (localObject == null) {
            return;
          }
          this.zzaPj.zza(new MapView.zza(this.zzaPq, (IMapViewDelegate)localObject));
          localObject = this.zzaPk.iterator();
          while (((Iterator)localObject).hasNext())
          {
            OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)((Iterator)localObject).next();
            ((MapView.zza)zzts()).getMapAsync(localOnMapReadyCallback);
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          throw new RuntimeRemoteException(localRemoteException);
          this.zzaPk.clear();
          return;
        }
        catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
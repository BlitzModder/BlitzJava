package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzl.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapFragment
  extends Fragment
{
  private final zzb zzaPe = new zzb(this);
  private GoogleMap zzaPf;
  
  public static MapFragment newInstance()
  {
    return new MapFragment();
  }
  
  public static MapFragment newInstance(GoogleMapOptions paramGoogleMapOptions)
  {
    MapFragment localMapFragment = new MapFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
    localMapFragment.setArguments(localBundle);
    return localMapFragment;
  }
  
  @Deprecated
  public final GoogleMap getMap()
  {
    Object localObject = zzzg();
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        localObject = ((IMapFragmentDelegate)localObject).getMap();
        if (localObject == null) {
          continue;
        }
        if ((this.zzaPf == null) || (this.zzaPf.zzyU().asBinder() != ((IGoogleMapDelegate)localObject).asBinder())) {
          this.zzaPf = new GoogleMap((IGoogleMapDelegate)localObject);
        }
        return this.zzaPf;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    com.google.android.gms.common.internal.zzx.zzcx("getMapAsync must be called on the main thread.");
    this.zzaPe.getMapAsync(paramOnMapReadyCallback);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    zzb.zza(this.zzaPe, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzaPe.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.zzaPe.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setClickable(true);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.zzaPe.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.zzaPe.onDestroyView();
    super.onDestroyView();
  }
  
  public final void onEnterAmbient(Bundle paramBundle)
  {
    com.google.android.gms.common.internal.zzx.zzcx("onEnterAmbient must be called on the main thread.");
    this.zzaPe.onEnterAmbient(paramBundle);
  }
  
  public final void onExitAmbient()
  {
    com.google.android.gms.common.internal.zzx.zzcx("onExitAmbient must be called on the main thread.");
    this.zzaPe.onExitAmbient();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    zzb.zza(this.zzaPe, paramActivity);
    paramAttributeSet = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramAttributeSet);
    this.zzaPe.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.zzaPe.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.zzaPe.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.zzaPe.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.zzaPe.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  protected IMapFragmentDelegate zzzg()
  {
    this.zzaPe.zzzh();
    if (this.zzaPe.zzts() == null) {
      return null;
    }
    return ((zza)this.zzaPe.zzts()).zzzg();
  }
  
  static class zza
    implements MapLifecycleDelegate
  {
    private final IMapFragmentDelegate zzaPg;
    private final Fragment zzatC;
    
    public zza(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate)
    {
      this.zzaPg = ((IMapFragmentDelegate)com.google.android.gms.common.internal.zzx.zzy(paramIMapFragmentDelegate));
      this.zzatC = ((Fragment)com.google.android.gms.common.internal.zzx.zzy(paramFragment));
    }
    
    public void getMapAsync(final OnMapReadyCallback paramOnMapReadyCallback)
    {
      try
      {
        this.zzaPg.getMapAsync(new zzl.zza()
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
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {}
      try
      {
        localBundle = new Bundle();
        paramBundle = this.zzatC.getArguments();
        if ((paramBundle != null) && (paramBundle.containsKey("MapOptions"))) {
          com.google.android.gms.maps.internal.zzx.zza(localBundle, "MapOptions", paramBundle.getParcelable("MapOptions"));
        }
        this.zzaPg.onCreate(localBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        paramLayoutInflater = this.zzaPg.onCreateView(zze.zzB(paramLayoutInflater), zze.zzB(paramViewGroup), paramBundle);
        return (View)zze.zzp(paramLayoutInflater);
      }
      catch (RemoteException paramLayoutInflater)
      {
        throw new RuntimeRemoteException(paramLayoutInflater);
      }
    }
    
    public void onDestroy()
    {
      try
      {
        this.zzaPg.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      try
      {
        this.zzaPg.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      try
      {
        this.zzaPg.onEnterAmbient(paramBundle);
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
        this.zzaPg.onExitAmbient();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      paramBundle1 = (GoogleMapOptions)paramBundle1.getParcelable("MapOptions");
      try
      {
        this.zzaPg.onInflate(zze.zzB(paramActivity), paramBundle1, paramBundle2);
        return;
      }
      catch (RemoteException paramActivity)
      {
        throw new RuntimeRemoteException(paramActivity);
      }
    }
    
    public void onLowMemory()
    {
      try
      {
        this.zzaPg.onLowMemory();
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
        this.zzaPg.onPause();
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
        this.zzaPg.onResume();
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
        this.zzaPg.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public IMapFragmentDelegate zzzg()
    {
      return this.zzaPg;
    }
  }
  
  static class zzb
    extends zza<MapFragment.zza>
  {
    private Activity mActivity;
    protected zzf<MapFragment.zza> zzaPj;
    private final List<OnMapReadyCallback> zzaPk = new ArrayList();
    private final Fragment zzatC;
    
    zzb(Fragment paramFragment)
    {
      this.zzatC = paramFragment;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.mActivity = paramActivity;
      zzzh();
    }
    
    public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      if (zzts() != null)
      {
        ((MapFragment.zza)zzts()).getMapAsync(paramOnMapReadyCallback);
        return;
      }
      this.zzaPk.add(paramOnMapReadyCallback);
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      if (zzts() != null) {
        ((MapFragment.zza)zzts()).onEnterAmbient(paramBundle);
      }
    }
    
    public void onExitAmbient()
    {
      if (zzts() != null) {
        ((MapFragment.zza)zzts()).onExitAmbient();
      }
    }
    
    protected void zza(zzf<MapFragment.zza> paramzzf)
    {
      this.zzaPj = paramzzf;
      zzzh();
    }
    
    public void zzzh()
    {
      if ((this.mActivity != null) && (this.zzaPj != null) && (zzts() == null)) {
        try
        {
          MapsInitializer.initialize(this.mActivity);
          Object localObject = zzy.zzaP(this.mActivity).zzt(zze.zzB(this.mActivity));
          if (localObject == null) {
            return;
          }
          this.zzaPj.zza(new MapFragment.zza(this.zzatC, (IMapFragmentDelegate)localObject));
          localObject = this.zzaPk.iterator();
          while (((Iterator)localObject).hasNext())
          {
            OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)((Iterator)localObject).next();
            ((MapFragment.zza)zzts()).getMapAsync(localOnMapReadyCallback);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/MapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
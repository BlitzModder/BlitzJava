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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzv.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreetViewPanoramaFragment
  extends Fragment
{
  private StreetViewPanorama zzaPA;
  private final zzb zzaPz = new zzb(this);
  
  public static StreetViewPanoramaFragment newInstance()
  {
    return new StreetViewPanoramaFragment();
  }
  
  public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    StreetViewPanoramaFragment localStreetViewPanoramaFragment = new StreetViewPanoramaFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("StreetViewPanoramaOptions", paramStreetViewPanoramaOptions);
    localStreetViewPanoramaFragment.setArguments(localBundle);
    return localStreetViewPanoramaFragment;
  }
  
  @Deprecated
  public final StreetViewPanorama getStreetViewPanorama()
  {
    Object localObject = zzzk();
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        localObject = ((IStreetViewPanoramaFragmentDelegate)localObject).getStreetViewPanorama();
        if (localObject == null) {
          continue;
        }
        if ((this.zzaPA == null) || (this.zzaPA.zzzj().asBinder() != ((IStreetViewPanoramaDelegate)localObject).asBinder())) {
          this.zzaPA = new StreetViewPanorama((IStreetViewPanoramaDelegate)localObject);
        }
        return this.zzaPA;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
  {
    com.google.android.gms.common.internal.zzx.zzcx("getStreetViewPanoramaAsync() must be called on the main thread");
    this.zzaPz.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    zzb.zza(this.zzaPz, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzaPz.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.zzaPz.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.zzaPz.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.zzaPz.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    zzb.zza(this.zzaPz, paramActivity);
    paramAttributeSet = new Bundle();
    this.zzaPz.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.zzaPz.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.zzaPz.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.zzaPz.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.zzaPz.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  protected IStreetViewPanoramaFragmentDelegate zzzk()
  {
    this.zzaPz.zzzh();
    if (this.zzaPz.zzts() == null) {
      return null;
    }
    return ((zza)this.zzaPz.zzts()).zzzk();
  }
  
  static class zza
    implements StreetViewLifecycleDelegate
  {
    private final IStreetViewPanoramaFragmentDelegate zzaPB;
    private final Fragment zzatC;
    
    public zza(Fragment paramFragment, IStreetViewPanoramaFragmentDelegate paramIStreetViewPanoramaFragmentDelegate)
    {
      this.zzaPB = ((IStreetViewPanoramaFragmentDelegate)com.google.android.gms.common.internal.zzx.zzy(paramIStreetViewPanoramaFragmentDelegate));
      this.zzatC = ((Fragment)com.google.android.gms.common.internal.zzx.zzy(paramFragment));
    }
    
    public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      try
      {
        this.zzaPB.getStreetViewPanoramaAsync(new zzv.zza()
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
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {}
      try
      {
        localBundle = new Bundle();
        paramBundle = this.zzatC.getArguments();
        if ((paramBundle != null) && (paramBundle.containsKey("StreetViewPanoramaOptions"))) {
          com.google.android.gms.maps.internal.zzx.zza(localBundle, "StreetViewPanoramaOptions", paramBundle.getParcelable("StreetViewPanoramaOptions"));
        }
        this.zzaPB.onCreate(localBundle);
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
        paramLayoutInflater = this.zzaPB.onCreateView(zze.zzB(paramLayoutInflater), zze.zzB(paramViewGroup), paramBundle);
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
        this.zzaPB.onDestroy();
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
        this.zzaPB.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      try
      {
        this.zzaPB.onInflate(zze.zzB(paramActivity), null, paramBundle2);
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
        this.zzaPB.onLowMemory();
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
        this.zzaPB.onPause();
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
        this.zzaPB.onResume();
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
        this.zzaPB.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public IStreetViewPanoramaFragmentDelegate zzzk()
    {
      return this.zzaPB;
    }
  }
  
  static class zzb
    extends zza<StreetViewPanoramaFragment.zza>
  {
    private Activity mActivity;
    private final List<OnStreetViewPanoramaReadyCallback> zzaPE = new ArrayList();
    protected zzf<StreetViewPanoramaFragment.zza> zzaPj;
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
    
    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      if (zzts() != null)
      {
        ((StreetViewPanoramaFragment.zza)zzts()).getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
        return;
      }
      this.zzaPE.add(paramOnStreetViewPanoramaReadyCallback);
    }
    
    protected void zza(zzf<StreetViewPanoramaFragment.zza> paramzzf)
    {
      this.zzaPj = paramzzf;
      zzzh();
    }
    
    public void zzzh()
    {
      if ((this.mActivity != null) && (this.zzaPj != null) && (zzts() == null)) {}
      try
      {
        MapsInitializer.initialize(this.mActivity);
        Object localObject = zzy.zzaP(this.mActivity).zzu(zze.zzB(this.mActivity));
        this.zzaPj.zza(new StreetViewPanoramaFragment.zza(this.zzatC, (IStreetViewPanoramaFragmentDelegate)localObject));
        localObject = this.zzaPE.iterator();
        while (((Iterator)localObject).hasNext())
        {
          OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)((Iterator)localObject).next();
          ((StreetViewPanoramaFragment.zza)zzts()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
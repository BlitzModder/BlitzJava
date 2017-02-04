package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

public class SupportStreetViewPanoramaFragment
  extends Fragment
{
  private StreetViewPanorama zzaPA;
  private final zzb zzaPT = new zzb(this);
  
  public static SupportStreetViewPanoramaFragment newInstance()
  {
    return new SupportStreetViewPanoramaFragment();
  }
  
  public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    SupportStreetViewPanoramaFragment localSupportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("StreetViewPanoramaOptions", paramStreetViewPanoramaOptions);
    localSupportStreetViewPanoramaFragment.setArguments(localBundle);
    return localSupportStreetViewPanoramaFragment;
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
    this.zzaPT.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    zzb.zza(this.zzaPT, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzaPT.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.zzaPT.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.zzaPT.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.zzaPT.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    zzb.zza(this.zzaPT, paramActivity);
    paramAttributeSet = new Bundle();
    this.zzaPT.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.zzaPT.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.zzaPT.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.zzaPT.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.zzaPT.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  protected IStreetViewPanoramaFragmentDelegate zzzk()
  {
    this.zzaPT.zzzh();
    if (this.zzaPT.zzts() == null) {
      return null;
    }
    return ((zza)this.zzaPT.zzts()).zzzk();
  }
  
  static class zza
    implements StreetViewLifecycleDelegate
  {
    private final IStreetViewPanoramaFragmentDelegate zzaPB;
    private final Fragment zzajv;
    
    public zza(Fragment paramFragment, IStreetViewPanoramaFragmentDelegate paramIStreetViewPanoramaFragmentDelegate)
    {
      this.zzaPB = ((IStreetViewPanoramaFragmentDelegate)com.google.android.gms.common.internal.zzx.zzy(paramIStreetViewPanoramaFragmentDelegate));
      this.zzajv = ((Fragment)com.google.android.gms.common.internal.zzx.zzy(paramFragment));
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
        paramBundle = this.zzajv.getArguments();
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
    extends zza<SupportStreetViewPanoramaFragment.zza>
  {
    private Activity mActivity;
    private final List<OnStreetViewPanoramaReadyCallback> zzaPE = new ArrayList();
    protected zzf<SupportStreetViewPanoramaFragment.zza> zzaPj;
    private final Fragment zzajv;
    
    zzb(Fragment paramFragment)
    {
      this.zzajv = paramFragment;
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
        ((SupportStreetViewPanoramaFragment.zza)zzts()).getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
        return;
      }
      this.zzaPE.add(paramOnStreetViewPanoramaReadyCallback);
    }
    
    protected void zza(zzf<SupportStreetViewPanoramaFragment.zza> paramzzf)
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
        this.zzaPj.zza(new SupportStreetViewPanoramaFragment.zza(this.zzajv, (IStreetViewPanoramaFragmentDelegate)localObject));
        localObject = this.zzaPE.iterator();
        while (((Iterator)localObject).hasNext())
        {
          OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)((Iterator)localObject).next();
          ((SupportStreetViewPanoramaFragment.zza)zzts()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/SupportStreetViewPanoramaFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
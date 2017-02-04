package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class zzb
  extends zzc.zza
{
  private Fragment zzatC;
  
  private zzb(Fragment paramFragment)
  {
    this.zzatC = paramFragment;
  }
  
  public static zzb zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzb(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return this.zzatC.getArguments();
  }
  
  public int getId()
  {
    return this.zzatC.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.zzatC.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.zzatC.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.zzatC.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.zzatC.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzB(this.zzatC.getView());
  }
  
  public boolean isAdded()
  {
    return this.zzatC.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.zzatC.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.zzatC.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.zzatC.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.zzatC.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.zzatC.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.zzatC.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzatC.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.zzatC.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.zzatC.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzatC.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.zzatC.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzatC.startActivityForResult(paramIntent, paramInt);
  }
  
  public void zzn(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzatC.registerForContextMenu(paramzzd);
  }
  
  public void zzo(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzatC.unregisterForContextMenu(paramzzd);
  }
  
  public zzd zztt()
  {
    return zze.zzB(this.zzatC.getActivity());
  }
  
  public zzc zztu()
  {
    return zza(this.zzatC.getParentFragment());
  }
  
  public zzd zztv()
  {
    return zze.zzB(this.zzatC.getResources());
  }
  
  public zzc zztw()
  {
    return zza(this.zzatC.getTargetFragment());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/dynamic/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
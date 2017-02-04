package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzh
  extends zzc.zza
{
  private Fragment zzajv;
  
  private zzh(Fragment paramFragment)
  {
    this.zzajv = paramFragment;
  }
  
  public static zzh zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzh(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return this.zzajv.getArguments();
  }
  
  public int getId()
  {
    return this.zzajv.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.zzajv.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.zzajv.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.zzajv.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.zzajv.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzB(this.zzajv.getView());
  }
  
  public boolean isAdded()
  {
    return this.zzajv.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.zzajv.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.zzajv.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.zzajv.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.zzajv.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.zzajv.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.zzajv.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzajv.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.zzajv.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.zzajv.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzajv.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.zzajv.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzajv.startActivityForResult(paramIntent, paramInt);
  }
  
  public void zzn(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzajv.registerForContextMenu(paramzzd);
  }
  
  public void zzo(zzd paramzzd)
  {
    paramzzd = (View)zze.zzp(paramzzd);
    this.zzajv.unregisterForContextMenu(paramzzd);
  }
  
  public zzd zztt()
  {
    return zze.zzB(this.zzajv.getActivity());
  }
  
  public zzc zztu()
  {
    return zza(this.zzajv.getParentFragment());
  }
  
  public zzd zztv()
  {
    return zze.zzB(this.zzajv.getResources());
  }
  
  public zzc zztw()
  {
    return zza(this.zzajv.getTargetFragment());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/dynamic/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
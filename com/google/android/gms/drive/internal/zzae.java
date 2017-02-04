package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import java.util.ArrayList;
import java.util.List;

public class zzae
  extends zzao.zza
{
  private final int zzalo;
  private final List<Integer> zzapA = new ArrayList();
  private final zzf zzapy;
  private final zza zzapz;
  
  public zzae(Looper paramLooper, Context paramContext, int paramInt, zzf paramzzf)
  {
    this.zzalo = paramInt;
    this.zzapy = paramzzf;
    this.zzapz = new zza(paramLooper, paramContext, null);
  }
  
  public void zzc(OnEventResponse paramOnEventResponse)
    throws RemoteException
  {
    paramOnEventResponse = paramOnEventResponse.zzsT();
    if (this.zzalo == paramOnEventResponse.getType()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      zzx.zzaa(this.zzapA.contains(Integer.valueOf(paramOnEventResponse.getType())));
      this.zzapz.zza(this.zzapy, paramOnEventResponse);
      return;
    }
  }
  
  public void zzdd(int paramInt)
  {
    this.zzapA.add(Integer.valueOf(paramInt));
  }
  
  public boolean zzde(int paramInt)
  {
    return this.zzapA.contains(Integer.valueOf(paramInt));
  }
  
  private static class zza
    extends Handler
  {
    private final Context mContext;
    
    private zza(Looper paramLooper, Context paramContext)
    {
      super();
      this.mContext = paramContext;
    }
    
    private static void zza(zzl paramzzl, QueryResultEventParcelable paramQueryResultEventParcelable)
    {
      DataHolder localDataHolder = paramQueryResultEventParcelable.zzsA();
      if (localDataHolder != null) {
        paramzzl.zza(new zzj() {});
      }
      if (paramQueryResultEventParcelable.zzsB()) {
        paramzzl.zzcL(paramQueryResultEventParcelable.zzsC());
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        zzz.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
        return;
      }
      Object localObject = (Pair)paramMessage.obj;
      paramMessage = (zzf)((Pair)localObject).first;
      localObject = (DriveEvent)((Pair)localObject).second;
      switch (((DriveEvent)localObject).getType())
      {
      default: 
        zzz.zzA("EventCallback", "Unexpected event: " + localObject);
        return;
      case 1: 
        ((ChangeListener)paramMessage).onChange((ChangeEvent)localObject);
        return;
      case 2: 
        ((CompletionListener)paramMessage).onCompletion((CompletionEvent)localObject);
        return;
      case 3: 
        zza((zzl)paramMessage, (QueryResultEventParcelable)localObject);
        return;
      case 4: 
        ((zzc)paramMessage).zza((ChangesAvailableEvent)localObject);
        return;
      }
      ((zzi)paramMessage).zza((ProgressEvent)localObject);
    }
    
    public void zza(zzf paramzzf, DriveEvent paramDriveEvent)
    {
      sendMessage(obtainMessage(1, new Pair(paramzzf, paramDriveEvent)));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
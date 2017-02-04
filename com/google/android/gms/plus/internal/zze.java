package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class zze
  extends zzj<zzd>
{
  private Person zzaYV;
  private final PlusSession zzaYW;
  
  public zze(Context paramContext, Looper paramLooper, zzf paramzzf, PlusSession paramPlusSession, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 2, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzaYW = paramPlusSession;
  }
  
  public static boolean zzd(Set<Scope> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    while ((paramSet.size() == 1) && (paramSet.contains(new Scope("plus_one_placeholder_scope")))) {
      return false;
    }
    return true;
  }
  
  private Bundle zzlV()
  {
    Bundle localBundle = this.zzaYW.zzDp();
    localBundle.putStringArray("request_visible_actions", this.zzaYW.zzDj());
    localBundle.putString("auth_package", this.zzaYW.zzDl());
    return localBundle;
  }
  
  public String getAccountName()
  {
    zzqr();
    try
    {
      String str = ((zzd)zzqs()).getAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void zzDd()
  {
    zzqr();
    try
    {
      this.zzaYV = null;
      ((zzd)zzqs()).zzDd();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Person zzDf()
  {
    zzqr();
    return this.zzaYV;
  }
  
  public zzq zza(zzlx.zzb<People.LoadPeopleResult> paramzzb, int paramInt, String paramString)
  {
    zzqr();
    paramzzb = new zze(paramzzb);
    try
    {
      paramString = ((zzd)zzqs()).zza(paramzzb, 1, paramInt, -1, paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramzzb.zza(DataHolder.zzbJ(8), null);
    }
    return null;
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.zzaYV = PersonEntity.zzu(paramBundle.getByteArray("loaded_person"));
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public void zza(zzlx.zzb<Moments.LoadMomentsResult> paramzzb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    zzqr();
    if (paramzzb != null) {}
    for (paramzzb = new zzd(paramzzb);; paramzzb = null) {
      try
      {
        ((zzd)zzqs()).zza(paramzzb, paramInt, paramString1, paramUri, paramString2, paramString3);
        return;
      }
      catch (RemoteException paramString1)
      {
        paramzzb.zza(DataHolder.zzbJ(8), null, null);
      }
    }
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, Moment paramMoment)
  {
    zzqr();
    if (paramzzb != null) {}
    for (paramzzb = new zzc(paramzzb);; paramzzb = null) {
      try
      {
        paramMoment = SafeParcelResponse.zza((MomentEntity)paramMoment);
        ((zzd)zzqs()).zza(paramzzb, paramMoment);
        return;
      }
      catch (RemoteException paramMoment)
      {
        if (paramzzb != null) {
          break;
        }
        throw new IllegalStateException(paramMoment);
        paramzzb.zzba(new Status(8, null, null));
      }
    }
  }
  
  public void zza(zzlx.zzb<People.LoadPeopleResult> paramzzb, Collection<String> paramCollection)
  {
    zzqr();
    paramzzb = new zze(paramzzb);
    try
    {
      ((zzd)zzqs()).zza(paramzzb, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException paramCollection)
    {
      paramzzb.zza(DataHolder.zzbJ(8), null);
    }
  }
  
  public void zzd(zzlx.zzb<People.LoadPeopleResult> paramzzb, String[] paramArrayOfString)
  {
    zza(paramzzb, Arrays.asList(paramArrayOfString));
  }
  
  protected zzd zzdN(IBinder paramIBinder)
  {
    return zzd.zza.zzdM(paramIBinder);
  }
  
  public void zzeS(String paramString)
  {
    zzqr();
    try
    {
      ((zzd)zzqs()).zzeS(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  public void zzl(zzlx.zzb<Moments.LoadMomentsResult> paramzzb)
  {
    zza(paramzzb, 20, null, null, null, "me");
  }
  
  protected Bundle zzlU()
  {
    return zzlV();
  }
  
  public void zzm(zzlx.zzb<People.LoadPeopleResult> paramzzb)
  {
    zzqr();
    paramzzb = new zze(paramzzb);
    try
    {
      ((zzd)zzqs()).zza(paramzzb, 2, 1, -1, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramzzb.zza(DataHolder.zzbJ(8), null);
    }
  }
  
  public boolean zzmn()
  {
    return zzd(zzqq().zzb(Plus.API));
  }
  
  public void zzn(zzlx.zzb<Status> paramzzb)
  {
    zzqr();
    zzDd();
    paramzzb = new zzf(paramzzb);
    try
    {
      ((zzd)zzqs()).zzb(paramzzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramzzb.zzi(8, null);
    }
  }
  
  public zzq zzq(zzlx.zzb<People.LoadPeopleResult> paramzzb, String paramString)
  {
    return zza(paramzzb, 0, paramString);
  }
  
  protected Bundle zzqt()
  {
    return zzlV();
  }
  
  static final class zza
    implements Moments.LoadMomentsResult
  {
    private final Status zzTA;
    private final String zzaYX;
    private final String zzaYY;
    private final MomentBuffer zzaYZ;
    
    public zza(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      this.zzTA = paramStatus;
      this.zzaYX = paramString1;
      this.zzaYY = paramString2;
      if (paramDataHolder != null) {}
      for (paramStatus = new MomentBuffer(paramDataHolder);; paramStatus = null)
      {
        this.zzaYZ = paramStatus;
        return;
      }
    }
    
    public MomentBuffer getMomentBuffer()
    {
      return this.zzaYZ;
    }
    
    public String getNextPageToken()
    {
      return this.zzaYX;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public String getUpdated()
    {
      return this.zzaYY;
    }
    
    public void release()
    {
      if (this.zzaYZ != null) {
        this.zzaYZ.release();
      }
    }
  }
  
  static final class zzb
    implements People.LoadPeopleResult
  {
    private final Status zzTA;
    private final String zzaYX;
    private final PersonBuffer zzaZa;
    
    public zzb(Status paramStatus, DataHolder paramDataHolder, String paramString)
    {
      this.zzTA = paramStatus;
      this.zzaYX = paramString;
      if (paramDataHolder != null) {}
      for (paramStatus = new PersonBuffer(paramDataHolder);; paramStatus = null)
      {
        this.zzaZa = paramStatus;
        return;
      }
    }
    
    public String getNextPageToken()
    {
      return this.zzaYX;
    }
    
    public PersonBuffer getPersonBuffer()
    {
      return this.zzaZa;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      if (this.zzaZa != null) {
        this.zzaZa.release();
      }
    }
  }
  
  static final class zzc
    extends zza
  {
    private final zzlx.zzb<Status> zzaLZ;
    
    public zzc(zzlx.zzb<Status> paramzzb)
    {
      this.zzaLZ = paramzzb;
    }
    
    public void zzba(Status paramStatus)
    {
      this.zzaLZ.zzr(paramStatus);
    }
  }
  
  static final class zzd
    extends zza
  {
    private final zzlx.zzb<Moments.LoadMomentsResult> zzaLZ;
    
    public zzd(zzlx.zzb<Moments.LoadMomentsResult> paramzzb)
    {
      this.zzaLZ = paramzzb;
    }
    
    public void zza(DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      if (paramDataHolder.zzpH() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.zzpH().getParcelable("pendingIntent");; localObject = null)
      {
        Status localStatus = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
        localObject = paramDataHolder;
        if (!localStatus.isSuccess())
        {
          localObject = paramDataHolder;
          if (paramDataHolder != null)
          {
            if (!paramDataHolder.isClosed()) {
              paramDataHolder.close();
            }
            localObject = null;
          }
        }
        this.zzaLZ.zzr(new zze.zza(localStatus, (DataHolder)localObject, paramString1, paramString2));
        return;
      }
    }
  }
  
  static final class zze
    extends zza
  {
    private final zzlx.zzb<People.LoadPeopleResult> zzaLZ;
    
    public zze(zzlx.zzb<People.LoadPeopleResult> paramzzb)
    {
      this.zzaLZ = paramzzb;
    }
    
    public void zza(DataHolder paramDataHolder, String paramString)
    {
      if (paramDataHolder.zzpH() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.zzpH().getParcelable("pendingIntent");; localObject = null)
      {
        Status localStatus = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
        localObject = paramDataHolder;
        if (!localStatus.isSuccess())
        {
          localObject = paramDataHolder;
          if (paramDataHolder != null)
          {
            if (!paramDataHolder.isClosed()) {
              paramDataHolder.close();
            }
            localObject = null;
          }
        }
        this.zzaLZ.zzr(new zze.zzb(localStatus, (DataHolder)localObject, paramString));
        return;
      }
    }
  }
  
  static final class zzf
    extends zza
  {
    private final zzlx.zzb<Status> zzaLZ;
    
    public zzf(zzlx.zzb<Status> paramzzb)
    {
      this.zzaLZ = paramzzb;
    }
    
    public void zzi(int paramInt, Bundle paramBundle)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt, null, paramBundle);
        this.zzaLZ.zzr(paramBundle);
        return;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.AppMeasurement;

public class zzo
  extends zzw
{
  private final long zzaSk = zzAX().zzAE();
  private final char zzaTh;
  private final zza zzaTi;
  private final zza zzaTj;
  private final zza zzaTk;
  private final zza zzaTl;
  private final zza zzaTm;
  private final zza zzaTn;
  private final zza zzaTo;
  private final zza zzaTp;
  private final zza zzaTq;
  private final String zzakw = zzAX().zzAs();
  
  zzo(zzt paramzzt)
  {
    super(paramzzt);
    if (zzAX().zzkb())
    {
      if (zzAX().zzka()) {}
      for (c = 'P';; c = 'C')
      {
        this.zzaTh = c;
        this.zzaTi = new zza(6, false, false);
        this.zzaTj = new zza(6, true, false);
        this.zzaTk = new zza(6, false, true);
        this.zzaTl = new zza(5, false, false);
        this.zzaTm = new zza(5, true, false);
        this.zzaTn = new zza(5, false, true);
        this.zzaTo = new zza(4, false, false);
        this.zzaTp = new zza(3, false, false);
        this.zzaTq = new zza(2, false, false);
        return;
      }
    }
    if (zzAX().zzka()) {}
    for (char c = 'p';; c = 'c')
    {
      this.zzaTh = c;
      break;
    }
  }
  
  static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zzc(paramBoolean, paramObject1);
    paramObject2 = zzc(paramBoolean, paramObject2);
    paramObject3 = zzc(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = (String)paramObject1;
    if (!TextUtils.isEmpty((CharSequence)paramObject2))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append((String)paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  static String zzc(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof Integer)) {
      paramObject = Long.valueOf(((Integer)paramObject).intValue());
    }
    for (;;)
    {
      String str1;
      if ((paramObject instanceof Long))
      {
        if (!paramBoolean) {
          return String.valueOf(paramObject);
        }
        if (Math.abs(((Long)paramObject).longValue()) < 100L) {
          return String.valueOf(paramObject);
        }
        if (String.valueOf(paramObject).charAt(0) == '-') {}
        for (str1 = "-";; str1 = "")
        {
          paramObject = String.valueOf(Math.abs(((Long)paramObject).longValue()));
          return str1 + Math.round(Math.pow(10.0D, ((String)paramObject).length() - 1)) + "..." + str1 + Math.round(Math.pow(10.0D, ((String)paramObject).length()) - 1.0D);
        }
      }
      if ((paramObject instanceof Boolean)) {
        return String.valueOf(paramObject);
      }
      if ((paramObject instanceof Throwable))
      {
        Object localObject1 = (Throwable)paramObject;
        paramObject = new StringBuilder(((Throwable)localObject1).toString());
        str1 = zzey(AppMeasurement.class.getCanonicalName());
        String str2 = zzey(zzt.class.getCanonicalName());
        localObject1 = ((Throwable)localObject1).getStackTrace();
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (((StackTraceElement)localObject2).isNativeMethod()) {}
          String str3;
          do
          {
            do
            {
              i += 1;
              break;
              str3 = ((StackTraceElement)localObject2).getClassName();
            } while (str3 == null);
            str3 = zzey(str3);
          } while ((!str3.equals(str1)) && (!str3.equals(str2)));
          ((StringBuilder)paramObject).append(": ");
          ((StringBuilder)paramObject).append(localObject2);
        }
        return ((StringBuilder)paramObject).toString();
      }
      if (paramBoolean) {
        return "-";
      }
      return String.valueOf(paramObject);
    }
  }
  
  private static String zzey(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf('.');
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public zza zzBl()
  {
    return this.zzaTi;
  }
  
  public zza zzBm()
  {
    return this.zzaTl;
  }
  
  public zza zzBn()
  {
    return this.zzaTm;
  }
  
  public zza zzBo()
  {
    return this.zzaTn;
  }
  
  public zza zzBp()
  {
    return this.zzaTo;
  }
  
  public zza zzBq()
  {
    return this.zzaTp;
  }
  
  public zza zzBr()
  {
    return this.zzaTq;
  }
  
  public String zzBs()
  {
    Pair localPair = zzAW().zzaTE.zzlw();
    if (localPair == null) {
      return null;
    }
    return String.valueOf(localPair.second) + ":" + (String)localPair.first;
  }
  
  protected boolean zzQ(int paramInt)
  {
    return Log.isLoggable(this.zzakw, paramInt);
  }
  
  protected void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((!paramBoolean1) && (zzQ(paramInt))) {
      zzn(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3));
    }
    if ((!paramBoolean2) && (paramInt >= 5)) {
      zzb(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
  }
  
  public void zzb(int paramInt, final String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zzx.zzy(paramString);
    zzs localzzs = this.zzaQX.zzBA();
    if ((localzzs == null) || (!localzzs.isInitialized()) || (localzzs.zzBP()))
    {
      zzn(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= "01VDIWEA?".length()) {
      paramInt = "01VDIWEA?".length() - 1;
    }
    paramObject1 = "1" + "01VDIWEA?".charAt(paramInt) + this.zzaTh + this.zzaSk + ":" + zza(true, paramString, paramObject1, paramObject2, paramObject3);
    if (((String)paramObject1).length() > 1024) {}
    for (paramString = paramString.substring(0, 1024);; paramString = (String)paramObject1)
    {
      localzzs.zzg(new Runnable()
      {
        public void run()
        {
          zzr localzzr = zzo.this.zzaQX.zzAW();
          if ((!localzzr.isInitialized()) || (localzzr.zzBP()))
          {
            zzo.this.zzn(6, "Persisted config not initialized . Not logging error/warn.");
            return;
          }
          localzzr.zzaTE.zzbn(paramString);
        }
      });
      return;
    }
  }
  
  protected void zzir() {}
  
  protected void zzn(int paramInt, String paramString)
  {
    Log.println(paramInt, this.zzakw, paramString);
  }
  
  public class zza
  {
    private final int mPriority;
    private final boolean zzaTt;
    private final boolean zzaTu;
    
    zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mPriority = paramInt;
      this.zzaTt = paramBoolean1;
      this.zzaTu = paramBoolean2;
    }
    
    public void zzd(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      zzo.this.zza(this.mPriority, this.zzaTt, this.zzaTu, paramString, paramObject1, paramObject2, paramObject3);
    }
    
    public void zze(String paramString, Object paramObject1, Object paramObject2)
    {
      zzo.this.zza(this.mPriority, this.zzaTt, this.zzaTu, paramString, paramObject1, paramObject2, null);
    }
    
    public void zzez(String paramString)
    {
      zzo.this.zza(this.mPriority, this.zzaTt, this.zzaTu, paramString, null, null, null);
    }
    
    public void zzj(String paramString, Object paramObject)
    {
      zzo.this.zza(this.mPriority, this.zzaTt, this.zzaTu, paramString, paramObject, null, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
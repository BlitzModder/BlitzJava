package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public abstract interface HistoryApi
{
  public abstract PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, DataDeleteRequest paramDataDeleteRequest);
  
  public abstract PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet);
  
  public abstract PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, DataReadRequest paramDataReadRequest);
  
  public static class ViewIntentBuilder
  {
    private final Context mContext;
    private long zzQj;
    private final DataType zzatO;
    private DataSource zzatP;
    private long zzatQ;
    private String zzatR;
    
    public ViewIntentBuilder(Context paramContext, DataType paramDataType)
    {
      this.mContext = paramContext;
      this.zzatO = paramDataType;
    }
    
    private Intent zzl(Intent paramIntent)
    {
      if (this.zzatR == null) {}
      Intent localIntent;
      ResolveInfo localResolveInfo;
      do
      {
        return paramIntent;
        localIntent = new Intent(paramIntent).setPackage(this.zzatR);
        localResolveInfo = this.mContext.getPackageManager().resolveActivity(localIntent, 0);
      } while (localResolveInfo == null);
      paramIntent = localResolveInfo.activityInfo.name;
      localIntent.setComponent(new ComponentName(this.zzatR, paramIntent));
      return localIntent;
    }
    
    public Intent build()
    {
      boolean bool2 = true;
      if (this.zzQj > 0L)
      {
        bool1 = true;
        zzx.zza(bool1, "Start time must be set");
        if (this.zzatQ <= this.zzQj) {
          break label107;
        }
      }
      label107:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "End time must be set and after start time");
        Intent localIntent = new Intent("vnd.google.fitness.VIEW");
        localIntent.setType(DataType.getMimeType(this.zzatP.getDataType()));
        localIntent.putExtra("vnd.google.fitness.start_time", this.zzQj);
        localIntent.putExtra("vnd.google.fitness.end_time", this.zzatQ);
        zzc.zza(this.zzatP, localIntent, "vnd.google.fitness.data_source");
        return zzl(localIntent);
        bool1 = false;
        break;
      }
    }
    
    public ViewIntentBuilder setDataSource(DataSource paramDataSource)
    {
      zzx.zzb(paramDataSource.getDataType().equals(this.zzatO), "Data source %s is not for the data type %s", new Object[] { paramDataSource, this.zzatO });
      this.zzatP = paramDataSource;
      return this;
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      this.zzatR = paramString;
      return this;
    }
    
    public ViewIntentBuilder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzQj = paramTimeUnit.toMillis(paramLong1);
      this.zzatQ = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/HistoryApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
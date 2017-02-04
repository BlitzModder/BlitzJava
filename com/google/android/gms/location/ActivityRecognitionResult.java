package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
  Bundle extras;
  private final int mVersionCode;
  List<DetectedActivity> zzaKH;
  long zzaKI;
  long zzaKJ;
  int zzaKK;
  
  public ActivityRecognitionResult(int paramInt1, List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt2, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.zzaKH = paramList;
    this.zzaKI = paramLong1;
    this.zzaKJ = paramLong2;
    this.zzaKK = paramInt2;
    this.extras = paramBundle;
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(paramDetectedActivity, paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, paramInt, paramBundle);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this(paramList, paramLong1, paramLong2, 0, null);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = true;
      zzx.zzb(bool1, "Must have at least 1 detected activity");
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Must set times");
      this.mVersionCode = 2;
      this.zzaKH = paramList;
      this.zzaKI = paramLong1;
      this.zzaKJ = paramLong2;
      this.zzaKK = paramInt;
      this.extras = paramBundle;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    paramIntent = paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    if ((paramIntent instanceof byte[]))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall((byte[])paramIntent, 0, ((byte[])paramIntent).length);
      localParcel.setDataPosition(0);
      return CREATOR.createFromParcel(localParcel);
    }
    if ((paramIntent instanceof ActivityRecognitionResult)) {
      return (ActivityRecognitionResult)paramIntent;
    }
    return null;
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
  }
  
  private static boolean zzc(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return true;
    }
    if (((paramBundle1 == null) && (paramBundle2 != null)) || ((paramBundle1 != null) && (paramBundle2 == null))) {
      return false;
    }
    if (paramBundle1.size() != paramBundle2.size()) {
      return false;
    }
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle2.containsKey(str)) {
        return false;
      }
      if (paramBundle1.get(str) == null)
      {
        if (paramBundle2.get(str) != null) {
          return false;
        }
      }
      else if ((paramBundle1.get(str) instanceof Bundle))
      {
        if (!zzc(paramBundle1.getBundle(str), paramBundle2.getBundle(str))) {
          return false;
        }
      }
      else if (!paramBundle1.get(str).equals(paramBundle2.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ActivityRecognitionResult)paramObject;
    } while ((this.zzaKI == ((ActivityRecognitionResult)paramObject).zzaKI) && (this.zzaKJ == ((ActivityRecognitionResult)paramObject).zzaKJ) && (this.zzaKK == ((ActivityRecognitionResult)paramObject).zzaKK) && (zzw.equal(this.zzaKH, ((ActivityRecognitionResult)paramObject).zzaKH)) && (zzc(this.extras, ((ActivityRecognitionResult)paramObject).extras)));
    return false;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = this.zzaKH.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt) {
        return localDetectedActivity.getConfidence();
      }
    }
    return 0;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return this.zzaKJ;
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)this.zzaKH.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities()
  {
    return this.zzaKH;
  }
  
  public long getTime()
  {
    return this.zzaKI;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzaKI), Long.valueOf(this.zzaKJ), Integer.valueOf(this.zzaKK), this.zzaKH, this.extras });
  }
  
  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + this.zzaKH + ", timeMillis=" + this.zzaKI + ", elapsedRealtimeMillis=" + this.zzaKJ + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ActivityRecognitionResultCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/ActivityRecognitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
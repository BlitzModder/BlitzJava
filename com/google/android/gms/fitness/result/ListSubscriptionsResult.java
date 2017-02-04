package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSubscriptionsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzh();
  private final int mVersionCode;
  private final Status zzTA;
  private final List<Subscription> zzazs;
  
  ListSubscriptionsResult(int paramInt, List<Subscription> paramList, Status paramStatus)
  {
    this.mVersionCode = paramInt;
    this.zzazs = paramList;
    this.zzTA = paramStatus;
  }
  
  public ListSubscriptionsResult(List<Subscription> paramList, Status paramStatus)
  {
    this.mVersionCode = 3;
    this.zzazs = Collections.unmodifiableList(paramList);
    this.zzTA = ((Status)zzx.zzb(paramStatus, "status"));
  }
  
  public static ListSubscriptionsResult zzU(Status paramStatus)
  {
    return new ListSubscriptionsResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean zzb(ListSubscriptionsResult paramListSubscriptionsResult)
  {
    return (this.zzTA.equals(paramListSubscriptionsResult.zzTA)) && (zzw.equal(this.zzazs, paramListSubscriptionsResult.zzazs));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof ListSubscriptionsResult)) && (zzb((ListSubscriptionsResult)paramObject)));
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public List<Subscription> getSubscriptions()
  {
    return this.zzazs;
  }
  
  public List<Subscription> getSubscriptions(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzazs.iterator();
    while (localIterator.hasNext())
    {
      Subscription localSubscription = (Subscription)localIterator.next();
      if (paramDataType.equals(localSubscription.zztV())) {
        localArrayList.add(localSubscription);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTA, this.zzazs });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("subscriptions", this.zzazs).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/ListSubscriptionsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
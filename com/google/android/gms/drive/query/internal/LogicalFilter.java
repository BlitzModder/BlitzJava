package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new zzk();
  final int mVersionCode;
  private List<Filter> zzarU;
  final Operator zzasa;
  final List<FilterHolder> zzasp;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzasa = paramOperator;
    this.zzasp = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs)
  {
    this.mVersionCode = 1;
    this.zzasa = paramOperator;
    this.zzasp = new ArrayList(paramVarArgs.length + 1);
    this.zzasp.add(new FilterHolder(paramFilter));
    this.zzarU = new ArrayList(paramVarArgs.length + 1);
    this.zzarU.add(paramFilter);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramOperator = paramVarArgs[i];
      this.zzasp.add(new FilterHolder(paramOperator));
      this.zzarU.add(paramOperator);
      i += 1;
    }
  }
  
  public LogicalFilter(Operator paramOperator, Iterable<Filter> paramIterable)
  {
    this.mVersionCode = 1;
    this.zzasa = paramOperator;
    this.zzarU = new ArrayList();
    this.zzasp = new ArrayList();
    paramOperator = paramIterable.iterator();
    while (paramOperator.hasNext())
    {
      paramIterable = (Filter)paramOperator.next();
      this.zzarU.add(paramIterable);
      this.zzasp.add(new FilterHolder(paramIterable));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public <T> T zza(zzf<T> paramzzf)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzasp.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((FilterHolder)localIterator.next()).getFilter().zza(paramzzf));
    }
    return (T)paramzzf.zzb(this.zzasa, localArrayList);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
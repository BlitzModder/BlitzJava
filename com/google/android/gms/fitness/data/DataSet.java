package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSet> CREATOR = new zze();
  private final int mVersionCode;
  private final DataType zzatO;
  private final DataSource zzatP;
  private boolean zzaud = false;
  private final List<DataPoint> zzauk;
  private final List<DataSource> zzaul;
  
  DataSet(int paramInt, DataSource paramDataSource, DataType paramDataType, List<RawDataPoint> paramList, List<DataSource> paramList1, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzatP = paramDataSource;
    this.zzatO = paramDataSource.getDataType();
    this.zzaud = paramBoolean;
    this.zzauk = new ArrayList(paramList.size());
    if (paramInt >= 2) {}
    for (;;)
    {
      this.zzaul = paramList1;
      paramDataSource = paramList.iterator();
      while (paramDataSource.hasNext())
      {
        paramDataType = (RawDataPoint)paramDataSource.next();
        this.zzauk.add(new DataPoint(this.zzaul, paramDataType));
      }
      paramList1 = Collections.singletonList(paramDataSource);
    }
  }
  
  public DataSet(DataSource paramDataSource)
  {
    this.mVersionCode = 3;
    this.zzatP = ((DataSource)zzx.zzy(paramDataSource));
    this.zzatO = paramDataSource.getDataType();
    this.zzauk = new ArrayList();
    this.zzaul = new ArrayList();
    this.zzaul.add(this.zzatP);
  }
  
  public DataSet(RawDataSet paramRawDataSet, List<DataSource> paramList)
  {
    this.mVersionCode = 3;
    this.zzatP = ((DataSource)zzb(paramList, paramRawDataSet.zzauX));
    this.zzatO = this.zzatP.getDataType();
    this.zzaul = paramList;
    this.zzaud = paramRawDataSet.zzaud;
    paramRawDataSet = paramRawDataSet.zzava;
    this.zzauk = new ArrayList(paramRawDataSet.size());
    paramRawDataSet = paramRawDataSet.iterator();
    while (paramRawDataSet.hasNext())
    {
      paramList = (RawDataPoint)paramRawDataSet.next();
      this.zzauk.add(new DataPoint(this.zzaul, paramList));
    }
  }
  
  public static DataSet create(DataSource paramDataSource)
  {
    zzx.zzb(paramDataSource, "DataSource should be specified");
    return new DataSet(paramDataSource);
  }
  
  private boolean zza(DataSet paramDataSet)
  {
    return (zzw.equal(getDataType(), paramDataSet.getDataType())) && (zzw.equal(this.zzatP, paramDataSet.zzatP)) && (zzw.equal(this.zzauk, paramDataSet.zzauk)) && (this.zzaud == paramDataSet.zzaud);
  }
  
  private static <T> T zzb(List<T> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (T)paramList.get(paramInt);
    }
    return null;
  }
  
  public void add(DataPoint paramDataPoint)
  {
    Object localObject = paramDataPoint.getDataSource();
    zzx.zzb(((DataSource)localObject).getStreamIdentifier().equals(this.zzatP.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[] { localObject, this.zzatP });
    paramDataPoint.zztG();
    localObject = zzop.zzd(paramDataPoint);
    if (localObject == null)
    {
      zzb(paramDataPoint);
      return;
    }
    Log.w("Fitness", "Ignoring invalid datapoint (Will be an exception in the next release): " + paramDataPoint, new IllegalArgumentException((String)localObject));
  }
  
  public void addAll(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add((DataPoint)paramIterable.next());
    }
  }
  
  public DataPoint createDataPoint()
  {
    return DataPoint.create(this.zzatP);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataSet)) && (zza((DataSet)paramObject)));
  }
  
  public List<DataPoint> getDataPoints()
  {
    return Collections.unmodifiableList(this.zzauk);
  }
  
  public DataSource getDataSource()
  {
    return this.zzatP;
  }
  
  public DataType getDataType()
  {
    return this.zzatP.getDataType();
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatP });
  }
  
  public boolean isEmpty()
  {
    return this.zzauk.isEmpty();
  }
  
  public String toString()
  {
    Object localObject = zztI();
    String str = this.zzatP.toDebugString();
    if (this.zzauk.size() < 10) {}
    for (;;)
    {
      return String.format("DataSet{%s %s}", new Object[] { str, localObject });
      localObject = String.format("%d data points, first 5: %s", new Object[] { Integer.valueOf(this.zzauk.size()), ((List)localObject).subList(0, 5) });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public void zzb(DataPoint paramDataPoint)
  {
    this.zzauk.add(paramDataPoint);
    paramDataPoint = paramDataPoint.getOriginalDataSource();
    if ((paramDataPoint != null) && (!this.zzaul.contains(paramDataPoint))) {
      this.zzaul.add(paramDataPoint);
    }
  }
  
  public void zzb(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      zzb((DataPoint)paramIterable.next());
    }
  }
  
  List<RawDataPoint> zzt(List<DataSource> paramList)
  {
    ArrayList localArrayList = new ArrayList(this.zzauk.size());
    Iterator localIterator = this.zzauk.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataPoint((DataPoint)localIterator.next(), paramList));
    }
    return localArrayList;
  }
  
  public boolean zztA()
  {
    return this.zzaud;
  }
  
  List<RawDataPoint> zztI()
  {
    return zzt(this.zzaul);
  }
  
  List<DataSource> zztJ()
  {
    return this.zzaul;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/DataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
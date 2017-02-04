package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new zza();
  final int mVersionCode;
  final List<DriveSpace> zzanF;
  private final Set<DriveSpace> zzanG;
  final boolean zzapH;
  final LogicalFilter zzarP;
  final String zzarQ;
  final SortOrder zzarR;
  final List<String> zzarS;
  final boolean zzarT;
  
  private Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean1, List<DriveSpace> paramList1, Set<DriveSpace> paramSet, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzarP = paramLogicalFilter;
    this.zzarQ = paramString;
    this.zzarR = paramSortOrder;
    this.zzarS = paramList;
    this.zzarT = paramBoolean1;
    this.zzanF = paramList1;
    this.zzanG = paramSet;
    this.zzapH = paramBoolean2;
  }
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean1, List<DriveSpace> paramList1, boolean paramBoolean2) {}
  
  private Query(LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean1, Set<DriveSpace> paramSet, boolean paramBoolean2) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.zzarP;
  }
  
  @Deprecated
  public String getPageToken()
  {
    return this.zzarQ;
  }
  
  public SortOrder getSortOrder()
  {
    return this.zzarR;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[] { this.zzarP, this.zzarR, this.zzarQ, this.zzanF });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public List<String> zzth()
  {
    return this.zzarS;
  }
  
  public boolean zzti()
  {
    return this.zzarT;
  }
  
  public Set<DriveSpace> zztj()
  {
    return this.zzanG;
  }
  
  public boolean zztk()
  {
    return this.zzapH;
  }
  
  public static class Builder
  {
    private Set<DriveSpace> zzanG;
    private boolean zzapH;
    private String zzarQ;
    private SortOrder zzarR;
    private List<String> zzarS;
    private boolean zzarT;
    private final List<Filter> zzarU = new ArrayList();
    
    public Builder() {}
    
    public Builder(Query paramQuery)
    {
      this.zzarU.add(paramQuery.getFilter());
      this.zzarQ = paramQuery.getPageToken();
      this.zzarR = paramQuery.getSortOrder();
      this.zzarS = paramQuery.zzth();
      this.zzarT = paramQuery.zzti();
      this.zzanG = paramQuery.zztj();
      this.zzapH = paramQuery.zztk();
    }
    
    public Builder addFilter(Filter paramFilter)
    {
      if (!(paramFilter instanceof MatchAllFilter)) {
        this.zzarU.add(paramFilter);
      }
      return this;
    }
    
    public Query build()
    {
      return new Query(new LogicalFilter(Operator.zzasw, this.zzarU), this.zzarQ, this.zzarR, this.zzarS, this.zzarT, this.zzanG, this.zzapH, null);
    }
    
    @Deprecated
    public Builder setPageToken(String paramString)
    {
      this.zzarQ = paramString;
      return this;
    }
    
    public Builder setSortOrder(SortOrder paramSortOrder)
    {
      this.zzarR = paramSortOrder;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
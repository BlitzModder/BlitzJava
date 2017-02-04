package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

public final class AppContentSectionBuffer
  extends zzf<AppContentSection>
{
  private final ArrayList<DataHolder> zzaBi;
  
  public void release()
  {
    super.release();
    int j = this.zzaBi.size();
    int i = 1;
    while (i < j)
    {
      DataHolder localDataHolder = (DataHolder)this.zzaBi.get(i);
      if (localDataHolder != null) {
        localDataHolder.close();
      }
      i += 1;
    }
  }
  
  protected AppContentSection zzn(int paramInt1, int paramInt2)
  {
    return new AppContentSectionRef(this.zzaBi, paramInt1, paramInt2);
  }
  
  protected String zzpO()
  {
    return "section_id";
  }
  
  protected String zzpQ()
  {
    return "card_id";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentSectionBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
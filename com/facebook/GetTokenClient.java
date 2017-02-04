package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

final class GetTokenClient
  extends PlatformServiceClient
{
  GetTokenClient(Context paramContext, String paramString)
  {
    super(paramContext, 65536, 65537, 20121101, paramString);
  }
  
  protected void populateRequestBundle(Bundle paramBundle) {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/GetTokenClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package rrrrrr;

import com.immersion.hapticmediasdk.MediaPlaybackSDK;
import com.immersion.hapticmediasdk.utils.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class rrccrr
  implements Runnable
{
  private static final String a = "ValidateURL";
  private URL b;
  
  public rrccrr(MediaPlaybackSDK paramMediaPlaybackSDK, String paramString)
    throws MalformedURLException
  {
    this.b = new URL(paramString);
  }
  
  private void a(int paramInt)
  {
    try
    {
      MediaPlaybackSDK.bъ044A044Aъ044Aъ(this.b0427Ч0427ЧЧ0427, paramInt);
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)this.b.openConnection();
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setRequestMethod("HEAD");
      int i = localHttpURLConnection.getResponseCode();
      a(i);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("ValidateURL", localIOException.getMessage());
      return;
    }
    finally
    {
      a(500);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/rrrrrr/rrccrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
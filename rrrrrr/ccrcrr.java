package rrrrrr;

import android.os.Handler;
import android.os.SystemClock;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.controllers.HapticPlaybackThread;
import com.immersion.hapticmediasdk.utils.RuntimeInfo;
import java.util.ArrayList;

public class ccrcrr
  implements Runnable
{
  private final byte[] a;
  private final long b;
  private final long c;
  private final int d;
  private final long e;
  
  public ccrcrr(HapticPlaybackThread paramHapticPlaybackThread, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt, long paramLong3)
  {
    this.a = paramArrayOfByte;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramInt;
    this.e = paramLong3;
  }
  
  public void run()
  {
    if (HapticPlaybackThread.b04460446ц0446ц0446(this.bЧ0427ЧЧЧ0427)) {
      synchronized (HapticPlaybackThread.bцц04460446ц0446(this.bЧ0427ЧЧЧ0427))
      {
        HapticPlaybackThread.b0446ц04460446ц0446(this.bЧ0427ЧЧЧ0427).remove(this);
        if (this.b >= this.c) {
          if (HapticPlaybackThread.bц044604460446ц0446(this.bЧ0427ЧЧЧ0427).areHapticsEnabled()) {
            HapticPlaybackThread.b0446044604460446ц0446(this.bЧ0427ЧЧЧ0427).update(this.a, this.a.length, this.e, this.d);
          }
        }
      }
    }
    synchronized (HapticPlaybackThread.bцццц04460446(this.bЧ0427ЧЧЧ0427))
    {
      HapticPlaybackThread.b0446ццц04460446(this.bЧ0427ЧЧЧ0427, HapticPlaybackThread.bцц0446цц0446(this.bЧ0427ЧЧЧ0427));
      HapticPlaybackThread.bц0446цц04460446(this.bЧ0427ЧЧЧ0427, HapticPlaybackThread.b04460446цц04460446(this.bЧ0427ЧЧЧ0427));
      HapticPlaybackThread.bцц0446ц04460446(this.bЧ0427ЧЧЧ0427, SystemClock.uptimeMillis());
      HapticPlaybackThread.bц0446ц04460446ц(this.bЧ0427ЧЧЧ0427).post(HapticPlaybackThread.b0446ц0446ц04460446(this.bЧ0427ЧЧЧ0427));
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/rrrrrr/ccrcrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
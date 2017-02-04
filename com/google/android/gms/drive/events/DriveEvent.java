package com.google.android.gms.drive.events;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract interface DriveEvent
  extends SafeParcelable
{
  public abstract int getType();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/DriveEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
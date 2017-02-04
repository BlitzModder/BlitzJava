package com.crashlytics.android.core.internal;

import com.crashlytics.android.core.internal.models.SessionEventData;

public abstract interface CrashEventDataProvider
{
  public abstract SessionEventData getCrashEventData();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/core/internal/CrashEventDataProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
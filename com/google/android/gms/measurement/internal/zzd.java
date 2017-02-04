package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzqq.zzd;
import com.google.android.gms.internal.zztd;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzd
  extends zzw
{
  private static final Map<String, String> zzaSu = new ArrayMap(5);
  private final zza zzaSv;
  private final zzaa zzaSw = new zzaa(zziT());
  
  static
  {
    zzaSu.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
    zzaSu.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
    zzaSu.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
    zzaSu.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
    zzaSu.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
  }
  
  zzd(zzt paramzzt)
  {
    super(paramzzt);
    paramzzt = zzjz();
    this.zzaSv = new zza(getContext(), paramzzt);
  }
  
  private boolean zzBc()
  {
    return getContext().getDatabasePath(zzjz()).exists();
  }
  
  static int zza(Cursor paramCursor, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return paramCursor.getType(paramInt);
    }
    CursorWindow localCursorWindow = ((SQLiteCursor)paramCursor).getWindow();
    int i = paramCursor.getPosition();
    if (localCursorWindow.isNull(i, paramInt)) {
      return 0;
    }
    if (localCursorWindow.isLong(i, paramInt)) {
      return 1;
    }
    if (localCursorWindow.isFloat(i, paramInt)) {
      return 2;
    }
    if (localCursorWindow.isString(i, paramInt)) {
      return 3;
    }
    if (localCursorWindow.isBlob(i, paramInt)) {
      return 4;
    }
    return -1;
  }
  
  private long zza(String paramString, String[] paramArrayOfString, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    Object localObject = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = localSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject = paramArrayOfString;
      long l;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject = paramArrayOfString;
        paramLong = paramArrayOfString.getLong(0);
        l = paramLong;
        if (paramArrayOfString != null)
        {
          paramArrayOfString.close();
          l = paramLong;
        }
      }
      do
      {
        return l;
        l = paramLong;
      } while (paramArrayOfString == null);
      paramArrayOfString.close();
      return paramLong;
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject = arrayOfString;
      zzzz().zzBl().zze("Database error", paramString, paramArrayOfString);
      localObject = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  private String zzjz()
  {
    if (!zzAX().zzka()) {
      return zzAX().zzkA();
    }
    if (zzAX().zzkb()) {
      return zzAX().zzkA();
    }
    zzzz().zzBn().zzez("Using secondary database");
    return zzAX().zzkB();
  }
  
  public void beginTransaction()
  {
    zzje();
    getWritableDatabase().beginTransaction();
  }
  
  public void endTransaction()
  {
    zzje();
    getWritableDatabase().endTransaction();
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    zziS();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzaSv.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzzz().zzBm().zzj("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  public void setTransactionSuccessful()
  {
    zzje();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  /* Error */
  public String zzAY()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 141	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc -23
    //   11: aconst_null
    //   12: invokevirtual 147	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore_1
    //   16: aload_1
    //   17: astore_2
    //   18: aload_1
    //   19: invokeinterface 150 1 0
    //   24: ifeq +29 -> 53
    //   27: aload_1
    //   28: astore_2
    //   29: aload_1
    //   30: iconst_0
    //   31: invokeinterface 237 2 0
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +11 -> 51
    //   43: aload_1
    //   44: invokeinterface 157 1 0
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: areturn
    //   53: aload 4
    //   55: astore_2
    //   56: aload_1
    //   57: ifnull -6 -> 51
    //   60: aload_1
    //   61: invokeinterface 157 1 0
    //   66: aconst_null
    //   67: areturn
    //   68: astore_3
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   77: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   80: ldc -17
    //   82: aload_3
    //   83: invokevirtual 227	com/google/android/gms/measurement/internal/zzo$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload 4
    //   88: astore_2
    //   89: aload_1
    //   90: ifnull -39 -> 51
    //   93: aload_1
    //   94: invokeinterface 157 1 0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +9 -> 114
    //   108: aload_2
    //   109: invokeinterface 157 1 0
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: goto -13 -> 104
    //   120: astore_3
    //   121: goto -50 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	zzd
    //   7	87	1	localObject1	Object
    //   101	14	1	localObject2	Object
    //   116	1	1	localObject3	Object
    //   17	92	2	localObject4	Object
    //   36	14	3	str	String
    //   68	15	3	localSQLiteException1	SQLiteException
    //   120	1	3	localSQLiteException2	SQLiteException
    //   1	86	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   8	16	68	android/database/sqlite/SQLiteException
    //   8	16	101	finally
    //   18	27	116	finally
    //   29	37	116	finally
    //   73	86	116	finally
    //   18	27	120	android/database/sqlite/SQLiteException
    //   29	37	120	android/database/sqlite/SQLiteException
  }
  
  void zzAZ()
  {
    zziS();
    zzje();
    if (!zzBc()) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = zzAW().zzaTI.get();
      l2 = zziT().elapsedRealtime();
    } while (Math.abs(l2 - l1) <= zzAX().zzAG());
    zzAW().zzaTI.set(l2);
    zzBa();
  }
  
  void zzBa()
  {
    zziS();
    zzje();
    if (!zzBc()) {}
    int i;
    do
    {
      return;
      i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(zziT().currentTimeMillis()), String.valueOf(zzAX().zzAF()) });
    } while (i <= 0);
    zzzz().zzBr().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
  }
  
  public long zzBb()
  {
    return zza("select max(bundle_end_timestamp) from queue", null, 0L);
  }
  
  /* Error */
  public zzh zzL(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 322	com/google/android/gms/common/internal/zzx:zzcG	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_2
    //   9: invokestatic 322	com/google/android/gms/common/internal/zzx:zzcG	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 217	com/google/android/gms/measurement/internal/zzd:zziS	()V
    //   17: aload_0
    //   18: invokevirtual 209	com/google/android/gms/measurement/internal/zzd:zzje	()V
    //   21: aload_0
    //   22: invokevirtual 141	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc_w 324
    //   28: iconst_3
    //   29: anewarray 285	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 326
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc_w 328
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc_w 330
    //   49: aastore
    //   50: ldc_w 332
    //   53: iconst_2
    //   54: anewarray 285	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 336	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 4
    //   73: aload 4
    //   75: invokeinterface 150 1 0
    //   80: istore_3
    //   81: iload_3
    //   82: ifne +19 -> 101
    //   85: aload 4
    //   87: ifnull +10 -> 97
    //   90: aload 4
    //   92: invokeinterface 157 1 0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: new 338	com/google/android/gms/measurement/internal/zzh
    //   104: dup
    //   105: aload_1
    //   106: aload_2
    //   107: aload 4
    //   109: iconst_0
    //   110: invokeinterface 154 2 0
    //   115: aload 4
    //   117: iconst_1
    //   118: invokeinterface 154 2 0
    //   123: aload 4
    //   125: iconst_2
    //   126: invokeinterface 154 2 0
    //   131: invokespecial 341	com/google/android/gms/measurement/internal/zzh:<init>	(Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   134: astore 5
    //   136: aload 4
    //   138: invokeinterface 344 1 0
    //   143: ifeq +16 -> 159
    //   146: aload_0
    //   147: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   150: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   153: ldc_w 346
    //   156: invokevirtual 202	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
    //   159: aload 5
    //   161: astore_1
    //   162: aload 4
    //   164: ifnull -65 -> 99
    //   167: aload 4
    //   169: invokeinterface 157 1 0
    //   174: aload 5
    //   176: areturn
    //   177: astore 5
    //   179: aconst_null
    //   180: astore 4
    //   182: aload_0
    //   183: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   186: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   189: ldc_w 348
    //   192: aload_1
    //   193: aload_2
    //   194: aload 5
    //   196: invokevirtual 352	com/google/android/gms/measurement/internal/zzo$zza:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   199: aload 4
    //   201: ifnull +10 -> 211
    //   204: aload 4
    //   206: invokeinterface 157 1 0
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: aload 5
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +9 -> 227
    //   221: aload_2
    //   222: invokeinterface 157 1 0
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: aload 4
    //   232: astore_2
    //   233: goto -16 -> 217
    //   236: astore_1
    //   237: aload 4
    //   239: astore_2
    //   240: goto -23 -> 217
    //   243: astore 5
    //   245: goto -63 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	zzd
    //   0	248	1	paramString1	String
    //   0	248	2	paramString2	String
    //   80	2	3	bool	boolean
    //   71	167	4	localCursor	Cursor
    //   1	174	5	localzzh	zzh
    //   177	38	5	localSQLiteException1	SQLiteException
    //   243	1	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   21	73	177	android/database/sqlite/SQLiteException
    //   21	73	213	finally
    //   73	81	229	finally
    //   101	159	229	finally
    //   182	199	236	finally
    //   73	81	243	android/database/sqlite/SQLiteException
    //   101	159	243	android/database/sqlite/SQLiteException
  }
  
  public void zzM(String paramString1, String paramString2)
  {
    zzx.zzcG(paramString1);
    zzx.zzcG(paramString2);
    zziS();
    zzje();
    try
    {
      int i = getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      zzzz().zzBr().zzj("Deleted user attribute rows:", Integer.valueOf(i));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzzz().zzBl().zzd("Error deleting user attribute", paramString1, paramString2, localSQLiteException);
    }
  }
  
  public void zzP(long paramLong)
  {
    zziS();
    zzje();
    if (getWritableDatabase().delete("queue", "rowid=?", new String[] { String.valueOf(paramLong) }) != 1) {
      zzzz().zzBl().zzez("Deleted fewer rows from queue than expected");
    }
  }
  
  void zza(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    zzx.zzcG(paramString);
    zzx.zzy(paramObject);
    if ((paramObject instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put(paramString, (Long)paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramContentValues.put(paramString, (Float)paramObject);
      return;
    }
    throw new IllegalArgumentException("Invalid value type");
  }
  
  public void zza(zzqq.zzd paramzzd)
  {
    zziS();
    zzje();
    zzx.zzy(paramzzd);
    zzx.zzcG(paramzzd.appId);
    zzx.zzy(paramzzd.zzaVw);
    zzAZ();
    long l = zziT().currentTimeMillis();
    if ((paramzzd.zzaVw.longValue() < l - zzAX().zzAF()) || (paramzzd.zzaVw.longValue() > zzAX().zzAF() + l)) {
      zzzz().zzBm().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(l), paramzzd.zzaVw);
    }
    try
    {
      byte[] arrayOfByte = new byte[paramzzd.getSerializedSize()];
      Object localObject = zztd.zzD(arrayOfByte);
      paramzzd.writeTo((zztd)localObject);
      ((zztd)localObject).zzHy();
      arrayOfByte = zzAU().zzg(arrayOfByte);
      zzzz().zzBr().zzj("Saving bundle, size", Integer.valueOf(arrayOfByte.length));
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramzzd.appId);
      ((ContentValues)localObject).put("bundle_end_timestamp", paramzzd.zzaVw);
      ((ContentValues)localObject).put("data", arrayOfByte);
      return;
    }
    catch (IOException paramzzd)
    {
      try
      {
        if (getWritableDatabase().insert("queue", null, (ContentValues)localObject) == -1L) {
          zzzz().zzBl().zzez("Failed to insert bundle (got -1)");
        }
        return;
      }
      catch (SQLiteException paramzzd)
      {
        zzzz().zzBl().zzj("Error storing bundle", paramzzd);
      }
      paramzzd = paramzzd;
      zzzz().zzBl().zzj("Data loss. Failed to serialize bundle", paramzzd);
      return;
    }
  }
  
  public void zza(zza paramzza)
  {
    zzx.zzy(paramzza);
    zziS();
    zzje();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzza.zzaRd);
    localContentValues.put("app_instance_id", paramzza.zzaSe);
    localContentValues.put("gmp_app_id", paramzza.zzaSf);
    localContentValues.put("resettable_device_id_hash", paramzza.zzaSg);
    localContentValues.put("last_bundle_index", Long.valueOf(paramzza.zzaSh));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramzza.zzaSi));
    localContentValues.put("app_version", paramzza.zzRl);
    localContentValues.put("app_store", paramzza.zzaSj);
    localContentValues.put("gmp_version", Long.valueOf(paramzza.zzaSk));
    localContentValues.put("dev_cert_hash", Long.valueOf(paramzza.zzaSl));
    localContentValues.put("measurement_enabled", Boolean.valueOf(paramzza.zzaSm));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("apps", null, localContentValues, 5) == -1L) {
        zzzz().zzBl().zzez("Failed to insert/update app (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzza)
    {
      zzzz().zzBl().zzj("Error storing app", paramzza);
    }
  }
  
  public void zza(zzac paramzzac)
  {
    zzx.zzy(paramzzac);
    zziS();
    zzje();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzac.zzaRd);
    localContentValues.put("name", paramzzac.mName);
    localContentValues.put("set_timestamp", Long.valueOf(paramzzac.zzaVf));
    zza(localContentValues, "value", paramzzac.zzLI);
    try
    {
      if (getWritableDatabase().insertWithOnConflict("user_attributes", null, localContentValues, 5) == -1L) {
        zzzz().zzBl().zzez("Failed to insert/update user attribute (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzzac)
    {
      zzzz().zzBl().zzj("Error storing user attribute", paramzzac);
    }
  }
  
  public void zza(zzh paramzzh)
  {
    zzx.zzy(paramzzh);
    zziS();
    zzje();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramzzh.zzaRd);
    localContentValues.put("name", paramzzh.mName);
    localContentValues.put("lifetime_count", Long.valueOf(paramzzh.zzaSF));
    localContentValues.put("current_bundle_count", Long.valueOf(paramzzh.zzaSG));
    localContentValues.put("last_fire_timestamp", Long.valueOf(paramzzh.zzaSH));
    try
    {
      if (getWritableDatabase().insertWithOnConflict("events", null, localContentValues, 5) == -1L) {
        zzzz().zzBl().zzez("Failed to insert/update event aggregates (got -1)");
      }
      return;
    }
    catch (SQLiteException paramzzh)
    {
      zzzz().zzBl().zzj("Error storing event aggregates", paramzzh);
    }
  }
  
  Object zzb(Cursor paramCursor, int paramInt)
  {
    int i = zza(paramCursor, paramInt);
    switch (i)
    {
    default: 
      zzzz().zzBl().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
      return null;
    case 0: 
      zzzz().zzBl().zzez("Loaded invalid null value from database");
      return null;
    case 1: 
      return Long.valueOf(paramCursor.getLong(paramInt));
    case 2: 
      return Float.valueOf(paramCursor.getFloat(paramInt));
    case 3: 
      return paramCursor.getString(paramInt);
    }
    zzzz().zzBl().zzez("Loaded invalid blob type value, ignoring it");
    return null;
  }
  
  /* Error */
  public java.util.List<zzac> zzev(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 322	com/google/android/gms/common/internal/zzx:zzcG	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 217	com/google/android/gms/measurement/internal/zzd:zziS	()V
    //   9: aload_0
    //   10: invokevirtual 209	com/google/android/gms/measurement/internal/zzd:zzje	()V
    //   13: new 592	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 593	java/util/ArrayList:<init>	()V
    //   20: astore 7
    //   22: aload_0
    //   23: invokevirtual 141	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 6
    //   28: aload_0
    //   29: invokevirtual 182	com/google/android/gms/measurement/internal/zzd:zzAX	()Lcom/google/android/gms/measurement/internal/zzc;
    //   32: invokevirtual 596	com/google/android/gms/measurement/internal/zzc:zzAz	()I
    //   35: istore_2
    //   36: aload 6
    //   38: ldc_w 356
    //   41: iconst_3
    //   42: anewarray 285	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc_w 536
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc_w 541
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: ldc_w 546
    //   62: aastore
    //   63: ldc_w 598
    //   66: iconst_1
    //   67: anewarray 285	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: aconst_null
    //   75: aconst_null
    //   76: ldc_w 600
    //   79: iload_2
    //   80: iconst_1
    //   81: iadd
    //   82: invokestatic 602	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 605	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 6
    //   90: aload 6
    //   92: invokeinterface 150 1 0
    //   97: istore_3
    //   98: iload_3
    //   99: ifne +18 -> 117
    //   102: aload 6
    //   104: ifnull +10 -> 114
    //   107: aload 6
    //   109: invokeinterface 157 1 0
    //   114: aload 7
    //   116: areturn
    //   117: aload 6
    //   119: iconst_0
    //   120: invokeinterface 237 2 0
    //   125: astore 8
    //   127: aload 6
    //   129: iconst_1
    //   130: invokeinterface 154 2 0
    //   135: lstore 4
    //   137: aload_0
    //   138: aload 6
    //   140: iconst_2
    //   141: invokevirtual 607	com/google/android/gms/measurement/internal/zzd:zzb	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   144: astore 9
    //   146: aload 9
    //   148: ifnonnull +86 -> 234
    //   151: aload_0
    //   152: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   155: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   158: ldc_w 609
    //   161: invokevirtual 202	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
    //   164: aload 6
    //   166: invokeinterface 344 1 0
    //   171: ifne -54 -> 117
    //   174: aload 7
    //   176: invokeinterface 614 1 0
    //   181: aload_0
    //   182: invokevirtual 182	com/google/android/gms/measurement/internal/zzd:zzAX	()Lcom/google/android/gms/measurement/internal/zzc;
    //   185: invokevirtual 596	com/google/android/gms/measurement/internal/zzc:zzAz	()I
    //   188: if_icmple +31 -> 219
    //   191: aload_0
    //   192: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   195: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   198: ldc_w 616
    //   201: invokevirtual 202	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
    //   204: aload 7
    //   206: aload_0
    //   207: invokevirtual 182	com/google/android/gms/measurement/internal/zzd:zzAX	()Lcom/google/android/gms/measurement/internal/zzc;
    //   210: invokevirtual 596	com/google/android/gms/measurement/internal/zzc:zzAz	()I
    //   213: invokeinterface 620 2 0
    //   218: pop
    //   219: aload 6
    //   221: ifnull +10 -> 231
    //   224: aload 6
    //   226: invokeinterface 157 1 0
    //   231: aload 7
    //   233: areturn
    //   234: aload 7
    //   236: new 533	com/google/android/gms/measurement/internal/zzac
    //   239: dup
    //   240: aload_1
    //   241: aload 8
    //   243: lload 4
    //   245: aload 9
    //   247: invokespecial 623	com/google/android/gms/measurement/internal/zzac:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   250: invokeinterface 627 2 0
    //   255: pop
    //   256: goto -92 -> 164
    //   259: astore 7
    //   261: aload_0
    //   262: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   265: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   268: ldc_w 629
    //   271: aload_1
    //   272: aload 7
    //   274: invokevirtual 175	com/google/android/gms/measurement/internal/zzo$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   277: aload 6
    //   279: ifnull +10 -> 289
    //   282: aload 6
    //   284: invokeinterface 157 1 0
    //   289: aconst_null
    //   290: areturn
    //   291: astore_1
    //   292: aconst_null
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +10 -> 307
    //   300: aload 6
    //   302: invokeinterface 157 1 0
    //   307: aload_1
    //   308: athrow
    //   309: astore_1
    //   310: goto -15 -> 295
    //   313: astore_1
    //   314: goto -19 -> 295
    //   317: astore 7
    //   319: aconst_null
    //   320: astore 6
    //   322: goto -61 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	zzd
    //   0	325	1	paramString	String
    //   35	47	2	i	int
    //   97	2	3	bool	boolean
    //   135	109	4	l	long
    //   26	295	6	localObject1	Object
    //   20	215	7	localArrayList	java.util.ArrayList
    //   259	14	7	localSQLiteException1	SQLiteException
    //   317	1	7	localSQLiteException2	SQLiteException
    //   125	117	8	str	String
    //   144	102	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   90	98	259	android/database/sqlite/SQLiteException
    //   117	146	259	android/database/sqlite/SQLiteException
    //   151	164	259	android/database/sqlite/SQLiteException
    //   164	219	259	android/database/sqlite/SQLiteException
    //   234	256	259	android/database/sqlite/SQLiteException
    //   22	90	291	finally
    //   90	98	309	finally
    //   117	146	309	finally
    //   151	164	309	finally
    //   164	219	309	finally
    //   234	256	309	finally
    //   261	277	313	finally
    //   22	90	317	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public zza zzew(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 322	com/google/android/gms/common/internal/zzx:zzcG	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 217	com/google/android/gms/measurement/internal/zzd:zziS	()V
    //   9: aload_0
    //   10: invokevirtual 209	com/google/android/gms/measurement/internal/zzd:zzje	()V
    //   13: aconst_null
    //   14: astore 13
    //   16: aload_0
    //   17: invokevirtual 141	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: ldc_w 522
    //   23: bipush 10
    //   25: anewarray 285	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 472
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc_w 477
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc_w 482
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc_w 487
    //   51: aastore
    //   52: dup
    //   53: iconst_4
    //   54: ldc_w 493
    //   57: aastore
    //   58: dup
    //   59: iconst_5
    //   60: ldc 26
    //   62: aastore
    //   63: dup
    //   64: bipush 6
    //   66: ldc 36
    //   68: aastore
    //   69: dup
    //   70: bipush 7
    //   72: ldc 40
    //   74: aastore
    //   75: dup
    //   76: bipush 8
    //   78: ldc 44
    //   80: aastore
    //   81: dup
    //   82: bipush 9
    //   84: ldc 48
    //   86: aastore
    //   87: ldc_w 598
    //   90: iconst_1
    //   91: anewarray 285	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: aload_1
    //   97: aastore
    //   98: aconst_null
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 336	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore 12
    //   106: aload 12
    //   108: invokeinterface 150 1 0
    //   113: istore_3
    //   114: iload_3
    //   115: ifne +26 -> 141
    //   118: aconst_null
    //   119: astore 13
    //   121: aload 13
    //   123: astore_1
    //   124: aload 12
    //   126: ifnull +13 -> 139
    //   129: aload 12
    //   131: invokeinterface 157 1 0
    //   136: aload 13
    //   138: astore_1
    //   139: aload_1
    //   140: areturn
    //   141: aload 12
    //   143: iconst_0
    //   144: invokeinterface 237 2 0
    //   149: astore 13
    //   151: aload 12
    //   153: iconst_1
    //   154: invokeinterface 237 2 0
    //   159: astore 14
    //   161: aload 12
    //   163: iconst_2
    //   164: invokeinterface 237 2 0
    //   169: astore 15
    //   171: aload 12
    //   173: iconst_3
    //   174: invokeinterface 154 2 0
    //   179: lstore 4
    //   181: aload 12
    //   183: iconst_4
    //   184: invokeinterface 154 2 0
    //   189: lstore 6
    //   191: aload 12
    //   193: iconst_5
    //   194: invokeinterface 237 2 0
    //   199: astore 16
    //   201: aload 12
    //   203: bipush 6
    //   205: invokeinterface 237 2 0
    //   210: astore 17
    //   212: aload 12
    //   214: bipush 7
    //   216: invokeinterface 154 2 0
    //   221: lstore 8
    //   223: aload 12
    //   225: bipush 8
    //   227: invokeinterface 154 2 0
    //   232: lstore 10
    //   234: aload 12
    //   236: bipush 9
    //   238: invokeinterface 636 2 0
    //   243: ifeq +81 -> 324
    //   246: iconst_1
    //   247: istore_2
    //   248: iload_2
    //   249: ifeq +88 -> 337
    //   252: iconst_1
    //   253: istore_3
    //   254: new 467	com/google/android/gms/measurement/internal/zza
    //   257: dup
    //   258: aload_1
    //   259: aload 13
    //   261: aload 14
    //   263: aload 15
    //   265: lload 4
    //   267: lload 6
    //   269: aload 16
    //   271: aload 17
    //   273: lload 8
    //   275: lload 10
    //   277: iload_3
    //   278: invokespecial 639	com/google/android/gms/measurement/internal/zza:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JJZ)V
    //   281: astore 13
    //   283: aload 12
    //   285: invokeinterface 344 1 0
    //   290: ifeq +16 -> 306
    //   293: aload_0
    //   294: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   297: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   300: ldc_w 641
    //   303: invokevirtual 202	com/google/android/gms/measurement/internal/zzo$zza:zzez	(Ljava/lang/String;)V
    //   306: aload 13
    //   308: astore_1
    //   309: aload 12
    //   311: ifnull -172 -> 139
    //   314: aload 12
    //   316: invokeinterface 157 1 0
    //   321: aload 13
    //   323: areturn
    //   324: aload 12
    //   326: bipush 9
    //   328: invokeinterface 644 2 0
    //   333: istore_2
    //   334: goto -86 -> 248
    //   337: iconst_0
    //   338: istore_3
    //   339: goto -85 -> 254
    //   342: astore 13
    //   344: aconst_null
    //   345: astore 12
    //   347: aload_0
    //   348: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   351: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   354: ldc_w 646
    //   357: aload_1
    //   358: aload 13
    //   360: invokevirtual 175	com/google/android/gms/measurement/internal/zzo$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   363: aconst_null
    //   364: astore_1
    //   365: aload 12
    //   367: ifnull -228 -> 139
    //   370: aload 12
    //   372: invokeinterface 157 1 0
    //   377: aconst_null
    //   378: areturn
    //   379: astore_1
    //   380: aload 13
    //   382: astore 12
    //   384: aload 12
    //   386: ifnull +10 -> 396
    //   389: aload 12
    //   391: invokeinterface 157 1 0
    //   396: aload_1
    //   397: athrow
    //   398: astore_1
    //   399: goto -15 -> 384
    //   402: astore_1
    //   403: goto -19 -> 384
    //   406: astore 13
    //   408: goto -61 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	zzd
    //   0	411	1	paramString	String
    //   247	87	2	i	int
    //   113	226	3	bool	boolean
    //   179	87	4	l1	long
    //   189	79	6	l2	long
    //   221	53	8	l3	long
    //   232	44	10	l4	long
    //   104	286	12	localObject1	Object
    //   14	308	13	localObject2	Object
    //   342	39	13	localSQLiteException1	SQLiteException
    //   406	1	13	localSQLiteException2	SQLiteException
    //   159	103	14	str1	String
    //   169	95	15	str2	String
    //   199	71	16	str3	String
    //   210	62	17	str4	String
    // Exception table:
    //   from	to	target	type
    //   16	106	342	android/database/sqlite/SQLiteException
    //   16	106	379	finally
    //   106	114	398	finally
    //   141	246	398	finally
    //   254	306	398	finally
    //   324	334	398	finally
    //   347	363	402	finally
    //   106	114	406	android/database/sqlite/SQLiteException
    //   141	246	406	android/database/sqlite/SQLiteException
    //   254	306	406	android/database/sqlite/SQLiteException
    //   324	334	406	android/database/sqlite/SQLiteException
  }
  
  protected void zzir() {}
  
  /* Error */
  public java.util.List<android.util.Pair<zzqq.zzd, Long>> zzn(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: invokevirtual 217	com/google/android/gms/measurement/internal/zzd:zziS	()V
    //   7: aload_0
    //   8: invokevirtual 209	com/google/android/gms/measurement/internal/zzd:zzje	()V
    //   11: iload_2
    //   12: ifle +112 -> 124
    //   15: iconst_1
    //   16: istore 5
    //   18: iload 5
    //   20: invokestatic 653	com/google/android/gms/common/internal/zzx:zzab	(Z)V
    //   23: iload_3
    //   24: ifle +106 -> 130
    //   27: iload 6
    //   29: istore 5
    //   31: iload 5
    //   33: invokestatic 653	com/google/android/gms/common/internal/zzx:zzab	(Z)V
    //   36: aload_1
    //   37: invokestatic 322	com/google/android/gms/common/internal/zzx:zzcG	(Ljava/lang/String;)Ljava/lang/String;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 141	com/google/android/gms/measurement/internal/zzd:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc_w 281
    //   48: iconst_2
    //   49: anewarray 285	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 600
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc_w 449
    //   63: aastore
    //   64: ldc_w 598
    //   67: iconst_1
    //   68: anewarray 285	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: ldc_w 600
    //   80: iload_2
    //   81: invokestatic 602	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 605	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore 9
    //   89: aload 9
    //   91: invokeinterface 150 1 0
    //   96: ifne +40 -> 136
    //   99: invokestatic 659	java/util/Collections:emptyList	()Ljava/util/List;
    //   102: astore 10
    //   104: aload 10
    //   106: astore_1
    //   107: aload 9
    //   109: ifnull +13 -> 122
    //   112: aload 9
    //   114: invokeinterface 157 1 0
    //   119: aload 10
    //   121: astore_1
    //   122: aload_1
    //   123: areturn
    //   124: iconst_0
    //   125: istore 5
    //   127: goto -109 -> 18
    //   130: iconst_0
    //   131: istore 5
    //   133: goto -102 -> 31
    //   136: new 592	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 593	java/util/ArrayList:<init>	()V
    //   143: astore 10
    //   145: iconst_0
    //   146: istore_2
    //   147: aload 9
    //   149: iconst_0
    //   150: invokeinterface 154 2 0
    //   155: lstore 7
    //   157: aload 9
    //   159: iconst_1
    //   160: invokeinterface 663 2 0
    //   165: astore 11
    //   167: aload_0
    //   168: invokevirtual 433	com/google/android/gms/measurement/internal/zzd:zzAU	()Lcom/google/android/gms/measurement/internal/zzae;
    //   171: aload 11
    //   173: invokevirtual 666	com/google/android/gms/measurement/internal/zzae:zzq	([B)[B
    //   176: astore 11
    //   178: aload 10
    //   180: invokeinterface 669 1 0
    //   185: ifne +70 -> 255
    //   188: aload 11
    //   190: arraylength
    //   191: istore 4
    //   193: iload 4
    //   195: iload_2
    //   196: iadd
    //   197: iload_3
    //   198: if_icmple +57 -> 255
    //   201: aload 10
    //   203: astore_1
    //   204: aload 9
    //   206: ifnull -84 -> 122
    //   209: aload 9
    //   211: invokeinterface 157 1 0
    //   216: aload 10
    //   218: areturn
    //   219: astore 11
    //   221: aload_0
    //   222: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   225: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   228: ldc_w 671
    //   231: aload_1
    //   232: aload 11
    //   234: invokevirtual 175	com/google/android/gms/measurement/internal/zzo$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   237: aload 9
    //   239: invokeinterface 344 1 0
    //   244: ifeq -43 -> 201
    //   247: iload_2
    //   248: iload_3
    //   249: if_icmpgt -48 -> 201
    //   252: goto -105 -> 147
    //   255: aload 11
    //   257: invokestatic 677	com/google/android/gms/internal/zztc:zzC	([B)Lcom/google/android/gms/internal/zztc;
    //   260: astore 12
    //   262: new 395	com/google/android/gms/internal/zzqq$zzd
    //   265: dup
    //   266: invokespecial 678	com/google/android/gms/internal/zzqq$zzd:<init>	()V
    //   269: astore 13
    //   271: aload 13
    //   273: aload 12
    //   275: invokevirtual 682	com/google/android/gms/internal/zzqq$zzd:zzw	(Lcom/google/android/gms/internal/zztc;)Lcom/google/android/gms/internal/zzqq$zzd;
    //   278: pop
    //   279: aload 11
    //   281: arraylength
    //   282: iload_2
    //   283: iadd
    //   284: istore_2
    //   285: aload 10
    //   287: aload 13
    //   289: lload 7
    //   291: invokestatic 413	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   294: invokestatic 688	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   297: invokeinterface 627 2 0
    //   302: pop
    //   303: goto -66 -> 237
    //   306: astore 10
    //   308: aload_0
    //   309: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   312: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   315: ldc_w 690
    //   318: aload_1
    //   319: aload 10
    //   321: invokevirtual 175	com/google/android/gms/measurement/internal/zzo$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   324: invokestatic 659	java/util/Collections:emptyList	()Ljava/util/List;
    //   327: astore 10
    //   329: aload 10
    //   331: astore_1
    //   332: aload 9
    //   334: ifnull -212 -> 122
    //   337: aload 9
    //   339: invokeinterface 157 1 0
    //   344: aload 10
    //   346: areturn
    //   347: astore 11
    //   349: aload_0
    //   350: invokevirtual 161	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
    //   353: invokevirtual 167	com/google/android/gms/measurement/internal/zzo:zzBl	()Lcom/google/android/gms/measurement/internal/zzo$zza;
    //   356: ldc_w 692
    //   359: aload_1
    //   360: aload 11
    //   362: invokevirtual 175	com/google/android/gms/measurement/internal/zzo$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   365: goto -128 -> 237
    //   368: astore_1
    //   369: aconst_null
    //   370: astore 9
    //   372: aload 9
    //   374: ifnull +10 -> 384
    //   377: aload 9
    //   379: invokeinterface 157 1 0
    //   384: aload_1
    //   385: athrow
    //   386: astore_1
    //   387: goto -15 -> 372
    //   390: astore_1
    //   391: goto -19 -> 372
    //   394: astore 10
    //   396: aconst_null
    //   397: astore 9
    //   399: goto -91 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	zzd
    //   0	402	1	paramString	String
    //   0	402	2	paramInt1	int
    //   0	402	3	paramInt2	int
    //   191	6	4	i	int
    //   16	116	5	bool1	boolean
    //   1	27	6	bool2	boolean
    //   155	135	7	l	long
    //   87	311	9	localCursor	Cursor
    //   102	184	10	localObject	Object
    //   306	14	10	localSQLiteException1	SQLiteException
    //   327	18	10	localList	java.util.List
    //   394	1	10	localSQLiteException2	SQLiteException
    //   165	24	11	arrayOfByte	byte[]
    //   219	61	11	localIOException1	IOException
    //   347	14	11	localIOException2	IOException
    //   260	14	12	localzztc	com.google.android.gms.internal.zztc
    //   269	19	13	localzzd	zzqq.zzd
    // Exception table:
    //   from	to	target	type
    //   157	178	219	java/io/IOException
    //   89	104	306	android/database/sqlite/SQLiteException
    //   136	145	306	android/database/sqlite/SQLiteException
    //   147	157	306	android/database/sqlite/SQLiteException
    //   157	178	306	android/database/sqlite/SQLiteException
    //   178	193	306	android/database/sqlite/SQLiteException
    //   221	237	306	android/database/sqlite/SQLiteException
    //   237	247	306	android/database/sqlite/SQLiteException
    //   255	271	306	android/database/sqlite/SQLiteException
    //   271	279	306	android/database/sqlite/SQLiteException
    //   279	303	306	android/database/sqlite/SQLiteException
    //   349	365	306	android/database/sqlite/SQLiteException
    //   271	279	347	java/io/IOException
    //   41	89	368	finally
    //   89	104	386	finally
    //   136	145	386	finally
    //   147	157	386	finally
    //   157	178	386	finally
    //   178	193	386	finally
    //   221	237	386	finally
    //   237	247	386	finally
    //   255	271	386	finally
    //   271	279	386	finally
    //   279	303	386	finally
    //   349	365	386	finally
    //   308	329	390	finally
    //   41	89	394	android/database/sqlite/SQLiteException
  }
  
  private class zza
    extends SQLiteOpenHelper
  {
    zza(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
      throws SQLiteException
    {
      if (!zza(paramSQLiteDatabase, paramString1)) {
        paramSQLiteDatabase.execSQL(paramString2);
      }
      try
      {
        zza(paramSQLiteDatabase, paramString1, paramString3, paramMap);
        return;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        zzd.this.zzzz().zzBl().zzj("Failed to verify columns on table that was just created", paramString1);
        throw paramSQLiteDatabase;
      }
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, Map<String, String> paramMap)
      throws SQLiteException
    {
      Set localSet = zzb(paramSQLiteDatabase, paramString1);
      paramString2 = paramString2.split(",");
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString2[i];
        if (!localSet.remove(localObject)) {
          throw new SQLiteException("Database " + paramString1 + " is missing required column: " + (String)localObject);
        }
        i += 1;
      }
      if (paramMap != null)
      {
        paramString2 = paramMap.entrySet().iterator();
        while (paramString2.hasNext())
        {
          paramMap = (Map.Entry)paramString2.next();
          if (!localSet.remove(paramMap.getKey())) {
            paramSQLiteDatabase.execSQL((String)paramMap.getValue());
          }
        }
      }
      if (!localSet.isEmpty()) {
        throw new SQLiteException("Database " + paramString1 + " table has extra columns");
      }
    }
    
    /* Error */
    private boolean zza(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_1
      //   4: ldc 126
      //   6: iconst_1
      //   7: anewarray 61	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc -128
      //   14: aastore
      //   15: ldc -126
      //   17: iconst_1
      //   18: anewarray 61	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_2
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 134	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_1
      //   32: aload_1
      //   33: astore 4
      //   35: aload 4
      //   37: astore_1
      //   38: aload 4
      //   40: invokeinterface 139 1 0
      //   45: istore_3
      //   46: aload 4
      //   48: ifnull +10 -> 58
      //   51: aload 4
      //   53: invokeinterface 142 1 0
      //   58: iload_3
      //   59: ireturn
      //   60: astore 5
      //   62: aconst_null
      //   63: astore 4
      //   65: aload 4
      //   67: astore_1
      //   68: aload_0
      //   69: getfield 13	com/google/android/gms/measurement/internal/zzd$zza:zzaSx	Lcom/google/android/gms/measurement/internal/zzd;
      //   72: invokevirtual 36	com/google/android/gms/measurement/internal/zzd:zzzz	()Lcom/google/android/gms/measurement/internal/zzo;
      //   75: invokevirtual 145	com/google/android/gms/measurement/internal/zzo:zzBm	()Lcom/google/android/gms/measurement/internal/zzo$zza;
      //   78: ldc -109
      //   80: aload_2
      //   81: aload 5
      //   83: invokevirtual 151	com/google/android/gms/measurement/internal/zzo$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   86: aload 4
      //   88: ifnull +10 -> 98
      //   91: aload 4
      //   93: invokeinterface 142 1 0
      //   98: iconst_0
      //   99: ireturn
      //   100: astore_1
      //   101: aload 4
      //   103: astore_2
      //   104: aload_2
      //   105: ifnull +9 -> 114
      //   108: aload_2
      //   109: invokeinterface 142 1 0
      //   114: aload_1
      //   115: athrow
      //   116: astore 4
      //   118: aload_1
      //   119: astore_2
      //   120: aload 4
      //   122: astore_1
      //   123: goto -19 -> 104
      //   126: astore 5
      //   128: goto -63 -> 65
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	131	0	this	zza
      //   0	131	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	131	2	paramString	String
      //   45	14	3	bool	boolean
      //   1	101	4	localSQLiteDatabase	SQLiteDatabase
      //   116	5	4	localObject	Object
      //   60	22	5	localSQLiteException1	SQLiteException
      //   126	1	5	localSQLiteException2	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	60	android/database/sqlite/SQLiteException
      //   3	32	100	finally
      //   38	46	116	finally
      //   68	86	116	finally
      //   38	46	126	android/database/sqlite/SQLiteException
    }
    
    private Set<String> zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      HashSet localHashSet = new HashSet();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM " + paramString + " LIMIT 0", null);
      try
      {
        Collections.addAll(localHashSet, paramSQLiteDatabase.getColumnNames());
        return localHashSet;
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if (!zzd.zza(zzd.this).zzv(zzd.this.zzAX().zzAA())) {
        throw new SQLiteException("Database open failed");
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zzd.zza(zzd.this).start();
        zzd.this.zzzz().zzBl().zzez("Opening the database failed, dropping and recreating it");
        Object localObject = zzd.zzb(zzd.this);
        zzd.this.getContext().getDatabasePath((String)localObject).delete();
        try
        {
          localObject = super.getWritableDatabase();
          zzd.zza(zzd.this).clear();
          return (SQLiteDatabase)localObject;
        }
        catch (SQLiteException localSQLiteException2)
        {
          zzd.this.zzzz().zzBl().zzj("Failed to open freshly created database", localSQLiteException2);
          throw localSQLiteException2;
        }
      }
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
        paramSQLiteDatabase.setReadable(false, false);
        paramSQLiteDatabase.setWritable(false, false);
        paramSQLiteDatabase.setReadable(true, true);
        paramSQLiteDatabase.setWritable(true, true);
      }
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        zza(paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
        zza(paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
        zza(paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzd.zzBd());
        zza(paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        return;
      }
      finally
      {
        localCursor.close();
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
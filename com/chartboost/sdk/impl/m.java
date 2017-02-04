package com.chartboost.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class m
{
  private AtomicInteger a = new AtomicInteger();
  private final Map<String, Queue<l<?>>> b = new HashMap();
  private final Set<l<?>> c = new HashSet();
  private final PriorityBlockingQueue<l<?>> d = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<l<?>> e = new PriorityBlockingQueue();
  private final b f;
  private final f g;
  private final o h;
  private g[] i;
  private c j;
  private List<b> k = new ArrayList();
  
  public m(b paramb, f paramf)
  {
    this(paramb, paramf, 4);
  }
  
  public m(b paramb, f paramf, int paramInt)
  {
    this(paramb, paramf, paramInt, new e(new Handler(Looper.getMainLooper())));
  }
  
  public m(b paramb, f paramf, int paramInt, o paramo)
  {
    this.f = paramb;
    this.g = paramf;
    this.i = new g[paramInt];
    this.h = paramo;
  }
  
  public <T> l<T> a(l<T> paraml)
  {
    paraml.a(this);
    synchronized (this.c)
    {
      this.c.add(paraml);
      paraml.a(c());
      paraml.a("add-to-queue");
      if (!paraml.r())
      {
        this.e.add(paraml);
        return paraml;
      }
    }
    for (;;)
    {
      String str;
      synchronized (this.b)
      {
        str = paraml.e();
        if (this.b.containsKey(str))
        {
          Queue localQueue = (Queue)this.b.get(str);
          ??? = localQueue;
          if (localQueue == null) {
            ??? = new LinkedList();
          }
          ((Queue)???).add(paraml);
          this.b.put(str, ???);
          if (t.b) {
            t.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paraml;
        }
      }
      this.b.put(str, null);
      this.d.add(paraml);
    }
  }
  
  public void a()
  {
    b();
    this.j = new c(this.d, this.e, this.f, this.h);
    this.j.start();
    int m = 0;
    while (m < this.i.length)
    {
      g localg = new g(this.e, this.g, this.f, this.h);
      this.i[m] = localg;
      localg.start();
      m += 1;
    }
  }
  
  public void a(a parama)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        if (parama.a(locall)) {
          locall.g();
        }
      }
    }
  }
  
  public void a(final Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }
    a(new a()
    {
      public boolean a(l<?> paramAnonymousl)
      {
        return paramAnonymousl.b() == paramObject;
      }
    });
  }
  
  public void b()
  {
    if (this.j != null) {
      this.j.a();
    }
    int m = 0;
    while (m < this.i.length)
    {
      if (this.i[m] != null) {
        this.i[m].a();
      }
      m += 1;
    }
  }
  
  <T> void b(l<T> paraml)
  {
    Object localObject2;
    synchronized (this.c)
    {
      this.c.remove(paraml);
      synchronized (this.k)
      {
        localObject2 = this.k.iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((b)((Iterator)localObject2).next()).a(paraml);
        }
      }
    }
    if (paraml.r()) {
      synchronized (this.b)
      {
        paraml = paraml.e();
        localObject2 = (Queue)this.b.remove(paraml);
        if (localObject2 != null)
        {
          if (t.b) {
            t.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((Queue)localObject2).size()), paraml });
          }
          this.d.addAll((Collection)localObject2);
        }
        return;
      }
    }
  }
  
  public int c()
  {
    return this.a.incrementAndGet();
  }
  
  public b d()
  {
    return this.f;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(l<?> paraml);
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(l<T> paraml);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
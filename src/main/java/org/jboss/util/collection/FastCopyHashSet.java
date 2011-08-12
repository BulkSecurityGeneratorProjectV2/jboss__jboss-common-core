/*
* JBoss, Home of Professional Open Source
* Copyright 2006, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.jboss.util.collection;

import java.io.Serializable;
import java.util.Collection;

/**
 * Concurrent Set based on top of FastCopyHashMap.
 * It's serializable if the elements are serializable.
 *
 * @param <E> the element type
 * @author <a href="ales.justin@jboss.org">Ales Justin</a>
 */
public class FastCopyHashSet<E> extends MapDelegateSet<E> implements Serializable
{
   /** The serialVersionUID */
   private static final long serialVersionUID = 1L;

   /**
    * Constructs a new, empty set; the backing <tt>FastCopyHashMap</tt> instance has
    * default initial capacity (16) and load factor (0.75).
    */
   public FastCopyHashSet()
   {
      super(new FastCopyHashMap<E, Object>());
   }

   /**
    * Constructs a new set containing the elements in the specified
    * collection.  The <tt>FastCopyHashMap</tt> is created with default load factor
    * (0.75) and an initial capacity sufficient to contain the elements in
    * the specified collection.
    *
    * @param c the collection whose elements are to be placed into this set.
    * @throws NullPointerException if the specified collection is null.
    */
   public FastCopyHashSet(Collection<? extends E> c)
   {
      super(new FastCopyHashMap<E, Object>(Math.max((int)(c.size() / .75f) + 1, 16)));
      addAll(c);
   }

   /**
    * Constructs a new, empty set; the backing <tt>FastCopyHashMap</tt> instance has
    * the specified initial capacity and the specified load factor.
    *
    * @param initialCapacity  the initial capacity. The implementation
    *                         performs internal sizing to accommodate this many elements.
    * @param loadFactor       the load factor threshold, used to control resizing.
    *                         Resizing may be performed when the average number of elements per
    *                         bin exceeds this threshold.
    * @throws IllegalArgumentException if the initial capacity is less
    *                                  than zero, or if the load factor is nonpositive.
    */
   public FastCopyHashSet(int initialCapacity, float loadFactor)
   {
      super(new FastCopyHashMap<E, Object>(initialCapacity, loadFactor));
   }

   /**
    * Constructs a new, empty set; the backing <tt>FastCopyHashMap</tt> instance has
    * the specified initial capacity and default load factor, which is
    * <tt>0.75</tt>.
    *
    * @param initialCapacity the initial capacity of the hash table.
    * @throws IllegalArgumentException if the initial capacity is less
    *                                  than zero.
    */
   public FastCopyHashSet(int initialCapacity)
   {
      super(new FastCopyHashMap<E, Object>(initialCapacity));
   }
}
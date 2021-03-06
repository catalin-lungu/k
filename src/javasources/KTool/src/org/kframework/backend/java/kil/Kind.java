package org.kframework.backend.java.kil;

import com.google.common.collect.EnumHashBiMap;


/**
 * Enumeration of the kinds of K. Seven different kinds are currently available
 * in the Java backend: <li>{@code Kind#BOTTOM} <li>{@code Kind#CELL} <li>
 * {@code Kind#CELL_COLLECTION} <li>{@code Kind#K} <li>{@code Kind#KITEM} <li>
 * {@code Kind#KLABEL} <li>{@code Kind#KLIST}
 * <p>
 * <br>
 * Essentially, kinds can be seen as a more coarse-grained categorization of the
 * {@link Term}s than sorts. To be more specific, 1) each sort has a most
 * precise corresponding kind, and 2) two sorts with disjoint kinds are disjoint
 * as well.
 * 
 * @author AndreiS
 */
public enum Kind {
    BOTTOM,
    CELL,
    CELL_COLLECTION,
    K,
    KITEM,
    KLABEL,
    KLIST;
    //MAP;

    /**
     * Stores names of all the available {@code Kind}s.
     */
    private static final EnumHashBiMap<Kind, String> names = EnumHashBiMap.create(Kind.class);
    
    static {
        names.put(BOTTOM, "Bottom");
        names.put(CELL, "Cell");
        names.put(CELL_COLLECTION, "Bag");
        names.put(K, "K");
        names.put(KITEM, "KItem");
        names.put(KLABEL, "KLabel");
        names.put(KLIST, "KList");
        //names.put(MAP, "Map");
    }

    /**
     * @param sort
     *            the sort
     * @return the kind of the given sort
     */
    public static Kind of(String sort) {
        Kind kind = names.inverse().get(sort);
        if (kind != null) {
            return kind;
        } else {
            return KITEM;
        }
    }

    @Override
    public String toString() {
        return names.get(this);
    }

}

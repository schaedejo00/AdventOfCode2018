package com.gmo.sae.aoc;

import com.gmo.sae.aoc.IdItem;

import java.util.Comparator;

public class IdComparator implements Comparator<IdItem> {
    @Override
    public int compare(IdItem o1, IdItem o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

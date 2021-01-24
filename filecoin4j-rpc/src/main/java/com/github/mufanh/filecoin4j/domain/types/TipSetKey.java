package com.github.mufanh.filecoin4j.domain.types;

import com.github.mufanh.filecoin4j.domain.cid.Cid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xinquan.huangxq
 */
public class TipSetKey extends ArrayList<Cid> implements Serializable {

    public static TipSetKey of(Cid... cids) {
        TipSetKey result = new TipSetKey();
        result.addAll(Arrays.asList(cids));
        return result;
    }

    public static TipSetKey of(String... cids) {
        TipSetKey result = new TipSetKey();
        for (String cid : cids) {
            result.add(Cid.of(cid));
        }
        return result;
    }
}

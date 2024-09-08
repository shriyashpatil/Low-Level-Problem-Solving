package com.lld.splitwise.factories;

import com.lld.splitwise.models.SettleUpAlgorithm;
import com.lld.splitwise.strategies.HeapSettleUpStrategy;
import com.lld.splitwise.strategies.SettleUpStrategy;

public class SettleUpFactory {

    public static SettleUpStrategy getSrategy(SettleUpAlgorithm settleUpAlgorithm){

        if(settleUpAlgorithm.equals(SettleUpAlgorithm.HEAP_ALGORITHM)) return new HeapSettleUpStrategy();

        return null;
    }


}

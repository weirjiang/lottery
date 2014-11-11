package com.weir.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.weir.entiy.Gift;

public class LotteryTest {
    public static void main(String[] args) {
        List<Gift> gifts = new ArrayList<Gift>();
        gifts.add(new Gift(1, "P1", "test1", 0.2f));
        gifts.add(new Gift(2, "P2", "test2", 0.2f));
        gifts.add(new Gift(3, "P3", "tset3", 0.4f));
        gifts.add(new Gift(4, "P4", "test4", 0.3f));
        gifts.add(new Gift(5, "P5", "tset5", 0f));
        gifts.add(new Gift(6, "P6", "test6", -0.1f));
        gifts.add(new Gift(7, "P7", "test7", 0.008f));

        List<Float> orignalRates = new ArrayList<Float>(gifts.size());
        for (Gift gift : gifts) {
            float probability = gift.getProbability();
            if (probability < 0) {
                probability = 0;
            }
            orignalRates.add(probability);
        }

        // // test
        // for (int i = 0; i < 10000; i++) {
        // try {
        // Gift tuple = gifts.get(LotteryUtil.lottery(orignalRates));
        // System.out.println(tuple);
        // } catch (Exception e) {
        // System.out.println("lottery failed, please check it!");
        // }
        // }

        // statistics
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        double num = 1000000;
        for (int i = 0; i < num; i++) {
            int orignalIndex = LotteryUtil.lottery(orignalRates);

            Integer value = count.get(orignalIndex);
            count.put(orignalIndex, value == null ? 1 : value + 1);
        }

        for (Entry<Integer, Integer> entry : count.entrySet()) {
            System.out.println(gifts.get(entry.getKey()) + ", count=" + entry.getValue() + ", probability=" + entry.getValue() / num);
        }
    }

}
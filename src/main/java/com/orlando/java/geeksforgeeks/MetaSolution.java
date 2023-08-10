package com.orlando.java.geeksforgeeks;

import junit.framework.Test;

import java.util.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MetaSolution {

    /*
    input
        data = {
            "web": [0, 1, 0, 0, 1, 0],
            "iphone": [1, 0, 0, 0, 1, 1],
            "android": [0, 0, 0, 0, 1, 0],
            "windows": [0, 0, 0, 0, 0, 1]
        }
        config = {
                "overall": ["web", "iphone", "android", "windows"],
                "mobile": ["iphone", "android"]
        }

    output
        rollup = {
            "overall": 4,
            "mobile": 3
        }
     rollup sum is the OR of the values of the sub-keys
     */
    public Map<String, Integer> rollup(HashMap<String, List<Integer>> data, HashMap<String, List<String>> conf) {
        Map<String, Integer> rollup = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : conf.entrySet()) {
            String category = entry.getKey();
            List<String> items = entry.getValue();

            int sum = 0;
            for (int i = 0; i < data.get(items.get(0)).size(); i++) {
                boolean orResult = false;
                for (String item : items) {
                    if (data.containsKey(item)) {
                        if (data.get(item).get(i) == 1) {
                            orResult = true;
                            break;
                        }
                    }
                }
                if (orResult) {
                    sum++;
                }
            }

            rollup.put(category, sum);
        }

        return rollup;
    }


    private void testRollup() {
        HashMap<String, List<Integer>> data = new HashMap<>();
        data.put("web", Arrays.asList(0, 1, 0, 0, 1, 0));
        data.put("iphone", Arrays.asList(1, 0, 0, 0, 1, 1));
        data.put("android", Arrays.asList(0, 0, 0, 0, 1, 0));
        data.put("windows", Arrays.asList(0, 0, 0, 0, 0, 1));

        HashMap<String, List<String>> conf = new HashMap<>();
        conf.put("overall", Arrays.asList("web", "iphone", "android", "windows"));
        conf.put("mobile", Arrays.asList("iphone", "android"));

        MetaSolution solution = new MetaSolution();
        Map<String, Integer> rollup = solution.rollup(data, conf);
        System.out.println(rollup);
        assertEquals(Optional.ofNullable(rollup.get("overall")), 4);
        assertEquals(Optional.ofNullable(rollup.get("mobile")), 3);
    }
}

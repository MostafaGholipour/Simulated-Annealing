package com.example.Simulated.Annealing;

import lombok.Synchronized;

import java.util.*;

public class Service {
    private final Long target = 1000L;
    private Long changeValue = 10L;


    public Long[] random() {
        Long[] neighbor;
        Random rand = new Random();
        neighbor = new Long[3];
        neighbor[0] = rand.nextLong(0, 1000);
        neighbor[1] = rand.nextLong(0, 1000);
        neighbor[2] = rand.nextLong(0, 1000);
        return neighbor;
    }

    public void run() {
        Long[] random = random();
        int record = 0;
        if (sum(random) > target) {
            for (;;) {
                record++;
                System.out.println();
                Long[] offer = offer(random, changeValue);
                if (sum(offer) < sum(random)) {
                    random = offer;
                }else
                    break;
            }
        }
        if (sum(random) < target) {
            for (;;) {
                record++;
                System.out.println();
                Long[] offer = offer(random, changeValue);
                if (sum(offer) > sum(random)) {
                    random = offer;
                }else
                    break;
            }
        }
        System.out.println("record  :"+record);
        System.out.println(Arrays.toString(random));
    }

    @Synchronized
    public Long[] offer(Long[] input, Long change) {
        List<Long[]> list = new ArrayList<Long[]>();
        for (int i = 0; i < input.length; i++) {
            Long[] offer = new Long[input.length];
            System.arraycopy(input, 0, offer, 0, input.length);
            offer[i] = offer[i] + (change);
            list.add(offer);
        }
        for (int i = 0; i < input.length; i++) {
            Long[] offer = new Long[input.length];
            System.arraycopy(input, 0, offer, 0, input.length);

            offer[i] = offer[i] - (change);
            if (offer[i] < 0)
                offer[i] = 0L;
            list.add(offer);
        }
        list.forEach(l -> System.out.println(Arrays.toString(l)));
        System.out.println("--------------------------------------");
        if (sum(input) > target) {
            Long a = sum(list.get(0));
            Long[] b = list.get(0);
            for (Long[] l : list) {
                if (sum(l) < a) {
                    a = sum(l);
                    b = l;
                }
            }
            return b;
        }
        if (sum(input) < target) {
            Long a = sum(list.get(0));
            Long[] b = list.get(0);
            for (Long[] l : list) {
                if (sum(l) > a) {
                    a = sum(l);
                    b = l;
                }
            }
            return b;
        }
        return input;
    }

    public Long sum(Long[] longs) {
        Long sum = 0L;
        for (int i = 0; i < longs.length; i++) {
            sum += longs[i];
        }
        return sum;
    }
}

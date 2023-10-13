package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

@Service
public class FactorialService {
    private static final Map<Integer, BigInteger> cache = new ConcurrentHashMap<>();
    public static BigInteger calculate(int number) {
        if(number < 2) return BigInteger.valueOf(1);
        if (!cache.containsKey(number)){
            cache.put(number, factorial(number));
        }

        return cache.get(number);
    }

    private static BigInteger factorial(int number) {
        return IntStream
                .rangeClosed(2, number)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();
    }
}

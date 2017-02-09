package ratpackrocker.example.service;

import ratpackrocker.example.service.model.NumberBuckets;

import java.util.ArrayList;
import java.util.List;

public class NumberBucketsService {

    public NumberBuckets sort(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        numbers.forEach(num -> {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        });

        return new NumberBuckets(evens, odds);
    }

}

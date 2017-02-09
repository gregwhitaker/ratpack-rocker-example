package ratpackrocker.example.service;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Singleton
public class NumberGeneratorService {

    private static final Random RAND = new Random(System.currentTimeMillis());

    public List<Integer> generate(Integer maxValue) {
        List<Integer> numbers = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            numbers.add(RAND.nextInt(maxValue) + 1);
        }

        return numbers;
    }

}

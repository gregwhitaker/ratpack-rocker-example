package ratpackrocker.example.service.model;

import java.util.Collections;
import java.util.List;

public class NumberBuckets {

    private final List<Integer> evenBucket;
    private final List<Integer> oddBucket;

    public NumberBuckets(List<Integer> evenBucket, List<Integer> oddBucket) {
        this.evenBucket = evenBucket;
        this.oddBucket = oddBucket;
    }

    public List<Integer> getEvenBucket() {
        return Collections.unmodifiableList(evenBucket);
    }

    public List<Integer> getOddBucket() {
        return Collections.unmodifiableList(oddBucket);
    }

}

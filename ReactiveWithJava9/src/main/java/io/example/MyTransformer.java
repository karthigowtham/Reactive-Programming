package io.example;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyTransformer extends SubmissionPublisher<Integer> implements Processor<Integer, Integer> {

	private Function<Integer, Integer> function;
    private Subscription subscription;
 
    public MyTransformer(Function<Integer, Integer> function) {
        super();
        this.function = function;
    }
 

    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(5);
    }
 
    public void onNext(Integer item) {
        submit(function.apply(item));
        subscription.request(1);
    }
 
    public void onError(Throwable t) {
    	System.out.println("TRANSFORMER ERROR:" + t);
    }
 
    public void onComplete() {
        close();
    }


}

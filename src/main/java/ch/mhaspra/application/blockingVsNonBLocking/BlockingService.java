package ch.mhaspra.application.blockingVsNonBLocking;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlockingService {
    public String getThreadName(){
        return Thread.currentThread().getName();
    }
}

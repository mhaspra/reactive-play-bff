package ch.mhaspra.application;

import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NonblockingService {
    public Uni<String> getThreadName(){
        return Uni.createFrom().item(Thread.currentThread().getName());
    }
}

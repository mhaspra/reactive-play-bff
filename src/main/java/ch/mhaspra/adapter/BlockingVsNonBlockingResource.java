package ch.mhaspra.adapter;

import ch.mhaspra.application.BlockingService;
import ch.mhaspra.application.NonblockingService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("blocking-vs-nonblocking")
public class BlockingVsNonBlockingResource {
    @Inject
    BlockingService blockingService;

    @Inject
    NonblockingService nonblockingService;

    @GET
    @Path("blocking-blocking")
    @Produces(MediaType.TEXT_PLAIN)
    public String blockingBlocking(){
        return blockingService.getThreadName();
    }

    @GET
    @Path("blocking-nonblocking")
    @Produces(MediaType.TEXT_PLAIN)
    public String blockingNonblocking(){
        return nonblockingService.getThreadName().await().indefinitely();
    }

    @GET
    @Path("nonblocking-nonblocking")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> nonblockingNonblocking(){
        return nonblockingService.getThreadName();
    }

    @GET
    @Path("nonblocking-blocking")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> nonblockingBlocking(){
        return Uni.createFrom().item(blockingService.getThreadName());
    }
}

package io.helvetia.frontend.nl;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/sleeper")
public class SleeperResource {

    private static final Logger LOG = Logger.getLogger(SleeperResource.class);

    @GET
    public Response sleeper() throws InterruptedException {

        LOG.info("SLEEPER starting");

        Thread.sleep(15_000);

        LOG.info("SLEEPER finished");

        return Response.status(Response.Status.OK).build();
    }
}

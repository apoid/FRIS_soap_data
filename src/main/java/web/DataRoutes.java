package web;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import java.util.logging.Logger;

public class DataRoutes {
    private static final Logger LOGGER = Logger.getLogger(DataRoutes.class.getSimpleName());

    public void returnTestResponse(RoutingContext routingContext) {
        LOGGER.info("Test route called");
        sendJson(routingContext.response().setStatusCode(200), "UhUH test successful");
    }

    private void sendJson(HttpServerResponse response, Object object){
        response.putHeader("Content-Type", "application/json;charset=utf-8")
                .end(Json.encodePrettily(object));
    }

    public void getProjects(RoutingContext routingContext) {
        LOGGER.info("Get projects route called");
        int nOfProjects = getNumber(routingContext);

        if (nOfProjects < 1){
            sendJson(routingContext.response().setStatusCode(400), "The value is not valid for /api/projects/");
        }

        else {
            //TODO
            sendJson(routingContext.response().setStatusCode(202), "VALUE = "+nOfProjects+"; We are building the route. Hang on ;)");
        }
    }

    private int getNumber(RoutingContext routingContext) {
        String n = routingContext.request().getParam("number");
        try {
            return Math.max(Integer.parseInt(n), 0);
        } catch (NumberFormatException e){
            return -1;
        }

    }
}
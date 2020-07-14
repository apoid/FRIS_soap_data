package web;

import data.SoapRepository;
import entities.Project;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * Class to set the behaviour of each route
 *
 */
public class DataRoutes {
    private static final Logger LOGGER = Logger.getLogger(DataRoutes.class.getSimpleName());

    DataRoutes(){}

    /**
     * Method for the behaviour of the test route
     *
     * @param routingContext the request context
     */
    public void returnTestResponse(RoutingContext routingContext) {
        LOGGER.info("Test route called");
        sendJson(routingContext.response().setStatusCode(200), "UhUH test successful");
    }

    /**
     * Method to return a single project as JSON data identified by its UUID
     *
     * @param routingContext the request context
     */
    public void getProject(RoutingContext routingContext) {
        LOGGER.info("Get projects route called");
        UUID uuid = UUID.fromString(routingContext.request().getParam("uuid"));
        Project project = SoapRepository.getProject(uuid);

        if (project.isEmpty()){
            sendJson(routingContext.response().setStatusCode(404), "Project not found");
        }
        else {
            sendJson(routingContext.response().setStatusCode(200), project);
        }

    }

    /**
     * Method to return multiple projects as JSON data
     *
     * @param routingContext the request context
     */
    public void getProjects(RoutingContext routingContext) {
        LOGGER.info("Get projects route called");
        int nOfProjects = getNumber(routingContext);

        if (nOfProjects < 1){
            sendJson(routingContext.response().setStatusCode(400), "The value is not valid for /api/projects/size/");
        }

        else {
            sendJson(routingContext.response().setStatusCode(202), SoapRepository.getProjects(nOfProjects));
        }
    }

    /**
     * Method to return multiple publications as JSON data
     *
     * @param routingContext the request context
     */
    public void getPublications(RoutingContext routingContext) {
        LOGGER.info("Get publications route called");
        int nOfPublications = getNumber(routingContext);

        if (nOfPublications < 1){
            sendJson(routingContext.response().setStatusCode(400), "The value is not valid for /api/publications/size/");
        }

        else {
            sendJson(routingContext.response().setStatusCode(202), SoapRepository.getPublications(nOfPublications));
        }

    }

    /**
     * Method to send the JSON data as response to the client
     *
     * @param response the response to send to the client
     * @param object the object to send to the client
     */
    private void sendJson(HttpServerResponse response, Object object){
        response.putHeader("Content-Type", "application/json;charset=iso-8859-1")
                .end(Json.encodePrettily(object));
    }

    /**
     * Method to safely extract a URL parameter as integer
     *
     * @param routingContext the request context
     * @return the parameter as integer
     */
    private int getNumber(RoutingContext routingContext) {
        String n = routingContext.request().getParam("number");
        try {
            return Math.max(Integer.parseInt(n), 0);
        } catch (NumberFormatException e){
            return -1;
        }

    }
}

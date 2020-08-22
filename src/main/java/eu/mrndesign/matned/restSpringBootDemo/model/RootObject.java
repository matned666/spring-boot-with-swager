package eu.mrndesign.matned.restSpringBootDemo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
//import net.minidev.json.annotate.JsonIgnore;

public class RootObject {

    @JsonProperty("RestResponse")
    private RestResponse restResponse;

    public RootObject() {
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }

    @Override
    public String toString() {
        return "RootObject{" +
                "restResponse=" + restResponse +
                '}';
    }
}

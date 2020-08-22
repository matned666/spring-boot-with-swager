package eu.mrndesign.matned.restSpringBootDemo.model;

import java.util.List;

public class RestResponse {

    private List<String> messages;
    private Result result;

    public RestResponse() {
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "messages=" + messages +
                ", result=" + result +
                '}';
    }
}

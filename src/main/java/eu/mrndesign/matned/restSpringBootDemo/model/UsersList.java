package eu.mrndesign.matned.restSpringBootDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "Prezydenci")
public class UsersList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Prezydent")
    @JsonProperty("Prezydenci")
    private List<User> users;

    public UsersList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}

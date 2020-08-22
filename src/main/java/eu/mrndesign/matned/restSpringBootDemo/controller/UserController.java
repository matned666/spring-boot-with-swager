package eu.mrndesign.matned.restSpringBootDemo.controller;

import eu.mrndesign.matned.restSpringBootDemo.exceptions.WithRollbackException;
import eu.mrndesign.matned.restSpringBootDemo.model.User;
import eu.mrndesign.matned.restSpringBootDemo.model.UsersList;
import eu.mrndesign.matned.restSpringBootDemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public User createUser(@RequestBody @Valid User user){
        return userService.add(user);
    }

    @PostMapping("/users/exception")
    public User createUserWithException(@RequestBody @Valid User user) throws WithRollbackException {
        user = userService.addUserWithRollback(user);
//        EntityModel<User> entityModel = EntityModel.of(user);
//        Link link = linkTo(UserController.class)
//                .slash("users")
//                .slash(user.getId())
//                .withSelfRel();
//        entityModel.add(link);
        return user;
    }


//    @PostMapping("/users")
//    public List<User> createUser(@RequestBody List<User> users){
//        return userService.addAll(users);
//    }
    @GetMapping("/users")
    public UsersList getUsers(){
        return new UsersList(userService.getAllUsers());
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1")
    public User getById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/users/{name}", headers = "X-API-VERSION=2")
    public User getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }
}

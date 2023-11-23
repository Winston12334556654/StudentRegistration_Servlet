package app.controllers;

import app.daos.UserDao;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.nio.file.spi.FileSystemProvider;

@Controller
public class UserController {

    @Autowired
    private UserDao userdao;

    @GetMapping("/createAccount")
    public String getUserCreateForm(){
    return "userRegistration";
}

    @PostMapping("/createAccount")
    public String postUserCreateForm(@RequestParam String name,String email, String password,
                                  int role, HttpSession session){

        User user=new User(name, email,password, role);
        userdao.createUser(user);


        session.setAttribute("username", name);

        return "home";
    }





}

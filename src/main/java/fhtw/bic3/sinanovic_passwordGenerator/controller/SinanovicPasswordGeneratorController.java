package fhtw.bic3.sinanovic_passwordGenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Controller class
 * REST functionality
 */
@RestController
@CrossOrigin
public class SinanovicPasswordGeneratorController {


    @RequestMapping("/api/password-generator")
    public String writeMessage(@RequestParam String length) {
        return getPassword(Integer.parseInt(length));
    }

    protected String getPassword(int size) {
        if(size<0){
            return "<invalid>";
        }
        if (size==0){
            return "";
        }
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        while (password.length() < size) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            password.append(CHARS.charAt(index));
        }
        String finalPassword = password.toString();
        return finalPassword;

    }

}


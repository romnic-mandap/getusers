package com.romnicmandap.getusers.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping(value="/fetch-external", produces={"application/json"})
    public ResponseEntity<?> getUsers(){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return new ResponseEntity<>(
                response.getBody(),
                HttpStatus.OK
        );
    }

}

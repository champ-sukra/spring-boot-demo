package com.sample.demo.services;


import com.sample.demo.controllers.Response;
import com.sample.demo.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Role> getProfiles() {
        String url = "http://localhost:8082/auth/management/v1/roles";

//        HttpEntity<String> httpEntity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Response<List<Role>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Response<List<Role>>>() {}
        );

        Response<List<Role>> res = response.getBody();
        if (res == null || !res.getCode().equals("success")) {
            throw new RuntimeException("error.!!");
        }

        return res.getData();
    }
}
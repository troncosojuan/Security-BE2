package com.example.msusers.repository;

import com.example.msusers.domain.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KeycloakRepository {

    @Autowired
    private Keycloak keycloak;

    @Value("${dh.keycloak.realm}")
    private String realm;

    public User findByUserId(String id) {
        UserRepresentation userRepresentation = keycloak
                .realm(realm)
                .users()
                .get(id)
                .toRepresentation();
        return toUser(userRepresentation);
    }



    public User toUser(UserRepresentation userRepresentation){
        User user = new User();
        user.setId(userRepresentation.getId());
        user.setUsername(userRepresentation.getUsername());
        user.setEmail(userRepresentation.getEmail());
        user.setFirstname(userRepresentation.getFirstName());
        user.setBills(null);

        return user;
    }


}

package org.example.servlet;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;

import static java.util.Arrays.asList;
import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

@ApplicationScoped
public class TestIdentityStore implements IdentityStore {

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {

        if (usernamePasswordCredential.compareTo("testuser", "secret1")) {
            return new CredentialValidationResult("testuser", new HashSet<>(asList("foo", "bar")));
        }

        return INVALID_RESULT;
    }

}
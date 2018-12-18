package com.bsuir.course.controller;


import com.bsuir.course.configuration.JwtTokenUtil;
import com.bsuir.course.entity.Account;
import com.bsuir.course.entity.AuthToken;
import com.bsuir.course.entity.LoginPassword;
import com.bsuir.course.resource.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping(value = "/token")
public class AuthenticationController {

    private AuthenticationManager manager;

    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager manager, JwtTokenUtil jwtTokenUtil) {
        this.manager = manager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<AuthToken> register(@RequestBody LoginPassword loginPassword) throws AuthenticationException {
        final Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginPassword.getLogin(),
                        loginPassword.getPassword()
                )
        );
        return ResponseEntity.ok(new AuthToken(jwtTokenUtil.generateToken(authentication)));
    }

    @RequestMapping(value = "/expDate/{token}", method = RequestMethod.GET)
    public ResponseEntity<?> GetExpDate(@PathVariable String token) {
        token = token.replace(Constants.TOKEN_PREFIX, "");
        return ResponseEntity.ok(jwtTokenUtil.getExpirationDateFromToken(token));
    }
}

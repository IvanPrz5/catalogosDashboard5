package com.example.catalogosDashboard.Controller.Auth;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogosDashboard.Entity.Utils.ResultObjectResponse;
import com.example.catalogosDashboard.Security.AuthCredentials;
import com.example.catalogosDashboard.Security.TokenUtils;
import com.example.catalogosDashboard.Security.UserDetailImp;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("/authentication")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResultObjectResponse authenticateUser(@RequestBody AuthCredentials authCredentials) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authCredentials.getEmail(), authCredentials.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            if (authentication.getPrincipal() != null) {
                UserDetailImp userDetails = (UserDetailImp) authentication.getPrincipal();
                String token = TokenUtils.createToken(userDetails.getNombre() + " " + userDetails.getUser().getApPaterno() + " " + 
                userDetails.getUser().getApMaterno(), userDetails.getUsername());
                // String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());

                HashMap<String, Object> response = new HashMap<>();
                response.put("Authorization", "Bearer " + token);

                return new ResultObjectResponse(1, false, "Success", response);
            } else {
                return new ResultObjectResponse(0, true, "Verifique los datos de acceso e intentelo nuevamente.", null);
            }
        } catch (Exception ex) {
            return new ResultObjectResponse(0, true, "Verifique los datos de acceso e intentelo nuevamente aqui.", null);
        }
    }
}

package miu.edu.studentenrollment.controller;

import miu.edu.studentenrollment.domain.securitydomain.AuthRequest;
import miu.edu.studentenrollment.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            //Validating user name and password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );

        } catch (Exception ex) {
            throw new Exception("Invalid username or password "+ authRequest.getUserName()+ "...."+authRequest.getPassword());
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}

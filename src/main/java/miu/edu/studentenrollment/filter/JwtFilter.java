package miu.edu.studentenrollment.filter;

import miu.edu.studentenrollment.service.impl.CustomUserDetailsService;
import miu.edu.studentenrollment.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class is created to let Springboot know about generated token
 * Authenticate only once and keep on using the token without providing user name and password.
 */

@Component
public class JwtFilter extends OncePerRequestFilter {


    /**
     * Token will look like this:
     * Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4MzY3NzgxMywiaWF0IjoxNTgzNjQxODEzfQ.26Q3zGGlfjjAHR_PBPsipE8RLsLePseLRf0BAOe5Y7I
     * here we don't need Bearer namespace
     * We have to remove it using subString method of String class
     */


    //JwtUtil is for extracting username and password from generated token
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //Getting token with namespace (Bearer)
        String authorizationHeader = request.getHeader("Authorization");

        String token = null;
        String userName = null;

        //Removing Bearer namespace and keep real token in token variable
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            userName = jwtUtil.extractUsername(token);
        }

        //Validating username holder
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            //get User Details
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);

            // if token is valid configure Spring Security to manually set
            // authentication
            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                userNamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
            }

        }
        filterChain.doFilter(request, response);


    }
}

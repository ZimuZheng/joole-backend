package com.itlize.service.impl;

import java.security.Principal;
import java.sql.SQLIntegrityConstraintViolationException;

import com.itlize.dao.UserDao;
import com.itlize.entity.User;
import com.itlize.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.model.AuthenticationResponse;
import com.itlize.model.MessageResponse;
import com.itlize.util.JwtUtil;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public ResponseEntity<?> createUser(User user) throws Exception{
        try {
            String username = user.getUsername();
            String email = user.getEmail();
            String fname = user.getFname();
            String lname = user.getLname();
            String title = user.getTitle();
            String plain_password = user.getPassword();
            String password = BCrypt.hashpw(plain_password, BCrypt.gensalt());
            if (userDao.findUserByUsername(username) != null) {
                return new ResponseEntity<>(new MessageResponse("This username is already used."),
                        HttpStatus.NOT_ACCEPTABLE);
            }

            userDao.addUser(new User(username,fname,lname,email,title,plain_password,password));

            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(username);

            final String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }

        catch(DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        }
        catch(Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }

    @Override
    public ResponseEntity<?> getUserByName(User user) throws Exception {
        try {
            User newUser = userDao.findUserByUsername(user.getUsername());

            if (newUser == null) {
                return new ResponseEntity<>(new MessageResponse("This username is not exist."),HttpStatus.NOT_ACCEPTABLE);
            }
//            String pass1 = newUser.getPassword();
//            String pass2 = user.getPassword();
//            System.out.println(pass1 != pass2);
//            if (newUser.getPassword() != user.getPassword()) {
//                return new ResponseEntity<>(new MessageResponse("The password is not correct"),HttpStatus.NOT_ACCEPTABLE);
//            }


            return ResponseEntity.ok(newUser);
        }

        catch(DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("The information provided cannot be accepted", e);
        }
        catch(Exception e) {
            throw new Exception("Something went wrong", e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> login(String username, String password) throws Exception {

        try {
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//            User user = userDao.findUserByUsername(authenticationToken.getName());
//            user.setPassword_hash(jwtTokenUtil.generateToken((UserDetails) authenticationToken));
//            return new ResponseEntity<>(user,HttpStatus.OK);

            authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(username,password)));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            final String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
//            return null;
        }

        catch(Exception e) {
            return new ResponseEntity<>(new MessageResponse("The information provided is not accurate"),
                    HttpStatus.FORBIDDEN);
            //throw new Exception("Something went wrong", e);
        }
    }

}

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService myUserDetailsService;
//
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailsService);
//    }
//
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        //　CSRF（Cross-site request forgery），one click attack/session riding
//        //		Attackers steal your identity and send malicious requests on your behalf
//        httpSecurity.csrf().disable()
//                //		Entry points
//                .authorizeRequests()
//                .antMatchers("/user/login").permitAll()
//                .antMatchers("/user/createUser").permitAll()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/swagger-ui.html#/*").permitAll()
//                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
//                .permitAll()
//                // Disallow everything else..
//                .anyRequest().authenticated().and().exceptionHandling()
//                //Logout
//                //.and().logout().logoutUrl("/user/logout").logoutSuccessUrl("/user/login").permitAll()
//                // No session will be created or used by spring security
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//}

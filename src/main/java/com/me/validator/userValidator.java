/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.validator;

import com.me.pojo.User;
import static java.lang.Compiler.command;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Adhyantini
 */
@Component
public class userValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object command, Errors errors) {
        User user = (User) command;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emaildID", "empty-emaildID", "Email ID cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty-password", "Password cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm_password", "empty-confirm_password", "Confirm Password cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "empty-phonw", "Phone cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address_line1", "empty-address_line1", "Adress Line1 cannot be empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address_line2", "empty-address_line2", "Email ID cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "empty-city", "City cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "empty-state", "State cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipcode", "empty-zipcode", "Zipcode cannot be empty");
        
        
        String email = user.getEmaildID();
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches())
            errors.rejectValue("emaildID", "emaildID-type", "Invalid Email Format");
        
        String password = user.getPassword();
        String conf_password = user.getConfirm_password();
        
        if(!password.equals(conf_password)){
                errors.rejectValue("confirm_password", "password-type", "This does not match the password field");
        }
    }
  }
   

package com.example.springsecurityclient.service;

import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.entity.VerificationToken;
import com.example.springsecurityclient.model.UserModel;

import java.util.Optional;

public interface UserService
{
    User registerUser( UserModel userModel );

    void saveVerificationTokenForUser( String token, User user );

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken( String oldToken );

    User findByEmail( String email );

    void createPasswordResetTokenForUser( User user, String token );

    String validatePasswordResetToken( String token );

    Optional<User> getUserByPasswordResetToken( String token );

    void changePassword( User user, String newPassword );

    boolean checkIfValidOldPassword( User user, String oldPassword );
}

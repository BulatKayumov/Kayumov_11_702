package ru.itis.services;

import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.forms.UserForm;
import ru.itis.models.User;

public interface UsersService {
    void signUp(SignUpForm form);

    UserForm signIn(SignInForm form);

    boolean isExistByCookie(String cookieValue);

    User getUserByCookie(String cookieValue);
}

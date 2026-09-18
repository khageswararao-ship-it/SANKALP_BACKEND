package com.sankalp.backend.service;

import com.sankalp.backend.entity.Login;

public interface ProfileService {

    Login getAdminProfile();

    Login updateAdminProfile(Login login);

}
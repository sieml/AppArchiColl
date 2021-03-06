package com.example.dev_wang.databindingdemo.Module.AppFacade;


import com.example.puremvc_appfacade.Runs.Facade;
import com.example.puremvc_appfacade.Runs.protocol.IFacade;

/**
 * Created by dev_wang on 2017/1/24.
 */

public abstract class Runs {

    //RunsUserLoginMediator
    public static final String BIND_VIEW_COMPONENT = "BIND_VIEW_COMPONENT";
    public static final String UNBUNDLED_VIEW_COMPONENT = "UNBUNDLED_VIEW_COMPONENT";
    public static final String USER_LOGIN_NOTIFICATION = "USER_LOGIN_NOTIFICATION";
    public static final String USER_LOGOUT_NOTIFICATION = "USER_LOGOUT_NOTIFICATION";
    public static final String USER_REGISTER_NOTIFICATION = "USER_REGISTER_NOTIFICATION";

    //RunsUserRegisterMediatorUNLOCK
    public static final String BIND_REGISTER_COMPONENT = "BIND_REGISTER_COMPONENT";
    public static final String USER_BIND_PHONE_NOTIFICATION = "USER_BIND_PHONE_NOTIFICATION";
    public static final String USER_REGISTER_DONE_NOTIFICATION = "USER_REGISTER_DONE_NOTIFICATION";

}

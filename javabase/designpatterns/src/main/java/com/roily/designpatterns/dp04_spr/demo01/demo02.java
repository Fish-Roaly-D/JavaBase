package com.roily.designpatterns.dp04_spr.demo01;

/**
 * @version 1.0.0
 * @Description
 * @ClassName demo02.java
 * @author: RoilyFish
 * @date: 2022/5/30 23:37
 */
public class demo02 {

}

interface iUserBusiness {
}

interface IRegister extends iUserBusiness{
    void register();
}
interface ILogin extends iUserBusiness{
    void login();
}
interface ILogout extends iUserBusiness{
    void logout();
}

class IRegisterImpl implements IRegister {

    @Override
    public void register() {

    }
}
class ILoginImpl implements ILogin {
    @Override
    public void login() {

    }
}class ILogoutImpl implements ILogout {
    @Override
    public void logout() {
    }
}
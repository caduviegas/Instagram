package com.innaval.instagram.common.base

import com.innaval.instagram.login.data.FakeDataSource
import com.innaval.instagram.login.data.LoginRepository
import com.innaval.instagram.register.data.FakeRegisterDataSource
import com.innaval.instagram.register.data.RegisterRepository

object DependencyInjector {

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }
}
package com.innaval.instagram.add.data

import com.innaval.instagram.common.model.Database
import com.innaval.instagram.common.model.UserAuth
import java.lang.RuntimeException

class AddLocalDataSource: AddDataSource {

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?:throw RuntimeException("Usuário não logado!!")
    }
}
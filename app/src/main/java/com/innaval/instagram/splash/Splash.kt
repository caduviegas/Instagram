package com.innaval.instagram.splash

import com.innaval.instagram.common.base.BasePresenter
import com.innaval.instagram.common.base.BaseView

interface Splash {

    interface Presenter : BasePresenter {
        fun authenticated()
    }

    interface View : BaseView<Presenter> {
        fun goToMainScreen()
        fun goToLoginScreen()
    }

}
package com.innaval.instagram.common.base

import android.content.Context
import com.innaval.instagram.add.data.AddFakeRemoteDataSource
import com.innaval.instagram.add.data.AddLocalDataSource
import com.innaval.instagram.add.data.AddRepository
import com.innaval.instagram.home.data.FeedMemoryCache
import com.innaval.instagram.home.data.HomeDataSourceFactory
import com.innaval.instagram.home.data.HomeRepository
import com.innaval.instagram.login.data.FakeDataSource
import com.innaval.instagram.login.data.LoginRepository
import com.innaval.instagram.post.data.PostLocalDataSource
import com.innaval.instagram.post.data.PostRepository
import com.innaval.instagram.profile.data.PostListMemoryCache
import com.innaval.instagram.profile.data.ProfileDataSourceFactory
import com.innaval.instagram.profile.data.ProfileMemoryCache
import com.innaval.instagram.profile.data.ProfileRepository
import com.innaval.instagram.register.data.FakeRegisterDataSource
import com.innaval.instagram.register.data.RegisterRepository
import com.innaval.instagram.search.data.SearchFakeRemoteDataSource
import com.innaval.instagram.search.data.SearchRepository
import com.innaval.instagram.splash.data.FakeLocalDataSource
import com.innaval.instagram.splash.data.SplashRepository

object DependencyInjector {

    fun splashRepository() : SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

    fun searchRepository() : SearchRepository {
        return SearchRepository(SearchFakeRemoteDataSource())
    }

    fun profileRepository() : ProfileRepository {
        return ProfileRepository(ProfileDataSourceFactory(ProfileMemoryCache, PostListMemoryCache))
    }

    fun homeRepository() : HomeRepository {
        return HomeRepository(HomeDataSourceFactory(FeedMemoryCache))
    }

    fun addRepository() : AddRepository {
        return AddRepository(AddFakeRemoteDataSource(), AddLocalDataSource())
    }

    fun postRepository(context: Context) : PostRepository {
        return PostRepository(PostLocalDataSource(context))
    }

}
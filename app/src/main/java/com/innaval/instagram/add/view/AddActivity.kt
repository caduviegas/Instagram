package com.innaval.instagram.add.view

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.innaval.instagram.R
import com.innaval.instagram.add.Add
import com.innaval.instagram.add.presentation.AddPresenter
import com.innaval.instagram.common.base.DependencyInjector
import com.innaval.instagram.databinding.ActivityAddBinding
import java.lang.RuntimeException

class AddActivity : AppCompatActivity(), Add.View {

    private lateinit var binding: ActivityAddBinding
    private lateinit var uri: Uri

    override lateinit var presenter: Add.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.addToolbar)

        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back)
        supportActionBar?.setHomeAsUpIndicator(drawable)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        uri = intent.extras?.getParcelable("photoUri") ?: throw RuntimeException("photo not found")

        binding.addImgCaption.setImageURI(uri)

        val repository = DependencyInjector.addRepository()
        presenter = AddPresenter(this, repository)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.action_share -> {
                presenter.createPost(uri, binding.addEditCaption.text.toString())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showProgress(enabled: Boolean) {
        binding.addProgress.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun displayRequestSuccess() {
        setResult(RESULT_OK)
        finish()
    }

    override fun displayRequestFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
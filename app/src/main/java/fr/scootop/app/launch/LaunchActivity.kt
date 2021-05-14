package fr.scootop.app.launch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import fr.scootop.R
import fr.scootop.app.home.HomeActivity
import fr.scootop.app.login.LoginActivity
import fr.scootop.data.storage.TokenStorage

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        
        val handler = Handler()
        handler.postDelayed({
            val nextIntent: Intent

            val tokenStorage = TokenStorage.get(this@LaunchActivity)
            nextIntent = if (null != tokenStorage.jwt && null != tokenStorage.refreshToken) {
                /** User already logged in  */
                //nextIntent = new Intent(LaunchActivity.this, SearchActivity.class);
                Intent(this@LaunchActivity, HomeActivity::class.java)
            } else {
                /** We should present the login page to the user  */
                Intent(this@LaunchActivity, LoginActivity::class.java)
            }

            startActivity(nextIntent)
            finish()
        }, DELAY_MILLIS)
    }

    companion object {
        private val DELAY_MILLIS: Long = 5000 // 5 seconds
    }
}

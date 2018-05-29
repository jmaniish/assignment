package milvik.com.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import milvik.com.myapplication.model.User
import org.jetbrains.anko.alert

class MainActivity : AppCompatActivity() {

    private var btnCheckBalance: Button? = null
    private var btnRecharge: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCheckBalance = findViewById(R.id.buttonCheckBalance)
        btnRecharge = findViewById(R.id.buttonRecharge)

        val user = User()
        user.balance = 100.00
        user.name = "Fred"

        btnCheckBalance?.setOnClickListener {
            alert("Your balance is ${user.balance} Rs.") {
                yesButton {
                    if (user.balance < 200) {
                        alert("Would you like to recharge") {
                            yesButton {
                                val intent = Intent(this@MainActivity, RechargeActivity::class.java)
                                startActivity(intent)
                            }
                            noButton { }
                        }.show()
                    }
                }
            }.show()
        }

        btnRecharge?.setOnClickListener {
            val intent = Intent(this@MainActivity, RechargeActivity::class.java)
            startActivity(intent)
        }
    }
}

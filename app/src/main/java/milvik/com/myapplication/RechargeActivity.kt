package milvik.com.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import milvik.com.myapplication.model.RechargeBundle
import org.jetbrains.anko.alert

class RechargeActivity : AppCompatActivity() {

    private var numberInput: TextView? = null
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recharge)

        var rechargeBundle1 = RechargeBundle()
        rechargeBundle1.details = "50p for 1 minute call"
        rechargeBundle1.pricePerMonth = 400.0
        var rechargeBundle2 = RechargeBundle()
        rechargeBundle2.details = "25p for 1 minute call"
        rechargeBundle2.pricePerMonth = 600.0
        var rechargeBundle3 = RechargeBundle()
        rechargeBundle3.details = "1Rs for 1 minute call"
        rechargeBundle3.pricePerMonth = 0.0

        numberInput = findViewById(R.id.editText)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)

        productOneSelected()
        productTwoSelected()
        productThreeSelected()
    }

    private fun productThreeSelected() {
        btn2?.setOnClickListener {
            val amount = numberInput?.text.toString().toInt()
            checkValidAmount(amount)
        }
    }

    private fun productTwoSelected() {
        btn3?.setOnClickListener {
            val amount = numberInput?.text.toString().toInt()
            checkValidAmount(amount)
        }
    }

    private fun productOneSelected() {
        btn1?.setOnClickListener {
            val amount = numberInput?.text.toString().toInt()
            checkValidAmount(amount)
        }
    }

    private fun checkValidAmount(amount: Int) {
        if (amount in 1..9999) {
            showSuccessRechargeAlert()
        } else {
            showFailureAlert()
        }
    }

    private fun showFailureAlert() {
        alert("You cannot recharge with the specific amount, please enter the amount again") {
            yesButton {}
        }.show()
    }

    private fun showSuccessRechargeAlert() {
        alert("Recharge successful") {
            yesButton {}
        }.show()
    }
}

package com.softwaree.icelatte

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import com.softwaree.icelatte.Enums.ApplicationState
import com.softwaree.icelatte.Enums.COFFEETYPES
import com.softwaree.icelatte.Enums.COINS
import kotlinx.android.synthetic.main.activity_main.*
import org.apmem.tools.layouts.FlowLayout
import java.lang.Integer.valueOf

class MainActivity : AppCompatActivity() {

    private val coins: Array<COINS> = COINS.values()
    private val coffeeTypes: Array<COFFEETYPES> = COFFEETYPES.values()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainState = MainState(0, 0, ApplicationState.SAYHELLO)

        giveMeChange(135)

        // Fill Screen with Buttons
        coins.forEach { createCoinButton(mainState, it) }
        coffeeTypes.forEach { createCoffeeButton(mainState, it) }
    }

    private fun createCoinButton(state: MainState, token: COINS) {
        val button = Button(this)
        button.text = token.cash.toString()
        button.setOnClickListener {
            val clickedButton = it as Button
            Log.d("INFO", "i was pressed: " + clickedButton.text)
            state.balance += valueOf(clickedButton.text.toString())
            saldoTextView.text = state.balance.toString()
        }
        findViewById<FlowLayout>(R.id.coinsFlow).addView(button)
    }

    private fun createCoffeeButton(state: MainState, bean: COFFEETYPES) {
        val button = Button(this)
        button.text = bean.toString()
        button.setOnClickListener {
            val clickedButton = it as Button
            Log.d("INFO", "i was pressed: " + clickedButton.text)
            state.price = COFFEETYPES.valueOf(clickedButton.text.toString()).cash
            priceTextView.text = state.price.toString()

            if (state.balance >= state.price){
                giveMeChange(state.balance -state.price)
                state.balance = 0
            }
        }
        findViewById<FlowLayout>(R.id.coffeeFlow).addView(button)
    }

    private fun giveMeChange(saldo:Int) {

        var remainingSaldo = saldo

        for (coin in coins.sorted().reversed()) {
            val countCoin = (remainingSaldo / coin.cash)
            remainingSaldo = saldo.rem(coin.cash)
            Log.d("INFO","Coin: " + coin.name + " Anzahl: " + countCoin + " Rest: " + remainingSaldo)
        }
    }
}
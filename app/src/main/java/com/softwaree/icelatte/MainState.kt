package com.softwaree.icelatte


import com.softwaree.icelatte.Enums.ApplicationState
import com.softwaree.icelatte.Enums.COINS

class MainState(var price: Int, var balance: Int, var inState: ApplicationState)


fun calculateChange(change: Int) = {


    var coins = COINS.values()
    var returnvalue: Map<COINS, Int>

    coins.forEach {


        val coinsToReturn = change % it.cash


    }

}

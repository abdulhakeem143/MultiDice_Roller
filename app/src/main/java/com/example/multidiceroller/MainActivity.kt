package com.example.multidiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //rolling button 1
        val rollButton: Button = findViewById(R.id.roll_btn)
        rollButton.setOnClickListener {
            rollDice()

        }

        //rolling button 2
        val rollButton2: Button = findViewById(R.id.roll_btn2)
        rollButton2.setOnClickListener {
            rollDice2()
            val greetText: TextView = findViewById(R.id.greet_text)
            val userName: TextView = findViewById(R.id.p1_id)
            val userName2: TextView = findViewById(R.id.p2_id)
            val uName1 = userName.text
            val uName2 = userName2.text
            if(disk1RandomInt>disk2RandomInt){
                greetText.text = "${uName1} Won the Match."
            }else if(disk1RandomInt == disk2RandomInt){
                greetText.text = "Match Draw!"
            }
            else{
                greetText.text = "${uName2} Won the Match."
            }
        }
    }
    var disk1RandomInt = 0
    var disk2RandomInt = 0

    /**
     * Roll the dice and update the screen with the result.
     */
    public fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        disk1RandomInt = diceRoll

        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.img1)
        when(diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }

    public fun rollDice2() {
        // Create new Dice object with 6 sides and roll it
        val dice2 = Dice2(6)
        val diceRoll2 = dice2.roll2()
        disk2RandomInt = diceRoll2

        // Update the screen with the dice roll
        val diceImage2: ImageView = findViewById(R.id.img2)
        when(diceRoll2){
            1 -> diceImage2.setImageResource(R.drawable.dice_1)
            2 -> diceImage2.setImageResource(R.drawable.dice_2)
            3 -> diceImage2.setImageResource(R.drawable.dice_3)
            4 -> diceImage2.setImageResource(R.drawable.dice_4)
            5 -> diceImage2.setImageResource(R.drawable.dice_5)
            6 -> diceImage2.setImageResource(R.drawable.dice_6)
        }


    }


}
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
class Dice2(val numSides2: Int){

    fun roll2(): Int{
        return (1..numSides2).random()
    }
}


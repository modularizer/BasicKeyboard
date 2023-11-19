package com.example.helloworldkeyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button

class KeyboardService : InputMethodService() {
    override fun onCreateInputView(): View {
        // Inflate your keyboard layout from the XML file
        val inflater = layoutInflater
        val inputView = inflater.inflate(R.layout.keyboard_layout, null)

        // Get references to your buttons
        val buttonHello = inputView.findViewById<Button>(R.id.button_hello)
        val buttonWorld = inputView.findViewById<Button>(R.id.button_world)
        val buttonKeyboard = inputView.findViewById<Button>(R.id.button_keyboard)

        // Set click listeners for your buttons
        buttonHello.setOnClickListener { inputText("hello") }
        buttonWorld.setOnClickListener { inputText("world") }
        buttonKeyboard.setOnClickListener { inputText("keyboard") }


        return inputView
    }

    private fun inputText(text: String) {
        val inputConnection = currentInputConnection
        inputConnection?.commitText(text, 1)
    }
}

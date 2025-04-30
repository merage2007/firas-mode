package com.example.mobiletrackerfree

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
            val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

            when (state) {
                TelephonyManager.EXTRA_STATE_RINGING -> {
                    Log.d("CallReceiver", "Incoming call ringing from: $incomingNumber")
                    // TODO: Handle incoming call ringing event
                }
                TelephonyManager.EXTRA_STATE_OFFHOOK -> {
                    Log.d("CallReceiver", "Call answered or outgoing call started")
                    // TODO: Handle call answered or outgoing call started event
                }
                TelephonyManager.EXTRA_STATE_IDLE -> {
                    Log.d("CallReceiver", "Call ended or idle")
                    // TODO: Handle call ended event
                }
            }
        } else if (intent.action == Intent.ACTION_NEW_OUTGOING_CALL) {
            val outgoingNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)
            Log.d("CallReceiver", "Outgoing call started to: $outgoingNumber")
            // TODO: Handle outgoing call started event
        }
    }
}

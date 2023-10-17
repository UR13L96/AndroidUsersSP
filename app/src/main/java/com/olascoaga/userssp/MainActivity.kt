package com.olascoaga.userssp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.olascoaga.userssp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        val username = preferences.getString(getString(R.string.sp_username), "N/A")

        Log.i("SP", "${ getString(R.string.sp_first_time) } = $isFirstTime")
        Log.i("SP", "${ getString(R.string.sp_username) } = $username")

        if (isFirstTime) {
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)

            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm) { _, _ ->
                    val newUsername = dialogView.findViewById<TextInputEditText>(R.id.et_username)
                        .text.toString()
                    with(preferences.edit()) {
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), newUsername)
                            .apply()
                    }
                    Toast.makeText(this, getString(R.string.user_registered), Toast.LENGTH_SHORT)
                        .show()
                }
                .setNeutralButton(getString(R.string.guest), null)
                .show()
        } else {
            Toast.makeText(this, "Welcome $username!", Toast.LENGTH_SHORT).show()
        }

        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()

        val alejandro = User(1, "Alejandro", "Abed", "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8dXNlciUyMHByb2ZpbGV8ZW58MHx8MHx8fDA%3D&w=1000&q=80")
        val yarael = User(2, "Yarael", "Garcia", "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlciUyMHByb2ZpbGV8ZW58MHx8MHx8fDA%3D&w=1000&q=80")
        val miles = User(3, "Miles", "Morales", "https://www.infobae.com/new-resizer/b1YhCRwrSa31Zxo4NzLHLH9AIeg=/1200x900/filters:format(webp):quality(85)/cloudfront-us-east-1.images.arcpublishing.com/infobae/4XZXEYWUGNHWBDSIUQBXFYGGFY.jpeg")
        val frida = User(4, "Frida", "Kahlo", "https://upload.wikimedia.org/wikipedia/commons/0/06/Frida_Kahlo%2C_by_Guillermo_Kahlo.jpg")

        users.add(alejandro)
        users.add(yarael)
        users.add(miles)
        users.add(frida)
        users.add(alejandro)
        users.add(yarael)
        users.add(miles)
        users.add(frida)
        users.add(alejandro)
        users.add(yarael)
        users.add(miles)
        users.add(frida)
        users.add(alejandro)
        users.add(yarael)
        users.add(miles)
        users.add(frida)

        return users
    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position - ${user.getFullname()}", Toast.LENGTH_SHORT).show()
    }
}
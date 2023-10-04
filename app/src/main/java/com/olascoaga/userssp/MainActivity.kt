package com.olascoaga.userssp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olascoaga.userssp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userAdapter = UserAdapter(getUsers())
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
}
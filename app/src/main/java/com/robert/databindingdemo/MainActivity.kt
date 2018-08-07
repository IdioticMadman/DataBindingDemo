package com.robert.databindingdemo

import android.databinding.ObservableArrayMap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.robert.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val user = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        LayoutInflater.from(this).inflate(R.layout.activity_main,
//                window.decorView.findViewById(android.R.id.content))
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.person = Person("robert", "xiong")
        binding.userMap = ObservableArrayMap<String, Any>().apply {
            put("firstName", "robert")
            put("lastName", "xiong")
            put("age", 17)
        }

        binding.user = user.also {
            it.firstName = "cindy"
            it.lastName = "chen"
        }

        binding.handlers = MyHandlers()
        binding.viewStub.viewStub?.inflate()
    }

    inner class MyHandlers {
        fun onClickFriend(view: View, person: Person) {
            Toast.makeText(this@MainActivity, person.toString(), Toast.LENGTH_SHORT).show()
        }

        fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            user.firstName= s.toString()
        }
    }
}

package com.chobo.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.view.GravityCompat
import com.chobo.navigation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNaviImg.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START) // start : left , end : right 같은말
        }
        val navigationView: NavigationView = findViewById(R.id.btn_navi1)
        navigationView.setNavigationItemSelectedListener(this) // 여기서 this는 결국 R.id.access -> Toast 여기를 가르키게됨
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { // 네비게이션 메뉴 아이템 클릭 시 수행
        when (item.itemId){
            R.id.access -> Toast.makeText(applicationContext, "접근성",Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일",Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지",Toast.LENGTH_SHORT).show()

        }
        binding.layoutDrawer.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if (binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){
         binding.layoutDrawer.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }
}
package com.ripalay.taskapp35.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.taskapp35.R
import com.ripalay.taskapp35.databinding.ActivityMainBinding
import com.ripalay.taskapp35.domain.ShopItem
import java.lang.Exception

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()
    private var shopList = mutableListOf<ShopItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.shopList.observe(this) {
            shopList = it as MutableList<ShopItem>
            it.forEach { shopItem ->
                Log.e("olololo", "list: $shopItem")
            }
        }
        initListener()
    }

    private fun initListener() {
        binding.startBtn.setOnClickListener {
            addShopItem()
        }
        binding.deleteBtn.setOnClickListener {
            deleteShopItem()
        }
        binding.getitemBtn.setOnClickListener {
            getShopItem()
        }
        binding.editBtn.setOnClickListener {
            editShopItem()
        }

    }

    private fun addShopItem() {
        viewModel.addShopItem(ShopItem(1, "potato", 2, false))
        viewModel.addShopItem(ShopItem(2, "potato", 2, false))
        viewModel.addShopItem(ShopItem(3, "potato", 2, false))
        viewModel.addShopItem(ShopItem(4, "potato", 2, false))

        viewModel.getShopItemList()
    }

    private fun deleteShopItem() {
        try {
            viewModel.deleteShopItem(shopList[0])
            Log.e("Delete:", shopList[0].toString())
            viewModel.getShopItemList()
        } catch (e: Exception) {
            print(e.localizedMessage)
        }
    }

    private fun getShopItem() {
        viewModel.getShopItem(shopList[0])
        Log.e("Get Item", shopList[0].toString())
    }
    private fun editShopItem(){
        viewModel.editShopItem(ShopItem(3,"potato", 3, true))
        viewModel.getShopItemList()
    }
}
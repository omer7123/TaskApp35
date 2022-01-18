package com.ripalay.taskapp35.data

import com.ripalay.taskapp35.domain.ShopItem
import com.ripalay.taskapp35.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private lateinit var data: ShopItem

    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopList.forEach {
            if(it.id == shopItem.id){
                it.enabled = shopItem.enabled
            }
        }
    }

    override fun getShopItem(shopItem: ShopItem): ShopItem {
        shopList.forEach {
            if (it == shopItem) {
                data = it
            }
        }
        return data
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}
package com.ripalay.taskapp35.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ripalay.taskapp35.data.ShopListRepositoryImpl
import com.ripalay.taskapp35.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemListUseCase = GetShopItemListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()
    val searchShopItem = MutableLiveData<ShopItem?>()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun getShopItemList() {
        val list = getShopItemListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun getShopItem(shopItem: ShopItem): ShopItem? {
        return getShopItemUseCase.getShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem){
        editShopItemUseCase.editShopItem(shopItem)
    }
}
package com.ripalay.taskapp35.domain

class GetShopItemListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList() = shopListRepository.getShopList()
}
package com.ripalay.taskapp35.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItem: ShopItem) = shopListRepository.getShopItem(shopItem)


}
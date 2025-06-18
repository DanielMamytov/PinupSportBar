package com.pinup.barapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.pinup.barapp.data.repositories.CartRepository
import com.pinup.barapp.domain.models.CartItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository
) : ViewModel() {

    val totalQuantity: LiveData<Int> = repository.getTotalQuantity().asLiveData()
    val totalPrice: LiveData<Double> = repository.getTotalPrice().asLiveData()
    val cartItems: LiveData<List<CartItem>> = repository.getAll().asLiveData()

    fun addToCart(item: CartItem) {
        viewModelScope.launch {
            repository.insert(item)
        }
    }

    fun increaseQuantity(item: CartItem) {
        viewModelScope.launch {
            repository.increaseQuantity(item)
        }
    }

    fun decreaseQuantity(item: CartItem) {
        viewModelScope.launch {
            repository.decreaseQuantity(item)
        }
    }

    fun removeFromCart(item: CartItem) {
        viewModelScope.launch {
            repository.deleteById(item.id)
        }
    }
}

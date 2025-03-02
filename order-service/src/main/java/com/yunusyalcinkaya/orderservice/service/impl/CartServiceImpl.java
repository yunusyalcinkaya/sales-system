package com.yunusyalcinkaya.orderservice.service.impl;

import com.yunusyalcinkaya.commonutils.util.NullSafeUtil;
import com.yunusyalcinkaya.orderservice.dto.cart.BaseCartItemInfo;
import com.yunusyalcinkaya.orderservice.dto.cart.request.AddItemToCartRequest;
import com.yunusyalcinkaya.orderservice.dto.cart.response.AddItemToCartResponse;
import com.yunusyalcinkaya.orderservice.entity.Cart;
import com.yunusyalcinkaya.orderservice.entity.CartItem;
import com.yunusyalcinkaya.orderservice.enums.OrderServiceResponse;
import com.yunusyalcinkaya.orderservice.repository.CartRepository;
import com.yunusyalcinkaya.orderservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddItemToCartResponse addItemToCart(AddItemToCartRequest request) {

        Cart cartEntity = cartRepository.findByCustomerNumber(request.getCustomerNumber());
        NullSafeUtil.checkIfNull(cartEntity, OrderServiceResponse.CART_NOT_FOUND);
        
        CartItem cartItemEntity = new CartItem(request.getProductCode(), request.getQuantity(), cartEntity);
        cartEntity.getCartItemList().add(cartItemEntity);

        cartRepository.save(cartEntity);

        List<BaseCartItemInfo> cartItemList = cartEntity.getCartItemList().stream()
                .map(cartItem -> modelMapper.map(cartItem, BaseCartItemInfo.class))
                .toList();

        return AddItemToCartResponse.builder()
                .customerNumber(cartEntity.getCustomerNumber())
                .cartItemList(cartItemList).build();
    }
}

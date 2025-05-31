package com.yunusyalcinkaya.orderservice.service.impl;

import com.yunusyalcinkaya.commonutils.util.NullSafeUtil;
import com.yunusyalcinkaya.orderservice.dto.cart.BaseCartInfo;
import com.yunusyalcinkaya.orderservice.dto.cart.BaseCartItemInfo;
import com.yunusyalcinkaya.orderservice.dto.cart.request.AddItemToCartRequest;
import com.yunusyalcinkaya.orderservice.dto.cart.response.AddItemToCartResponse;
import com.yunusyalcinkaya.orderservice.entity.Cart;
import com.yunusyalcinkaya.orderservice.entity.CartItem;
import com.yunusyalcinkaya.orderservice.enums.OrderServiceResponse;
import com.yunusyalcinkaya.orderservice.repository.CartItemRepository;
import com.yunusyalcinkaya.orderservice.repository.CartRepository;
import com.yunusyalcinkaya.orderservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ModelMapper modelMapper;

    @Override
    public BaseCartInfo getByCustomerNumber(String customerNumber) {
        Cart cartEntity = cartRepository.findByCustomerNumber(customerNumber);
        NullSafeUtil.checkIfNull(cartEntity, OrderServiceResponse.CART_NOT_FOUND);

        // todo: icerisindeki listeyi map'liyor mu kontrol et
        return modelMapper.map(cartEntity, BaseCartInfo.class);
    }

    @Override
    @Transactional
    public AddItemToCartResponse addItemToCart(AddItemToCartRequest request) {

        Cart cartEntity = cartRepository.findByCustomerNumber(request.getCustomerNumber());
        NullSafeUtil.checkIfNull(cartEntity, OrderServiceResponse.CART_NOT_FOUND);

        CartItem cartItemEntity = new CartItem(request.getProductCode(), request.getQuantity(), request.getPrice(), cartEntity);
        cartEntity.getCartItemList().add(cartItemEntity);

        BigDecimal itemTotal = request.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));
        cartEntity.setTotalPrice(cartEntity.getTotalPrice().add(itemTotal));

        cartRepository.save(cartEntity);

        List<BaseCartItemInfo> cartItemList = cartEntity.getCartItemList().stream()
                .map(cartItem -> modelMapper.map(cartItem, BaseCartItemInfo.class))
                .toList();

        return AddItemToCartResponse.builder()
                .customerNumber(cartEntity.getCustomerNumber())
                .totalPrice(cartEntity.getTotalPrice())
                .cartItemList(cartItemList).build();
    }

    @Override
    public BaseCartInfo clearCart(String customerNumber) {
        Cart cart = cartRepository.findByCustomerNumber(customerNumber);
        NullSafeUtil.checkIfNull(cart, OrderServiceResponse.CART_NOT_FOUND);

        cart.setTotalPrice(BigDecimal.ZERO);
        cartItemRepository.deleteAllByCartId(cart.getId());

        cartRepository.save(cart);

        BaseCartInfo response = modelMapper.map(cart, BaseCartInfo.class);
        response.setCartItemList(Collections.emptyList());

        return response;
    }
}

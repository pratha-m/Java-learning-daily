package com.batch.example.config;

import com.batch.example.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
            if(item.getDiscount().trim().equalsIgnoreCase("discount")) return null;
            try {
                int discountPerc = Integer.parseInt(item.getDiscount().trim());
                double originalPrice = Double.parseDouble(item.getPrice().trim());
                double discount = (originalPrice * discountPerc) / 100;
                double finalPrice = originalPrice - discount;
                item.setDiscounted_price(String.valueOf(finalPrice));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            return item;
    }
}

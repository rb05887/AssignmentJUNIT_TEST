package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.model.Product;
import com.service.ProductService;

public class ProductServiceTest {

	@Test
	public void testIncreasePriceByCategory() {
		Product mobile = new Product(1, "iPhone", 1000.0, "Mobiles");
		Product laptop = new Product(2, "Dell XPS", 1500.0, "Laptops");

		ProductService productService = new ProductService();

		Product updatedMobile = productService.increasePriceByCategory(mobile);
		Product updatedLaptop = productService.increasePriceByCategory(laptop);

		assertEquals(1020.0, updatedMobile.getPrice(), 0.001); // 2% increment on mobile
		assertEquals(1515.0, updatedLaptop.getPrice(), 0.001); // 1% increment on laptop
	}

	@Test
	public void testComputeTotalPrice() {
		Product mobile = new Product(1, "iPhone", 1000.0, "Mobiles");
		Product laptop = new Product(2, "Dell XPS", 1500.0, "Laptops");

		ProductService productService = new ProductService();

		double totalPrice = productService.computeTotalPrice(new Product[] { mobile, laptop });

		assertEquals(2500.0, totalPrice, 0.001); // Sum of mobile and laptop prices
	}

	@Test
	public void testComputeGreaterPrice() {
		Product cheaper = new Product(1, "Cheap Phone", 500.0, "Mobiles");
		Product expensive = new Product(2, "Expensive Phone", 1000.0, "Mobiles");

		ProductService productService = new ProductService();

		productService.computeGreaterPrice(cheaper, expensive);
	}
}

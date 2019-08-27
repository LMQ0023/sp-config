package com.tedu.sp06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;

@RestController
public class RibbonController {
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/item-service/{orderId}") //item-service Eureka中微服务ID
	public JsonResult<List<Item>> getItems(@PathVariable String orderId){
		return rt.getForObject("http://localhost:8001/{1}",JsonResult.class,orderId);
	}
	
	@PostMapping("/item-service/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		return rt.postForObject("http://localhost:8001/decreaseNumber", items, JsonResult.class);
	}
}

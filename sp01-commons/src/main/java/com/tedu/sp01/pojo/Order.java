package com.tedu.sp01.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Order {
	private String id; //����id
	private User user; //���������û�
	private List<Item> items; //������Ʒ
}
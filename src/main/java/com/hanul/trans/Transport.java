package com.hanul.trans;

import org.springframework.stereotype.Component;

@Component
public class Transport {

	//point cut
	public void bus() {
		System.out.println("�����ϱ�");
		System.out.println("���ڱ�");
	}
	
	
	public void subway() {
		System.out.println("�뷡���");
		System.out.println("����� ī�� ����");
	}
}

package com.packtpub.java7.concurrency.chapter2.recipe6.core;

import java.util.LinkedList;
import java.util.Random;

public class TestBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> bf = new LinkedList<>();
		String line = "123456789";
		String linestr = "abcdefg";
		bf.add(line);
		bf.add(linestr);
		System.out.println(bf.toString());
		bf.offer(linestr);
		System.out.println(bf.toString());
		System.out.println("after pool");
		String temp = bf.poll();
		System.out.println(bf.toString());
		System.out.println(temp);
		
		Random random=new Random();
		System.out.println(random.nextInt(100));
		
		StringBuilder buffer=new StringBuilder();
		int indice=(int)(Math.random()*255);
		buffer.append(indice);
		System.out.println(buffer.toString());
	}

}

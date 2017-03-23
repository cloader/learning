package com.vue;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class Run {
	public static void main(String[] args) {
		LongAdder longadder = new LongAdder();
		longadder.add(5);
		longadder.increment();
		System.out.println(longadder);
		ConcurrentHashMap hm = new ConcurrentHashMap(10);
		hm.put("a", "b");
		hm.forEach((k, v) -> System.out.println(k));
		List<String> items = new ArrayList<>();
		items.add("x");
		items.add("y");
		items.forEach(s -> System.out.println(s));
		items.stream().filter(a -> {
			return !a.equals("");
		}).map(a -> {
			return a + "1";
		}).forEach(s -> {
			System.out.println(s);
		});

		new Thread(() -> {
			System.out.println("x");
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println("y");
			}
		}).start();
		Runnable runable = () -> {
			System.out.println("b");
		};
		new Thread(runable).start();
		File a = new File("d");
		a.list((dir, name) -> {
			return name.equals("a");
		});
	}

}

package com.context;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;

import java.io.*;

public class Robot {

	private ChartManager chartManager = null;

	public Robot() {
		chartManager = ChartManager.getInstance();
	}

	public String input(String input) {
//
//		input = Translate.translateString(input);
		 System.out.println("您的输入是：" + input);
		return chartManager.response(input);
	}

//	public static void main(String[] args) throws IOException {
//		Robot demo = new Robot();
//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////		BufferedReader br = bufferedReader();
//		String input;
//		while ((input = br.readLine()) != null) {
//			System.out.println("you say>" + input);
//			System.out.println("Alice>" + demo.input(input));
//		}
//	}

	public static void main(String[] args) throws Exception {
		Robot demo = new Robot();
		AliceBotMother mother = new AliceBotMother();
		mother.setUp();
		AliceBot bot = mother.newInstance();
		System.err.println("Alice>" + bot.respond("welcome"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		while(true)
//		{
//			String input = input();
//			if(Chat.END.equalsIgnoreCase(input))
//				break;
//
//			System.err.println("Alice>" + bot.respond(input));
//		}
		String input;
		while ((input = br.readLine()) != null) {
			System.out.println("you say>" + input);
			System.out.println("Alice>" + bot.respond(input));
		}
	}

	private static BufferedReader bufferedReader() {
		String inputPath = "./myinput.txt";
		File file = new File(inputPath);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;

	}
}

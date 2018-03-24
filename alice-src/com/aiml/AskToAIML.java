package com.aiml;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;

import java.io.IOException;

public class AskToAIML implements IAskApproach {

	private static AliceBotMother mother = null;
	private static AliceBot bot = null;
	private static GossipLoad gossipLoad = null;

	public AskToAIML(){
		gossipLoad = new GossipLoad();
		try {
			gossipLoad.load();
			mother = new AliceBotMother();
			mother.setUp();
			bot = mother.newInstance();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gossipLoad.clean();
		}


	}

	public String response(String input) {
		return bot.respond(input);
	}
}

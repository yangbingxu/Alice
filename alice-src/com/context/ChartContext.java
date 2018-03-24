package com.context;

import com.aiml.AskToAIML;
import com.aiml.IAskApproach;

public class ChartContext implements IAskApproach {
	private IAskApproach askToAIML = null;
	private final String NULLSIGN = "#"; // 这个标志是用来表示，当查询AIML的时候，匹配到了*。
	private final String USEFULSIGN = "$";// 这个标志是用来表示，当查询AIML的时候匹配到了专业问题的模式。
	private final String[] NULLREPLAY = { "对不起，我还不能回答您的这个问题。",
			"唔，主人还没有教会我这个问题呢。", "我暂时还回答不了这个问题呢？" };

	public ChartContext(AskToAIML askToAIML) {
		this.askToAIML = askToAIML;
	}

	/**
	 * 联合AIML和数据库这2个知识库。
	 */
	public String response(String input) {
		String responseFromAIML = askToAIML.response(input);
		responseFromAIML = responseFromAIML.replace(" ", "");
		return translate(input, responseFromAIML);
	}

	private String translate(String originInput, String aimlReplay) {
		String asDBInput = "";
		if (-1 != aimlReplay.indexOf(NULLSIGN)) {
			asDBInput = originInput;
		} else if (-1 != aimlReplay.indexOf(USEFULSIGN)) {
			asDBInput = aimlReplay.replaceAll(USEFULSIGN, "");
		} else
			return aimlReplay;
		return asDBInput;
	}

	private String getRandomResponse() {
		return NULLREPLAY[getRandomNum()];
	}

	private int getRandomNum() {
		return (int) (Math.random() * NULLREPLAY.length);
	}
}

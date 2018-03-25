package com.context;

import com.aiml.AskToAIML;

public class ChartManager {
	private static final AskToAIML askToAIML = new AskToAIML();
	private static ChartContext chartContext = null;
	private static ChartManager instance = null;

	/**
	 * 单例模式
	 */
	private ChartManager() {
		chartContext = new ChartContext(askToAIML);
	}

	public static ChartManager getInstance() {
		if (instance == null) {
			 synchronized (ChartManager.class) { // 这个什么意思？？？
			instance = new ChartManager();
			 }
		}
		return instance;
	}

	public String response(String input) {
		return chartContext.response(input);
	}
}

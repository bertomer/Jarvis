package jarvis.state;

import jarvis.state.configuration.Configuration;
import jarvis.state.history.History;
import jarvis.state.knowledge.Knowledge;
import jarvis.state.personality.Personality;

public class State {
	private Configuration config;
	private History hist;
	private Personality personality;
	private Knowledge knowledge;
	
	private static State instance = null;
	
	public void initialization(Configuration config) {
		this.config = config;
		loadLastState();
	}
	
	private void loadLastState() {
		
	}
	
	public static State getInstance() {
		if (instance == null) {
			instance = new State();
		}
		return instance;
	}
}

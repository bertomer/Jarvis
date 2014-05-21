package jarvis;

import jarvis.sense.Sense;
import jarvis.state.Languages;
import jarvis.state.State;
import jarvis.state.configuration.Configuration;
import jarvis.syntax.SyntaxMapper;
import jarvis.util.Result;

public class Jarvis {
	
	private State state;
	
	public Jarvis(Languages lang) {
		Configuration config = new Configuration(lang);
		this.state = State.getInstance();
		this.state.initialization(config);
	}
	
	public String getNextResponse(String request) {
		improveVocabulary(request);
		SyntaxMapper syntax = syntaxAnalysis(request);
		Sense sense = senseAnalysis(syntax);
		Result res = react(sense);
		return reply(res);
	}
	
	private void improveVocabulary(String request) {
		
	}
	
	private SyntaxMapper syntaxAnalysis(String request) {
		SyntaxMapper mapper = new SyntaxMapper(request);
		return mapper;
	}
	
	private Sense senseAnalysis(SyntaxMapper syntax) {
		Sense sense = new Sense(syntax);
		return sense;
	}
	
	private Result react(Sense sense) {
		Result res = new Result();
		res.setIsDone(true);
		return res;
	}
	
	private String reply(Result res) {
		if (res.getIsDone()) {
			return "Vous avez bien fait de me demander.";
		} else {
			return "Je n'y suis pas arrivé.";
		}
	}
}

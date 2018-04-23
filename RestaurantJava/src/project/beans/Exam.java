package project.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exam {

	@Id
	@GeneratedValue
	int quesnum;
	String question;
	String opta;
	String optb;
	String optc;
	String optd;
	private int getQuesnum() {
		return quesnum;
	}
	private void setQuesnum(int quesnum) {
		this.quesnum = quesnum;
	}
	int totalques;
	String answer;
	
	public int getTotalques() {
		return totalques;
	}
	public void setTotalques(int totalques) {
		this.totalques = totalques;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpta() {
		return opta;
	}
	public void setOpta(String opta) {
		this.opta = opta;
	}
	public String getOptb() {
		return optb;
	}
	public void setOptb(String optb) {
		this.optb = optb;
	}
	public String getOptc() {
		return optc;
	}
	public void setOptc(String optc) {
		this.optc = optc;
	}
	public String getOptd() {
		return optd;
	}
	public void setOptd(String optd) {
		this.optd = optd;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}

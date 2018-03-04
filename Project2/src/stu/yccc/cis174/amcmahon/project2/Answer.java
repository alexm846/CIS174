package stu.yccc.cis174.amcmahon.project2;

/**
 * Description: Project 2: Answer - an object consisting of answer content, user
 * answers, and question numbers & isCorrect method. Author: Alex McMahon Due
 * Due Date: 3/07/18
 *
 */

public class Answer {
	// instance variables
	private String content;
	private int questionNum;
	private String userAnswer;

	public Answer() { // Default Constructor
		content = "";
		questionNum = 0;
		userAnswer = "";
	}

	public Answer(String content, int questionNum, String userAnswer) { // Initializing Constructor
		this.content = content;
		this.questionNum = questionNum;
		this.userAnswer = userAnswer;
	}

	public String getContent() {
		return content;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String toString() {
		String quesStr = this.getQuestionNum() + ". User Answer: " + this.getUserAnswer() + " = ";
		if (this.isCorrect() == true) { // convert boolean to string
			quesStr += "Correct";
		} else {
			quesStr += "Incorrect";
		}
		return quesStr;
	}

	public boolean isCorrect() {
		// method returns true if user answer is correct
		if (this.content.equalsIgnoreCase(this.userAnswer)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

	}

}

package stu.yccc.cis174.amcmahon.project2;
/**
*  Description: Project 2: Exam (Interface) - consists of descriptor method, methods to source 
*  input files, and method to ask questions and take answers.  Designed for Administer to do the
*  rest to avoid redundancy.
*  Due Date: 3/07/18
*/

import java.util.List;

public interface Exam {
	
	public String describe();
	
	public String getQuestionFile();
	
	public String getAnswerFile();
	
	public void beginExam(List<Question> getQuestions, List<Answer> getAnswers);
	
}

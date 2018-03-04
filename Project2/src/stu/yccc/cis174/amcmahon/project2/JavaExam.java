package stu.yccc.cis174.amcmahon.project2;

/**
 *  Description: Project 2: Java Exam - revised to implement Exam; an application to test a 
 *  persons knowledge of Java.
 *  Author:  Alex McMahon
 *  Due Date: 3/07/18
 *
 */
import java.util.Scanner;
import java.util.List;

/**
 * @author alexanderjmcmahon
 */

public class JavaExam implements Exam{

	@Override
	public String describe() {
		System.out.println("Java Exam");
		return "Java Exam";
	}
	@Override
	public String getQuestionFile() {
		String questionFile = "JavaQuestions.txt";
		return questionFile;
	}
	@Override
	public String getAnswerFile() {
		String questionFile = "JavaAnswers.txt";
		return questionFile;
	}
	
	@Override
	public void beginExam(List<Question> questionList, List<Answer> answerList) {
			Scanner scan = new Scanner(System.in);
			int i = 0;
	
			System.out.println("Welcome to the Java Exam!");
			// print exam questions, scan user answer & store
			// them in Answer objects - uses questionNum to sort
			for (Question question : questionList) {
				System.out.println(question);
				String userAnswer = scan.next();
				i++;
				for (Answer answer : answerList) {
					if (answer.getQuestionNum() == i) {
						answer.setUserAnswer(userAnswer);
					}
				}
			}
		}

	public static void main(String[] args) {
		
	}
	
}

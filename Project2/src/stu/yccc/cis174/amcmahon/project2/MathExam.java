package stu.yccc.cis174.amcmahon.project2;

/**
 *  Description: Project 2: Math Exam - a second Exam implementation; not multiple choice;
 *  integers are represented as Strings
 *  Due Date: 3/07/18
 */
import java.util.Scanner;
import java.util.List;

/**
 * @author alexanderjmcmahon
 */

public class MathExam implements Exam{

	@Override
	public String describe() {
		System.out.println("Math Exam");
		return "Math Exam";
	}
	@Override
	public String getQuestionFile() {
		String questionFile = "MathQuestions.txt";
		return questionFile;
	}
	@Override
	public String getAnswerFile() {
		String questionFile = "MathAnswers.txt";
		return questionFile;
	}
	
	@Override
	public void beginExam(List<Question> questionList, List<Answer> answerList) {
			Scanner scan = new Scanner(System.in);
			int i = 0;
	
			System.out.println("Welcome to the Math Exam!");
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

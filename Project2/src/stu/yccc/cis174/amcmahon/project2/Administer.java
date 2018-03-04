package stu.yccc.cis174.amcmahon.project2;

/**
 *  Description: Project 2: Administer - a program to administer Exams. Loads, selects, reads
 *  in files, and calculates score.
 *  Author:  Alex McMahon
 *  Due Date: 3/07/18
 *
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administer {

	List<Exam> examList = new ArrayList<Exam>();
	int examSelection = 0;

	public static void main(String[] args) {

		Administer go = new Administer();
		go.loadExams();
		go.selectExam();
		List<Answer> answerList = go.administerExam();
		go.calculateScore(answerList);
	}

	public void loadExams() {
		examList.add(new JavaExam());
		examList.add(new MathExam());

	}

	public void selectExam() {
		int examNum = 1;
		for (Exam exam : examList) {
			System.out.print(examNum++ + ": ");
			exam.describe();
		}

		System.out.println("Select an exam number.");
		Scanner scan = new Scanner(System.in);
		examSelection = scan.nextInt() - 1;

	}

	public List<Answer> administerExam() {
		Exam exam = examList.get(examSelection);
		String questionFile = exam.getQuestionFile();
		String answerFile = exam.getAnswerFile();
		exam.describe();
		List<Question> questionList = getQuestions(questionFile);
		List<Answer> answerList = getAnswers(answerFile);
		exam.beginExam(questionList, answerList);
		return answerList;

	}

	public List<Question> getQuestions(String questionFile) {
		// method to read in question file, create Question objects, and put them into a
		// list
		List<Question> questionList = new ArrayList<Question>();
		try {
			int questionNum = 0;
			// open the input file for reading
			FileReader fReader = new FileReader(questionFile);
			// attach a scanner and read words until end of file
			Scanner scan = new Scanner(fReader);
			String line = "A";
			while (scan.hasNextLine()) {

				line = scan.nextLine();

				if (line.length() == 0) { // skip blank lines
					continue;
				}
				// if the first character is a number...
				if (Character.isDigit(line.charAt(0)) == true) {
					questionNum++;
					// add the actual (numbered) question to Question object, then add answer
					// options to content
					Question question = new Question(line, "", questionNum);
					questionList.add(question);
				}
				// if the first character is not a number...
				if (Character.isDigit(line.charAt(0)) == false) {
					questionList.get(questionNum - 1)
							.setContent(questionList.get(questionNum - 1).getContent() + "\n" + line);
				}
			}
			fReader.close();
		} catch (IOException e) {
			// if an error happened...
			System.out.println(e.getMessage());
		}
		return questionList;
	}

	public List<Answer> getAnswers(String answerFile) {
		// method to read in the answer file, create Answer objects, and add them to a
		// list
		List<Answer> answerList = new ArrayList<Answer>(); // create Answer list
		try {
			int questionNum = 0;
			FileReader fReader = new FileReader(answerFile);
			Scanner scan = new Scanner(fReader);
			String line = "A";
			while (scan.hasNextLine()) {

				line = scan.nextLine();

				if (line.length() == 0) {
					continue;
				}
				// start String after question number & trim
				String theAnswer = line.substring(3).trim();
				if (Character.isDigit(line.charAt(0)) == true) {
					questionNum++;
					Answer answer = new Answer(theAnswer, questionNum, "");
					answerList.add(answer);
				}
			}
			fReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return answerList;
	}

	public void calculateScore(List<Answer> answerList) {
		String outFile = "Score.txt";
		Exam exam = examList.get(examSelection);
		// method to print & write to exam results
		try {
			PrintWriter fWriter = new PrintWriter(outFile);
			int numCorrect = 0;
			int numQues = 0;
			double grade = 0;
			fWriter.println(exam.describe());
			for (Answer answer : answerList) {
				numQues++;
				fWriter.println(answer); // write the results to file
				System.out.println(answer);
				// use Answer isCorrect method & count correct answers
				if (answer.isCorrect() == true) {
					numCorrect++;
				}
			}
			grade = (double) numCorrect / (double) numQues * 100; // calculate grade
			System.out.println("Total Grade: " + grade);
			fWriter.println();
			fWriter.println("Total Grade: " + grade);
			fWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
